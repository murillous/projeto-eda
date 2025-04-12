import graph.Graph;

public class App {
    public static void main(String[] args) {
        
        ConfigFileReader.printConfigFile();
        
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 2);
        g.addEdge(4, 3);

        g.viewGraph();
    }
}
