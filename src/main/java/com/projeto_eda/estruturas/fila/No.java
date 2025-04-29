package com.projeto_eda.estruturas.fila;

public class No<T> {
    
    private T valor;
    private No<T> proximo;

    public No(T valor){
        this.valor = valor;
        proximo = null;
    }

    public No(T valor, No<T> proximo){
        this.valor = valor;
        this.proximo = proximo;
    }

    public T obterValor() {
        return valor;
    }
    public void definirValor (T valor) {
        this.valor = valor;
    }
    public No<T> obterProximo() {
        return proximo;
    }
    public void definirProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    
}
