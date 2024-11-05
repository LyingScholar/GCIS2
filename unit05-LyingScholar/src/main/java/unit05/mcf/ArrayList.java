package unit05.mcf;

import java.util.Arrays;
import java.util.Objects;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private Object[] elements;
    private int size;

    public ArrayList(){
        this.elements = new Object[2];
        this.size = 0;
    }

    public ArrayList(List<E> list){
        this.elements = new Object[list.size()];
        this.size = 0;
        for(E item : list){
            this.append(item);
        }

    }


    @Override
    public void append(E value) {

        if (size == elements.length) {
            System.out.println("*** Resizing ***");
            elements = Arrays.copyOf(elements, size*2);

        }
        elements[size] =value;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o instanceof ArrayList == false) {
            return false;
        }

        ArrayList<E> other = (ArrayList<E>) o;
        if (this.size != other.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (Objects.equals(this.get(i), other.get(i)) == false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index){
        return (E)elements[index];
    }

    @Override
    public void set(int index, E value){
        elements[index] = value;
    }

    @Override
    public String toString(){
        return size + ", " + Arrays.toString(elements);
    }

    @Override
    public Iterator<E> iterator() {
        System.out.println("ArrayList: iterator()");
        return new ArrayIterator<>(elements,size);
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        System.out.println("\n" + al);
        
        System.out.println("\nAppendimg: ");
        al.append(147);
        System.out.println(al);
        al.append(253);
        System.out.println(al);


        al.append(342);
        System.out.println(al);
        al.append(456);
        System.out.println(al);

        al.append(987);
        System.out.println(al);
        System.out.println();



    }


}
