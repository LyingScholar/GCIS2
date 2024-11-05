package unit07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit07.practicum.HeapPQ;
import unit07.practicum.ListPQ;
import unit07.practicum.Queue;

public class PQTest {
    private Queue<Integer> heapPQ;
    private Queue<Integer> listPQ;


    private void enqueueAndDequeue(Queue<Integer> queue) {
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(1);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
    }



    private void alternatingEnqueueAndDequeue(Queue<Integer> queue) {
        
        queue.enqueue(5);
        queue.enqueue(3);
        assertEquals(3, queue.dequeue());
        queue.enqueue(7);
        queue.enqueue(1);
        assertEquals(1, queue.dequeue());
        assertEquals(5, queue.dequeue());
        queue.enqueue(2);
        assertEquals(2, queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(6);
        assertEquals(4, queue.dequeue());
        assertEquals(6, queue.dequeue());
        queue.enqueue(8);
        assertEquals(7, queue.dequeue());
    }


    @Test
    public void testEnqueueAndDequeue() {
        heapPQ = new HeapPQ();
        listPQ = new ListPQ();
        enqueueAndDequeue(heapPQ);
        enqueueAndDequeue(listPQ);
    }

    @Test
    public void testAlternatingEnqueueAndDequeue() {
        heapPQ = new HeapPQ();
        listPQ = new ListPQ();
        alternatingEnqueueAndDequeue(heapPQ);
        alternatingEnqueueAndDequeue(listPQ);
    }


}
