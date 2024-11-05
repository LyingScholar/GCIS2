package unit04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageViewer extends Application {

    // private static final String PATH = "unit04-LyingScholar/media/";

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Image image = new Image("file:unit04-LyingScholar/media/images/smb.gif");
        // Image image = new Image("file:unit04-LyingScholar/media/images/sunflowers.jpg");
        // Image image = new Image("file:unit04-LyingScholar/media/TV/gaming.jpg");
        Image image = new Image( "file:unit04-LyingScholar/media/TV/LoveMeNot.jpg");
        // Image image = new Image("file:unit04-LyingScholar/media/TV/movie.jpg");
        // Image image = new Image("file:unit04-LyingScholar/media/TV/finance.jpg");
        // Image image = new Image("file:unit04-LyingScholar/media/TV/gaming.jpg");
        // Image image = new Image("file:unit04-LyingScholar/media/TV/whopper.jpg");
        // Image image = new Image("file:unit04-LyingScholar/media/TV/cartoon.jpg");
        // Image image = new Image("file:unit04-LyingScholar/media/TV/peace.jpg");
        // Image image = new Image("file:unit04-LyingScholar/media/TV/death.jpg");
        // Image image = new Image("file:unit04-LyingScholar/media/TV/life.jpg");
        ImageView view = new ImageView(image);
        HBox box = new HBox();
        box.getChildren().add(view);

        primaryStage.setScene(new Scene(box));
        primaryStage.setTitle("ImageView");
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
