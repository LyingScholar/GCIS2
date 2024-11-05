package unit09;

import unit09.graphs.WAdjacencyGraph;
import unit09.graphs.WPath;

public class Word {
    public static void main(String[] args) { 
    WAdjacencyGraph<String> graph = new WAdjacencyGraph<>();

        graph.add("G");
        graph.add("R");
        graph.add("A");
        graph.add("P");
        graph.add("H");


        graph.connect("G", "R", 1);
        graph.connect("R", "A", 1);
        graph.connect("A", "P", 1);
        graph.connect("P", "H", 1);
        graph.connect("G", "H", 10);
        
        graph.connect("P", "R", 10);
        graph.connect("H", "A", 10);
        graph.connect("G", "P", 10);
        graph.connect("R", "H", 10);

        WPath<String> path = graph.dijkstrasPath("G", "H");
        
        if(path != null) {
            System.out.println(path);
        } else {
            System.out.println("No path found");
        }
    }
}
