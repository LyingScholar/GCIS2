package unit04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackPaneActivity extends Application {

    private static final String PATH = "file:unit04-LyingScholar/media/images/emojis/";


    @Override
    public void start(Stage primaryStage) throws Exception {
        ImageView head = new ImageView(PATH + "headred.png");
        ImageView mouth = new ImageView(PATH + "mouthbasic.png");
        ImageView nose = new ImageView(PATH + "noseorange.png");
        ImageView eyes = new ImageView(PATH + "eyesblue.png");
        ImageView brows = new ImageView(PATH + "brownbasic.png");
        
        StackPane pane = new StackPane();
        pane.getChildren().addAll(
            head,
            mouth,
            nose,
            eyes,
            brows
        );
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("StackPane");
        primaryStage.show();
        
    }

    


    public static void main(String[] args) {
        launch(args);
    }
}
