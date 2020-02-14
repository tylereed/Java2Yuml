package java2yuml.listeners.classHierarchy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.antlr.v4.runtime.tree.TerminalNode;

import generated.Java8BaseListener;
import generated.Java8Parser.ClassTypeContext;
import generated.Java8Parser.ClassType_lfno_classOrInterfaceTypeContext;
import generated.Java8Parser.EnumDeclarationContext;
import generated.Java8Parser.ExtendsInterfacesContext;
import generated.Java8Parser.InterfaceTypeContext;
import generated.Java8Parser.NormalClassDeclarationContext;
import generated.Java8Parser.NormalInterfaceDeclarationContext;
import generated.Java8Parser.SuperclassContext;
import generated.Java8Parser.SuperinterfacesContext;
import generated.Java8Parser.TypeArgumentsContext;
import generated.Java8Parser.TypeParameterContext;
import generated.Java8Parser.TypeParametersContext;
import java2yuml.Declaration;
import java2yuml.Declaration.DeclarationBuilder;
import java2yuml.DeclarationType;
import java2yuml.LoggingListener;

public class ClassHierarchyListener extends Java8BaseListener {

	private static final Logger logger;

	/** Holds onto all the declarations encountered while parsing */
	private ArrayList<Declaration> classes;

	/** The current declaration we are building */
	private DeclarationBuilder current;

	/** Holds onto the non-generic portion of the name for generic declarations */
	private String currentName;

	/** Holds onto the type parameters of a generic declaration */
	private ArrayList<String> typeParameters;
	
	/** Holds onto nested generic declarations */
	private ArrayDeque<ArrayList<String>> genericsStack;

	/**
	 * Holds onto a stack of declarations to handle nested classes/interfaces/enums
	 */
	private ArrayDeque<DeclarationBuilder> stack;

	/** Is set to true when entering an extends of a class */
	private boolean inSuperClassDeclaration;

