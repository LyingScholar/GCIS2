package practicum3.labnetwork;

import java.util.List;

import practicum3.graphs.WAdjacencyGraph;
import practicum3.graphs.WGraph;
import practicum3.graphs.WPath;

public class PartB {
    /**
     * Construct the graph according to the given diagram
     * 
     * @param stations - list of stations on the network
     * @return - the graph that models the tube network
     */
    public static WGraph<String> modelTubes(String[] stations) {
        WGraph<String> network = new WAdjacencyGraph<>();
        network.add("E125");
        network.add("E230");
        network.add("E375");
        network.add("C101");
        network.add("C201");
        network.add("C301");
        network.add("W125");
        network.add("W150");

        network.connect("E125", "E230",13);
        network.connect("E125", "E375",40);
        network.connect("C101", "E125",5);
        network.connect("C101", "E230",25);
        network.connect("C301", "E230",28);
        network.connect("C301", "E375",9);
        network.connect("C101", "C201",8);
        network.connect("C301", "C201",6);
        network.connect("C101", "W150",22);
        network.connect("C301", "W150",30);
        network.connect("W125", "W150",7);

        return network;
    }

    /**
     * Prints the network path between each pair of stations using the printPath method
     * 
     * @param network - graph created from the modelTubes method
     * @param stations - list of stations on the network
     */
    public static void printAllTubePaths(WGraph<String> network,String[] stations) {
        for (String source : stations) {
            for (String destination : stations) {
                if (!source.equals(destination)) {
                    WPath<String> path = network.dijkstrasPath(source, destination);
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
     * @param path - weighted path of station names and weight, if one exists, null otherwise
     */
    public static void printPath(String source, String destination, WPath<String> path) {
        if (path != null)
            System.out.println(source + " --> " + destination + ": Length=" + path.size() + ", " + path);
        else
            System.out.println(source + " --> " + destination + ": Length=0");
    }

    public static void main(String[] args) {
        String[] stations = {"E125", "E230", "E375", "W125", "W150",
                            "C101", "C201", "C301"};
        //image has W150, the code had W250, contradicition
        //i chose W150

        WGraph<String> network = modelTubes(stations);

        System.out.println("Lab Network (Part B):");
        printAllTubePaths(network, stations);
    }
}
