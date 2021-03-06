package java2yuml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.google.common.base.Stopwatch;
import com.google.common.graph.Graph;

import generated.Java8Lexer;
import generated.Java8Listener;
import generated.Java8Parser;
import java2yuml.listeners.classHierarchy.ClassHierarchyListener;

public class App {

	private static final Logger logger;

	static {
		logger = Logger.getLogger(App.class.toString());
		logger.setLevel(Level.OFF);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.ALL);
		handler.setFormatter(new SimpleFormatter());
		logger.addHandler(handler);
		logger.fine("Starting application");
	}

	public static void main(String[] args) throws FileNotFoundException {
		Path javaFolder = Paths.get(args[0]);

		var listener = new ClassHierarchyListener();
		logger.fine("Walking folder " + javaFolder);

		System.out.println("Testing sequential");
		List<Declaration> classes = time(() -> {
			walkFolder(javaFolder, listener);
			return listener.getDeclarations();
		});

		System.out.println("Testing parallel");
		List<Declaration> classes2 = time(() -> walkFolderParallel(javaFolder, ClassHierarchyListener::new,
				ClassHierarchyListener::getDeclarations));

		try (PrintWriter out = new PrintWriter("out.yuml")) {
			printYuml(classes, out);
		}

		// Graph<Declaration> graph = Hierarchy.buildGraph(classes);
	}

	private static <T> T time(Supplier<T> task) {
		Stopwatch stopWatch = Stopwatch.createStarted();
		T result = task.get();
		stopWatch.stop();
		var elapsed = stopWatch.elapsed();
		var out = String.format("Time taken %d m %d.%04d", elapsed.toMinutes(), elapsed.toSecondsPart(), elapsed.toMillisPart());
		System.out.println(out);
		return result;
	}

	public static void printYuml(List<Declaration> declarations, PrintWriter writer) {

		for (var declaration : declarations) {
			String diagram = declaration.toYuml();
			if (diagram.length() > 0) {
				writer.println(diagram);
			}
		}
	}

	public static void walkFolder(Path folder, Java8Listener listener) {

		try (Stream<Path> walk = Files.walk(folder)) {

			PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.java");

			List<Path> files = walk.filter(f -> matcher.matches(f)).collect(Collectors.toList());

			for (Path javaFile : files) {
				//logger.fine("Walking file " + javaFile);
				walkFile(javaFile, listener);
			}

		} catch (IOException e) {
			System.err.println("Unable to walk folder " + folder);
			e.printStackTrace();
		}
	}

	public static <TListener extends Java8Listener, TResult> List<TResult> walkFolderParallel(Path folder,
			Supplier<TListener> createListener, Function<TListener, Collection<TResult>> getResults) {

		try (Stream<Path> walk = Files.walk(folder)) {

			PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.java");

			return walk.filter(f -> matcher.matches(f)).parallel().map(javaFile -> {
				//logger.fine("Walking file " + javaFile);
				TListener listener = createListener.get();
				walkFile(javaFile, listener);
				return getResults.apply(listener);
			}).flatMap(Collection::stream).collect(Collectors.toList());

		} catch (IOException e) {
			System.err.println("Unable to walk folder " + folder);
			e.printStackTrace();
		}

		return null;
	}

	public static void walkFile(Path fileName, Java8Listener listener) {

		CharStream stream;
		try {
			stream = CharStreams.fromPath(fileName);
		} catch (IOException e) {
			System.err.println("Unable to read file " + fileName);
			e.printStackTrace();
			return;
		}

		walkStream(stream, listener);
	}

	public static void walkStream(CharStream stream, Java8Listener listener) {
		ParseTree tree = createParseTree(stream);
		var walker = new ParseTreeWalker();
		walker.walk(listener, tree);
	}

	public static ParseTree createParseTree(CharStream stream) {
		var lexer = new Java8Lexer(stream);
		var tokens = new CommonTokenStream(lexer);
		var parser = new Java8Parser(tokens);
		return parser.compilationUnit();
	}

}
