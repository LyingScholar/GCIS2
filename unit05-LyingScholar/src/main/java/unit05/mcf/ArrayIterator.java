package unit05.mcf;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private Object[] elements;
    private int index;
    private int size;
    
    public ArrayIterator(Object[] elements, int stopIndex){
        this.elements = elements;
        this.index = 0;
        this.size = stopIndex;
    }

    @Override
    public boolean hasNext(){
        boolean temp = index <size;
        System.out.println("hasNext(): " + temp);
        return index < size;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public E next(){
        E element = (E)elements[index];
        index++;
        System.out.println("next(): " + element);
        return element;
    }
        
    
    
}
