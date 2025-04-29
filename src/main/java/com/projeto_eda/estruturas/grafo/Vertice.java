package com.projeto_eda.estruturas.grafo;

public class Vertice {
    private final String vertice;
    private final int indice;
    private int cor = -1;

    public Vertice(String vertice, int indice){
        this.vertice = vertice;
        this.indice = indice;
    }

    public String obterVertice(){
        return vertice;
    }

    public int obterIndice(){
        return indice;
    }

    public void definirCor(int cor){this.cor = cor;}

    public int obterCor(){return cor;}

    public boolean estaColorido(){return cor != -1;}
}
