package unit04.ttt.model;

/**
 * An exception used if an invalid move is made during a game of Tic-Tac-Toe.
 */
public class TicTacToeException extends Exception {
    /**
     * Creates a new TicTacToeException with the specified message.
     * 
     * @param message The message describing the error that occurred.
     */
    public TicTacToeException(String message) {
        super(message);
    }
}
