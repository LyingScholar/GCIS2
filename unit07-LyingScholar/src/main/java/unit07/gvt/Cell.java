package unit07.gvt;

import java.util.Objects;

public class Cell {
    private int row;
    private int col;
    private boolean troll;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isTroll() {
        return this.troll;
    }

    public void setTroll(){
        this.troll = true;
    }

    public void setNotTroll(){
        this.troll = false;
    }

    @Override
    public String toString() {
        return "(" + this.row + "," + this.col + ")";
    }
    
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    
    }

    public String getValue() {
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

