package java2yuml;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import generated.Java8BaseListener;
import generated.Java8Parser.ClassTypeContext;
import generated.Java8Parser.InterfaceTypeContext;
import generated.Java8Parser.NormalClassDeclarationContext;
import generated.Java8Parser.SuperclassContext;
import generated.Java8Parser.SuperinterfacesContext;
import java2yuml.ClassDeclaration.ClassDeclarationBuilder;

public class ClassHierarchyListener extends Java8BaseListener {

	private static final Logger logger;

	private ArrayList<ClassDeclaration> classes;

	private ClassDeclarationBuilder current;

	private ArrayDeque<ClassDeclarationBuilder> stack;

	private boolean inSuperClassDeclaration;

	private boolean inSuperInterfaceDeclaration;

	static {
		logger = Logger.getLogger(ClassHierarchyListener.class.toString());
		logger.setLevel(Level.ALL);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.ALL);
		handler.setFormatter(new SimpleFormatter());
		logger.addHandler(handler);
		logger.fine("Starting application");
	}

	public ClassHierarchyListener() {
		classes = new ArrayList<>();
		stack = new ArrayDeque<>();
		inSuperClassDeclaration = false;
		inSuperInterfaceDeclaration = false;
	}

	public List<ClassDeclaration> getDeclarations() {
		return Collections.unmodifiableList(classes);
	}

	@Override
	public void enterNormalClassDeclaration(NormalClassDeclarationContext ctx) {
		log("enterNormalClassDeclaration", () -> ctx.Identifier().toString());

		if (current != null) {
			stack.addLast(current);
		}
		current = new ClassDeclarationBuilder();
		current.className(ctx.Identifier().toString());
	}

	@Override
	public void enterSuperclass(SuperclassContext ctx) {
		log("enterSuperclass");

		inSuperClassDeclaration = true;
	}

	@Override
	public void enterClassType(ClassTypeContext ctx) {
		log("exitSuperclass", () -> ctx.Identifier().toString());

		if (inSuperClassDeclaration) {
			current.parentClassName(ctx.Identifier().toString());
		}
	}

	@Override
	public void exitSuperclass(SuperclassContext ctx) {
		log("exitSuperclass");

		inSuperClassDeclaration = false;
	}

	@Override
	public void enterSuperinterfaces(SuperinterfacesContext ctx) {
		log("enterSuperinterfaces");

		inSuperInterfaceDeclaration = true;
	}

	@Override
	public void enterInterfaceType(InterfaceTypeContext ctx) {
		log("enterInterfaceType", () -> ctx.classType().Identifier().toString());

		if (inSuperInterfaceDeclaration) {
			current.interfaceName(ctx.classType().Identifier().toString());
		}
	}

	@Override
	public void exitSuperinterfaces(SuperinterfacesContext ctx) {
		log("exitSuperinterfaces");

		inSuperInterfaceDeclaration = false;
	}

	@Override
	public void exitNormalClassDeclaration(NormalClassDeclarationContext ctx) {
		log("exitNormalClassDeclaration", () -> ctx.Identifier().toString());

		if (current != null) {
			classes.add(current.build());
			current = stack.pollLast();
		}
	}

	private Supplier<String> getState(Supplier<String> message) {
		return () -> "Id: " + message.get() + ", " + getState();
	}

	private String getState() {
		return String.format(
				"Current: %s, Number Declarations: %d, Stack size: %d, In Super: %b, In Super Interface: %b", current,
				classes.size(), stack.size(), inSuperClassDeclaration, inSuperInterfaceDeclaration);
	}

	private void log(String method) {
		logger.logp(Level.FINE, ClassHierarchyListener.class.toString(), method, this::getState);
	}

	private void log(String method, Supplier<String> message) {
		logger.logp(Level.FINE, ClassHierarchyListener.class.toString(), method, getState(message));
	}

}
