package com.projeto_eda.estruturas.fila;

public class No<T> {
    
    private T valor;
    private No<T> proximo;

    public No(T valor){
        this.valor = valor;
        proximo = null;
    }

    public T obterValor() {
        return valor;
    }
    public No<T> obterProximo() {
        return proximo;
    }
    public void definirProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    
}
