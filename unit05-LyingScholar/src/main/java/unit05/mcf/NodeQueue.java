package unit05.mcf;

import java.util.Iterator;

public class NodeQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> back;
    private int size;

    public NodeQueue(){
        front = null;
        back = null;
        size = 0;
    }
    @Override
    public void enqueue(E value) {
        Node<E> node = new Node<>(value);
        if(front == null){
            front = node;
            back = node;
        }else{
            back.setNext(node);
            back = node;
        }
        size++;

    }


    @Override
    public E dequeue() {
        E temp = front.getValue();
        front = front.getNext();
        if(front == null){
            back = null;
        }
        size--;
        return temp;
    }
    @Override
    public int size() {
        return size;
        
    }


    @Override
    public String toString(){
        if (size == 0){
            return "" + size();
        }else{
            return size() + ", " + front.toString();

        }
    }

    @Override
    public Iterator<E> iterator(){
        return new NodeIterator<>(front);
    }


    public static void main(String[] args) {
        NodeQueue<String> nq = new NodeQueue<>();

        System.out.println("\n" + nq);
        System.out.println("\nEnqueue:");
        nq.enqueue("a");
        System.out.println(nq);
        nq.enqueue("b");
        System.out.println(nq);
        nq.enqueue("c");
        System.out.println(nq);
        System.out.println();

        System.out.println("\nDequeue:");
        System.out.println(nq.dequeue());
        System.out.println(nq);
        System.out.println(nq.dequeue());
        System.out.println(nq);
        System.out.println(nq.dequeue());
        System.out.println(nq);
        System.out.println();
    }
    
}
