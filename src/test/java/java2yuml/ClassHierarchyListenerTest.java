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

	static Stream<Arguments> testWalkSource() {
		return Stream.of(Arguments.of("Single Class", "public class Test { }", List.of(buildCD("Test"))),
				Arguments.of("With Extends", "public class Test extends Super { }", List.of(buildCD("Test", "Super"))),
				Arguments.of("With 1 Interface", "public class Test implements I1 { }",
						List.of(buildCD("Test", null, "I1"))),
				Arguments.of("With 2 Interfaces", "public class Test implements I1, I2 { }",
						List.of(buildCD("Test", null, "I1", "I2"))),
				Arguments.of("With Extends, 1 Interface", "public class Test extends Super implements I1 { }",
						List.of(buildCD("Test", "Super", "I1"))),
				Arguments.of("With Inner Class", "public class Test { private class Inner {} }",
						List.of(buildCD("Test"), buildCD("Inner"))),
				Arguments.of("With Nested Inner Class",
						"public class Test { private class Inner { private class Inner2 {}} }",
						List.of(buildCD("Test"), buildCD("Inner"), buildCD("Inner2"))),
				Arguments.of("With Interface, With Inner Class",
						"public class Test implements I1 { private class Inner {} }",
						List.of(buildCD("Test", null, "I1"), buildCD("Inner"))),
				Arguments.of("With Extends, With Inner Class",
						"public class Test extends Super { private class Inner {} }",
						List.of(buildCD("Test", "Super"), buildCD("Inner"))),
				Arguments.of("With Inner Class, With Interface",
						"public class Test { private class Inner implements I1 {} }",
						List.of(buildCD("Test"), buildCD("Inner", null, "I1"))),
				Arguments.of("Everything",
						"public class Test extends Super implements I1, I2 { private class Inner extends Super2 implements I3, I4 { private class Inner2 extends Super3 implements I5, I6 {} } }",
						List.of(buildCD("Test", "Super", "I1", "I2"), buildCD("Inner", "Super2", "I3", "I4"),
								buildCD("Inner2", "Super3", "I5", "I6"))),
				Arguments.of("Single Interface", "public interface TestInterface { }",
						List.of(buildCD(DeclarationType.INTERFACE, "TestInterface"))),
				Arguments.of("With Inner Interface",
						"public interface TestInterface { public interface InnerInterface {} }",
						List.of(buildCD(DeclarationType.INTERFACE, "TestInterface"),
								buildCD(DeclarationType.INTERFACE, "InnerInterface"))),
				Arguments.of("Class inner Interface", "public class Test { public interface InnerInterface {} }",
						List.of(buildCD("Test"), buildCD(DeclarationType.INTERFACE, "InnerInterface"))),
				Arguments.of("Interface inner Class", "public interface TestInterface { public class Inner {}}",
						List.of(buildCD(DeclarationType.INTERFACE, "TestInterface"), buildCD("Inner"))),
				Arguments.of("With Super Interface", "public interface TestInterface extends SuperInterface { }",
						List.of(buildCD(DeclarationType.INTERFACE, "TestInterface", null, "SuperInterface"))),
				Arguments.of("With 2 Super Interfaces", "public interface TestInterface extends SI1, SI2 {}",
						List.of(buildCD(DeclarationType.INTERFACE, "TestInterface", null, "SI1", "SI2"))),
				Arguments.of("Generic Class", "public class Test<T> {}", List.of(buildCD("Test<T>"))),
				Arguments.of("With Generic SuperClass", "public class Test extends Super<G> {}",
						List.of(buildCD("Test", "Super<G>"))),
				Arguments.of("Enum", "public enum TestEnum", List.of(buildCD(DeclarationType.ENUM, "TestEnum"))),
				Arguments.of("Enum with Interface", "public enum TestEnum implements I1 {}",
						List.of(buildCD(DeclarationType.ENUM, "TestEnum", null, "I1"))));
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
