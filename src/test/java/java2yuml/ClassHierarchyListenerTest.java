package java2yuml;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.List;
import java.util.stream.Stream;

import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ClassHierarchyListenerTest {

	@ParameterizedTest(name = "{0}")
	@MethodSource("testWalkSource")
	public void testWalk(String name, String clazz, List<Declaration> expected) {
		var listener = new ClassHierarchyListener();

		App.walkStream(CharStreams.fromString(clazz), listener);

		List<Declaration> actual = listener.getDeclarations();

		assertThat(actual, containsInAnyOrder(expected.toArray()));
	}

	private static Arguments buildTest(String name, String code, Declaration... expected) {
		return Arguments.of(name, code, List.of(expected));
	}

	static Stream<Arguments> testWalkSource() {
		return Stream.of(buildTest("Single Class", "public class Test { }", buildCD("Test")),
				buildTest("With Extends", "public class Test extends Super { }", buildCD("Test", "Super")),
				buildTest("With 1 Interface", "public class Test implements I1 { }", buildCD("Test", null, "I1")),
				buildTest("With 2 Interfaces", "public class Test implements I1, I2 { }",
						buildCD("Test", null, "I1", "I2")),
				buildTest("With Extends, 1 Interface", "public class Test extends Super implements I1 { }",
						buildCD("Test", "Super", "I1")),
				buildTest("With Inner Class", "public class Test { private class Inner {} }", buildCD("Test"),
						buildCD("Inner")),
				buildTest("With Nested Inner Class",
						"public class Test { private class Inner { private class Inner2 {}} }", buildCD("Test"),
						buildCD("Inner"), buildCD("Inner2")),
				buildTest("With Interface, With Inner Class",
						"public class Test implements I1 { private class Inner {} }", buildCD("Test", null, "I1"),
						buildCD("Inner")),
				buildTest("With Extends, With Inner Class",
						"public class Test extends Super { private class Inner {} }", buildCD("Test", "Super"),
						buildCD("Inner")),
				buildTest("With Inner Class, With Interface",
						"public class Test { private class Inner implements I1 {} }", buildCD("Test"),
						buildCD("Inner", null, "I1")),
				buildTest("Everything",
						"public class Test extends Super implements I1, I2 { private class Inner extends Super2 implements I3, I4 { private class Inner2 extends Super3 implements I5, I6 {} } }",
						buildCD("Test", "Super", "I1", "I2"), buildCD("Inner", "Super2", "I3", "I4"),
						buildCD("Inner2", "Super3", "I5", "I6")),
				buildTest("Single Interface", "public interface TestInterface { }",
						buildCD(DeclarationType.INTERFACE, "TestInterface")),
				buildTest("With Inner Interface",
						"public interface TestInterface { public interface InnerInterface {} }",
						buildCD(DeclarationType.INTERFACE, "TestInterface"),
						buildCD(DeclarationType.INTERFACE, "InnerInterface")),
				buildTest("Class inner Interface", "public class Test { public interface InnerInterface {} }",
						buildCD("Test"), buildCD(DeclarationType.INTERFACE, "InnerInterface")),
				buildTest("Interface inner Class", "public interface TestInterface { public class Inner {}}",
						buildCD(DeclarationType.INTERFACE, "TestInterface"), buildCD("Inner")),
				buildTest("With Super Interface", "public interface TestInterface extends SuperInterface { }",
						buildCD(DeclarationType.INTERFACE, "TestInterface", null, "SuperInterface")),
				buildTest("With 2 Super Interfaces", "public interface TestInterface extends SI1, SI2 {}",
						buildCD(DeclarationType.INTERFACE, "TestInterface", null, "SI1", "SI2")),
				buildTest("Generic Class", "public class Test<T> {}", buildCD("Test<T>")),
				buildTest("Generic Class, 2 Type Params", "public class Test<T, U> {}", buildCD("Test<T, U>")),
				buildTest("Generic Class, Generic Type Param", "public class Test<T, List<U>> { }",
						buildCD("Test<T, List<U>>")),
				buildTest("Generic Class, Generic Type Param of 2", "public class Test<T, BiConsumer<U, V>> { }",
						buildCD("Test<T, BiConsumer<U, V>>")),
				buildTest("With Generic SuperClass", "public class Test extends Super<T> { }",
						buildCD("Test", "Super<T>")),
				buildTest("With Generic SuperClass", "public class Test implements I1<T> { }",
						buildCD("Test", null, "I1<T>")),
				buildTest("Enum", "public enum TestEnum", buildCD(DeclarationType.ENUM, "TestEnum")),
				buildTest("Enum with Interface", "public enum TestEnum implements I1 {}",
						buildCD(DeclarationType.ENUM, "TestEnum", null, "I1")));
	}

	private static Declaration buildCD(String clazz) {
		return buildCD(clazz, null);
	}

	private static Declaration buildCD(DeclarationType type, String clazz) {
		return buildCD(type, clazz, null);
	}

	private static Declaration buildCD(String clazz, String parent) {
		return buildCD(clazz, parent, (String[]) null);
	}

	private static Declaration buildCD(String clazz, String parent, String... interfaces) {
		return buildCD(DeclarationType.CLASS, clazz, parent, interfaces);
	}

	private static Declaration buildCD(DeclarationType type, String clazz, String parent, String... interfaces) {
		return new Declaration(type, clazz, parent, interfaces == null ? List.of() : List.of(interfaces));
	}

}
