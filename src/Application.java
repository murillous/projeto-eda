import estructures.graph.Graph;
import utils.GraphConstructor;

import java.io.IOException;


public class Application {
    public static void main(String[] args) throws IOException {

        String filepath = "src/resource/sample.txt";
        GraphConstructor graphConstructor = new GraphConstructor();
        graphConstructor.readFile(filepath);

        System.out.println(GraphConstructor.getVertices());
        System.out.println(GraphConstructor.getIsDirected());


        Graph g = new Graph(graphConstructor);
        System.out.println(g.getVertices());
    }
}
