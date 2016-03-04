import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.ext.DOTExporter;
import org.jgrapht.ext.StringNameProvider;
import org.jgrapht.graph.SimpleGraph;

/**
 * Produce 
 * @author Mickael CALLIMOUTOU
 */
public class Main {

	/**
	 * Main method.
	 * Write a dot file describing a simple graph.
	 */
	public static void main(String args[]) throws IOException {
		UndirectedGraph<String, DefaultEdge> stringGraph = createStringGraph();
		DOTExporter<String, DefaultEdge> dotExporter = new DOTExporter<>();
		DOTExporter<String, DefaultEdge> dot = new DOTExporter( new StringNameProvider<>(), null,null);
		FileWriter fw = new FileWriter(new File("java_graph.dot"));
		dot.export(fw, stringGraph);
	}

	/**
	 * Create and simple Graph
	 * @return
	 */
	private static UndirectedGraph<String, DefaultEdge> createStringGraph()
	{
		UndirectedGraph<String, DefaultEdge> model = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

		String top = "top";
		String v1 = "v1";
		String v2 = "v2";
		String v3 = "v3";
		String v4 = "v4";
		String v5 = "v5";
		String bottom = "bottom";

		// add the vertices
		model.addVertex(top);
		model.addVertex(v1);
		model.addVertex(v2);
		model.addVertex(v3);
		model.addVertex(v4);
		model.addVertex(v5);
		model.addVertex(bottom);

		// add edges to create a circuit
		model.addEdge(top, v1);
		model.addEdge(top, v3);
		model.addEdge(top, v4);
		model.addEdge(v1, v2);
		model.addEdge(v2, bottom);
		model.addEdge(v3, v5);
		model.addEdge(v4, v5);
		model.addEdge(v5, bottom);

		return model;
	}

}