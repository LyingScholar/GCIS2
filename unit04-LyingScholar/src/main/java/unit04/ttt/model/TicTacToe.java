package unit04.ttt.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Implements a simple game of Tic Tac Toe.
 * 
 * @author GCCIS Faculty
 */
public class TicTacToe {

    private int lastMoveRow = -1;
    private int lastMoveCol = -1;
    private Move previousMove;

    /**
     * The height of the board.
     */
    public static final int ROWS = 3;

    /**
     * The width of the board.
     */
    public static final int COLS = 3;

    /**
     * The board on which the game is played.
     */
    private final Move[][] board;

    /**
     * The current player's move (X or O).
     */
    private Move nextMove;

    /**
     * Keeps track of the number of moves that have been made. Used to easily
     * detect stalemates.
     */
    private int moves;

    /**
     * The current status of the game.
     */
    private TicTacToeStatus status;


    private List<BoardObserver> observers = new ArrayList<>();
    public void addObserver(BoardObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(int row, int col, Move move) {
        for (BoardObserver observer : observers) {
            observer.update(row, col, move);
        }
    }

    /**
     * Creates a new TicTacToe game with an empty board.
     */
    public TicTacToe() {
        board = new Move[ROWS][COLS];
        reset();
    }

    /**
     * Resets the board to start a new game.
     */
    public void reset() {
        moves = 0;
        nextMove = Move.X;
        status = TicTacToeStatus.ONGOING;
        for(int row=0; row<ROWS; row++) {
            for(int col=0; col<COLS; col++) {
                board[row][col] = Move.NONE;
            }
        }
        notifyObservers(-1, -1, Move.NONE);
    }

    /**
     * Returns the current status of the game.
     * 
     * @return The current status of the game.
     */
    public TicTacToeStatus getStatus() {
        return status;
    }

    /**
     * gets the move at the specified row and column location on the board.
     * 
     * @param row The row location.
     * @param col The column location.
     * 
     * @return The move at the specified location on the board.
     * 
     * @throws TicTacToeException If the location is invalid.
     */
    public Move getMoveAt(int row, int col) throws TicTacToeException {
        validateLocation(row, col);
        return board[row][col];
    }

    /**
     * Returns the next move that will be made on the board.
     * 
     * @return The next move that will be made on the board.
     */
    public Move getNextMove() {
        return this.nextMove;
    }
    public Move getPreviousMove() {
        return previousMove;
    }


    public Move flipper(Move input) {
        if (input == Move.X){
            return Move.O;
        }else if(input == Move.O){
            return Move.X;
        }else{
            return Move.NONE;
        }
    }


    /**
     * Attempts to make a move on the board.
     * 
     * @param row The row location of the move.
     * @param col The column location of the move.
     * 
     * @return The status of the game after the move is made.
     * 
     * @throws TicTacToeException If there is an error making the move.
     */
    public TicTacToeStatus move(int row, int col) throws TicTacToeException {
        validateLocation(row, col);
        if(board[row][col] != Move.NONE) {

            throw new TicTacToeException("A move has already been made at ("
                + row + ", " + col + ")");
        }  else if(status != TicTacToeStatus.ONGOING) {
            throw new TicTacToeException("Cannot move; the game is over.");
        } else {
            board[row][col] = nextMove;
            lastMoveRow = row;
            lastMoveCol = col;
            previousMove = nextMove;
            nextMove = nextMove == Move.X ? Move.O : Move.X;
            moves++;
            updateStatus(row, col);
            notifyObservers(row, col, nextMove);

            return status;
        
        }
    }

    public String getLastMoveDescription(){
        if(lastMoveRow == -1 || lastMoveCol == -1) {
            return "";
        }
        try{
        return String.format(flipper(getMoveAt(lastMoveRow, lastMoveCol)) + " played at [" + (lastMoveRow+1) + "," + (lastMoveCol+1) + "]");
        }catch(TicTacToeException e){
            return "Ew";
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("  0 1 2\n");
    
        for(int row=0; row<3; row++) {
            builder.append(row);
            builder.append(" ");
            builder.append(board[row][0].getSymbol());
            builder.append("|");
            builder.append(board[row][1].getSymbol());
            builder.append("|");
            builder.append(board[row][2].getSymbol());      
            builder.append("\n");      
        }
        notifyObservers(-1, -1, Move.NONE);

        return builder.toString();
    }

    /**
     * A helper function that validates the specified location on the board.
     * 
     * @param row The row location on the board.
     * @param col The column location on the board.
     * 
     * @exception If the location is not valid.
     */
    private void validateLocation(int row, int col) 
        throws TicTacToeException {
        if(row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            throw new TicTacToeException("The location (" + row + ", " + col 
            + ") is not on the board.");
        }
    }

    /**
     * A helper method that updates the status of the game based on the moves 
     * that have been made so far.
     * 
     * @param row The row location of the most recently made move.
     * @param col The column location of the most recently made move.
     */
    private void updateStatus(int row, int col) {
        Move move = board[row][col];
        boolean winner = false;
        if(checkRow(move, 0) || checkRow(move, 1) || checkRow(move, 2) || 
            checkCol(move, 0) || checkCol(move, 1) || checkCol(move, 2)) {
            winner = true;
        } else if(board[1][1] == move && 
            ((board[0][0] == move && board[2][2] == move) ||
            (board[0][2] == move && board[2][0] == move))) {
            winner = true;
        }

        if(winner) {
            status = move == Move.X ? TicTacToeStatus.O_WON : TicTacToeStatus.X_WON;
        } else if(moves == 9) {
            status = TicTacToeStatus.STALEMATE;
        }
    }

    /**
     * A helper function that checks the specified row to see if all moves
     * in that row match the last move made.
     * 
     * @param move The last move that was made.
     * @param row The row to check.
     * 
     * @return True if all of the moves in the row match the last move made, 
     * false otherwise.
     */
    private boolean checkRow(Move move, int row) {
        return board[row][0] == move 
            && board[row][1] == move 
            && board[row][2] == move;
    }

        /**
     * A helper function that checks the specified column to see if all moves
     * in that row match the last move made.
     * 
     * @param move The last move that was made.
     * @param col The column to check.
     * 
     * @return True if all of the in the column match the last move made, 
     * false otherwise.
     */
    private boolean checkCol(Move move, int col) {
        return board[0][col] == move 
            && board[1][col] == move
            && board[2][col] == move;
    }

}
