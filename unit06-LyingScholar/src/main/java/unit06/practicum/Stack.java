package unit06.practicum;

import java.util.Iterator;

public interface Stack<E> extends Iterable<E>{
    void push(E value);
    E top();
    E pop();
    int size();

    @Override
    default Iterator<E> iterator(){
        throw new UnsupportedOperationException("Unimplemented method 'iterator' ");
    }

}
