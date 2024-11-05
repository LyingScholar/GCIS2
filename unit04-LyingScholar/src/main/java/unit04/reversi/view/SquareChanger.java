package unit04.reversi.view;

import javafx.scene.image.ImageView;
import unit04.reversi.model.Square;
import unit04.reversi.model.SquareObserver;

public class SquareChanger implements SquareObserver {

    private final ImageView view;

    public SquareChanger(ImageView view){
        this.view = view;
    }

    @Override
    public void squareChanged(Square square) {
        switch(square.getOccupyingColor()){
            case BLACK:
                view.setImage(ReversiGUI.BLACK_IMAGE);
                break;
            case WHITE:
                view.setImage(ReversiGUI.WHITE_IMAGE);
                break;
            default:
                view.setImage(ReversiGUI.BLANK_IMAGE);
                break;
        }
    }
    
}
