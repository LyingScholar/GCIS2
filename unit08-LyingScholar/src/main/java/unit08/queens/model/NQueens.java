package unit08.queens.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import unit08.backtracker.Configuration;

public class NQueens implements Configuration<NQueens>{
    private final Queen[] queens;
    private final int n;

    public NQueens(int n){
        this(n, new Queen[0]);
    }

    public NQueens(int n, Queen[] queens){
        this.n = n;
        this.queens = queens != null ? queens : new Queen[0];
    }

    public Queen[] getQueens(){
        return queens;
    }


    @Override
    public Collection<NQueens> getSuccessors() {
        List<NQueens> successors = new ArrayList<>();
        int length = queens.length;
        int row = length > 0? queens[length-1].getRow() + 1 : 0;
        if (row<n){
            for (int col = 0;col<n;col++){
                Queen[] copy = Arrays.copyOf(queens, length+1);
                copy[length] = new Queen(row, col);
                successors.add(new NQueens(n,copy));

            }
        }
        return successors;
    }

    @Override
    public boolean isValid() {
        int length = queens.length;
        if(length<2){
            return true;
        } else{
            Queen last = queens[length-1];
            for(int i =0;i < length-1;i++){
                if(last.canAttack(queens[i])){
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public boolean isGoal() {
        return isValid() && queens.length ==n;
    }

    @Override
    public String toString(){
        String[][] board = new String[n][n];
        for(int row = 0;row<n;row++){
            for(int col = 0;col<n;col++){
                board[row][col]="[ ]";
            }
        }

        for(Queen q: queens){
            board[q.getRow()][q.getCol()] = "[Q]";
        }

        StringBuilder builder = new StringBuilder();
        for (String[] row: board){
            for (String col : row){
                builder.append(col);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
    
    public static void main(String[] args) {
        System.out.println();
        NQueens queens = new NQueens(4);
        System.out.println(queens);
        System.out.println("Valid: " + queens.isValid());
        System.out.println("Goal: " + queens.isGoal());


        System.out.println("============");
        Collection<NQueens> successors = queens.getSuccessors();
        for (NQueens n: successors){
            System.out.println(n);
            System.out.println("Valid: " + queens.isValid());
            System.out.println("Goal: " + queens.isGoal());
        }
    }
}
