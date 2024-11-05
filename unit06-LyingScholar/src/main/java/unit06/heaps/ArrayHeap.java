package unit06.heaps;

import java.util.Arrays;

public class ArrayHeap implements Heap{
    private int[] array;
    private int size;

    public ArrayHeap(){
        array = new int[3];
        size = 0;
    }

    @Override
    public String toString(){
        return size + ", " + Arrays.toString(array);
    }

    @Override
    public void add(int value) {
        if(size == array.length){
            array = Arrays.copyOf(array, size*2);
        }
        array[size] = value;

        //sift up if needed

        int child = size;
        int parent = (child-1)/2;
        while(array[parent] > array[child]){
            swap(parent,child);
            child = parent;
            parent = (child - 1 )/2;
        }

        size++;
    }

    private void swap(int a, int b){
        if(a !=b){
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;

        }
    }

    @Override
    public int remove() {
        int temp = array[0];
        size--;
        swap(0,size);
        array[size]=0;

        //sifting down
        int parent = 0;
        while (parent<size) {
            int left  = parent * 2 + 1;
            int right = left +1;
            int dest = parent;
            if (left<size) {
                dest = left;
            }
            if (right<size && array[right] < array[left]) {
                dest = right;
                
            }
            if(array[dest] < array[parent]){
                swap(dest,parent);
                parent = dest;
            }else{
                break;
            }
        }

        return temp;

    }


    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Heap heap = new ArrayHeap();
        System.out.println("\n" + heap);
        System.out.println();
        heap.add(5);
        System.out.println(heap);
        heap.add(4);
        System.out.println(heap);
        heap.add(3);
        System.out.println(heap);
        heap.add(2);
        System.out.println(heap);
        heap.add(1);
        System.out.println("\n" + heap);
        System.out.println();
        System.out.println(heap.remove() + " - " + heap);
        System.out.println(heap.remove() + " - " + heap);
        System.out.println(heap.remove() + " - " + heap);
        System.out.println(heap.remove() + " - " + heap);

        System.out.println();

    }
}