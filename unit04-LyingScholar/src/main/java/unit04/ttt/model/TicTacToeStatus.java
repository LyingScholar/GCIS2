package unit04.ttt.model;

/**
 * Represents the possible states of a game of Tic-Tac-Toe.
 */
public enum TicTacToeStatus {
    ONGOING,     // in progress
    X_WON,       // X player won
    O_WON,       // O player won
    STALEMATE;   // no more moves, no winner
}
