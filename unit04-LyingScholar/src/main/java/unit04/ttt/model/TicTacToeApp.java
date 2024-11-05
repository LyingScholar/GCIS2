package unit04.ttt.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicTacToeApp extends Application implements BoardObserver {

    private TicTacToe game = new TicTacToe();
    private Button[][] buttons = new Button[3][3]; // perhaps attempt to increase this later
    private Text statusMessage = new Text("Welcome to Tic- Tac- Toe! baby");

    @Override
    public void start(Stage stage) {
        game.addObserver(this);
        GridPane board = new GridPane();
        board.setAlignment(Pos.CENTER);
        
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                Button button = new Button();
                button.setMinSize(100, 100);//DO NOT CHANGE< VERY DELICATE
                button.setPadding(new Insets(20));
                button.setFont(new Font("Times New Roman", 48));
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                button.setBackground(new Background(
                new BackgroundFill(Color.PINK,new CornerRadii(3),Insets.EMPTY)));

                button.setBorder(new Border(new BorderStroke(Color.GRAY,
                BorderStrokeStyle.SOLID, new CornerRadii(3),
                BorderStroke.MEDIUM)));

                // these two variables are to avoid some error, cant plug row n col into handle move directly dunno y
                int thesamerow = row;
                int thesamecol = col;
                button.setOnAction(event -> handleMove(thesamerow, thesamecol));
                board.add(button, col, row);
                buttons[row][col] = button;
            }
        }

        Button resetButton = new Button("Reset");
        resetButton.setAlignment(Pos.CENTER);
        resetButton.setBackground(new Background(
                new BackgroundFill(Color.MEDIUMAQUAMARINE,new CornerRadii(3),Insets.EMPTY)));
        resetButton.setFont(new Font("Old English Text MT",25));
        resetButton.setPadding(new Insets(10));
        resetButton.setTextFill(Color.BLUE);
        resetButton.setMaxWidth(Double.MAX_VALUE);
        resetButton.setOnAction(event -> game.reset());

        BorderPane root = new BorderPane();
        root.setCenter(board);
        root.setBottom(statusMessage);
        root.setTop(resetButton);
        BorderPane.setAlignment(statusMessage, Pos.TOP_CENTER);
        BorderPane.setAlignment(resetButton, Pos.TOP_CENTER);


        Scene scene = new Scene(root, 320, 460);
        stage.setTitle("Tic-Tac-Toe");
        stage.setScene(scene);
        stage.show();
    }

    private void handleMove(int row, int col) {
        if (game.getStatus() == TicTacToeStatus.ONGOING){   
            try {
                game.move(row, col);
                Move move = game.getNextMove();
                update(row, col, move);
            } catch (TicTacToeException e) {
                statusMessage.setText("Wrong move, babygirl");
            }
        }else{
            statusMessage.setText("Game's over, babygirls");
        }
    }

    @Override
    public void update(int row, int col, Move move) {
        if(row == -1 && col == -1) {
            // Reset case
            resetBoardVisuals();
            statusMessage.setText("New Game, Same charm");
            
        } else {
            buttons[row][col].setText(Character.toString(move.getSymbol()));
            
            switch (game.getStatus()) {
            case X_WON:
                statusMessage.setText("Player X is such a smart girl!");
                disableBoard();
                break;
            case O_WON:
                statusMessage.setText("Good girl, O");
                disableBoard();
                break;
            case STALEMATE:
                statusMessage.setText("It's a tie! Begin catfight");
                disableBoard();
                break;
            case ONGOING:
                statusMessage.setText("Last move: " + game.getLastMoveDescription() + ". Player " + game.getPreviousMove() + " to move.");
                break;
            }
        }
        
    }
    private void resetBoardVisuals() {
        for (Button[] buttonRow : buttons) {
            for (Button button : buttonRow) {
                button.setText("");
                button.setDisable(false);
            }
        }
    }

    private void disableBoard() {
        for (Button[] buttonRow : buttons) {
            for (Button button : buttonRow) {
                button.setDisable(true);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}