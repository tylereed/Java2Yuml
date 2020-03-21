package java2yuml.listeners.classHierarchy;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.Java8Listener;
import generated.Java8Parser.*;

public class LoggingListener implements Java8Listener {

	private static final Logger logger;

	static {
		logger = Logger.getLogger(LoggingListener.class.toString());
		logger.setLevel(Level.ALL);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.ALL);
		handler.setFormatter(new SimpleFormatter());
		logger.addHandler(handler);
		logger.fine("Starting application");
	}

	private static void log(String method) {
		logger.logp(Level.FINE, LoggingListener.class.toString(), method, "");
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		//log("visitTerminal");
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		log("visitErrorNode");
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		//log("enterEveryRule");
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		//log("exitEveryRule");
	}

	@Override
	public void enterLiteral(LiteralContext ctx) {
		log("enterLiteral");
	}

	@Override
	public void exitLiteral(LiteralContext ctx) {
		log("exitLiteral");
	}

	@Override
	public void enterType(TypeContext ctx) {
		log("enterType");
	}

	@Override
	public void exitType(TypeContext ctx) {
		log("exitType");
	}

	@Override
	public void enterPrimitiveType(PrimitiveTypeContext ctx) {
		log("enterPrimitiveType");
	}

	@Override
	public void exitPrimitiveType(PrimitiveTypeContext ctx) {
		log("exitPrimitiveType");
	}

	@Override
	public void enterNumericType(NumericTypeContext ctx) {
		log("enterNumericType");
	}

	@Override
	public void exitNumericType(NumericTypeContext ctx) {
		log("exitNumericType");
	}

	@Override
	public void enterIntegralType(IntegralTypeContext ctx) {
		log("enterIntegralType");
	}

	@Override
	public void exitIntegralType(IntegralTypeContext ctx) {
		log("exitIntegralType");
	}

	@Override
	public void enterFloatingPointType(FloatingPointTypeContext ctx) {
		log("enterFloatingPointType");
	}

	@Override
	public void exitFloatingPointType(FloatingPointTypeContext ctx) {
		log("exitFloatingPointType");
	}

	@Override
	public void enterReferenceType(ReferenceTypeContext ctx) {
		log("enterReferenceType");
	}

	@Override
	public void exitReferenceType(ReferenceTypeContext ctx) {
		log("exitReferenceType");
	}

	@Override
	public void enterClassOrInterfaceType(ClassOrInterfaceTypeContext ctx) {
		log("enterClassOrInterfaceType");
	}

	@Override
	public void exitClassOrInterfaceType(ClassOrInterfaceTypeContext ctx) {
		log("exitClassOrInterfaceType");
	}

	@Override
	public void enterClassType(ClassTypeContext ctx) {
		log("enterClassType");
	}

	@Override
	public void exitClassType(ClassTypeContext ctx) {
		log("exitClassType");
	}

	@Override
	public void enterClassType_lf_classOrInterfaceType(ClassType_lf_classOrInterfaceTypeContext ctx) {
		log("enterClassType_lf_classOrInterfaceType");
	}

	@Override
	public void exitClassType_lf_classOrInterfaceType(ClassType_lf_classOrInterfaceTypeContext ctx) {
		log("exitClassType_lf_classOrInterfaceType");
	}

	@Override
	public void enterClassType_lfno_classOrInterfaceType(ClassType_lfno_classOrInterfaceTypeContext ctx) {
		log("enterClassType_lfno_classOrInterfaceType");
	}

	@Override
	public void exitClassType_lfno_classOrInterfaceType(ClassType_lfno_classOrInterfaceTypeContext ctx) {
		log("exitClassType_lfno_classOrInterfaceType");
	}

	@Override
	public void enterInterfaceType(InterfaceTypeContext ctx) {
		log("enterInterfaceType");
	}

	@Override
	public void exitInterfaceType(InterfaceTypeContext ctx) {
		log("exitInterfaceType");
	}

	@Override
	public void enterInterfaceType_lf_classOrInterfaceType(InterfaceType_lf_classOrInterfaceTypeContext ctx) {
		log("enterInterfaceType_lf_classOrInterfaceType");
	}

	@Override
	public void exitInterfaceType_lf_classOrInterfaceType(InterfaceType_lf_classOrInterfaceTypeContext ctx) {
		log("exitInterfaceType_lf_classOrInterfaceType");
	}

	@Override
	public void enterInterfaceType_lfno_classOrInterfaceType(InterfaceType_lfno_classOrInterfaceTypeContext ctx) {
		log("enterInterfaceType_lfno_classOrInterfaceType");
	}

	@Override
	public void exitInterfaceType_lfno_classOrInterfaceType(InterfaceType_lfno_classOrInterfaceTypeContext ctx) {
		log("exitInterfaceType_lfno_classOrInterfaceType");
	}

	@Override
	public void enterTypeVariable(TypeVariableContext ctx) {
		log("enterTypeVariable");
	}

	@Override
	public void exitTypeVariable(TypeVariableContext ctx) {
		log("exitTypeVariable");
	}

	@Override
	public void enterArrayType(ArrayTypeContext ctx) {
		log("enterArrayType");
	}

	@Override
	public void exitArrayType(ArrayTypeContext ctx) {
		log("exitArrayType");
	}

	@Override
	public void enterDims(DimsContext ctx) {
		log("enterDims");
	}

	@Override
	public void exitDims(DimsContext ctx) {
		log("exitDims");
	}

	@Override
	public void enterTypeParameter(TypeParameterContext ctx) {
		log("enterTypeParameter");
	}

	@Override
	public void exitTypeParameter(TypeParameterContext ctx) {
		log("exitTypeParameter");
	}

	@Override
	public void enterTypeParameterModifier(TypeParameterModifierContext ctx) {
		log("enterTypeParameterModifier");
	}

	@Override
	public void exitTypeParameterModifier(TypeParameterModifierContext ctx) {
		log("exitTypeParameterModifier");
	}

	@Override
	public void enterTypeBound(TypeBoundContext ctx) {
		log("enterTypeBound");
	}

	@Override
	public void exitTypeBound(TypeBoundContext ctx) {
		log("exitTypeBound");
	}

	@Override
	public void enterAdditionalBound(AdditionalBoundContext ctx) {
		log("enterAdditionalBound");
	}

	@Override
	public void exitAdditionalBound(AdditionalBoundContext ctx) {
		log("exitAdditionalBound");
	}

	@Override
	public void enterTypeArguments(TypeArgumentsContext ctx) {
		log("enterTypeArguments");
	}

	@Override
	public void exitTypeArguments(TypeArgumentsContext ctx) {
		log("exitTypeArguments");
	}

	@Override
	public void enterTypeArgumentList(TypeArgumentListContext ctx) {
		log("enterTypeArgumentList");
	}

	@Override
	public void exitTypeArgumentList(TypeArgumentListContext ctx) {
		log("exitTypeArgumentList");
	}

	@Override
	public void enterTypeArgument(TypeArgumentContext ctx) {
		log("enterTypeArgument");
	}

	@Override
	public void exitTypeArgument(TypeArgumentContext ctx) {
		log("exitTypeArgument");
	}

	@Override
	public void enterWildcard(WildcardContext ctx) {
		log("enterWildcard");
	}

	@Override
	public void exitWildcard(WildcardContext ctx) {
		log("exitWildcard");
	}

	@Override
	public void enterWildcardBounds(WildcardBoundsContext ctx) {
		log("enterWildcardBounds");
	}

	@Override
	public void exitWildcardBounds(WildcardBoundsContext ctx) {
		log("exitWildcardBounds");
	}

	@Override
	public void enterPackageName(PackageNameContext ctx) {
		log("enterPackageName");
	}

	@Override
	public void exitPackageName(PackageNameContext ctx) {
		log("exitPackageName");
	}

	@Override
	public void enterTypeName(TypeNameContext ctx) {
		log("enterTypeName");
	}

	@Override
	public void exitTypeName(TypeNameContext ctx) {
		log("exitTypeName");
	}

	@Override
	public void enterPackageOrTypeName(PackageOrTypeNameContext ctx) {
		log("enterPackageOrTypeName");
	}

	@Override
	public void exitPackageOrTypeName(PackageOrTypeNameContext ctx) {
		log("exitPackageOrTypeName");
	}

	@Override
	public void enterExpressionName(ExpressionNameContext ctx) {
		log("enterExpressionName");
	}

	@Override
	public void exitExpressionName(ExpressionNameContext ctx) {
		log("exitExpressionName");
	}

	@Override
	public void enterMethodName(MethodNameContext ctx) {
		log("enterMethodName");
	}

	@Override
	public void exitMethodName(MethodNameContext ctx) {
		log("exitMethodName");
	}

	@Override
	public void enterAmbiguousName(AmbiguousNameContext ctx) {
		log("enterAmbiguousName");
	}

	@Override
	public void exitAmbiguousName(AmbiguousNameContext ctx) {
		log("exitAmbiguousName");
	}

	@Override
	public void enterCompilationUnit(CompilationUnitContext ctx) {
		log("enterCompilationUnit");
	}

	@Override
	public void exitCompilationUnit(CompilationUnitContext ctx) {
		log("exitCompilationUnit");
	}

	@Override
	public void enterPackageDeclaration(PackageDeclarationContext ctx) {
		log("enterPackageDeclaration");
	}

	@Override
	public void exitPackageDeclaration(PackageDeclarationContext ctx) {
		log("exitPackageDeclaration");
	}

	@Override
	public void enterPackageModifier(PackageModifierContext ctx) {
		log("enterPackageModifier");
	}

	@Override
	public void exitPackageModifier(PackageModifierContext ctx) {
		log("exitPackageModifier");
	}

	@Override
	public void enterImportDeclaration(ImportDeclarationContext ctx) {
		log("enterImportDeclaration");
	}

	@Override
	public void exitImportDeclaration(ImportDeclarationContext ctx) {
		log("exitImportDeclaration");
	}

	@Override
	public void enterSingleTypeImportDeclaration(SingleTypeImportDeclarationContext ctx) {
		log("enterSingleTypeImportDeclaration");
	}

	@Override
	public void exitSingleTypeImportDeclaration(SingleTypeImportDeclarationContext ctx) {
		log("exitSingleTypeImportDeclaration");
	}

	@Override
	public void enterTypeImportOnDemandDeclaration(TypeImportOnDemandDeclarationContext ctx) {
		log("enterTypeImportOnDemandDeclaration");
	}

	@Override
	public void exitTypeImportOnDemandDeclaration(TypeImportOnDemandDeclarationContext ctx) {
		log("exitTypeImportOnDemandDeclaration");
	}

	@Override
	public void enterSingleStaticImportDeclaration(SingleStaticImportDeclarationContext ctx) {
		log("enterSingleStaticImportDeclaration");
	}

	@Override
	public void exitSingleStaticImportDeclaration(SingleStaticImportDeclarationContext ctx) {
		log("exitSingleStaticImportDeclaration");
	}

	@Override
	public void enterStaticImportOnDemandDeclaration(StaticImportOnDemandDeclarationContext ctx) {
		log("enterStaticImportOnDemandDeclaration");
	}

	@Override
	public void exitStaticImportOnDemandDeclaration(StaticImportOnDemandDeclarationContext ctx) {
		log("exitStaticImportOnDemandDeclaration");
	}

	@Override
	public void enterTypeDeclaration(TypeDeclarationContext ctx) {
		log("enterTypeDeclaration");
	}

	@Override
	public void exitTypeDeclaration(TypeDeclarationContext ctx) {
		log("exitTypeDeclaration");
	}

	@Override
	public void enterClassDeclaration(ClassDeclarationContext ctx) {
		log("enterClassDeclaration");
	}

	@Override
	public void exitClassDeclaration(ClassDeclarationContext ctx) {
		log("exitClassDeclaration");
	}

	@Override
	public void enterNormalClassDeclaration(NormalClassDeclarationContext ctx) {
		log("enterNormalClassDeclaration");
	}

	@Override
	public void exitNormalClassDeclaration(NormalClassDeclarationContext ctx) {
		log("exitNormalClassDeclaration");
	}

	@Override
	public void enterClassModifier(ClassModifierContext ctx) {
		log("enterClassModifier");
	}

	@Override
	public void exitClassModifier(ClassModifierContext ctx) {
		log("exitClassModifier");
	}

	@Override
	public void enterTypeParameters(TypeParametersContext ctx) {
		log("enterTypeParameters");
	}

	@Override
	public void exitTypeParameters(TypeParametersContext ctx) {
		log("exitTypeParameters");
	}

	@Override
	public void enterTypeParameterList(TypeParameterListContext ctx) {
		log("enterTypeParameterList");
	}

	@Override
	public void exitTypeParameterList(TypeParameterListContext ctx) {
		log("exitTypeParameterList");
	}

	@Override
	public void enterSuperclass(SuperclassContext ctx) {
		log("enterSuperclass");
	}

	@Override
	public void exitSuperclass(SuperclassContext ctx) {
		log("exitSuperclass");
	}

	@Override
	public void enterSuperinterfaces(SuperinterfacesContext ctx) {
		log("enterSuperinterfaces");
	}

	@Override
	public void exitSuperinterfaces(SuperinterfacesContext ctx) {
		log("exitSuperinterfaces");
	}

	@Override
	public void enterInterfaceTypeList(InterfaceTypeListContext ctx) {
		log("enterInterfaceTypeList");
	}

	@Override
	public void exitInterfaceTypeList(InterfaceTypeListContext ctx) {
		log("exitInterfaceTypeList");
	}

	@Override
	public void enterClassBody(ClassBodyContext ctx) {
		log("enterClassBody");
	}

	@Override
	public void exitClassBody(ClassBodyContext ctx) {
		log("exitClassBody");
	}

	@Override
	public void enterClassBodyDeclaration(ClassBodyDeclarationContext ctx) {
		log("enterClassBodyDeclaration");
	}

	@Override
	public void exitClassBodyDeclaration(ClassBodyDeclarationContext ctx) {
		log("exitClassBodyDeclaration");
	}

	@Override
	public void enterClassMemberDeclaration(ClassMemberDeclarationContext ctx) {
		log("enterClassMemberDeclaration");
	}

	@Override
	public void exitClassMemberDeclaration(ClassMemberDeclarationContext ctx) {
		log("exitClassMemberDeclaration");
	}

	@Override
	public void enterFieldDeclaration(FieldDeclarationContext ctx) {
		log("enterFieldDeclaration");
	}

	@Override
	public void exitFieldDeclaration(FieldDeclarationContext ctx) {
		log("exitFieldDeclaration");
	}

	@Override
	public void enterFieldModifier(FieldModifierContext ctx) {
		log("enterFieldModifier");
	}

	@Override
	public void exitFieldModifier(FieldModifierContext ctx) {
		log("exitFieldModifier");
	}

	@Override
	public void enterVariableDeclaratorList(VariableDeclaratorListContext ctx) {
		log("enterVariableDeclaratorList");
	}

	@Override
	public void exitVariableDeclaratorList(VariableDeclaratorListContext ctx) {
		log("exitVariableDeclaratorList");
	}

	@Override
	public void enterVariableDeclarator(VariableDeclaratorContext ctx) {
		log("enterVariableDeclarator");
	}

	@Override
	public void exitVariableDeclarator(VariableDeclaratorContext ctx) {
		log("exitVariableDeclarator");
	}

	@Override
	public void enterVariableDeclaratorId(VariableDeclaratorIdContext ctx) {
		log("enterVariableDeclaratorId");
	}

	@Override
	public void exitVariableDeclaratorId(VariableDeclaratorIdContext ctx) {
		log("exitVariableDeclaratorId");
	}

	@Override
	public void enterVariableInitializer(VariableInitializerContext ctx) {
		log("enterVariableInitializer");
	}

	@Override
	public void exitVariableInitializer(VariableInitializerContext ctx) {
		log("exitVariableInitializer");
	}

	@Override
	public void enterUnannType(UnannTypeContext ctx) {
		log("enterUnannType");
	}

	@Override
	public void exitUnannType(UnannTypeContext ctx) {
		log("exitUnannType");
	}

	@Override
	public void enterUnannPrimitiveType(UnannPrimitiveTypeContext ctx) {
		log("enterUnannPrimitiveType");
	}

	@Override
	public void exitUnannPrimitiveType(UnannPrimitiveTypeContext ctx) {
		log("exitUnannPrimitiveType");
	}

	@Override
	public void enterUnannReferenceType(UnannReferenceTypeContext ctx) {
		log("enterUnannReferenceType");
	}

	@Override
	public void exitUnannReferenceType(UnannReferenceTypeContext ctx) {
		log("exitUnannReferenceType");
	}

	@Override
	public void enterUnannClassOrInterfaceType(UnannClassOrInterfaceTypeContext ctx) {
		log("enterUnannClassOrInterfaceType");
	}

	@Override
	public void exitUnannClassOrInterfaceType(UnannClassOrInterfaceTypeContext ctx) {
		log("exitUnannClassOrInterfaceType");
	}

	@Override
	public void enterUnannClassType(UnannClassTypeContext ctx) {
		log("enterUnannClassType");
	}

	@Override
	public void exitUnannClassType(UnannClassTypeContext ctx) {
		log("exitUnannClassType");
	}

	@Override
	public void enterUnannInterfaceType(UnannInterfaceTypeContext ctx) {
		log("enterUnannInterfaceType");
	}

	@Override
	public void exitUnannInterfaceType(UnannInterfaceTypeContext ctx) {
		log("exitUnannInterfaceType");
	}

	@Override
	public void enterUnannTypeVariable(UnannTypeVariableContext ctx) {
		log("enterUnannTypeVariable");
	}

	@Override
	public void exitUnannTypeVariable(UnannTypeVariableContext ctx) {
		log("exitUnannTypeVariable");
	}

	@Override
	public void enterUnannArrayType(UnannArrayTypeContext ctx) {
		log("enterUnannArrayType");
	}

	@Override
	public void exitUnannArrayType(UnannArrayTypeContext ctx) {
		log("exitUnannArrayType");
	}

	@Override
	public void enterMethodDeclaration(MethodDeclarationContext ctx) {
		log("enterMethodDeclaration");
	}

	@Override
	public void exitMethodDeclaration(MethodDeclarationContext ctx) {
		log("exitMethodDeclaration");
	}

	@Override
	public void enterMethodModifier(MethodModifierContext ctx) {
		log("enterMethodModifier");
	}

	@Override
	public void exitMethodModifier(MethodModifierContext ctx) {
		log("exitMethodModifier");
	}

	@Override
	public void enterMethodHeader(MethodHeaderContext ctx) {
		log("enterMethodHeader");
	}

	@Override
	public void exitMethodHeader(MethodHeaderContext ctx) {
		log("exitMethodHeader");
	}

	@Override
	public void enterResult(ResultContext ctx) {
		log("enterResult");
	}

	@Override
	public void exitResult(ResultContext ctx) {
		log("exitResult");
	}

	@Override
	public void enterMethodDeclarator(MethodDeclaratorContext ctx) {
		log("enterMethodDeclarator");
	}

	@Override
	public void exitMethodDeclarator(MethodDeclaratorContext ctx) {
		log("exitMethodDeclarator");
	}

	@Override
	public void enterFormalParameterList(FormalParameterListContext ctx) {
		log("enterFormalParameterList");
	}

	@Override
	public void exitFormalParameterList(FormalParameterListContext ctx) {
		log("exitFormalParameterList");
	}

	@Override
	public void enterFormalParameters(FormalParametersContext ctx) {
		log("enterFormalParameters");
	}

	@Override
	public void exitFormalParameters(FormalParametersContext ctx) {
		log("exitFormalParameters");
	}

	@Override
	public void enterFormalParameter(FormalParameterContext ctx) {
		log("enterFormalParameter");
	}

	@Override
	public void exitFormalParameter(FormalParameterContext ctx) {
		log("exitFormalParameter");
	}

	@Override
	public void enterVariableModifier(VariableModifierContext ctx) {
		log("enterVariableModifier");
	}

	@Override
	public void exitVariableModifier(VariableModifierContext ctx) {
		log("exitVariableModifier");
	}

	@Override
	public void enterLastFormalParameter(LastFormalParameterContext ctx) {
		log("enterLastFormalParameter");
	}

	@Override
	public void exitLastFormalParameter(LastFormalParameterContext ctx) {
		log("exitLastFormalParameter");
	}

	@Override
	public void enterReceiverParameter(ReceiverParameterContext ctx) {
		log("enterReceiverParameter");
	}

	@Override
	public void exitReceiverParameter(ReceiverParameterContext ctx) {
		log("exitReceiverParameter");
	}

	@Override
	public void enterThrows_(Throws_Context ctx) {
		log("enterThrows_");
	}

	@Override
	public void exitThrows_(Throws_Context ctx) {
		log("exitThrows_");
	}

	@Override
	public void enterExceptionTypeList(ExceptionTypeListContext ctx) {
		log("enterExceptionTypeList");
	}

	@Override
	public void exitExceptionTypeList(ExceptionTypeListContext ctx) {
		log("exitExceptionTypeList");
	}

	@Override
	public void enterExceptionType(ExceptionTypeContext ctx) {
		log("enterExceptionType");
	}

	@Override
	public void exitExceptionType(ExceptionTypeContext ctx) {
		log("exitExceptionType");
	}

	@Override
	public void enterMethodBody(MethodBodyContext ctx) {
		log("enterMethodBody");
	}

	@Override
	public void exitMethodBody(MethodBodyContext ctx) {
		log("exitMethodBody");
	}

	@Override
	public void enterInstanceInitializer(InstanceInitializerContext ctx) {
		log("enterInstanceInitializer");
	}

	@Override
	public void exitInstanceInitializer(InstanceInitializerContext ctx) {
		log("exitInstanceInitializer");
	}

	@Override
	public void enterStaticInitializer(StaticInitializerContext ctx) {
		log("enterStaticInitializer");
	}

	@Override
	public void exitStaticInitializer(StaticInitializerContext ctx) {
		log("exitStaticInitializer");
	}

	@Override
	public void enterConstructorDeclaration(ConstructorDeclarationContext ctx) {
		log("enterConstructorDeclaration");
	}

	@Override
	public void exitConstructorDeclaration(ConstructorDeclarationContext ctx) {
		log("exitConstructorDeclaration");
	}

	@Override
	public void enterConstructorModifier(ConstructorModifierContext ctx) {
		log("enterConstructorModifier");
	}

	@Override
	public void exitConstructorModifier(ConstructorModifierContext ctx) {
		log("exitConstructorModifier");
	}

	@Override
	public void enterConstructorDeclarator(ConstructorDeclaratorContext ctx) {
		log("enterConstructorDeclarator");
	}

	@Override
	public void exitConstructorDeclarator(ConstructorDeclaratorContext ctx) {
		log("exitConstructorDeclarator");
	}

	@Override
	public void enterSimpleTypeName(SimpleTypeNameContext ctx) {
		log("enterSimpleTypeName");
	}

	@Override
	public void exitSimpleTypeName(SimpleTypeNameContext ctx) {
		log("exitSimpleTypeName");
	}

	@Override
	public void enterConstructorBody(ConstructorBodyContext ctx) {
		log("enterConstructorBody");
	}

	@Override
	public void exitConstructorBody(ConstructorBodyContext ctx) {
		log("exitConstructorBody");
	}

	@Override
	public void enterExplicitConstructorInvocation(ExplicitConstructorInvocationContext ctx) {
		log("enterExplicitConstructorInvocation");
	}

	@Override
	public void exitExplicitConstructorInvocation(ExplicitConstructorInvocationContext ctx) {
		log("exitExplicitConstructorInvocation");
	}

	@Override
	public void enterEnumDeclaration(EnumDeclarationContext ctx) {
		log("enterEnumDeclaration");
	}

	@Override
	public void exitEnumDeclaration(EnumDeclarationContext ctx) {
		log("exitEnumDeclaration");
	}

	@Override
	public void enterEnumBody(EnumBodyContext ctx) {
		log("enterEnumBody");
	}

	@Override
	public void exitEnumBody(EnumBodyContext ctx) {
		log("exitEnumBody");
	}

	@Override
	public void enterEnumConstantList(EnumConstantListContext ctx) {
		log("enterEnumConstantList");
	}

	@Override
	public void exitEnumConstantList(EnumConstantListContext ctx) {
		log("exitEnumConstantList");
	}

	@Override
	public void enterEnumConstant(EnumConstantContext ctx) {
		log("enterEnumConstant");
	}

	@Override
	public void exitEnumConstant(EnumConstantContext ctx) {
		log("exitEnumConstant");
	}

	@Override
	public void enterEnumConstantModifier(EnumConstantModifierContext ctx) {
		log("enterEnumConstantModifier");
	}

	@Override
	public void exitEnumConstantModifier(EnumConstantModifierContext ctx) {
		log("exitEnumConstantModifier");
	}

	@Override
	public void enterEnumBodyDeclarations(EnumBodyDeclarationsContext ctx) {
		log("enterEnumBodyDeclarations");
	}

	@Override
	public void exitEnumBodyDeclarations(EnumBodyDeclarationsContext ctx) {
		log("exitEnumBodyDeclarations");
	}

	@Override
	public void enterInterfaceDeclaration(InterfaceDeclarationContext ctx) {
		log("enterInterfaceDeclaration");
	}

	@Override
	public void exitInterfaceDeclaration(InterfaceDeclarationContext ctx) {
		log("exitInterfaceDeclaration");
	}

	@Override
	public void enterNormalInterfaceDeclaration(NormalInterfaceDeclarationContext ctx) {
		log("enterNormalInterfaceDeclaration");
	}

	@Override
	public void exitNormalInterfaceDeclaration(NormalInterfaceDeclarationContext ctx) {
		log("exitNormalInterfaceDeclaration");
	}

	@Override
	public void enterInterfaceModifier(InterfaceModifierContext ctx) {
		log("enterInterfaceModifier");
	}

	@Override
	public void exitInterfaceModifier(InterfaceModifierContext ctx) {
		log("exitInterfaceModifier");
	}

	@Override
	public void enterExtendsInterfaces(ExtendsInterfacesContext ctx) {
		log("enterExtendsInterfaces");
	}

	@Override
	public void exitExtendsInterfaces(ExtendsInterfacesContext ctx) {
		log("exitExtendsInterfaces");
	}

	@Override
	public void enterInterfaceBody(InterfaceBodyContext ctx) {
		log("enterInterfaceBody");
	}

	@Override
	public void exitInterfaceBody(InterfaceBodyContext ctx) {
		log("exitInterfaceBody");
	}

	@Override
	public void enterInterfaceMemberDeclaration(InterfaceMemberDeclarationContext ctx) {
		log("enterInterfaceMemberDeclaration");
	}

	@Override
	public void exitInterfaceMemberDeclaration(InterfaceMemberDeclarationContext ctx) {
		log("exitInterfaceMemberDeclaration");
	}

	@Override
	public void enterConstantDeclaration(ConstantDeclarationContext ctx) {
		log("enterConstantDeclaration");
	}

	@Override
	public void exitConstantDeclaration(ConstantDeclarationContext ctx) {
		log("exitConstantDeclaration");
	}

	@Override
	public void enterConstantModifier(ConstantModifierContext ctx) {
		log("enterConstantModifier");
	}

	@Override
	public void exitConstantModifier(ConstantModifierContext ctx) {
		log("exitConstantModifier");
	}

	@Override
	public void enterInterfaceMethodDeclaration(InterfaceMethodDeclarationContext ctx) {
		log("enterInterfaceMethodDeclaration");
	}

	@Override
	public void exitInterfaceMethodDeclaration(InterfaceMethodDeclarationContext ctx) {
		log("exitInterfaceMethodDeclaration");
	}

	@Override
	public void enterInterfaceMethodModifier(InterfaceMethodModifierContext ctx) {
		log("enterInterfaceMethodModifier");
	}

	@Override
	public void exitInterfaceMethodModifier(InterfaceMethodModifierContext ctx) {
		log("exitInterfaceMethodModifier");
	}

	@Override
	public void enterAnnotationTypeDeclaration(AnnotationTypeDeclarationContext ctx) {
		log("enterAnnotationTypeDeclaration");
	}

	@Override
	public void exitAnnotationTypeDeclaration(AnnotationTypeDeclarationContext ctx) {
		log("exitAnnotationTypeDeclaration");
	}

	@Override
	public void enterAnnotationTypeBody(AnnotationTypeBodyContext ctx) {
		log("enterAnnotationTypeBody");
	}

	@Override
	public void exitAnnotationTypeBody(AnnotationTypeBodyContext ctx) {
		log("exitAnnotationTypeBody");
	}

	@Override
	public void enterAnnotationTypeMemberDeclaration(AnnotationTypeMemberDeclarationContext ctx) {
		log("enterAnnotationTypeMemberDeclaration");
	}

	@Override
	public void exitAnnotationTypeMemberDeclaration(AnnotationTypeMemberDeclarationContext ctx) {
		log("exitAnnotationTypeMemberDeclaration");
	}

	@Override
	public void enterAnnotationTypeElementDeclaration(AnnotationTypeElementDeclarationContext ctx) {
		log("enterAnnotationTypeElementDeclaration");
	}

	@Override
	public void exitAnnotationTypeElementDeclaration(AnnotationTypeElementDeclarationContext ctx) {
		log("exitAnnotationTypeElementDeclaration");
	}

	@Override
	public void enterAnnotationTypeElementModifier(AnnotationTypeElementModifierContext ctx) {
		log("enterAnnotationTypeElementModifier");
	}

	@Override
	public void exitAnnotationTypeElementModifier(AnnotationTypeElementModifierContext ctx) {
		log("exitAnnotationTypeElementModifier");
	}

	@Override
	public void enterDefaultValue(DefaultValueContext ctx) {
		log("enterDefaultValue");
	}

	@Override
	public void exitDefaultValue(DefaultValueContext ctx) {
		log("exitDefaultValue");
	}

	@Override
	public void enterAnnotation(AnnotationContext ctx) {
		log("enterAnnotation");
	}

	@Override
	public void exitAnnotation(AnnotationContext ctx) {
		log("exitAnnotation");
	}

	@Override
	public void enterNormalAnnotation(NormalAnnotationContext ctx) {
		log("enterNormalAnnotation");
	}

	@Override
	public void exitNormalAnnotation(NormalAnnotationContext ctx) {
		log("exitNormalAnnotation");
	}

	@Override
	public void enterElementValuePairList(ElementValuePairListContext ctx) {
		log("enterElementValuePairList");
	}

	@Override
	public void exitElementValuePairList(ElementValuePairListContext ctx) {
		log("exitElementValuePairList");
	}

	@Override
	public void enterElementValuePair(ElementValuePairContext ctx) {
		log("enterElementValuePair");
	}

	@Override
	public void exitElementValuePair(ElementValuePairContext ctx) {
		log("exitElementValuePair");
	}

	@Override
	public void enterElementValue(ElementValueContext ctx) {
		log("enterElementValue");
	}

	@Override
	public void exitElementValue(ElementValueContext ctx) {
		log("exitElementValue");
	}

	@Override
	public void enterElementValueArrayInitializer(ElementValueArrayInitializerContext ctx) {
		log("enterElementValueArrayInitializer");
	}

	@Override
	public void exitElementValueArrayInitializer(ElementValueArrayInitializerContext ctx) {
		log("exitElementValueArrayInitializer");
	}

	@Override
	public void enterElementValueList(ElementValueListContext ctx) {
		log("enterElementValueList");
	}

	@Override
	public void exitElementValueList(ElementValueListContext ctx) {
		log("exitElementValueList");
	}

	@Override
	public void enterMarkerAnnotation(MarkerAnnotationContext ctx) {
		log("enterMarkerAnnotation");
	}

	@Override
	public void exitMarkerAnnotation(MarkerAnnotationContext ctx) {
		log("exitMarkerAnnotation");
	}

	@Override
	public void enterSingleElementAnnotation(SingleElementAnnotationContext ctx) {
		log("enterSingleElementAnnotation");
	}

	@Override
	public void exitSingleElementAnnotation(SingleElementAnnotationContext ctx) {
		log("exitSingleElementAnnotation");
	}

	@Override
	public void enterArrayInitializer(ArrayInitializerContext ctx) {
		log("enterArrayInitializer");
	}

	@Override
	public void exitArrayInitializer(ArrayInitializerContext ctx) {
		log("exitArrayInitializer");
	}

	@Override
	public void enterVariableInitializerList(VariableInitializerListContext ctx) {
		log("enterVariableInitializerList");
	}

	@Override
	public void exitVariableInitializerList(VariableInitializerListContext ctx) {
		log("exitVariableInitializerList");
	}

	@Override
	public void enterBlock(BlockContext ctx) {
		log("enterBlock");
	}

	@Override
	public void exitBlock(BlockContext ctx) {
		log("exitBlock");
	}

	@Override
	public void enterBlockStatements(BlockStatementsContext ctx) {
		log("enterBlockStatements");
	}

	@Override
	public void exitBlockStatements(BlockStatementsContext ctx) {
		log("exitBlockStatements");
	}

	@Override
	public void enterBlockStatement(BlockStatementContext ctx) {
		log("enterBlockStatement");
	}

	@Override
	public void exitBlockStatement(BlockStatementContext ctx) {
		log("exitBlockStatement");
	}

	@Override
	public void enterLocalVariableDeclarationStatement(LocalVariableDeclarationStatementContext ctx) {
		log("enterLocalVariableDeclarationStatement");
	}

	@Override
	public void exitLocalVariableDeclarationStatement(LocalVariableDeclarationStatementContext ctx) {
		log("exitLocalVariableDeclarationStatement");
	}

	@Override
	public void enterLocalVariableDeclaration(LocalVariableDeclarationContext ctx) {
		log("enterLocalVariableDeclaration");
	}

	@Override
	public void exitLocalVariableDeclaration(LocalVariableDeclarationContext ctx) {
		log("exitLocalVariableDeclaration");
	}

	@Override
	public void enterStatement(StatementContext ctx) {
		log("enterStatement");
	}

	@Override
	public void exitStatement(StatementContext ctx) {
		log("exitStatement");
	}

	@Override
	public void enterStatementNoShortIf(StatementNoShortIfContext ctx) {
		log("enterStatementNoShortIf");
	}

	@Override
	public void exitStatementNoShortIf(StatementNoShortIfContext ctx) {
		log("exitStatementNoShortIf");
	}

	@Override
	public void enterStatementWithoutTrailingSubstatement(StatementWithoutTrailingSubstatementContext ctx) {
		log("enterStatementWithoutTrailingSubstatement");
	}

	@Override
	public void exitStatementWithoutTrailingSubstatement(StatementWithoutTrailingSubstatementContext ctx) {
		log("exitStatementWithoutTrailingSubstatement");
	}

	@Override
	public void enterEmptyStatement(EmptyStatementContext ctx) {
		log("enterEmptyStatement");
	}

	@Override
	public void exitEmptyStatement(EmptyStatementContext ctx) {
		log("exitEmptyStatement");
	}

	@Override
	public void enterLabeledStatement(LabeledStatementContext ctx) {
		log("enterLabeledStatement");
	}

	@Override
	public void exitLabeledStatement(LabeledStatementContext ctx) {
		log("exitLabeledStatement");
	}

	@Override
	public void enterLabeledStatementNoShortIf(LabeledStatementNoShortIfContext ctx) {
		log("enterLabeledStatementNoShortIf");
	}

	@Override
	public void exitLabeledStatementNoShortIf(LabeledStatementNoShortIfContext ctx) {
		log("exitLabeledStatementNoShortIf");
	}

	@Override
	public void enterExpressionStatement(ExpressionStatementContext ctx) {
		log("enterExpressionStatement");
	}

	@Override
	public void exitExpressionStatement(ExpressionStatementContext ctx) {
		log("exitExpressionStatement");
	}

	@Override
	public void enterStatementExpression(StatementExpressionContext ctx) {
		log("enterStatementExpression");
	}

	@Override
	public void exitStatementExpression(StatementExpressionContext ctx) {
		log("exitStatementExpression");
	}

	@Override
	public void enterIfThenStatement(IfThenStatementContext ctx) {
		log("enterIfThenStatement");
	}

	@Override
	public void exitIfThenStatement(IfThenStatementContext ctx) {
		log("exitIfThenStatement");
	}

	@Override
	public void enterIfThenElseStatement(IfThenElseStatementContext ctx) {
		log("enterIfThenElseStatement");
	}

	@Override
	public void exitIfThenElseStatement(IfThenElseStatementContext ctx) {
		log("exitIfThenElseStatement");
	}

	@Override
	public void enterIfThenElseStatementNoShortIf(IfThenElseStatementNoShortIfContext ctx) {
		log("enterIfThenElseStatementNoShortIf");
	}

	@Override
	public void exitIfThenElseStatementNoShortIf(IfThenElseStatementNoShortIfContext ctx) {
		log("exitIfThenElseStatementNoShortIf");
	}

	@Override
	public void enterAssertStatement(AssertStatementContext ctx) {
		log("enterAssertStatement");
	}

	@Override
	public void exitAssertStatement(AssertStatementContext ctx) {
		log("exitAssertStatement");
	}

	@Override
	public void enterSwitchStatement(SwitchStatementContext ctx) {
		log("enterSwitchStatement");
	}

	@Override
	public void exitSwitchStatement(SwitchStatementContext ctx) {
		log("exitSwitchStatement");
	}

	@Override
	public void enterSwitchBlock(SwitchBlockContext ctx) {
		log("enterSwitchBlock");
	}

	@Override
	public void exitSwitchBlock(SwitchBlockContext ctx) {
		log("exitSwitchBlock");
	}

	@Override
	public void enterSwitchBlockStatementGroup(SwitchBlockStatementGroupContext ctx) {
		log("enterSwitchBlockStatementGroup");
	}

	@Override
	public void exitSwitchBlockStatementGroup(SwitchBlockStatementGroupContext ctx) {
		log("exitSwitchBlockStatementGroup");
	}

	@Override
	public void enterSwitchLabels(SwitchLabelsContext ctx) {
		log("enterSwitchLabels");
	}

	@Override
	public void exitSwitchLabels(SwitchLabelsContext ctx) {
		log("exitSwitchLabels");
	}

	@Override
	public void enterSwitchLabel(SwitchLabelContext ctx) {
		log("enterSwitchLabel");
	}

	@Override
	public void exitSwitchLabel(SwitchLabelContext ctx) {
		log("exitSwitchLabel");
	}

	@Override
	public void enterEnumConstantName(EnumConstantNameContext ctx) {
		log("enterEnumConstantName");
	}

	@Override
	public void exitEnumConstantName(EnumConstantNameContext ctx) {
		log("exitEnumConstantName");
	}

	@Override
	public void enterWhileStatement(WhileStatementContext ctx) {
		log("enterWhileStatement");
	}

	@Override
	public void exitWhileStatement(WhileStatementContext ctx) {
		log("exitWhileStatement");
	}

	@Override
	public void enterWhileStatementNoShortIf(WhileStatementNoShortIfContext ctx) {
		log("enterWhileStatementNoShortIf");
	}

	@Override
	public void exitWhileStatementNoShortIf(WhileStatementNoShortIfContext ctx) {
		log("exitWhileStatementNoShortIf");
	}

	@Override
	public void enterDoStatement(DoStatementContext ctx) {
		log("enterDoStatement");
	}

	@Override
	public void exitDoStatement(DoStatementContext ctx) {
		log("exitDoStatement");
	}

	@Override
	public void enterForStatement(ForStatementContext ctx) {
		log("enterForStatement");
	}

	@Override
	public void exitForStatement(ForStatementContext ctx) {
		log("exitForStatement");
	}

	@Override
	public void enterForStatementNoShortIf(ForStatementNoShortIfContext ctx) {
		log("enterForStatementNoShortIf");
	}

	@Override
	public void exitForStatementNoShortIf(ForStatementNoShortIfContext ctx) {
		log("exitForStatementNoShortIf");
	}

	@Override
	public void enterBasicForStatement(BasicForStatementContext ctx) {
		log("enterBasicForStatement");
	}

	@Override
	public void exitBasicForStatement(BasicForStatementContext ctx) {
		log("exitBasicForStatement");
	}

	@Override
	public void enterBasicForStatementNoShortIf(BasicForStatementNoShortIfContext ctx) {
		log("enterBasicForStatementNoShortIf");
	}

	@Override
	public void exitBasicForStatementNoShortIf(BasicForStatementNoShortIfContext ctx) {
		log("exitBasicForStatementNoShortIf");
	}

	@Override
	public void enterForInit(ForInitContext ctx) {
		log("enterForInit");
	}

	@Override
	public void exitForInit(ForInitContext ctx) {
		log("exitForInit");
	}

	@Override
	public void enterForUpdate(ForUpdateContext ctx) {
		log("enterForUpdate");
	}

	@Override
	public void exitForUpdate(ForUpdateContext ctx) {
		log("exitForUpdate");
	}

	@Override
	public void enterStatementExpressionList(StatementExpressionListContext ctx) {
		log("enterStatementExpressionList");
	}

	@Override
	public void exitStatementExpressionList(StatementExpressionListContext ctx) {
		log("exitStatementExpressionList");
	}

	@Override
	public void enterEnhancedForStatement(EnhancedForStatementContext ctx) {
		log("enterEnhancedForStatement");
	}

	@Override
	public void exitEnhancedForStatement(EnhancedForStatementContext ctx) {
		log("exitEnhancedForStatement");
	}

	@Override
	public void enterEnhancedForStatementNoShortIf(EnhancedForStatementNoShortIfContext ctx) {
		log("enterEnhancedForStatementNoShortIf");
	}

	@Override
	public void exitEnhancedForStatementNoShortIf(EnhancedForStatementNoShortIfContext ctx) {
		log("exitEnhancedForStatementNoShortIf");
	}

	@Override
	public void enterBreakStatement(BreakStatementContext ctx) {
		log("enterBreakStatement");
	}

	@Override
	public void exitBreakStatement(BreakStatementContext ctx) {
		log("exitBreakStatement");
	}

	@Override
	public void enterContinueStatement(ContinueStatementContext ctx) {
		log("enterContinueStatement");
	}

	@Override
	public void exitContinueStatement(ContinueStatementContext ctx) {
		log("exitContinueStatement");
	}

	@Override
	public void enterReturnStatement(ReturnStatementContext ctx) {
		log("enterReturnStatement");
	}

	@Override
	public void exitReturnStatement(ReturnStatementContext ctx) {
		log("exitReturnStatement");
	}

	@Override
	public void enterThrowStatement(ThrowStatementContext ctx) {
		log("enterThrowStatement");
	}

	@Override
	public void exitThrowStatement(ThrowStatementContext ctx) {
		log("exitThrowStatement");
	}

	@Override
	public void enterSynchronizedStatement(SynchronizedStatementContext ctx) {
		log("enterSynchronizedStatement");
	}

	@Override
	public void exitSynchronizedStatement(SynchronizedStatementContext ctx) {
		log("exitSynchronizedStatement");
	}

	@Override
	public void enterTryStatement(TryStatementContext ctx) {
		log("enterTryStatement");
	}

	@Override
	public void exitTryStatement(TryStatementContext ctx) {
		log("exitTryStatement");
	}

	@Override
	public void enterCatches(CatchesContext ctx) {
		log("enterCatches");
	}

	@Override
	public void exitCatches(CatchesContext ctx) {
		log("exitCatches");
	}

	@Override
	public void enterCatchClause(CatchClauseContext ctx) {
		log("enterCatchClause");
	}

	@Override
	public void exitCatchClause(CatchClauseContext ctx) {
		log("exitCatchClause");
	}

	@Override
	public void enterCatchFormalParameter(CatchFormalParameterContext ctx) {
		log("enterCatchFormalParameter");
	}

	@Override
	public void exitCatchFormalParameter(CatchFormalParameterContext ctx) {
		log("exitCatchFormalParameter");
	}

	@Override
	public void enterCatchType(CatchTypeContext ctx) {
		log("enterCatchType");
	}

	@Override
	public void exitCatchType(CatchTypeContext ctx) {
		log("exitCatchType");
	}

	@Override
	public void enterFinally_(Finally_Context ctx) {
		log("enterFinally_");
	}

	@Override
	public void exitFinally_(Finally_Context ctx) {
		log("exitFinally_");
	}

	@Override
	public void enterTryWithResourcesStatement(TryWithResourcesStatementContext ctx) {
		log("enterTryWithResourcesStatement");
	}

	@Override
	public void exitTryWithResourcesStatement(TryWithResourcesStatementContext ctx) {
		log("exitTryWithResourcesStatement");
	}

	@Override
	public void enterResourceSpecification(ResourceSpecificationContext ctx) {
		log("enterResourceSpecification");
	}

	@Override
	public void exitResourceSpecification(ResourceSpecificationContext ctx) {
		log("exitResourceSpecification");
	}

	@Override
	public void enterResourceList(ResourceListContext ctx) {
		log("enterResourceList");
	}

	@Override
	public void exitResourceList(ResourceListContext ctx) {
		log("exitResourceList");
	}

	@Override
	public void enterResource(ResourceContext ctx) {
		log("enterResource");
	}

	@Override
	public void exitResource(ResourceContext ctx) {
		log("exitResource");
	}

	@Override
	public void enterPrimary(PrimaryContext ctx) {
		log("enterPrimary");
	}

	@Override
	public void exitPrimary(PrimaryContext ctx) {
		log("exitPrimary");
	}

	@Override
	public void enterPrimaryNoNewArray(PrimaryNoNewArrayContext ctx) {
		log("enterPrimaryNoNewArray");
	}

	@Override
	public void exitPrimaryNoNewArray(PrimaryNoNewArrayContext ctx) {
		log("exitPrimaryNoNewArray");
	}

	@Override
	public void enterPrimaryNoNewArray_lf_arrayAccess(PrimaryNoNewArray_lf_arrayAccessContext ctx) {
		log("enterPrimaryNoNewArray_lf_arrayAccess");
	}

	@Override
	public void exitPrimaryNoNewArray_lf_arrayAccess(PrimaryNoNewArray_lf_arrayAccessContext ctx) {
		log("exitPrimaryNoNewArray_lf_arrayAccess");
	}

	@Override
	public void enterPrimaryNoNewArray_lfno_arrayAccess(PrimaryNoNewArray_lfno_arrayAccessContext ctx) {
		log("enterPrimaryNoNewArray_lfno_arrayAccess");
	}

	@Override
	public void exitPrimaryNoNewArray_lfno_arrayAccess(PrimaryNoNewArray_lfno_arrayAccessContext ctx) {
		log("exitPrimaryNoNewArray_lfno_arrayAccess");
	}

	@Override
	public void enterPrimaryNoNewArray_lf_primary(PrimaryNoNewArray_lf_primaryContext ctx) {
		log("enterPrimaryNoNewArray_lf_primary");
	}

	@Override
	public void exitPrimaryNoNewArray_lf_primary(PrimaryNoNewArray_lf_primaryContext ctx) {
		log("exitPrimaryNoNewArray_lf_primary");
	}

	@Override
	public void enterPrimaryNoNewArray_lfno_primary(PrimaryNoNewArray_lfno_primaryContext ctx) {
		log("enterPrimaryNoNewArray_lfno_primary");
	}

	@Override
	public void exitPrimaryNoNewArray_lfno_primary(PrimaryNoNewArray_lfno_primaryContext ctx) {
		log("exitPrimaryNoNewArray_lfno_primary");
	}

	@Override
	public void enterClassInstanceCreationExpression(ClassInstanceCreationExpressionContext ctx) {
		log("enterClassInstanceCreationExpression");
	}

	@Override
	public void exitClassInstanceCreationExpression(ClassInstanceCreationExpressionContext ctx) {
		log("exitClassInstanceCreationExpression");
	}

	@Override
	public void enterClassInstanceCreationExpression_lf_primary(ClassInstanceCreationExpression_lf_primaryContext ctx) {
		log("enterClassInstanceCreationExpression_lf_primary");
	}

	@Override
	public void exitClassInstanceCreationExpression_lf_primary(ClassInstanceCreationExpression_lf_primaryContext ctx) {
		log("exitClassInstanceCreationExpression_lf_primary");
	}

	@Override
	public void enterTypeArgumentsOrDiamond(TypeArgumentsOrDiamondContext ctx) {
		log("enterTypeArgumentsOrDiamond");
	}

	@Override
	public void exitTypeArgumentsOrDiamond(TypeArgumentsOrDiamondContext ctx) {
		log("exitTypeArgumentsOrDiamond");
	}

	@Override
	public void enterFieldAccess(FieldAccessContext ctx) {
		log("enterFieldAccess");
	}

	@Override
	public void exitFieldAccess(FieldAccessContext ctx) {
		log("exitFieldAccess");
	}

	@Override
	public void enterFieldAccess_lf_primary(FieldAccess_lf_primaryContext ctx) {
		log("enterFieldAccess_lf_primary");
	}

	@Override
	public void exitFieldAccess_lf_primary(FieldAccess_lf_primaryContext ctx) {
		log("exitFieldAccess_lf_primary");
	}

	@Override
	public void enterFieldAccess_lfno_primary(FieldAccess_lfno_primaryContext ctx) {
		log("enterFieldAccess_lfno_primary");
	}

	@Override
	public void exitFieldAccess_lfno_primary(FieldAccess_lfno_primaryContext ctx) {
		log("exitFieldAccess_lfno_primary");
	}

	@Override
	public void enterArrayAccess(ArrayAccessContext ctx) {
		log("enterArrayAccess");
	}

	@Override
	public void exitArrayAccess(ArrayAccessContext ctx) {
		log("exitArrayAccess");
	}

	@Override
	public void enterArrayAccess_lf_primary(ArrayAccess_lf_primaryContext ctx) {
		log("enterArrayAccess_lf_primary");
	}

	@Override
	public void exitArrayAccess_lf_primary(ArrayAccess_lf_primaryContext ctx) {
		log("exitArrayAccess_lf_primary");
	}

	@Override
	public void enterArrayAccess_lfno_primary(ArrayAccess_lfno_primaryContext ctx) {
		log("enterArrayAccess_lfno_primary");
	}

	@Override
	public void exitArrayAccess_lfno_primary(ArrayAccess_lfno_primaryContext ctx) {
		log("exitArrayAccess_lfno_primary");
	}

	@Override
	public void enterMethodInvocation(MethodInvocationContext ctx) {
		log("enterMethodInvocation");
	}

	@Override
	public void exitMethodInvocation(MethodInvocationContext ctx) {
		log("exitMethodInvocation");
	}

	@Override
	public void enterMethodInvocation_lf_primary(MethodInvocation_lf_primaryContext ctx) {
		log("enterMethodInvocation_lf_primary");
	}

	@Override
	public void exitMethodInvocation_lf_primary(MethodInvocation_lf_primaryContext ctx) {
		log("exitMethodInvocation_lf_primary");
	}

	@Override
	public void enterMethodInvocation_lfno_primary(MethodInvocation_lfno_primaryContext ctx) {
		log("enterMethodInvocation_lfno_primary");
	}

	@Override
	public void exitMethodInvocation_lfno_primary(MethodInvocation_lfno_primaryContext ctx) {
		log("exitMethodInvocation_lfno_primary");
	}

	@Override
	public void enterArgumentList(ArgumentListContext ctx) {
		log("enterArgumentList");
	}

	@Override
	public void exitArgumentList(ArgumentListContext ctx) {
		log("exitArgumentList");
	}

	@Override
	public void enterMethodReference(MethodReferenceContext ctx) {
		log("enterMethodReference");
	}

	@Override
	public void exitMethodReference(MethodReferenceContext ctx) {
		log("exitMethodReference");
	}

	@Override
	public void enterMethodReference_lf_primary(MethodReference_lf_primaryContext ctx) {
		log("enterMethodReference_lf_primary");
	}

	@Override
	public void exitMethodReference_lf_primary(MethodReference_lf_primaryContext ctx) {
		log("exitMethodReference_lf_primary");
	}

	@Override
	public void enterMethodReference_lfno_primary(MethodReference_lfno_primaryContext ctx) {
		log("enterMethodReference_lfno_primary");
	}

	@Override
	public void exitMethodReference_lfno_primary(MethodReference_lfno_primaryContext ctx) {
		log("exitMethodReference_lfno_primary");
	}

	@Override
	public void enterArrayCreationExpression(ArrayCreationExpressionContext ctx) {
		log("enterArrayCreationExpression");
	}

	@Override
	public void exitArrayCreationExpression(ArrayCreationExpressionContext ctx) {
		log("exitArrayCreationExpression");
	}

	@Override
	public void enterDimExprs(DimExprsContext ctx) {
		log("enterDimExprs");
	}

	@Override
	public void exitDimExprs(DimExprsContext ctx) {
		log("exitDimExprs");
	}

	@Override
	public void enterDimExpr(DimExprContext ctx) {
		log("enterDimExpr");
	}

	@Override
	public void exitDimExpr(DimExprContext ctx) {
		log("exitDimExpr");
	}

	@Override
	public void enterConstantExpression(ConstantExpressionContext ctx) {
		log("enterConstantExpression");
	}

	@Override
	public void exitConstantExpression(ConstantExpressionContext ctx) {
		log("exitConstantExpression");
	}

	@Override
	public void enterExpression(ExpressionContext ctx) {
		log("enterExpression");
	}

	@Override
	public void exitExpression(ExpressionContext ctx) {
		log("exitExpression");
	}

	@Override
	public void enterLambdaExpression(LambdaExpressionContext ctx) {
		log("enterLambdaExpression");
	}

	@Override
	public void exitLambdaExpression(LambdaExpressionContext ctx) {
		log("exitLambdaExpression");
	}

	@Override
	public void enterLambdaParameters(LambdaParametersContext ctx) {
		log("enterLambdaParameters");
	}

	@Override
	public void exitLambdaParameters(LambdaParametersContext ctx) {
		log("exitLambdaParameters");
	}

	@Override
	public void enterInferredFormalParameterList(InferredFormalParameterListContext ctx) {
		log("enterInferredFormalParameterList");
	}

	@Override
	public void exitInferredFormalParameterList(InferredFormalParameterListContext ctx) {
		log("exitInferredFormalParameterList");
	}

	@Override
	public void enterLambdaBody(LambdaBodyContext ctx) {
		log("enterLambdaBody");
	}

	@Override
	public void exitLambdaBody(LambdaBodyContext ctx) {
		log("exitLambdaBody");
	}

	@Override
	public void enterAssignmentExpression(AssignmentExpressionContext ctx) {
		log("enterAssignmentExpression");
	}

	@Override
	public void exitAssignmentExpression(AssignmentExpressionContext ctx) {
		log("exitAssignmentExpression");
	}

	@Override
	public void enterAssignment(AssignmentContext ctx) {
		log("enterAssignment");
	}

	@Override
	public void exitAssignment(AssignmentContext ctx) {
		log("exitAssignment");
	}

	@Override
	public void enterLeftHandSide(LeftHandSideContext ctx) {
		log("enterLeftHandSide");
	}

	@Override
	public void exitLeftHandSide(LeftHandSideContext ctx) {
		log("exitLeftHandSide");
	}

	@Override
	public void enterAssignmentOperator(AssignmentOperatorContext ctx) {
		log("enterAssignmentOperator");
	}

	@Override
	public void exitAssignmentOperator(AssignmentOperatorContext ctx) {
		log("exitAssignmentOperator");
	}

	@Override
	public void enterConditionalExpression(ConditionalExpressionContext ctx) {
		log("enterConditionalExpression");
	}

	@Override
	public void exitConditionalExpression(ConditionalExpressionContext ctx) {
		log("exitConditionalExpression");
	}

	@Override
	public void enterConditionalOrExpression(ConditionalOrExpressionContext ctx) {
		log("enterConditionalOrExpression");
	}

	@Override
	public void exitConditionalOrExpression(ConditionalOrExpressionContext ctx) {
		log("exitConditionalOrExpression");
	}

	@Override
	public void enterConditionalAndExpression(ConditionalAndExpressionContext ctx) {
		log("enterConditionalAndExpression");
	}

	@Override
	public void exitConditionalAndExpression(ConditionalAndExpressionContext ctx) {
		log("exitConditionalAndExpression");
	}

	@Override
	public void enterInclusiveOrExpression(InclusiveOrExpressionContext ctx) {
		log("enterInclusiveOrExpression");
	}

	@Override
	public void exitInclusiveOrExpression(InclusiveOrExpressionContext ctx) {
		log("exitInclusiveOrExpression");
	}

	@Override
	public void enterExclusiveOrExpression(ExclusiveOrExpressionContext ctx) {
		log("enterExclusiveOrExpression");
	}

	@Override
	public void exitExclusiveOrExpression(ExclusiveOrExpressionContext ctx) {
		log("exitExclusiveOrExpression");
	}

	@Override
	public void enterAndExpression(AndExpressionContext ctx) {
		log("enterAndExpression");
	}

	@Override
	public void exitAndExpression(AndExpressionContext ctx) {
		log("exitAndExpression");
	}

	@Override
	public void enterEqualityExpression(EqualityExpressionContext ctx) {
		log("enterEqualityExpression");
	}

	@Override
	public void exitEqualityExpression(EqualityExpressionContext ctx) {
		log("exitEqualityExpression");
	}

	@Override
	public void enterRelationalExpression(RelationalExpressionContext ctx) {
		log("enterRelationalExpression");
	}

	@Override
	public void exitRelationalExpression(RelationalExpressionContext ctx) {
		log("exitRelationalExpression");
	}

	@Override
	public void enterShiftExpression(ShiftExpressionContext ctx) {
		log("enterShiftExpression");
	}

	@Override
	public void exitShiftExpression(ShiftExpressionContext ctx) {
		log("exitShiftExpression");
	}

	@Override
	public void enterAdditiveExpression(AdditiveExpressionContext ctx) {
		log("enterAdditiveExpression");
	}

	@Override
	public void exitAdditiveExpression(AdditiveExpressionContext ctx) {
		log("exitAdditiveExpression");
	}

	@Override
	public void enterMultiplicativeExpression(MultiplicativeExpressionContext ctx) {
		log("enterMultiplicativeExpression");
	}

	@Override
	public void exitMultiplicativeExpression(MultiplicativeExpressionContext ctx) {
		log("exitMultiplicativeExpression");
	}

	@Override
	public void enterUnaryExpression(UnaryExpressionContext ctx) {
		log("enterUnaryExpression");
	}

	@Override
	public void exitUnaryExpression(UnaryExpressionContext ctx) {
		log("exitUnaryExpression");
	}

	@Override
	public void enterPreIncrementExpression(PreIncrementExpressionContext ctx) {
		log("enterPreIncrementExpression");
	}

	@Override
	public void exitPreIncrementExpression(PreIncrementExpressionContext ctx) {
		log("exitPreIncrementExpression");
	}

	@Override
	public void enterPreDecrementExpression(PreDecrementExpressionContext ctx) {
		log("enterPreDecrementExpression");
	}

	@Override
	public void exitPreDecrementExpression(PreDecrementExpressionContext ctx) {
		log("exitPreDecrementExpression");
	}

	@Override
	public void enterUnaryExpressionNotPlusMinus(UnaryExpressionNotPlusMinusContext ctx) {
		log("enterUnaryExpressionNotPlusMinus");
	}

	@Override
	public void exitUnaryExpressionNotPlusMinus(UnaryExpressionNotPlusMinusContext ctx) {
		log("exitUnaryExpressionNotPlusMinus");
	}

	@Override
	public void enterPostfixExpression(PostfixExpressionContext ctx) {
		log("enterPostfixExpression");
	}

	@Override
	public void exitPostfixExpression(PostfixExpressionContext ctx) {
		log("exitPostfixExpression");
	}

	@Override
	public void enterPostIncrementExpression(PostIncrementExpressionContext ctx) {
		log("enterPostIncrementExpression");
	}

	@Override
	public void exitPostIncrementExpression(PostIncrementExpressionContext ctx) {
		log("exitPostIncrementExpression");
	}

	@Override
	public void enterPostDecrementExpression(PostDecrementExpressionContext ctx) {
		log("enterPostDecrementExpression");
	}

	@Override
	public void exitPostDecrementExpression(PostDecrementExpressionContext ctx) {
		log("exitPostDecrementExpression");
	}

	@Override
	public void enterCastExpression(CastExpressionContext ctx) {
		log("enterCastExpression");
	}

	@Override
	public void exitCastExpression(CastExpressionContext ctx) {
		log("exitCastExpression");
	}

	@Override
	public void enterUnannClassType_lf_unannClassOrInterfaceType(
			UnannClassType_lf_unannClassOrInterfaceTypeContext ctx) {
		log("enterUnannClassType_lf_unannClassOrInterfaceType");
	}

	@Override
	public void exitUnannClassType_lf_unannClassOrInterfaceType(
			UnannClassType_lf_unannClassOrInterfaceTypeContext ctx) {
		log("exitUnannClassType_lf_unannClassOrInterfaceType");
	}

	@Override
	public void enterUnannClassType_lfno_unannClassOrInterfaceType(
			UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx) {
		log("enterUnannClassType_lfno_unannClassOrInterfaceType");
	}

	@Override
	public void exitUnannClassType_lfno_unannClassOrInterfaceType(
			UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx) {
		log("exitUnannClassType_lfno_unannClassOrInterfaceType");
	}

	@Override
	public void enterUnannInterfaceType_lf_unannClassOrInterfaceType(
			UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx) {
		log("enterUnannInterfaceType_lf_unannClassOrInterfaceType");
	}

	@Override
	public void exitUnannInterfaceType_lf_unannClassOrInterfaceType(
			UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx) {
		log("exitUnannInterfaceType_lf_unannClassOrInterfaceType");
	}

	@Override
	public void enterUnannInterfaceType_lfno_unannClassOrInterfaceType(
			UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx) {
		log("enterUnannInterfaceType_lfno_unannClassOrInterfaceType");
	}

	@Override
	public void exitUnannInterfaceType_lfno_unannClassOrInterfaceType(
			UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx) {
		log("exitUnannInterfaceType_lfno_unannClassOrInterfaceType");
	}

	@Override
	public void enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(
			PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx) {
		log("enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary");
	}

	@Override
	public void exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(
			PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx) {
		log("exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary");
	}

	@Override
	public void enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(
			PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx) {
		log("enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary");
	}

	@Override
	public void exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(
			PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx) {
		log("exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary");
	}

	@Override
	public void enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(
			PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx) {
		log("enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary");
	}

	@Override
	public void exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(
			PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx) {
		log("exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary");
	}

	@Override
	public void enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(
			PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx) {
		log("enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary");
	}

	@Override
	public void exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(
			PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx) {
		log("exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary");
	}

	@Override
	public void enterClassInstanceCreationExpression_lfno_primary(
			ClassInstanceCreationExpression_lfno_primaryContext ctx) {
		log("enterClassInstanceCreationExpression_lfno_primary");
	}

	@Override
	public void exitClassInstanceCreationExpression_lfno_primary(
			ClassInstanceCreationExpression_lfno_primaryContext ctx) {
		log("exitClassInstanceCreationExpression_lfno_primary");
	}

	@Override
	public void enterPostIncrementExpression_lf_postfixExpression(
			PostIncrementExpression_lf_postfixExpressionContext ctx) {
		log("enterPostIncrementExpression_lf_postfixExpression");
	}

	@Override
	public void exitPostIncrementExpression_lf_postfixExpression(
			PostIncrementExpression_lf_postfixExpressionContext ctx) {
		log("exitPostIncrementExpression_lf_postfixExpression");
	}

	@Override
	public void enterPostDecrementExpression_lf_postfixExpression(
			PostDecrementExpression_lf_postfixExpressionContext ctx) {
		log("enterPostDecrementExpression_lf_postfixExpression");
	}

	@Override
	public void exitPostDecrementExpression_lf_postfixExpression(
			PostDecrementExpression_lf_postfixExpressionContext ctx) {
		log("exitPostDecrementExpression_lf_postfixExpression");
	}
}
