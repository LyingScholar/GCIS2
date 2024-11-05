package unit05.mcf;

public class Node<E> {
    private E value;
    private Node<E> next;

    public Node(E value, Node<E> next){
        this.value = value;
        this.next = next;
    }
    
    public Node(E value){
        this(value, null);
    }

    public E getValue(){
        return value;
    }
    public void setNext(Node<E> next){
    this.next = next;
    }

    public Node<E> getNext(){
        return next;
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public String toString(){
        Node<E> current = this;
        String string = "";
        while(current.next != null){
            string +=current.getValue();
            string +=" -> ";
            current = current.getNext();

        }
        string += current.getValue() + " -> null";
        return string;
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(111);
        Node<Integer> node2 = new Node<>(222);
        Node<Integer> node3 = new Node<>(333);

        System.out.println();
        System.out.println(node1);

        System.out.println();
        node1.setNext(node2);
        System.out.println(node2);
        System.out.println(node1);

        node1.setNext(node3);
        node3.setNext(node2);

        System.out.println("\n"+ node1);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(null);

        System.out.println("\n"+ node1);

        System.out.println();
        System.out.println(node3);

    }
    
}
