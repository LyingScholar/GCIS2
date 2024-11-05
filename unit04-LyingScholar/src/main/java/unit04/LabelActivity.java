package unit04;

import javafx.application.Application;
import javafx.geometry.Insets;
// import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
// import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
// import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelActivity extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox();

        Label label1 = makLabel("Top",Color.LIGHTBLUE,Color.DARKBLUE);


        Label label2 = makLabel("Centre",Color.MAROON,Color.YELLOW);

        Label label3 = makLabel("Bottom",Color.VIOLET,Color.GREENYELLOW);

        box.getChildren().addAll(
            label1,
            label2,
            label3
        );

        
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My first JavaFX App!");
        primaryStage.show();
    }

    private Label makLabel(String text, Color foreground, Color background){
        Label label = new Label(text);
        label.setFont(new Font("Courier New",48));
        label.setMaxHeight(Double.POSITIVE_INFINITY);
        label.setMaxWidth(Double.POSITIVE_INFINITY);
        label.setTextFill(foreground);
        label.setPadding(new Insets(10));
        label.setBackground(new Background(
            new BackgroundFill(background,new CornerRadii(15),Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(15), BorderStroke.MEDIUM)));

        return label;
    }

    public static void main(String[] args){
        launch(args);
    }
}
