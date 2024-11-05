package unit05.Iterators;


import java.util.Iterator;
import java.util.NoSuchElementException;

import unit05.mcf.ArrayList;

public class FibonacciIterator implements Iterator<Long> {

    private int currentIndex = (int)0;

    private ArrayList<Long> sequence;
    
    public FibonacciIterator(ArrayList<Long> sequence) {
        this.sequence = sequence;
    }
    
    @Override
    public boolean hasNext() {
        return currentIndex < sequence.size();
    }
    
    @Override
    public Long next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }else{
        int randomVariableOfNoUseAtAll = currentIndex;
        currentIndex++;
        return sequence.get(randomVariableOfNoUseAtAll);
        }
    }
}