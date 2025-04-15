import estructures.graph.Graph;
import utils.GraphConstructor;

public class Application {
    public static void main(String[] args) {

        String filepath = "src/resource/sample.txt";
        GraphConstructor graphConstructor = new GraphConstructor();
        graphConstructor.readFile(filepath);

        System.out.println(graphConstructor.getVertices());
        //System.out.println(graphConstructor.getIsDirected());

        Graph g = new Graph(graphConstructor);

        g.viewGraph();

    }
}
