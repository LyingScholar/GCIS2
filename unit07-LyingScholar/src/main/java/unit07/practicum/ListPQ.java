package unit07.practicum;

import java.util.Iterator;
import java.util.LinkedList;

public class ListPQ implements Queue<Integer>{
    private LinkedList<Integer> list;

    public ListPQ() {
        list = new LinkedList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void enqueue(Integer value) {
        if (list.isEmpty()) {
                list.addLast(value);
        } else {

            Iterator<Integer> iterator = list.iterator();
            
            int i = 0;

            while (iterator.hasNext()) {
                if (iterator.next() >= value) {
                    break;
                }
                i++;
            }
            list.add(i, value);
        }
    }

    @Override
    public Integer dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.pop();
    }


}
