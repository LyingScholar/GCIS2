package unit08.Pac;

import java.util.Objects;

public class Cell {
    private int row;
    private int col;
    private CellType type;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "(" + this.row + "," + this.col + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Cell)){
            return false;
        }
        Cell cell = (Cell) obj;
        return row == cell.row && col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

}