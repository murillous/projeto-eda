package estructures.queue;

public class Queue<T> {
    
    private Node<T> head;
    private Node<T> last;

    public Queue(){
        head = null;
        last = null;
    }

    public void add(T value){
        Node<T> newNode = new Node<>(value);
        if(head == null){
            head = newNode;
            last = newNode;
            return;
        }

        last.setNext(newNode);
        last = newNode;

    }

    public T pop(){
        Node<T> current = head;
        head = head.getNext();
        return current.getValue();
    }

    public void printQueue(){
        Node<T> current = head;
        System.out.println("============QUEUE============");
        while(current != null){
            System.out.print(current.getValue() + " -> ");
            current = current.getNext();
        }
        System.out.printf("NULL%n=============================%n");
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getLast() {
        return last;
    }

}
