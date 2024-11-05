package unit07.practicum;


public class HeapPQ implements Queue<Integer>{
    private ArrayHeap heap;

    public HeapPQ() {
        heap = new ArrayHeap();
    }

    
    @Override
    public int size() {
        return heap.size();
    }
    
    @Override
    public void enqueue(Integer value) {
        heap.add(value);
    }

    @Override
    public Integer dequeue() {
        return heap.remove();
    }



}

