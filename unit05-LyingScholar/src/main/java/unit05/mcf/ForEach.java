package unit05.mcf;

public class ForEach {
    public static void forArray(String[] array){
        for(String element : array){
            System.out.println(element);
        }
    }
    public static void forList(List<String> list){
        for(String item : list){
            System.out.println(item);
        }
    }

    public static void forQueue(Queue<String> queue){
        for(String element: queue){
            System.out.println(element);
        }
    }


    public static void main(String[] args) {
        String[] array = {"Not","All", "Those", "Who", "Exist", "Want", "To"};
        System.out.println();
        forArray(array);

        System.out.println("\nArrayList: ");
        ArrayList<String> al = new ArrayList<>();
        al.append("Do");
        al.append("You");
        al.append("Wish");
        al.append("To");
        al.append("Exist");
        al.append("?");

        System.out.println();
        forList(al);

        System.out.println("\nNodeQueue: ");
        NodeQueue<String> nq = new NodeQueue<>();
        nq.enqueue("Is");

        nq.enqueue("Revenge");
        nq.enqueue("A");
        nq.enqueue("Science");
        nq.enqueue("or");
        nq.enqueue("An");
        nq.enqueue("Art");
        nq.enqueue("?");
        System.out.println();
        forQueue(nq);

        System.out.println("\nArrayQueue: ");
        ArrayQueue<String> aq = new ArrayQueue<>();
        aq.enqueue("Can");
        aq.enqueue("A");
        aq.enqueue("Woodchuck");
        aq.enqueue("Chuck");
        aq.enqueue("wood");
        aq.enqueue("like");
        aq.enqueue("A");
        aq.enqueue("Woodchecker");
        aq.enqueue("Chucks");
        aq.enqueue("Wood");
        aq.enqueue("?");
        aq.dequeue();
        aq.dequeue();
        System.out.println();
        forQueue(aq);





        System.out.println();
    }
}
