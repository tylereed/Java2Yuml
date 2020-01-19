package java2yuml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.api.Test;

public class ClassHierarchyListenerTest {

	@Test
	public void testSingleClass() {
		var clazz = "public class Test { }";
		var listener = new ClassHierarchyListener();
		
		App.walkStream(CharStreams.fromString(clazz), listener);
		
		List<ClassDeclaration> actual = listener.getDeclarations();
		
		List<ClassDeclaration> expected = Arrays.asList(new ClassDeclaration("Test", null, null));
		assertEquals(expected, actual);
	}
	
}
