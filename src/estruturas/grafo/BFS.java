package estruturas.grafo;

import estruturas.fila.Fila;

import java.util.List;
import java.util.Map;

public class BFS {

    private final int[][] matrizAdj;
    private final int numVertices;
    private final Map<String, Vertice> verticeParaIndice;
    private final List<Vertice> indiceParaVertice;

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
        int vertice = verticeParaIndice.get(verticeInicial).obterIndice();
        boolean[] visitados = new boolean[numVertices];

        visitados[vertice] = true;
        Fila filaVertices = new Fila();
        filaVertices.adicionar(indiceParaVertice.get(vertice));

        System.out.println("A busca em largura vai começar pelo vertice " + verticeInicial);

        while(!filaVertices.estaVazio()) {

            int verticeAtual = filaVertices.retirar().obterIndice();
            System.out.println("Vertice atual: " + indiceParaVertice.get(verticeAtual).obterVertice());
            for(int i = 0; i < numVertices; i++){
                if(matrizAdj[verticeAtual][i] == 1 && !visitados[i]){
                    visitados[i] = true;
                    filaVertices.adicionar(indiceParaVertice.get(i));
                }
            }

            System.out.print("Vertices visitados: ");
            for(int i = 0; i < numVertices; i++){
                if(visitados[i]){
                    System.out.print(indiceParaVertice.get(i).obterVertice() + " ");
                }
            }
            System.out.printf("%nFila: ");
            filaVertices.exibirFila();
        }
        System.out.println();
    }
}
