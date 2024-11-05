package unit05.Iterators;

import java.util.Iterator;

import unit05.mcf.ArrayList;

public class IterableFibonacci implements Iterable<Long> {

    private ArrayList<Long> fibbi;
    private long lastTerm;
    private long secondLastTerm;
    private long firstTerm;
    private long secondTerm;
    // I guess i need a sewuence

    public IterableFibonacci(long first, long second) {
        fibbi = new ArrayList<>();
        fibbi.append(first);
        fibbi.append(second);
        firstTerm = first;
        secondTerm = second;
        secondLastTerm = first;
        lastTerm = second;
    }

    public void add() {
        long next = lastTerm + secondLastTerm;
        fibbi.append(next);
        secondLastTerm = lastTerm;
        lastTerm = next;
    }

    public Long get(int index) {
        if (index < 0 || index >= fibbi.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + fibbi.size());
        } else {
            return fibbi.get(index);
        }
    }

    public int length() {
        return fibbi.size();
    }

    // @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Iterator<Long> iterator() {
        return new FibonacciIterator(fibbi);
    }

    @Override
    public String toString() {
        String sb = "["+ firstTerm + ", " + secondTerm;
        long previousNumber = firstTerm;
        long currentNumber = secondTerm;
        for (int i = 2; i < fibbi.size(); i++) {
            long next = previousNumber + currentNumber;
            sb+= ", "  + next;
            previousNumber = currentNumber;
            currentNumber = next;
        }
        sb += "]";
        return sb;
    }

    public static void main(String[] args) {
        IterableFibonacci fib = new IterableFibonacci(2, 5);
        fib.add();
        fib.add();
        fib.add();
        fib.add();
        fib.add();
        fib.add();
        fib.add();
        fib.add();
        System.out.println(fib);
        System.out.println(fib.get(0)); // 2
        System.out.println(fib.get(1)); // 5

        System.out.println("Fibonacci sequence length: " + fib.length());

        for (long fibNumber : fib) {
            System.out.println(fibNumber);
        }
    }

}