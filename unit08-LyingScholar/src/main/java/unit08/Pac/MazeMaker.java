package unit08.Pac;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import unit08.weighted.WPath;

public class MazeMaker {

    public static PacManMaze readMaze(String filename) throws IOException {
        PacManMaze maze = new PacManMaze();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                Cell cell = parseCell(parts[0]);
                maze.add(cell);

                for (int i = 1; i < parts.length; i++) {
                    Cell neighbor = parseCell(parts[i]);

                    if (!maze.contains(neighbor)) {
                        maze.add(neighbor);
                    }
                    maze.connect(cell, neighbor, 1.0);
                }
            }
        }
        return maze;
    }
    
    private static Cell parseCell(String line) {
        // System.out.println(line);
        //<type>-<row>-<col>
        String[] parts = line.split("-");
        int row = Integer.parseInt(parts[1]);
        // System.out.println(row);
        int col = Integer.parseInt(parts[2]);
        // System.out.println(col);
        Cell cell = new Cell(row, col);

        switch (parts[0]) {
            case "PE":
                cell.setType(CellType.PELLET);
                break;
            case "PP":
                cell.setType(CellType.POWER_PELLET);
                break;
            case "GH":
                cell.setType(CellType.GHOST);
                break;
            case "PM":
                cell.setType(CellType.PAC_MAN);
                break;
        }

        return cell;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the .maz file:");
        String filename = scanner.nextLine();
        filename = "./data/pacman/maze01.maz";

        try {
            PacManMaze maze = readMaze(filename);
            System.out.println("Maze loaded successfully!");
            
            Cell pacManStart = maze.getPacMan();
            if(pacManStart == null){
                System.out.println("Pac-Man's position not defined.");
            }else{
            for (Cell powerPellet : maze.getPowerPellets()) {
                WPath<Cell> path = maze.dijkstrasPath(pacManStart, powerPellet);

                if (path != null) {
                    System.out.println("Path found: " + powerPellet);
                    System.out.println(path);
                } else {
                    System.out.println("No path found");
                }
            }
        }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
        
        scanner.close();
    }
}