package unit04;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PacMan extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox();
        box.getChildren().addAll(
            makeButton("Start!", "unit04-LyingScholar/media/sounds/start.wav"),
            makeButton("Chomp!", "unit04-LyingScholar/media/sounds/chomp.wav"),
            makeButton("Eat!", "unit04-LyingScholar/media/sounds/eat.wav"),
            makeButton("Game Over!", "unit04-LyingScholar/media/sounds/end.wav")
        );

        primaryStage.setTitle("Pac-Man");
        primaryStage.setScene(new Scene(box));
        primaryStage.show();
    }

    private static Button makeButton(String text, String path){
        Button button = new Button(text);
        button.setPadding(new Insets(20));
        button.setFont(new Font("Comic Sans MS", 24));
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Media media = new Media(new File(path).toURI().toString());

        MediaPlayer player = new MediaPlayer(media);
        button.setOnAction(new SoundPlayer(player));

        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
    

}
