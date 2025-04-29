package com.projeto_eda.estruturas.grafo;

import com.projeto_eda.estruturas.fila.Fila;
import com.projeto_eda.utils.GrafoConstrutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.Viewer.ThreadingModel;
import org.graphstream.ui.view.View;

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

    public boolean grafoDuasCores(){

        for(Vertice v: indiceParaVertice){
            v.definirCor(-1);
        }

        int verticeInicial = 0;
        indiceParaVertice.get(0).definirCor(0);
        Fila fila = new Fila();
        fila.adicionar(indiceParaVertice.get(verticeInicial));

        while(!fila.estaVazio()){
            int indiceVerticeAtual = fila.retirar().obterIndice();
            Vertice verticeAtual = indiceParaVertice.get(indiceVerticeAtual);
            for(int i = 0; i < numVertices; i++){
                Vertice vi = indiceParaVertice.get(i);
                if(matrizAdj[indiceVerticeAtual][i] == 1){
                    if(vi.obterCor() == -1){
                        vi.definirCor(1 - verticeAtual.obterCor());
                        fila.adicionar(vi);
                    }
                    else if(verticeAtual.obterCor() == vi.obterCor()){
                        System.out.printf("%s e %s são vertices adjacentes que possuem a mesma cor%n", verticeAtual.obterVertice(), vi.obterVertice());
                        return false;
                    }
                }
            }
        }
        System.out.println("O grafo pode ser colorido com duas cores");
        return true;
    }

    public void visualizarGrafoUI() {
        try {
            System.setProperty("org.graphstream.ui", "swing");

            Graph graph = new SingleGraph("Visualização do Grafo");

            graph.setAttribute("ui.quality");
            graph.setAttribute("ui.antialias");

            graph.setAttribute("ui.stylesheet",
                    "node {" +
                            "   size: 30px;" +
                            "   text-alignment: center;" +
                            "   text-size: 14px;" +
                            "   text-color: black;" +
                            "   text-background-mode: rounded-box;" +
                            "   text-background-color: white;" +
                            "   text-padding: 5px, 4px;" +
                            "}" +
                            "edge {" +
                            "   arrow-size: 12px, 6px;" +
                            "   text-alignment: center;" +
                            "   text-background-mode: rounded-box;" +
                            "   text-background-color: white;" +
                            "   text-padding: 5px, 4px;" +
                            "}"
            );

            for (Vertice v : indiceParaVertice) {
                Node node = graph.addNode(v.obterVertice());
                node.setAttribute("ui.label", v.obterVertice());

                if (v.obterCor() != -1) {
                    String cor = v.obterCor() == 0 ? "red" : "blue";
                    node.setAttribute("ui.style", "fill-color: " + cor + ";");
                }
            }

            for (int i = 0; i < numVertices; i++) {
                for (int j = (ehDirecionado ? 0 : i + 1); j < numVertices; j++) {
                    if (matrizAdj[i][j] == 1) {
                        String id1 = indiceParaVertice.get(i).obterVertice();
                        String id2 = indiceParaVertice.get(j).obterVertice();
                        String edgeId = id1 + "-" + id2;
                        graph.addEdge(edgeId, id1, id2, ehDirecionado);
                    }
                }
            }

            Viewer viewer = graph.display();

            System.out.println("Grafo exibido com sucesso. Feche a janela para voltar ao menu principal.");

        } catch (Exception e) {
            System.err.println("Erro ao exibir o grafo: " + e.getMessage());
        }
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