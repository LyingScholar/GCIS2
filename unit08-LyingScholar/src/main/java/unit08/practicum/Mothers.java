package unit08.practicum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import unit08.graphs.AdjacencyGraph;

public class Mothers {

    public static List<String> findMothers(AdjacencyGraph<String> unweightedGraphOfStrings, List<String> values) {
        List<String> mothers = new ArrayList<>();
        
        for (String value : values) {
            if (isAMotherVertex(unweightedGraphOfStrings, value, values)) {
                mothers.add(value);
            }
        }
        
        return mothers;
    }

    private static boolean isAMotherVertex(AdjacencyGraph<String> graph, String val, List<String> values) {
        for(String node : values){
            if(!graph.dfSearch(val,node)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        AdjacencyGraph<String> graph1 = new AdjacencyGraph<>();
        AdjacencyGraph<String> graph2 = new AdjacencyGraph<>();

        List<String> graph1Values = Arrays.asList("A", "B", "C", "D", "E");
        List<String> graph2Values = Arrays.asList("X", "T", "V", "U", "Y", "Z", "W");


        graph1.add("A");
        graph1.add("B");
        graph1.add("C");
        graph1.add("D");
        graph1.add("E");
        graph1.connectDirected("A", "B");
        graph1.connectDirected("B", "C");
        graph1.connectDirected("C", "D");
        graph1.connectDirected("E", "A");
        graph1.connectDirected("B", "E");
        
        // For Graph 2
        graph2.add("X");
        graph2.add("T");
        graph2.add("V");
        graph2.add("U");
        graph2.add("Y");
        graph2.add("Z");
        graph2.add("W");
        graph2.connectDirected("X", "T");
        graph2.connectDirected("T", "V");
        graph2.connectDirected("X", "U");
        graph2.connectDirected("Y", "X");
        graph2.connectDirected("W", "T");
        graph2.connectDirected("Y", "W");
        graph2.connectDirected("Z", "U");
        graph2.connectDirected("Z", "Y");

        System.out.println("Mother Vertices in Graph 1: " + findMothers(graph1, graph1Values));
        System.out.println("Mother Vertices in Graph 2: " + findMothers(graph2, graph2Values));
    }
}