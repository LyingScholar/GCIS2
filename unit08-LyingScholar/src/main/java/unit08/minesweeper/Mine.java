package unit08.minesweeper;

public class Mine {
    private final int row;
    private final int col;
    private final String string;
    private final int hashCode;

    public Mine(int row, int col) {
        this.row = row;
        this.col = col;
        this.string = "Mine{row=" + row + ", col=" + col + "}";
        this.hashCode = string.hashCode();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Mine) {
            Mine other = (Mine)obj;
            return this.row == other.row && this.col == other.col;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        return string;
    }

}
