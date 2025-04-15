package estructures.graph;

import utils.GraphConstructor;

import java.util.List;
import java.util.Map;

public class Graph {

    private final boolean isDirected;
    private final int vertices;
    private final int[][] matrix;

    public Graph(GraphConstructor graphConstructor){
        isDirected = graphConstructor.getIsDirected();
        vertices = graphConstructor.getVertices().size();
        matrix = new int[vertices][vertices];

        Map<String, Integer> vertexIndex = graphConstructor.getVertexIndex();
        List<String[]> edges = graphConstructor.getEdges();

        for(String[] edge: edges){
            String firstVertex = edge[0];
            String secondVertex = edge[1];

            int source = vertexIndex.get(firstVertex);
            int destination = vertexIndex.get(secondVertex);

            addEdge(source, destination);
        }

    }

    public void addEdge(int source, int destination) {
            matrix[source][destination] = 1;

            if(!isDirected) {
                matrix[destination][source] = 1;
            }
    }

    public void removeEdge(int source, int destination){
        matrix[source][destination] = 0;

        if(!isDirected) {
            matrix[destination][source] = 0;
        }
    }

    public void viewGraph(){
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getVertices() {
        return vertices;
    }
}
