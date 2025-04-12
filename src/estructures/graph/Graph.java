package estructures.graph;

public class Graph {
    
    private int vertices;
    private int[][] matrix;

    public Graph(int vertices){
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    // Função para grafos não-dirigidos, por isso 1 nas duas posições
    public void addEdge(int source, int destination) {
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }

    public void removeEdge(int source, int destination){
        matrix[source][destination] = 0;
        matrix[destination][source] = 0;
    }

    public void viewGraph(){
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
