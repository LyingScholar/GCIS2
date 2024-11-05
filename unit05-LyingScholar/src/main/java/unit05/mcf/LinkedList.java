package unit05.mcf;


public class LinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    @Override
    public void append(E value) {
        Node<E> newNode = new Node<>(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> currentNode = head;
        int counter = 0;
        while (counter < index) {
            currentNode = currentNode.getNext();
            counter++;
        }
        return currentNode.getValue();
    }


    @Override
    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> currentNode = head;
        int counter = 0;

        while (counter < index) {
            currentNode = currentNode.getNext();
            counter++;
        }
        currentNode.setValue(value);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {

        if(size == 0){
            return " " + " [" + size() + "]";

        }else{
            String result = "";
            Node<E> current = head;
        while (current != null) {
            result += current.getValue();
            if (current.getNext() != null) {
                result += " -> ";
            }
            current = current.getNext();
        }
        return result + " [" + size() + "]";
        }

        
    }


    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        LinkedList<E> other = (LinkedList<E>) obj;
        if (size != other.size) {
            return false;
        }



        Node<E> current = head;
        Node<E> otherCurrent = other.head;

        while (current != null) {
            if (current.getValue().equals(otherCurrent.getValue()) == false) {
                return false;
            }
            current = current.getNext();
            otherCurrent = otherCurrent.getNext();
        }
        return true;
    }

    
}
