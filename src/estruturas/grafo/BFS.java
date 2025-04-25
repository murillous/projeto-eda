package estruturas.grafo;

import estruturas.fila.Fila;

import java.util.List;
import java.util.Map;

public class BFS {

    private final int[][] matrizAdj;
    private final int numVertices;
    private final Map<String, Integer> verticeParaIndice;
    private final List<String> indiceParaVertice;

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
        int contadorVisitados = 0;

        visitados[vertice] = true;
        contadorVisitados++;
        Fila<String> fila = new Fila<>();
        fila.adicionar(indiceParaVertice.get(vertice));

        System.out.println("A busca em largura vai começar pelo vertice " + verticeInicial);

        while(!fila.estaVazio()) {
            if(contadorVisitados == numVertices){
                System.out.println("Todos os vertices foram visitados");
                return;
            }
            int verticeAtual = verticeParaIndice.get(fila.retirar());
            System.out.println("Vertice atual: " + indiceParaVertice.get(verticeAtual));
            for(int i = 0; i < numVertices; i++){
                if(matrizAdj[verticeAtual][i] == 1 && !visitados[i]){
                    visitados[i] = true;
                    contadorVisitados++;
                    fila.adicionar(indiceParaVertice.get(i));
                }
            }

            System.out.print("Vertices visitados: ");
            for(int i = 0; i < numVertices; i++){
                if(visitados[i]){
                    System.out.print(indiceParaVertice.get(i) + " ");
                }
            }
            System.out.printf("%nFila: ");
            fila.exibirFila();
        }
        System.out.println();
    }
}
