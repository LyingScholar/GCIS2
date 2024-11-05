package unit05.mcf;

import java.util.Iterator;

public class NodeIterator<E> implements Iterator<E> {
    private Node<E> node;

    public NodeIterator(Node<E> node){
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        boolean temp = (node != null);
        System.out.println("hssNext() - " + temp);
        
        return node != null;

    }

    @Override
    public E next() {
        E element  = node.getValue();
        node = node.getNext();
        System.out.println(" next() - " + element);
        return element;
    }
    
}
