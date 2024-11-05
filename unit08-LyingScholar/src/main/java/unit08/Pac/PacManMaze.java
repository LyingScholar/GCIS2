package unit08.Pac;

import java.util.ArrayList;
import java.util.List;

import unit08.weighted.WAdjacencyGraph;

public class PacManMaze extends WAdjacencyGraph<Cell> {
    private Cell pacMan;
    private List<Cell> powerPellets;


    public PacManMaze() {
        super();
        this.powerPellets = new ArrayList<>();
    }

    public List<Cell> getPowerPellets() {
        return powerPellets;
    }
    public void setPowerPellets(List<Cell> powerPellets) {
        this.powerPellets = powerPellets;
    }

    public Cell getPacMan() {
        return pacMan;
    }
    public void setPacMan(Cell PacMan) {
        this.pacMan = PacMan;
    }

    @Override
    public void add(Cell cell) {
        if(cell.getType() == CellType.PAC_MAN) {
                this.pacMan= cell;
        }else if(cell.getType() == CellType.POWER_PELLET){
                this.powerPellets.add(cell);
        }

        super.add(cell);
    }


}
