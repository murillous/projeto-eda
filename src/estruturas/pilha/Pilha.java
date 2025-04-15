package estruturas.pilha;

public class Pilha<T> {
    
    private No<T> inicio;
    private No<T> fim;

    public Pilha(){
        inicio = null;
        fim = null;
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

    public void printQueue(){
        No<T> current = inicio;
        System.out.println("============QUEUE============");
        while(current != null){
            System.out.print(current.obterValor() + " -> ");
            current = current.obterProximo();
        }
        System.out.printf("VAZIO%n=============================%n");
    }

    public No<T> obterInicio() {
        return inicio;
    }

    public No<T> obterFim() {
        return fim;
    }

}
