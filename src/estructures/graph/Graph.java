package estructures.graph;

import utils.GraphConstructor;

public class Graph {

    private final boolean isDirected;
    private final int vertices;
    private final int[][] matrix;

    public Graph(GraphConstructor graphConstructor){
        isDirected = graphConstructor.getIsDirected();
        vertices = graphConstructor.getVertices().size();
        matrix = new int[vertices][vertices];
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
