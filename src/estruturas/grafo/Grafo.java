package estruturas.grafo;

import algoritmos.BFS;
import utils.GrafoConstrutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Grafo {

    private final boolean ehDirecionado;
    private final int numVertices;
    private final int[][] matrizAdj;
    private final Map<String, Integer> verticeParaIndice;
    private final List<String> indiceParaVertice;

    public Grafo(GrafoConstrutor grafoConstrutor){
        ehDirecionado = grafoConstrutor.obterEhDirecionado();
        verticeParaIndice = grafoConstrutor.obterVerticeParaIndice();

        indiceParaVertice = new ArrayList<>();
        for(String vertice : verticeParaIndice.keySet()){
            indiceParaVertice.add(vertice);
        }

        numVertices = verticeParaIndice.size();
        matrizAdj = new int[numVertices][numVertices];

        List<String[]> arestas = grafoConstrutor.obterArestas();

        for(String[] aresta: arestas){
            String primeiroVertice = aresta[0];
            String segundoVertice = aresta[1];

            int fonte = verticeParaIndice.get(primeiroVertice);
            int destino = verticeParaIndice.get(segundoVertice);

            adcionarAresta(fonte, destino);
        }
    }

    public void adcionarAresta(int fonte, int destino) {
            matrizAdj[fonte][destino] = 1;

            if(!ehDirecionado) {
                matrizAdj[destino][fonte] = 1;
            }
    }

    public void mostrarGrafo(){
        for(int i = 0; i < numVertices; i++){
            for(int j = 0; j < numVertices; j++){
                System.out.print(matrizAdj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int verticeGrau(String vertice){
        if(!verticeParaIndice.containsKey(vertice)){
            System.out.println("Esse vertice não existe");
            return -1;
        }
        int indice = verticeParaIndice.get(vertice);
        int grau = 0;
        for(int i = 0; i < numVertices; i++){
            if(matrizAdj[indice][i] == 1){
                grau++;
            }
        }
        System.out.println("O grau do vertice '" + vertice + "' é: " + grau);
        return grau;
    }

    public void BuscaEmLargura(String verticeInicial){
        BFS bfs = new BFS(this);
        bfs.buscaEmLargura(verticeInicial);
    }

    public int obterNumVertices() {
        return numVertices;
    }

    public Map<String, Integer> obterVerticeParaIndice() {
        return verticeParaIndice;
    }

    public int[][] obterMatrizAdj() {
        return matrizAdj;
    }

    public List<String> obterIndiceParaVertice() {
        return indiceParaVertice;
    }
}
