package unit04.ttt.model;

public interface BoardObserver {
    void update(int row, int col, Move move);
}