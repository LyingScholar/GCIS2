package unit04.ttt.model;

/**
 * Represents the possible moves in a game of Tic-Tac-Toe.
 */
public enum Move {
    X('X'),     // X Player
    O('O'),     // O Player
    NONE(' ');  // No Move

    /**
     * The symbol used to display the move.
     */
    private final char symbol;

    /**
     * Creates a new move with the specified symbol.
     * 
     * @param symbol The symbol used to display the move.
     */
    private Move(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the symbol used to display the move.
     * 
     * @return The symbol used to display the move.
     */
    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
