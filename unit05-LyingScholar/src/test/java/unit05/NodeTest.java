package unit05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit05.mcf.Node;

public class NodeTest {


        @Test
    public void testNewNode() {
        Node<Integer> node = new Node<>(100);
        assertEquals(100, node.getValue());
        assertEquals(null, node.getNext());
    }


    @Test
    public void testSetValueInNode() {
        Node<String> node = new Node<>("Hello");
        assertEquals("Hello", node.getValue());
        node.setValue("Updated");

        assertEquals("Updated", node.getValue());
    }

    @Test
    public void testSetNextNode() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        node1.setNext(node2);
        assertEquals(node2, node1.getNext());
    }
}
