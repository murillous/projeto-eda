package algoritmos;

import estruturas.fila.Fila;
import estruturas.grafo.Grafo;

import java.util.List;
import java.util.Map;

public class BFS {

    private int[][] matrizAdj;
    private int numVertices;
    private Map<String, Integer> verticeParaIndice;
    private List<String> indiceParaVertice;

    public BFS(Grafo grafo){
        this.matrizAdj = grafo.obterMatrizAdj();
        this.numVertices = grafo.obterNumVertices();
        this.verticeParaIndice = grafo.obterVerticeParaIndice();
        this.indiceParaVertice = grafo.obterIndiceParaVertice();
    }

    public void buscaEmLargura(String verticeInicial){
        if(!verticeParaIndice.containsKey(verticeInicial)){
            System.out.println("O vertice " + verticeInicial + " não existe");
            return;
        }
        int vertice = verticeParaIndice.get(verticeInicial);
        boolean[] visitados = new boolean[numVertices];

        visitados[vertice] = true;
        Fila<Integer> fila = new Fila<>();
        fila.adicionar(vertice);

        System.out.println("A busca em largura vai começar pelo vertice " + verticeInicial);

        while(!fila.estaVazio()) {
            int verticeAtual = fila.retirar();
            System.out.println("Vertice atual: " + indiceParaVertice.get(verticeAtual));
            for(int i = 0; i < numVertices; i++){
                if(matrizAdj[verticeAtual][i] == 1 && !visitados[i]){
                    visitados[i] = true;
                    fila.adicionar(i);
                }
            }

            System.out.print("Vertices visitados: ");
            for(int i = 0; i < numVertices; i++){
                if(visitados[i]){
                    System.out.print(indiceParaVertice.get(i) + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
