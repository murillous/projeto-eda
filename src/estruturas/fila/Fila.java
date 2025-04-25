package estruturas.fila;

public class Fila<T> {
    
    private No<T> inicio;
    private No<T> fim;

    public Fila(){
        inicio = null;
        fim = null;
    }

    public boolean estaVazio(){
        return inicio == null;
    }

    public void adicionar(T valor){
        No<T> novoNo = new No<>(valor);
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }

        fim.definirProximo(novoNo);
        fim = novoNo;

    }

    public T retirar(){
        No<T> current = inicio;
        inicio = inicio.obterProximo();
        return current.obterValor();
    }

    public void exibirFila(){
        No<T> current = inicio;

        while(current != null){
            System.out.print(current.obterValor() + " -> ");
            current = current.obterProximo();
        }
        System.out.printf("VAZIO%n");
    }

    public No<T> obterInicio() {
        return inicio;
    }

    public No<T> obterFim() {
        return fim;
    }

}
