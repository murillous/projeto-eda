package estruturas.grafo;

import utils.GrafoConstrutor;

import java.util.List;
import java.util.Map;

public class Grafo {

    private final boolean ehDirecionado;

    private final int vertices;
    private final int[][] matrizAdj;
    Map<String, Integer> verticeIndice;

    public Grafo(GrafoConstrutor grafoConstrutor){
        ehDirecionado = grafoConstrutor.obterEhDirecionado();
        verticeIndice = grafoConstrutor.obterVerticeIndice();
        vertices = verticeIndice.size();
        matrizAdj = new int[vertices][vertices];

        List<String[]> arestas = grafoConstrutor.obterArestas();

        for(String[] aresta: arestas){
            String primeiroVertice = aresta[0];
            String segundoVertice = aresta[1];

            int fonte = verticeIndice.get(primeiroVertice);
            int destino = verticeIndice.get(segundoVertice);

            adcionarAresta(fonte, destino);
        }

    }

    public void adcionarAresta(int fonte, int destino) {
            matrizAdj[fonte][destino] = 1;

            if(!ehDirecionado) {
                matrizAdj[destino][fonte] = 1;
            }
    }

    public void removerAresta(int fonte, int destino){
        matrizAdj[fonte][destino] = 0;

        if(!ehDirecionado) {
            matrizAdj[destino][fonte] = 0;
        }
    }

    public void mostrarGrafo(){
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++){
                System.out.print(matrizAdj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int verticeGrau(String vertice){
        try {
            int indice = verticeIndice.get(vertice);
            int grau = 0;
            for(int i = 0; i < vertices; i++){
                if(matrizAdj[indice][i] == 1){
                    grau++;
                }
            }
            System.out.println("O grau do vertice '" + vertice + "' é: " + grau);
            return grau;
        }
        catch(NullPointerException e){
            System.out.println("Esse vertice não existe");
        }
        return -1;
    }

    public int obterVertices() {
        return vertices;
    }
}
