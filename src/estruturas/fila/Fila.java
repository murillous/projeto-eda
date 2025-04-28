package estruturas.fila;

import estruturas.grafo.Vertice;

public class Fila {
    
    private No<Vertice> inicio;
    private No<Vertice> fim;

    public Fila(){
        inicio = null;
        fim = null;
    }

    public boolean estaVazio(){
        return inicio == null;
    }

    public void adicionar(Vertice valor){
        No<Vertice> novoNo = new No<>(valor);
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }

        fim.definirProximo(novoNo);
        fim = novoNo;

    }

    public Vertice retirar(){
        No<Vertice> current = inicio;
        inicio = inicio.obterProximo();
        return current.obterValor();
    }

    public void exibirFila(){
        No<Vertice> current = inicio;

        while(current != null){
            System.out.print(current.obterValor().obterVertice() + " -> ");
            current = current.obterProximo();
        }
        System.out.printf("VAZIO%n");
    }

    public No<Vertice> obterInicio() {
        return inicio;
    }

    public No<Vertice> obterFim() {
        return fim;
    }

}
