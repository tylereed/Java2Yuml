package java2yuml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import generated.Java8Lexer;
import generated.Java8Listener;
import generated.Java8Parser;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		Path javaFolder = Paths.get(args[0]);
		try (PrintWriter out = new PrintWriter("out.yuml")) {
			walkFolder(javaFolder, out);
		}
	}

	public static void walkFolder(Path folder, PrintWriter writer) {

		try (Stream<Path> walk = Files.walk(folder)) {

			PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.java");

			List<Path> files = walk.filter(f -> matcher.matches(f)).collect(Collectors.toList());

			var listener = new ClassHierarchyListener();

			for (Path javaFile : files) {
				walkFile(javaFile, listener);
			}

			for (var declaration : listener.getDeclarations()) {
				String diagram = declaration.toYuml();
				if (diagram.length() > 0) {
					writer.println(diagram);
				}
			}

		} catch (IOException e) {
			System.err.println("Unable to walk folder " + folder);
			e.printStackTrace();
		}
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
