package unit04.reversi.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
// import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import unit04.reversi.model.Reversi;
import unit04.reversi.model.ReversiException;
import unit04.reversi.model.Square;

public class ReversiGUI extends Application{
    public static final Image SQUARE_IMAGE = 
    new Image("file:media/images/reversi/square.png");
    public static final Image BLANK_IMAGE = 
    new Image("file:media/images/reversi/blank.png");
    public static final Image WHITE_IMAGE = 
    new Image("file:media/images/reversi/whitepiece.png");
    public static final Image BLACK_IMAGE = 
    new Image("file:media/images/reversi/blackpiece.png");

    private Reversi board;
    // private Label status;
    // private Label player1score;
    // private Label player2score;

    @Override
    public void start(Stage primaryStage) throws Exception {
        board = new Reversi();
        GridPane boardPane = new GridPane();
        for (int col =0; col < Reversi.COLS;col++){
            for (int row =0; row < Reversi.ROWS;row++){
                boardPane.add(makeReversiButton(col,row), col, row);
            }
        }
        primaryStage.setTitle("Reversi");
        primaryStage.setScene(new Scene(boardPane));
        primaryStage.show();

        // makeMove(5, 3);
    }

    public void makeMove(int row, int col){
        try{
            board.move(row, col);
            System.out.println("good move!");
        }catch(ReversiException re){
            System.err.println("Invalid move");
        }
    }

    private Button makeReversiButton(int column, int row){
        ImageView squareView = new ImageView(BLANK_IMAGE);
        Button button = new Button("");
        button.setBackground(new Background(new BackgroundImage(SQUARE_IMAGE,
            BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            button.setPrefSize(72,72);
            button.setPadding(new Insets(0));
            button.setOnAction(new MoveMaker(row, column, this));
            
            Square square = board.getSquare(row, column);
            updateImage(square, squareView);
            square.setOnChange(new SquareChanger(squareView));
            
            return button;

    }

    public static void updateImage(Square square, ImageView squareView){
        switch(square.getOccupyingColor()){
            case BLACK:
                squareView.setImage(BLACK_IMAGE);
                break;
            case WHITE:
                squareView.setImage(WHITE_IMAGE);
                break;
            default:
                squareView.setImage(BLANK_IMAGE);
                break;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
