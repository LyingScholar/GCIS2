package unit05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import unit05.mcf.LinkedList;



public class LinkedListTest {
    
     @Test
    void testAppendAndGet() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(10);
        list.append(20);
        list.append(30);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    void testSet() {
        LinkedList<String> list = new LinkedList<>();
        list.append("apple");
        list.append("banana");
        list.append("cherry");

        list.set(1, "bluberry");
        assertEquals("apple", list.get(0));
        assertEquals("bluberry", list.get(1));
        assertEquals("cherry", list.get(2));

        // assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, "orange"));
    }

    @Test
    void testSize() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(0, list.size());

        list.append(" one");
        assertEquals(1, list.size());

        list.append(" two");
        assertEquals(2, list.size());

        list.append("three");
        assertEquals(3, list.size());
    }

    @Test
    void testToString() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);

        assertEquals("1 -> 2 -> 3 [3]", list.toString());
    }


    @Test
    void testEquals() {

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();

        assertTrue(list1.equals(list2));

        list1.append(10);
        list2.append(10);
        assertTrue(list1.equals(list2));

        list1.append(20);
        list2.append(30);
        assertFalse(list1.equals(list2));

        list3.append(10);
        list3.append(20);
        assertTrue(list1.equals(list3));
    }
}