	/**
	 * Is set to true when entering an extends of an interface or an implements of a
	 * class/enum
	 */
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
		genericsStack = new ArrayDeque<>();
		inSuperClassDeclaration = false;
		inSuperInterfaceDeclaration = false;
	}

	public List<Declaration> getDeclarations() {
		return Collections.unmodifiableList(classes);
	}

	private void enterDeclaration(String id, DeclarationType type) {

		if (current != null) {
			stack.addLast(current);
		}
		current = Declaration.builder();
		current.className(id).type(type);
		currentName = id;
	}

	@Override
	public void enterNormalClassDeclaration(NormalClassDeclarationContext ctx) {
		log("enterNormalClassDeclaration", () -> ctx.Identifier());
		enterDeclaration(ctx.Identifier().toString(), DeclarationType.CLASS);
	}

	@Override
	public void enterEnumDeclaration(EnumDeclarationContext ctx) {
		log("enterEnumDeclaration", () -> ctx.Identifier());
		enterDeclaration(ctx.Identifier().toString(), DeclarationType.ENUM);
	}

	@Override
	public void enterNormalInterfaceDeclaration(NormalInterfaceDeclarationContext ctx) {
		log("enterNormalInterfaceDeclaration", () -> ctx.Identifier());
		enterDeclaration(ctx.Identifier().toString(), DeclarationType.INTERFACE);
	}
	
	@Override
	public void enterTypeParameters(TypeParametersContext ctx) {
		log("enterTypeParameters");
		typeParameters = new ArrayList<>();
	}

	@Override
	public void enterTypeParameter(TypeParameterContext ctx) {
		log("enterTypeParameter", () -> ctx.Identifier());
		typeParameters.add(ctx.Identifier().toString());
	}

	@Override
	public void exitTypeParameter(TypeParameterContext ctx) {
		log("exitTypeParameter", () -> ctx.Identifier());
	}

	@Override
	public void exitTypeParameters(TypeParametersContext ctx) {
		log("exitTypeParameters");

		String genericName = currentName + "<" + String.join(", ", typeParameters) + ">";
		current.className(genericName);
		typeParameters = null;
	}

	@Override
	public void enterSuperclass(SuperclassContext ctx) {
		log("enterSuperclass");

		inSuperClassDeclaration = true;
	}

	@Override
	public void enterClassType(ClassTypeContext ctx) {
		log("enterClassType", () -> ctx.Identifier());

		if (inSuperClassDeclaration) {
			currentName = ctx.Identifier().toString();
			current.parentClassName(currentName);
		}
	}

	@Override
	public void enterTypeArguments(TypeArgumentsContext ctx) {
		log("enterTypeArguments");
		if (inSuperClassDeclaration || inSuperInterfaceDeclaration) {
			if (typeParameters == null) {
				typeParameters = new ArrayList<>();
			} else {
				genericsStack.push(typeParameters);
				typeParameters = new ArrayList<>();
			}
		}
	}

	@Override
	public void enterClassType_lfno_classOrInterfaceType(ClassType_lfno_classOrInterfaceTypeContext ctx) {
		log("enterClassType_lfno_classOrInterfaceType", () -> ctx.Identifier());
		if (inSuperClassDeclaration || inSuperInterfaceDeclaration) {
			typeParameters.add(ctx.Identifier().toString());
		}
	}
	
	@Override
	public void exitTypeArguments(TypeArgumentsContext ctx) {
		if (genericsStack.peek() != null) {
			String generic = "<" + String.join(", ", typeParameters) + ">";
			typeParameters = genericsStack.pop();
			
			int last = typeParameters.size() - 1;
			String type = typeParameters.remove(last);
			typeParameters.add(type + generic);
		}
	}

	@Override
	public void exitSuperclass(SuperclassContext ctx) {
		log("exitSuperclass");

		inSuperClassDeclaration = false;
		if (typeParameters != null) {
			String name = currentName + "<" + String.join(", ", typeParameters) + ">";
			current.parentClassName(name);
			typeParameters = null;
		}
	}

	@Override
	public void enterSuperinterfaces(SuperinterfacesContext ctx) {
		log("enterSuperinterfaces");

		inSuperInterfaceDeclaration = true;
	}

	@Override
	public void enterExtendsInterfaces(ExtendsInterfacesContext ctx) {
		log("enterExtendsInterfaces");

		inSuperInterfaceDeclaration = true;
	}

	@Override
	public void enterInterfaceType(InterfaceTypeContext ctx) {
		log("enterInterfaceType", () -> ctx.classType().Identifier());

		if (inSuperInterfaceDeclaration) {
			currentName = ctx.classType().Identifier().toString();
		}
	}

	@Override
	public void exitInterfaceType(InterfaceTypeContext ctx) {
		log("exitInterfaceType", () -> ctx.classType().Identifier());

		if (inSuperInterfaceDeclaration) {
			if (typeParameters != null) {
				String name = currentName + "<" + String.join(", ", typeParameters) + ">";
				current.interfaceName(name);
				typeParameters = null;
			} else {
				current.interfaceName(currentName);
			}
		}
	}

	@Override
	public void exitExtendsInterfaces(ExtendsInterfacesContext ctx) {
		log("exitExtendsInterfaces");

		inSuperInterfaceDeclaration = false;
	}

	@Override
	public void exitSuperinterfaces(SuperinterfacesContext ctx) {
		log("exitSuperinterfaces");

		inSuperInterfaceDeclaration = false;
	}

	private void exitDeclaration() {
		if (current != null) {
			classes.add(current.build());
			current = stack.pollLast();
		}
	}

	@Override
	public void exitNormalInterfaceDeclaration(NormalInterfaceDeclarationContext ctx) {
		log("exitNormalInterfaceDeclaration", () -> ctx.Identifier());
		exitDeclaration();
	}

	@Override
	public void exitEnumDeclaration(EnumDeclarationContext ctx) {
		log("exitEnumDeclaration", () -> ctx.Identifier());
		exitDeclaration();
	}

	@Override
	public void exitNormalClassDeclaration(NormalClassDeclarationContext ctx) {
		log("exitNormalClassDeclaration", () -> ctx.Identifier());
		exitDeclaration();
	}

	private Supplier<String> getState(Supplier<TerminalNode> message) {
		return () -> {
			String id = Optional.ofNullable(message.get()).map(n -> n.toString()).orElse("(null)");
			return "Id: " + id + ", " + getState();
		};
	}

	private String getState() {
		String tp;
		if (typeParameters == null) {
			tp = "(null)";
		} else {
			tp = "[" + String.join(", ", typeParameters) + "]";
		}

		return String.format(
				"Current: %s, Current Name: %s, Type Parameters: %s, Number Declarations: %d, Stack size: %d, In Super: %b, In Super Interface: %b",
				current, currentName, tp, classes.size(), stack.size(), inSuperClassDeclaration,
				inSuperInterfaceDeclaration);
	}

	private void log(String method) {
		logger.logp(Level.FINE, ClassHierarchyListener.class.toString(), method, this::getState);
	}

	private void log(String method, Supplier<TerminalNode> message) {
		logger.logp(Level.FINE, ClassHierarchyListener.class.toString(), method, getState(message));
	}

}
