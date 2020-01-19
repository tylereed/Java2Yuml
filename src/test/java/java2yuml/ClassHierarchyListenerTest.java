package java2yuml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ClassHierarchyListenerTest {

	@ParameterizedTest(name = "{0}")
	@MethodSource("testWalkSource")
	public void testWalk(String name, String clazz, List<ClassDeclaration> expected) {
		var listener = new ClassHierarchyListener();

		App.walkStream(CharStreams.fromString(clazz), listener);

		List<ClassDeclaration> actual = listener.getDeclarations();
		assertEquals(expected, actual);
	}

	static Stream<Arguments> testWalkSource() {
		return Stream.of(
				Arguments.of("Single Class", "public class Test { }", List.of(buildCD("Test"))),
				Arguments.of("With Extends", "public class Test extends Super { }", List.of(buildCD("Test", "Super"))),
				Arguments.of("With 1 Interface", "public class Test implements I1 { }",
						List.of(buildCD("Test", null, "I1"))),
				Arguments.of("With 2 Interfaces", "public class Test implements I1, I2 { }",
						List.of(buildCD("Test", null, "I1", "I2"))),
				Arguments.of("With Extends, 1 Interface", "public class Test extends Super implements I1 { }",
						List.of(buildCD("Test", "Super", "I1"))),
				Arguments.of("With Inner Class", "public class Test { private class Inner {} }",
						List.of(buildCD("Test"), buildCD("Inner"))),
				Arguments.of("With Nested Inner Class", "public class Test { private class Inner { private class Inner2 {}} }",
						List.of(buildCD("Test"), buildCD("Inner"), buildCD("Inner2")))
			);
	}

	private static ClassDeclaration buildCD(String clazz) {
		return buildCD(clazz, null);
	}

	private static ClassDeclaration buildCD(String clazz, String parent) {
		return buildCD(clazz, parent, (String[]) null);
	}

	private static ClassDeclaration buildCD(String clazz, String parent, String... interfaces) {
		return new ClassDeclaration(clazz, parent, interfaces == null ? null : List.of(interfaces));
	}

}
