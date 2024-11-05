package practicum3.labnetwork;
import java.nio.file.Path;
import java.util.List;

import practicum3.graphs.AdjacencyGraph;
import practicum3.graphs.Graph;

public class PartA {
    /**
     * Construct the graph according to the given diagram
     * @param stations - list of stations on the network
     * @return - the graph that models the tube network
     */
    public static Graph<String> modelTubes(String[] stations) {
        Graph<String> network = new AdjacencyGraph<>();

        network.add("E125");
        network.add("E230");
        network.add("E375");
        network.add("C101");
        network.add("C201");
        network.add("C301");
        network.add("W125");
        network.add("W250");


        network.connectUndirected("E125", "E230");
        network.connectUndirected("E125", "E375");
        network.connectUndirected("C101", "E125");
        network.connectUndirected("C101", "E230");
        network.connectUndirected("C301", "E230");
        network.connectUndirected("C301", "E375");
        network.connectUndirected("C101", "C201");
        network.connectUndirected("C301", "C201");
        network.connectUndirected("C101", "W250");


        network.connectDirected("W125", "W250");
        network.connectDirected("W250","C301");
        return network;
    }

    /**
     * Prints the network path between each pair of stations using the printPath method
     * @param network - graph created from the buildNetwork method
     * @param stations - list of stations on the network
     */
    public static void printAllTubePaths(Graph<String> network,String[] stations) {
        for (String source : stations) {
            for (String destination : stations) {
                if (!source.equals(destination)) {
                    List<String> path = network.bfPath(source, destination);
                    printPath(source, destination, path);
                }
            }
        }
    }

    /**
     * Prints the path between two stations, if it exists
     * 
     * @param source - name of the starting station
     * @param destination - name of ending station
     * @param path - list of station names if path exists, null otherwise
     */
    public static void printPath(String source, String destination, List<String> path) {
        if (path != null)
            System.out.println(source + " --> " + destination +": Length=" + path.size() + ", " + path);
        else
            System.out.println(source + " --> " + destination +": Length=0");
    }

    public static void main(String[] args) {
        String[] stations = {"E125", "E230", "E375", "W125", "W250",
                            "C101", "C201", "C301"};

        Graph<String> network = modelTubes(stations);

        System.out.println("Lab Network (Part A):");
        printAllTubePaths(network, stations);
    }  
}
