package unit07.gvt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import unit07.graphs.Vertex;

public class GvT{
    // public dfPathMage()

    private AdjacencyGraph<Cell> graph;
    private Cell Start;
    private Cell End;
    ArrayList<Cell> Trolls = new ArrayList<Cell>();


    public GvT(String filename){
        graph = new AdjacencyGraph<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String[] dimensions = br.readLine().split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);
            //i am aware this is not part of what was taught i googled this


            
            for( int row = 0; row<rows;row++){
                String line = br.readLine();
                for (int col = 0; col < cols; col++) {
                    Cell cell = new Cell(row, col);
                    if (line.charAt(2*col) == 'T'){
                        cell.setTroll();
                        Trolls.add(cell);
                    }else{
                        cell.setNotTroll();
                    }
                    graph.add(cell);


                    //might delete later,
                    if(row == 0 && col == 0){
                        Start = cell;
                    }
                    if(row == rows - 1 && col == cols - 1){
                        End = cell;
                    }
                    connectNeighbors(cell);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connectNeighbors(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();

            Vertex<Cell> vert0= graph.getVertex(cell);
            if(row > 0){
            Vertex<Cell> vert1= graph.getVertex(new Cell(row-1, col));
            vert0.connect(vert1);
            vert1.connect(vert0);
            }
            if(col>0){
            Vertex<Cell> vert2= graph.getVertex(new Cell(row, col-1));
            vert0.connect(vert2);
            vert2.connect(vert0);
            
        }
    }
    


    public List<Cell> dfPathMage() {
        Vertex<Cell> s = graph.getVertex(Start);
        Vertex<Cell> e = graph.getVertex(End);

        Set<Vertex<Cell>> visited = new HashSet<>();
        visited.add(s);
        for (Cell cell : Trolls){
            visited. add(graph.getVertex(cell));
        }
        return graph.visitDFPath(s, e, visited);
    }



    public List<Cell> dfPathFighter() {
        Vertex<Cell> s = graph.getVertex(Start);
        Vertex<Cell> e = graph.getVertex(End);

        Set<Vertex<Cell>> visited = new HashSet<>();
        visited.add(s);


        return visitFighterPath(false, s, e, visited,Trolls);
    }


    public List<Cell> visitFighterPath(boolean murderedTroll, Vertex<Cell> v, Vertex<Cell> e, Set<Vertex<Cell>> visited, List<Cell>Trolls){
        if (v == e){
            List<Cell> path = new LinkedList<>();
            path.add(e.getValue());
            return path;
        }else{
            for(Vertex<Cell> neighbour :v.getNeighbors()) {
                if(visited.contains(neighbour)){
                    continue;
                }
                visited.add(neighbour);


                List<Cell> path;

                if (Trolls.contains(neighbour.getValue()) && !murderedTroll) {
                    path = visitFighterPath(true, neighbour, e, new HashSet<>(visited), Trolls);
                    // for (Cell cell : Trolls){
                    //     visited.add(graph.getVertex(cell));
                    // }
                    // List<Cell> path = visitFighterPath(true, neighbour, e, visited,Trolls);
                    // if(path!=null){
                    //     path.add(0,v.getValue());
                    //     return path;
                    // }

                    
                } else if (!neighbour.getValue().isTroll() || murderedTroll) {
                    path = visitFighterPath(murderedTroll, neighbour, e, new HashSet<>(visited), Trolls);
                } else {
                    path = null;
                }


                if(path != null){
                    path.add(0, v.getValue());
                    return path;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // String filename = "data/dfs/graph2_mage.txt";
        
        // GvT game = new GvT(filename);

        // System.out.println("Testing Mage in graph2");
        // List<Cell> pathResult = game.dfPathMage();
        // if (pathResult != null) {
        //     System.out.println("Path for Mage: " + pathResult);
        // } else {
        //     System.out.println("No path found");
        // }


        String filename = "data/dfs/graph4_fighter.txt";
        
        GvT game = new GvT(filename);

        System.out.println("Testing Fighter in graph");
        List<Cell> pathResult = game.dfPathFighter();
        if (pathResult != null) {
            System.out.println("Path for Fighter: " + pathResult);
        } else {
            System.out.println("No path found");
        }
    }
}


