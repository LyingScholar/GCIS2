package unit07.sourceTarget;

 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import unit07.graphs.AdjacencyGraph;

public class BFSMain {

    public static AdjacencyGraphST<String> makeAdjacencyGraphST(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String[] sourceTextValues = br.readLine().split(" ");

            String[] targetTextValues = br.readLine().split(" ");

            AdjacencyGraph<String> graph = makeAdjacencyGraph(br);

            AdjacencyGraphST<String> adjancy = new AdjacencyGraphST<>(graph,sourceTextValues,targetTextValues);
            return adjancy;
        }
        
    }

    public static AdjacencyGraphSTv2<String> makeAdjacencyGraphSTv2(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String[] sourceTextValues = br.readLine().split(" ");

            String[] targetTextValues = br.readLine().split(" ");

            AdjacencyGraph<String> graph = makeAdjacencyGraph(br);

            AdjacencyGraphSTv2<String> adjancy = new AdjacencyGraphSTv2<>(graph,sourceTextValues,targetTextValues);
            return adjancy;
        }
        
    }

    private static AdjacencyGraph<String> makeAdjacencyGraph(BufferedReader br) throws IOException{
    AdjacencyGraph<String> graph = new AdjacencyGraph<>();
            
            String line = br.readLine();
            // System.out.println("ertyuik");
            while (line != null) {
                // System.out.println(line);
                String[] textValues = line.split(" ");
                for(String textValue : textValues){
                    if (!graph.contains(textValue)) {
                        graph.add(textValue);
                    }
                    // if(graph.connected(textValues[0], textValue)){
                    //     graph.connectUndirected(textValues[0], textValue);
                    // }else{
                        graph.connectDirected(textValues[0], textValue);
                    }
                    line = br.readLine();
            }
            return graph;
        }
        

    public static void main(String[] args) {
        
        String filename = "data/bfs/graph10.txt";

        try {
            //ypu may change the file, it works with all of them
            AdjacencyGraphST<String> adjacencyGraphST = makeAdjacencyGraphST(filename);

            System.out.println("Testing bfSearch in v1");
            boolean searchResult = adjacencyGraphST.bfSearch();
            System.out.println("Path exist between the sources and targets? " + searchResult);

            System.out.println("Testing bfPath in v1");
            List<String> pathResult = adjacencyGraphST.bfPath();
            if (pathResult != null) {
                System.out.println("Path between source and target: " + pathResult);
            } else {
                System.out.println("No path found");
            }
        } catch (IOException e) {
            System.err.println("Wrong filename");
        } catch (Exception e) {
            //i am well aware this was not taught
            //please dont email me about this
            System.err.println("An unexpected error occurred");
        }

        System.out.println();

        try {

            AdjacencyGraphSTv2<String> adjacencyGraphSTv2 = makeAdjacencyGraphSTv2(filename);

            System.out.println("Testing bfSearch in v2");
            boolean searchResult = adjacencyGraphSTv2.bfSearch();
            System.out.println("Path exist between the sources and targets? " + searchResult);

            System.out.println("Testing bfPath in v2");
            List<String> pathResult = adjacencyGraphSTv2.bfPath();
            if (pathResult != null) {
                System.out.println("Path between source and target: " + pathResult);
            } else {
                System.out.println("No path found");
            }
        } catch (IOException e) {
            System.err.println("Wrong filename");
        }
    }
}