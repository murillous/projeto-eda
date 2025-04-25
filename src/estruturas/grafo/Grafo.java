package estruturas.grafo;

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
        indiceParaVertice.addAll(verticeParaIndice.keySet());

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

    private void adcionarAresta(int fonte, int destino) {
            matrizAdj[fonte][destino] = 1;

            if(!ehDirecionado) {
                matrizAdj[destino][fonte] = 1;
            }
    }

    public void mostrarGrafo() {
        System.out.print("    ");
        for (String coluna : indiceParaVertice) {
            System.out.printf("%4s", coluna);
        }
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            String rotuloLinha = indiceParaVertice.get(i);
            System.out.printf("%4s", rotuloLinha);
            for (int j = 0; j < numVertices; j++) {
                System.out.printf("%4d", matrizAdj[i][j]);
            }
            System.out.println();
        }
    }

    public boolean ehAdjacente(String vx, String vy){
        if(!(verticeParaIndice.containsKey(vx) && verticeParaIndice.containsKey(vy))){
            System.out.println("Um ou mais vertices não existem");
            return false;
        }
        int primeiroVertice = verticeParaIndice.get(vx);
        int segundoVertice = verticeParaIndice.get(vy);

        if(matrizAdj[primeiroVertice][segundoVertice] == 1){
            System.out.printf("O vertices %s e %s são adjacentes\n",vx,vy);
            return true;
        }
        else {
            System.out.printf("O vertices %s e %s não são adjacentes\n", vx, vy);
            return false;
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
        System.out.printf("Grau do vertice %s: %d%n",vertice,grau);
        return grau;
    }

    public List<String> buscarVizinhos(String vx){
        if(!(verticeParaIndice.containsKey(vx))){
            System.out.printf("O vertice %s não existe",vx);
            return null;
        }
        int indiceVx = verticeParaIndice.get(vx);
        List<String> vizinhos = new ArrayList<>();

        for(int i = 0; i < numVertices; i++){
            if(matrizAdj[indiceVx][i] == 1){
                vizinhos.add(indiceParaVertice.get(i));
            }
        }

        System.out.printf("Os vizinhos do vertice %s são: ",vx);
        for(String vertice: vizinhos){
            System.out.print(vertice + " ");
        }

        System.out.println();
        return vizinhos;
    }

    public List<String[]> visitarArestas(){
        List<String[]> arestas = new ArrayList<>();
        for(int i = 0; i < numVertices; i++){
            for(int j = (ehDirecionado ? 0 : i) ; j < numVertices; j++){
                if(matrizAdj[i][j] == 1){
                    String fonte = indiceParaVertice.get(i);
                    String destino = indiceParaVertice.get(j);
                    System.out.printf("Visitando aresta entre %s e %s%n",fonte,destino);
                    arestas.add(new String[]{fonte,destino});
                }
            }
        }
        return arestas;
    }

    public void buscaEmLargura(String verticeInicial){
        BFS bfs = new BFS(this);
        bfs.buscaEmLargura(verticeInicial);
    }

    int obterNumVertices() {
        return numVertices;
    }

    Map<String, Integer> obterVerticeParaIndice() {
        return verticeParaIndice;
    }

    int[][] obterMatrizAdj() {
        return matrizAdj;
    }

    List<String> obterIndiceParaVertice() {
        return indiceParaVertice;
    }
}
