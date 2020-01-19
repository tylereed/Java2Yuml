package java2yuml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import generated.Java8BaseListener;
import generated.Java8Parser.ClassTypeContext;
import generated.Java8Parser.InterfaceTypeContext;
import generated.Java8Parser.NormalClassDeclarationContext;
import generated.Java8Parser.SuperclassContext;
import generated.Java8Parser.SuperinterfacesContext;

import java2yuml.ClassDeclaration.ClassDeclarationBuilder;

public class ClassHierarchyListener extends Java8BaseListener {

	private ArrayList<ClassDeclaration> classes;

	private ArrayList<String> interfaces;

	private ClassDeclarationBuilder current;

	private boolean inSuperClassDeclaration;

	public ClassHierarchyListener() {
		classes = new ArrayList<>();
		inSuperClassDeclaration = false;
	}

	public List<ClassDeclaration> getDeclarations() {
		return Collections.unmodifiableList(classes);
	}

	@Override
	public void enterNormalClassDeclaration(NormalClassDeclarationContext ctx) {
		System.out.print("In enterNormalClassDeclaration ");
		System.out.println(ctx.Identifier());

		current = new ClassDeclarationBuilder();
		current.className(ctx.Identifier().toString());
	}

	@Override
	public void enterSuperclass(SuperclassContext ctx) {
		System.out.println("In enterSuperclass");

		inSuperClassDeclaration = true;
	}

	@Override
	public void enterClassType(ClassTypeContext ctx) {
		System.out.print("In enterClassType ");
		System.out.println(ctx.Identifier());

		if (inSuperClassDeclaration) {
			current.parentClassName(ctx.Identifier().toString());
		}
	}

	@Override
	public void exitSuperclass(SuperclassContext ctx) {
		System.out.println("In exitSuperclass");

		inSuperClassDeclaration = false;
	}

	@Override
	public void enterSuperinterfaces(SuperinterfacesContext ctx) {
		System.out.println("In enterSuperinterfaces ");

		interfaces = new ArrayList<>();
	}

	@Override
	public void enterInterfaceType(InterfaceTypeContext ctx) {
		System.out.println("In enterInterfaceType " + ctx.classType().Identifier().toString());

		if (interfaces != null) {
			interfaces.add(ctx.classType().Identifier().toString());
		}
	}

	@Override
	public void exitSuperinterfaces(SuperinterfacesContext ctx) {
		System.out.println("In exitSuperinterfaces ");

		if (current != null) {
			current.interfaces(interfaces);
		}
		interfaces = null;
	}

	@Override
	public void exitNormalClassDeclaration(NormalClassDeclarationContext ctx) {
		System.out.print("In exitNormalClassDeclaration ");
		System.out.println(ctx.Identifier());

		if (current != null) {
			classes.add(current.build());
			current = null;
		}
	}

}
