package unit08.minesweeper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import unit08.backtracker.Backtracker;
import unit08.backtracker.Configuration;

public class Minesweeper implements Configuration<Minesweeper> {
    private char[][] board;
    private boolean[][] uncovered;
    //boolean is easier than string or char for plugging into for loopd and equations

    private List<String> moves;
    private int rows, cols;
    private int nextRow, nextCol;
    public static final char MINE = '*';
    public static final char EMPTY = '-';
    public static final char FLAG = 'F';



    public Minesweeper(String filename, int startRow, int startCol) throws IOException {
        board = makeBoard(filename);
        uncovered = new boolean[rows][cols];
        moves = new ArrayList<>();
        this.nextRow = startRow;
        this.nextCol = startCol;
        flip(startRow, startCol);
    }

    public Minesweeper(Minesweeper other) {
        this.board = deepCopy(other.board);
        this.uncovered = deepCopy(other.uncovered);
        this.moves = new ArrayList<>(other.moves);
        this.rows = other.rows;
        this.cols = other.cols;
        this.nextRow = other.nextRow;
        this.nextCol = other.nextCol;
    }

    public char[][] deepCopy(char[][] other) {
        int rows = other.length;
        int cols = other[0].length;
        char[][] newBoard = new char[rows][cols];
        newBoard = Arrays.copyOf(other, rows);
        return newBoard;
    }

    
    public boolean[][] deepCopy(boolean[][] other) {
        int rows = other.length;
        int cols = other[0].length;
        boolean[][] newBoard = new boolean[rows][cols];
        newBoard = Arrays.copyOf(other, rows);
        return newBoard;
    }


    @Override
    public Collection<Minesweeper> getSuccessors() {
        List<Minesweeper> successors = new ArrayList<>();
        if (isValidMove(nextRow, nextCol)) {

            Minesweeper uncoveredSuccessor = new Minesweeper(this);
            if (uncoveredSuccessor.flip(nextRow, nextCol)) {
                successors.add(uncoveredSuccessor);
            }
            
            Minesweeper flaggedSuccessor = new Minesweeper(this);
            if (flaggedSuccessor.placeFlag(nextRow, nextCol)) {
                successors.add(flaggedSuccessor);
            }
        }

        findNextMovePosition();
        return successors;
    }

    @Override
    public boolean isValid() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (uncovered[r][c] && board[r][c] == MINE) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isGoal() {
        // All non-mine tiles are uncovered and all mines are flagged.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] != MINE && !uncovered[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
    



    private boolean flip(int row, int col) {
        if (board[row][col] == MINE) {
            return false; // hit a mine
        }
        if (uncovered[row][col]) {
            return true; // already uncovered
        }
        uncovered[row][col] = true;
        moves.add("(" + row + "," + col + ")");

        if (countAdjacentMines(row, col) == 0) {
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr == 0 && dc == 0) continue;
                    if (row + dr >= 0 && row + dr < rows && col + dc >= 0 && col + dc < cols) {
                        flip(row + dr, col + dc);
                    }
                }
            }
        }
        return true;
    }

    private int countAdjacentMines(int row, int col) {
        int mineCount = 0;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int newRow = row + dr;
                int newCol = col + dc;

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (board[newRow][newCol] == MINE) {
                        mineCount++;
                    }
                }
            }
        }
        return mineCount;
    }
    
        private boolean placeFlag(int row, int col) {
            if (board[row][col] == MINE) {
                uncovered[row][col] = true;
                moves.add("F(" + row + "," + col + ")");
                return true;
            }
            return false;
        }
        
        private char[][] makeBoard(String filename) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String[] dimensions = reader.readLine().split(" ");
                rows = Integer.parseInt(dimensions[0]);
                cols = Integer.parseInt(dimensions[1]);

                char[][] emptyBoard = new char[rows][cols];
    
                for (int r = 0; r < rows; r++) {
                    String line = reader.readLine();
                    for (int c = 0; c < cols; c++) {
                        emptyBoard[r][c] = line.charAt(c);
                        //took me an hour to remeber line[0] dowsnt work lol
                    }
                }

                return emptyBoard;
            }
        }
    
        private boolean isValidMove(int row, int col) {
            return row >= 0 && row < rows && col >= 0 && col < cols && !uncovered[row][col];
        }
    
        private void findNextMovePosition() {
            // Increment the next move row by row, might be wrong
            //maybe col by row is faster?
            while (nextRow < rows && uncovered[nextRow][nextCol]){
                    nextCol++;
                    if (nextCol >= cols) {
                        nextCol = 0;
                        nextRow++;
                    }else{
                        continue;
                    }
            }
        }
    
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    sb.append(uncovered[r][c] ? (board[r][c] == MINE ? FLAG : EMPTY) : '_');
                    sb.append(' ');
                }
                sb.append('\n');
            }
            sb.append("Moves: ").append(moves);
            return sb.toString();
        }

        public static void main(String[] args) {
    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // System.out.println("Enter the file name of a map: ");
        // String filename = reader.readLine();
        String filename = "data/minesweeper/map_01.txt";

        System.out.println("Enter the starting location in row column format ('2 4', '1 2'): ");
        String[] startLocation = reader.readLine().split(" ");
        int startRow = Integer.parseInt(startLocation[0]);
        int startCol = Integer.parseInt(startLocation[1]);
        Minesweeper minesweeperBoard = new Minesweeper(filename, startRow, startCol);
        // System.out.println(minesweeperBoard);

        Backtracker<Minesweeper> solver = new Backtracker<Minesweeper>(true);
        Minesweeper solution = solver.solve(minesweeperBoard);
        if (solution != null) {
            System.out.println("Solved configuration:");
            System.out.println(solution);
        } else {
            System.out.println("No solution found.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

