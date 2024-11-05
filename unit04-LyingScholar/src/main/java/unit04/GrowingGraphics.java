package unit04;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GrowingGraphics extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setCenter(new ImageView("file:media/images/smb.gif"));
        pane.setLeft(makeVbox("Jump!","file:media/images/smb/jump.png" ));
        pane.setRight(makeVbox("Stand!","file:media/images/smb/stand.png" ));
        pane.setTop(makeHbox("Mushroom!","file:media/images/smb/mushroom.png" ));
        pane.setBottom(makeHbox("Goomba!","file:media/images/smb/goomba.png" ));
        

        primaryStage.setTitle("GrowingGraphics");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();

    }

    private static Label makeLabel(String text, String path){
        Label label = new Label(text,new ImageView(path));
        label.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        label.setContentDisplay(ContentDisplay.TOP);
        VBox.setVgrow(label, Priority.ALWAYS);
        return label;

    }

    private static Button makeButton(String text, String path){
        Button button = new Button(text,new ImageView(path));
        button.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        button.setContentDisplay(ContentDisplay.BOTTOM);
        HBox.setHgrow(button, Priority.ALWAYS);
        return button;

    }

    private static VBox makeVbox(String text, String path){
        VBox box = new VBox(5);
        box.setBackground(new Background(new BackgroundFill(Color.AZURE,CornerRadii.EMPTY,Insets.EMPTY)));
        
        box.getChildren().addAll(
            makeLabel(text, path),
            makeLabel(text, path),
            makeLabel(text, path)
        );
        return box;
    
    }

    private static HBox makeHbox(String text, String path){
        HBox box = new HBox(5);
        box.setBackground(new Background(new BackgroundFill(Color.AZURE,CornerRadii.EMPTY,Insets.EMPTY)));
        
        box.getChildren().addAll(
            makeButton(text, path),
            makeButton(text, path),
            makeButton(text, path),
            makeButton(text, path),
            makeButton(text, path)
        );
        return box;
    
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
