package unit06.practicum;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E> {
    private Object[] elements;
    private int size;
    
    public ArrayStack() {
        elements = new Object[10];
        size = 0;
    }
    
    @Override
    public String toString() {
        String str = "[";
        for (int i = size - 1; i >= 0; i--) {
            str += elements[i];
            if (i > 0) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @SuppressWarnings("unchecked")
    //vscode recommnedation
    @Override
    public E top() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return (E) elements[size - 1];
    }
    
    
    private void increaseCapacity() {
        Object[] newArray = new Object[elements.length * 2];
        //saves time if i just double it i guess
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }
    
    @Override
    public void push(E value) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = value;
    }
    
    @SuppressWarnings("unchecked")
    //vscode recommnedation
    @Override
    public E pop() {
        if (size == 0) {
            throw new IllegalStateException("Cannot pop from empty stack");
        }
        E value = (E) elements[--size];
        elements[size] = null;
        return value;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(elements, size); 
    }
}