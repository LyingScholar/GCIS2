package practicum3.graphs;

import java.util.List;

public interface WGraph<E> {
    void add(E value);
    boolean contains(E value);
    int size();
    void connect(E a, E b, double weight);
    boolean connected(E a, E b);
    double weight(E a, E b);
    List<E> getValues();

    List<E> bfPath(E start, E end);
    List<E> dfPath(E start, E end);
    WPath<E> nearestNeighbors(E start, E end);
    WPath<E> dijkstrasPath(E start, E end);
}
