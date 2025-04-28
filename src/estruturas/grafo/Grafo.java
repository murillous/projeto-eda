package estruturas.grafo;

import utils.GrafoConstrutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Grafo {

    private final boolean ehDirecionado;
    private final int numVertices;
    private final int[][] matrizAdj;
    private final Map<String, Vertice> verticeParaIndice;
    private final List<Vertice> indiceParaVertice;

    public Grafo(GrafoConstrutor grafoConstrutor){
        ehDirecionado = grafoConstrutor.obterEhDirecionado();
        verticeParaIndice = grafoConstrutor.obterVerticeParaIndice();

        indiceParaVertice = new ArrayList<>();
        indiceParaVertice.addAll(verticeParaIndice.values());

        numVertices = verticeParaIndice.size();
        matrizAdj = new int[numVertices][numVertices];

        List<String[]> arestas = grafoConstrutor.obterArestas();

        for(String[] aresta: arestas){
            String primeiroVertice = aresta[0];
            String segundoVertice = aresta[1];

            int fonte = verticeParaIndice.get(primeiroVertice).obterIndice();
            int destino = verticeParaIndice.get(segundoVertice).obterIndice();

            adcionarAresta(fonte, destino);
        }
    }

    private void adcionarAresta(int fonte, int destino) {
            matrizAdj[fonte][destino] = 1;

            if(!ehDirecionado) {
                matrizAdj[destino][fonte] = 1;
            }
    }

    public void mostrarGrafo() {
        System.out.print("    ");
        for (Vertice coluna : indiceParaVertice) {
            System.out.printf("%4s", coluna.obterVertice());
        }
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            String rotuloLinha = indiceParaVertice.get(i).obterVertice();
            System.out.printf("%4s", rotuloLinha);
            for (int j = 0; j < numVertices; j++) {
                System.out.printf("%4d", matrizAdj[i][j]);
            }
            System.out.println();
        }
    }

    // TODO: Rever necessidade de retorno
    public boolean ehAdjacente(String vx, String vy){
        if(!(verticeParaIndice.containsKey(vx) && verticeParaIndice.containsKey(vy))){
            System.out.println("\nUm ou mais vertices não existem\n");
            return false;
        }
        int primeiroVertice = verticeParaIndice.get(vx).obterIndice();
        int segundoVertice = verticeParaIndice.get(vy).obterIndice();

        if(matrizAdj[primeiroVertice][segundoVertice] == 1){
            System.out.printf("\nOs vertices %s e %s são adjacentes\n\n",vx,vy);
            return true;
        }
        else {
            System.out.printf("\nOs vertices %s e %s não são adjacentes\n\n", vx, vy);
            return false;
        }
    }

    // TODO: Rever necessidade de retorno
    public int verticeGrau(String vertice){
        if(!verticeParaIndice.containsKey(vertice)){
            System.out.println("\nEsse vertice não existe\n");
            return -1;
        }
        int indice = verticeParaIndice.get(vertice).obterIndice();
        int grau = 0;
        for(int i = 0; i < numVertices; i++){
            if(matrizAdj[indice][i] == 1){
                grau++;
            }
        }
        System.out.printf("\nGrau do vertice %s: %d%n\n",vertice,grau);
        return grau;
    }

    // TODO: Rever necessidade de retorno
    public List<Vertice> buscarVizinhos(String vx){
        if(!(verticeParaIndice.containsKey(vx))){
            System.out.printf("\nO vertice %s não existe\n\n",vx);
            return null;
        }
        int indiceVx = verticeParaIndice.get(vx).obterIndice();
        List<Vertice> vizinhos = new ArrayList<>();

        for(int i = 0; i < numVertices; i++){
            if(matrizAdj[indiceVx][i] == 1){
                vizinhos.add(indiceParaVertice.get(i));
            }
        }

        System.out.printf("\nOs vizinhos do vertice %s são: ",vx);
        for(Vertice vertice: vizinhos){
            System.out.print(vertice.obterVertice() + " ");
        }

        System.out.println("\n");
        return vizinhos;
    }

    // TODO: Rever necessidade de retorno
    public List<String[]> visitarArestas(){
        List<String[]> arestas = new ArrayList<>();
        System.out.println();

        for(int i = 0; i < numVertices; i++){
            for(int j = (ehDirecionado ? 0 : i) ; j < numVertices; j++){
                if(matrizAdj[i][j] == 1){
                    String fonte = indiceParaVertice.get(i).obterVertice();
                    String destino = indiceParaVertice.get(j).obterVertice();
                    System.out.printf("Visitando aresta entre %s e %s%n",fonte,destino);
                    arestas.add(new String[]{fonte,destino});
                }
            }
        }

        System.out.println();
        return arestas;
    }

    public void buscaEmLargura(String verticeInicial){
        BFS bfs = new BFS(this);
        bfs.buscaEmLargura(verticeInicial);
    }

    int obterNumVertices() {
        return numVertices;
    }

    Map<String, Vertice> obterVerticeParaIndice() {
        return verticeParaIndice;
    }

    int[][] obterMatrizAdj() {
        return matrizAdj;
    }

    List<Vertice> obterIndiceParaVertice() {
        return indiceParaVertice;
    }
}