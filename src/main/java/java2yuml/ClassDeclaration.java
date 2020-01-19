package java2yuml;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClassDeclaration {

	private final String className, parentClassName;
	private final List<String> interfaces;

	public String toYuml() {
		StringBuilder builder = new StringBuilder();

		if (parentClassName != null) {
			appendExtends(builder, parentClassName, className);
		}

		if (interfaces != null) {
			for (String interface_ : interfaces) {
				if (builder.length() > 0) {
					builder.append(System.lineSeparator());
				}
				appendInherits(builder, interface_, className);
			}
		}

		if (builder.length() == 0) {
			builder.append("[").append(className).append("]");
		}

		return builder.toString();
	}

	private static StringBuilder appendExtends(StringBuilder builder, String parent, String clazz) {
		return append(builder, parent, "^-", clazz);
	}

	private static StringBuilder appendInherits(StringBuilder builder, String interface_, String clazz) {
		return append(builder, interface_, "^-.-", clazz);
	}

	private static StringBuilder append(StringBuilder builder, String parent, String inheritType, String clazz) {
		builder.append("[");
		builder.append(parent);
		builder.append("]");
		builder.append(inheritType);
		builder.append("[");
		builder.append(clazz);
		builder.append("]");
		return builder;
	}

}
