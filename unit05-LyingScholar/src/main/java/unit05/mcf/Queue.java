package unit05.mcf;

import java.util.Iterator;

public interface Queue<E> extends Iterable<E>{
    void enqueue(E value);
    E dequeue();
    int size();

    @Override
    default Iterator<E> iterator(){
        throw new UnsupportedOperationException("Unimplemented method 'iterator' ");
    }

}
