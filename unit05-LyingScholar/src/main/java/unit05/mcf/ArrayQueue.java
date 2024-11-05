package unit05.mcf;

import java.util.Arrays;
import java.util.Iterator;


public class ArrayQueue<E> implements Queue<E> {
    private Object[] elements;
    private int front;
    private int back;
    private int size;

    public ArrayQueue(){
        elements = new Object[2];
        front = 0;
        back= 0;
        size=0;
    }

    // public String[] ArrayList(List<E> list){
    //     for(int i = 0;i<list.length; i++):

    // }

    @Override
    public void enqueue(E value){
        //5.11 resize if needed
        if(size == elements.length){
            System.out.println("*** resizing... ***");
            Object[] copy = new Object[elements.length *2];
            for(int dest = 0; dest<size; dest++){
                int source = (front +dest) % size;
                copy[dest] = elements[source];
            }
            elements = copy;
            front = 0;
            back = size;
        }

        //5.9 basic enqueue

        elements[back] = value;
        back = (back+1)% elements.length;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E dequeue() {
        E temp = (E)elements[front];
        elements[front] = null;
        front = (front+1)% elements.length;
        size--;
        return temp;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public String toString(){
        if(size == 0){
            return "" + size();

        }else{
            return size() + ","+Arrays.toString(elements);
        }
    }

    @Override
    public Iterator<E> iterator(){
        return new ArrayIterator<>(elements, size);
    }

    public static void main(String[] args) {
        ArrayQueue<String> aq = new ArrayQueue<>();
        System.out.println("\nelements: " + aq.elements.length);
        System.out.println(aq);

        System.out.println("\nEnqueue:");
        aq.enqueue("Xx");
        System.out.println(aq);
        aq.enqueue("Yy");
        System.out.println(aq);
        aq.enqueue("Zz");
        System.out.println(aq);
        System.out.println();

        System.out.println("\nDequeue:");
        System.out.println(aq);
        System.out.println("Dequeued: "+ aq.dequeue());
        System.out.println(aq);
        System.out.println("Dequeued: "+aq.dequeue());
        System.out.println(aq);
        System.out.println("Dequeued: "+aq.dequeue());
        
        System.out.println();
        System.out.println();
    }
}
