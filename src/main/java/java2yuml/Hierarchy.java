package java2yuml;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

public class Hierarchy {
	
	public static Graph<Declaration> buildGraph(List<Declaration> classes) {
		MutableGraph<Declaration> graph = GraphBuilder.directed().build();
		
		Map<String, Declaration> nameToClass = classes.stream().collect(Collectors.toMap(d -> d.getClassName(), d -> d));
		
		for (var declaration : classes) {
			Declaration parent = nameToClass.get(declaration.getParentClassName());
			if (parent != null) {
				graph.putEdge(parent, declaration);
			}
			
			for (String parentInterfaceName : declaration.getInterfaceNames()) {
				Declaration parentInterface = nameToClass.get(parentInterfaceName);
				graph.putEdge(parentInterface, declaration);
			}
		}
		
		return graph;
	}

}
