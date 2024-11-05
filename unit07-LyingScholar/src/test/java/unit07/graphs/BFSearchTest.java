package unit07.graphs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BFSearchTest {
    @Test
    public void bfSearchUndirectedTrue() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        boolean actual = graph.bfSearch("A", "G");

        // analyze
        assertTrue(actual);
    }

    @Test
    public void bfSearchFalse() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        boolean actual = graph.bfSearch("A", "K");

        // analyze
        assertFalse(actual);
    }

    @Test
    public void bfSearchDirectedTrue() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        boolean actual = graph.bfSearch("A", "H");

        // analyze
        assertTrue(actual);
    }

    @Test
    public void bfSearchDirectedFalse() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        boolean actual = graph.bfSearch("H", "A");

        // analyze
        assertFalse(actual);
    }
}
