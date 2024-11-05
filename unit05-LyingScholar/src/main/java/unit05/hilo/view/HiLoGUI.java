package unit05.hilo.view;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import unit05.hilo.model.HiLo;

public class HiLoGUI extends Application{
    private TextField text;
    private Label hint;
    private Label availableGuesses;
    private HiLo game;
    
    @Override
    public void start(Stage stage){
        game = new HiLo();

        VBox vbox = new VBox();
        
        text = new TextField("Enter a number 1-100.");    
        hint = makeLabel("Game has not started yet.");
        availableGuesses = makeLabel(game.getAvailableGuesses()  + " guesses left.");


        text.setOnAction(event -> guess());


        vbox.getChildren().addAll(text, hint, availableGuesses);
        vbox.setPrefWidth(200);

        stage.setScene(new Scene(vbox));
        stage.setTitle("High Low Game");
        stage.show();
    }

    private void updateGUI() {
        hint.setText(game.getHint());

        availableGuesses.setText(game.getAvailableGuesses() + "  guesses left.");
        if (game.isGameOver()) {
            text.setText("Game Over!");;
        }
    }

    public void guess() {
        String inputText = text.getText(); 
        try {
            int guess = Integer.parseInt(inputText);
            game.makeGuess(guess);
            updateGUI();
            text.clear();
        } catch (NumberFormatException e) {
            hint.setText("Please enter a valid number!");
        }
    }

    public Label getHint(){
        return this.hint;
    }
    public Label getAvailableGuesses(){
        return this.availableGuesses;
    }
    public TextField getText(){
        return this.text;
    }

    private Label makeLabel(String msg){
        Label label = new Label(msg);
        label.setMaxWidth(Integer.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
        CornerRadii.EMPTY, BorderStroke.THIN)));
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}






