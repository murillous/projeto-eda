package com.projeto_eda.estruturas.grafo;

import com.projeto_eda.estruturas.fila.Fila;
import com.projeto_eda.utils.GrafoConstrutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;


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
    
    public void ehAdjacente(String vx, String vy){
        vx = vx.toUpperCase();
        vy = vy.toUpperCase();
        if(!(verticeParaIndice.containsKey(vx) && verticeParaIndice.containsKey(vy))){
            System.out.println("\nUm ou mais vertices não existem\n");
            return;
        }
        int primeiroVertice = verticeParaIndice.get(vx).obterIndice();
        int segundoVertice = verticeParaIndice.get(vy).obterIndice();

        if(matrizAdj[primeiroVertice][segundoVertice] == 1){
            System.out.printf("\nOs vertices %s e %s são adjacentes\n\n",vx,vy);
        }
        else {
            System.out.printf("\nOs vertices %s e %s não são adjacentes\n\n", vx, vy);
        }
    }

    public void verticeGrau(String vertice){
        vertice = vertice.toUpperCase();
        if(!verticeParaIndice.containsKey(vertice)){
            System.out.println("\nEsse vertice não existe\n");
            return;
        }
        int indice = verticeParaIndice.get(vertice).obterIndice();
        int grau = 0;
        int grauSaida = 0;
        int grauEntrada = 0;
        if(ehDirecionado) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdj[indice][i] == 1) {
                    grauSaida++;
                }
                if (matrizAdj[i][indice] == 1) {
                    grauEntrada++;
                }
            }
            System.out.printf("No vertice %s:\n--> Grau de saida: %d\n--> Grau de entrada\n\n",vertice,grauSaida,grauEntrada);
            return;
        }
        for(int i = 0; i < numVertices; i++){
            if(matrizAdj[indice][i] == 1){
                grau++;
            }
        }
        System.out.printf("\nGrau do vertice %s: %d%n\n",vertice,grau);
    }
    
    public void buscarVizinhos(String vx){
        vx = vx.toUpperCase();
        if(!(verticeParaIndice.containsKey(vx))){
            System.out.printf("\nO vertice %s não existe\n\n",vx);
            return;
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
    }

    public void visitarArestas() {
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            for (int j = (ehDirecionado ? 0 : i); j < numVertices; j++) {
                if (matrizAdj[i][j] == 1) {
                    String fonte = indiceParaVertice.get(i).obterVertice();
                    String destino = indiceParaVertice.get(j).obterVertice();
                    System.out.printf("Visitando aresta entre %s e %s%n", fonte, destino);
                }
            }
        }

        System.out.println();
    }

    public void buscaEmLargura(String verticeInicial){
        verticeInicial = verticeInicial.toUpperCase();
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

    public void grafoDuasCores(){

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
                        return;
                    }
                }
            }
        }
        System.out.println("O grafo pode ser colorido com duas cores");
    }

    public void visualizarGrafoUI() {
            System.setProperty("org.graphstream.ui", "swing");

            Graph graph = new SingleGraph("Visualização do Grafo");

            graph.setAttribute("ui.quality");
            graph.setAttribute("ui.antialias");

            graph.setAttribute("ui.stylesheet",
                    "node {" +
                            "   size: 30px;" +
                            "   text-alignment: center;" +
                            "   text-size: 14px;" +
                            "   text-color: white;" +
                            "   text-style: bold;" +
                            "   text-background-mode: none;" +
                            "   text-padding: 5px, 4px;" +
                            "}" +
                            "edge {" +
                            "   arrow-size: 12px, 6px;" +
                            "   text-alignment: center;" +
                            "   text-style: bold;" +
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

            graph.display();

            System.out.println("Grafo exibido com sucesso. Feche a janela para voltar ao menu principal.");
    }
}