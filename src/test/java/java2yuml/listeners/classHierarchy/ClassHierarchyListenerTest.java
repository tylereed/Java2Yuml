package java2yuml.listeners.classHierarchy;

import static java2yuml.DeclarationType.CLASS;
import static java2yuml.DeclarationType.ENUM;
import static java2yuml.DeclarationType.INTERFACE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.List;
import java.util.stream.Stream;

import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.google.common.collect.ObjectArrays;

import java2yuml.App;
import java2yuml.Declaration;

public class ClassHierarchyListenerTest {

	@ParameterizedTest(name = "{0}")
	@MethodSource("testWalkSource")
	public void testWalk(String name, String clazz, List<Declaration> expected) {
		var listener = new ClassHierarchyListener();

		App.walkStream(CharStreams.fromString(clazz), listener);

		List<Declaration> actual = listener.getDeclarations();

		assertThat(actual, containsInAnyOrder(expected.toArray()));
	}

	static Stream<Arguments> testWalkSource() {
		return Stream.of(
				buildTest("Single Class", "public class Test { }", new Declaration(CLASS, "Test", null, "", List.of())),

				buildTest("With Extends", "public class Test extends Super { }",
						new Declaration(CLASS, "Test", "Super", "", List.of())),

				buildTest("With 1 Interface", "public class Test implements I1 { }",
						new Declaration(CLASS, "Test", null, "", List.of("I1"))),

				buildTest("With 2 Interfaces", "public class Test implements I1, I2 { }",
						new Declaration(CLASS, "Test", null, "", List.of("I1", "I2"))),

				buildTest("With Extends, 1 Interface", "public class Test extends Super implements I1 { }",
						new Declaration(CLASS, "Test", "Super", "", List.of("I1"))),

				buildTest("With Inner Class", "public class Test { private class Inner {} }",
						new Declaration(CLASS, "Test", null, "", List.of()),
						new Declaration(CLASS, "Inner", null, "Test", List.of())),

				buildTest("With Nested Inner Class",
						"public class Test { private class Inner { private class Inner2 {}} }",
						new Declaration(CLASS, "Test", null, "", List.of()),
						new Declaration(CLASS, "Inner", null, "Test", List.of()),
						new Declaration(CLASS, "Inner2", null, "Test.Inner", List.of())),

				buildTest("With Interface, With Inner Class",
						"public class Test implements I1 { private class Inner {} }",
						new Declaration(CLASS, "Test", null, "", List.of("I1")),
						new Declaration(CLASS, "Inner", null, "Test", List.of())),

				buildTest("With Extends, With Inner Class",
						"public class Test extends Super { private class Inner {} }",
						new Declaration(CLASS, "Test", "Super", "", List.of()),
						new Declaration(CLASS, "Inner", null, "Test", List.of())),

				buildTest("With Inner Class, With Interface",
						"public class Test { private class Inner implements I1 {} }",
						new Declaration(CLASS, "Test", null, "", List.of()),
						new Declaration(CLASS, "Inner", null, "Test", List.of("I1"))),

				buildTest("Everything",
						"public class Test extends Super implements I1, I2 { private class Inner extends Super2 implements I3, I4 { private class Inner2 extends Super3 implements I5, I6 {} } }",
						new Declaration(CLASS, "Test", "Super", "", List.of("I1", "I2")),
						new Declaration(CLASS, "Inner", "Super2", "Test", List.of("I3", "I4")),
						new Declaration(CLASS, "Inner2", "Super3", "Test.Inner", List.of("I5", "I6"))),

				buildTest("Single Interface", "public interface TestInterface { }",
						new Declaration(INTERFACE, "TestInterface", null, "", List.of())),

				buildTest("With Inner Interface",
						"public interface TestInterface { public interface InnerInterface {} }",
						new Declaration(INTERFACE, "TestInterface", null, "", List.of()),
						new Declaration(INTERFACE, "InnerInterface", null, "TestInterface", List.of())),

				buildTest("Class inner Interface", "public class Test { public interface InnerInterface {} }",
						new Declaration(CLASS, "Test", null, "", List.of()),
						new Declaration(INTERFACE, "InnerInterface", null, "Test", List.of())),

				buildTest("Interface inner Class", "public interface TestInterface { public class Inner {}}",
						new Declaration(INTERFACE, "TestInterface", null, "", List.of()),
						new Declaration(CLASS, "Inner", null, "TestInterface", List.of())),

				buildTest("With Super Interface", "public interface TestInterface extends SuperInterface { }",
						new Declaration(INTERFACE, "TestInterface", null, "", List.of("SuperInterface"))),

				buildTest("With 2 Super Interfaces", "public interface TestInterface extends SI1, SI2 {}",
						new Declaration(INTERFACE, "TestInterface", null, "", List.of("SI1", "SI2"))),

				buildTest("Generic Class", "public class Test<T> {}",
						new Declaration(CLASS, "Test<T>", null, "", List.of())),

				buildTest("Generic Class, 2 Type Params", "public class Test<T, U> {}",
						new Declaration(CLASS, "Test<T, U>", null, "", List.of())),

				buildTest("With Generic SuperClass", "public class Test extends Super<T> { }",
						new Declaration(CLASS, "Test", "Super<T>", "", List.of())),

				buildTest("With Generic SuperClass with Nested Type Param",
						"public class Test extends Super<List<T>> {}",
						new Declaration(CLASS, "Test", "Super<List<T>>", "", List.of())),

				buildTest("With Generic SuperClass with Nested Type Params",
						"public class Test extends Super<Map<T, U>> {}",
						new Declaration(CLASS, "Test", "Super<Map<T, U>>", "", List.of())),

				buildTest("With Generic SuperClass with Nested Generic Type Params",
						"public class Test extends HashMap<List<T>, List<U>> {}",
						new Declaration(CLASS, "Test", "HashMap<List<T>, List<U>>", "", List.of())),

				buildTest("Generic Class With Generic SuperClass", "public class Test<T> extends Super<U> { }",
						new Declaration(CLASS, "Test<T>", "Super<U>", "", List.of())),

				buildTest("With Generic Interface", "public class Test implements I1<T> { }",
						new Declaration(CLASS, "Test", null, "", List.of("I1<T>"))),

				buildTest("With 2 Generic Super Interfaces", "public class Test implements SI<T>, SI2<U> {}",
						new Declaration(CLASS, "Test", null, "", List.of("SI<T>", "SI2<U>"))),

				buildTest("With Generic Interface with Nested Type Param", "public class Test implements I1<List<T>> {}",
						new Declaration(CLASS, "Test", null, "", List.of("I1<List<T>>"))),

				buildTest("With Generic Interface with Nested Type Params",
						"public class Test implements I1<Map<T, U>> {}",
						new Declaration(CLASS, "Test", null, "", List.of("I1<Map<T, U>>"))),

				buildTest("Generic Interface", "public interface Test<T> {}",
						new Declaration(INTERFACE, "Test<T>", null, "", List.of())),

				buildTest("Generic Interface with Generic Super Interface",
						"public interface Test<T> extends SI<U> { }",
						new Declaration(INTERFACE, "Test<T>", null, "", List.of("SI<U>"))),

				buildTest("Generic Interface with 2 Generic Super Interfaces",
						"public interface Test extends SI<T>, SI2<U> {}",
						new Declaration(INTERFACE, "Test", null, "", List.of("SI<T>", "SI2<U>"))),

				buildTest("Enum", "public enum TestEnum {}", new Declaration(ENUM, "TestEnum", null, "", List.of())),

				buildTest("Enum with Interface", "public enum TestEnum implements I1 {}",
						new Declaration(ENUM, "TestEnum", null, "", List.of("I1"))),

				buildTest("FullyQualified Interface", "class Test implements u.I1<T> { }",
						new Declaration(CLASS, "Test", null, "", List.of("I1<T>"))),

				buildTest("With Package", "package test; public class Test { }",
						new Declaration(CLASS, "Test", null, "test", List.of())),

				buildTest("With Deep Package", "package test.subpackage; public class Test { }",
						new Declaration(CLASS, "Test", null, "test.subpackage", List.of())),

				buildTest("Package With Nested Class", "package test; public class Outer { public class Inner {} }",
						new Declaration(CLASS, "Outer", null, "test", List.of()),
						new Declaration(CLASS, "Inner", null, "test.Outer", List.of()))
				);
	}

	private static Arguments buildTest(String name, String code, Declaration expected) {
		return Arguments.of(name, code, List.of(expected));
	}

	private static Arguments buildTest(String name, String code, Declaration expected, Declaration... expectedOthers) {
		Declaration[] e = ObjectArrays.concat(expected, expectedOthers);
		return Arguments.of(name, code, List.of(e));
	}

}
