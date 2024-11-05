package unit04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BorderPaneAtivity extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setTop(makeLabel("Top",Color.YELLOW));
        pane.setLeft(makeLabel("Left",Color.LIGHTGREEN));
        pane.setCenter(makeLabel("Centre",Color.CORAL));
        pane.setRight(makeLabel("Right",Color.LIGHTBLUE));
        pane.setBottom(makeLabel("Top",Color.PINK));


        primaryStage.setTitle("BorderPane");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    private static Label makeLabel(String text, Color background){
        Label label = new Label(text);

        label.setFont(new Font("Calibri", 24));

        label.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        label.setTextFill(Color.BLACK);
        label.setPadding(new Insets(10));
        label.setBackground(new Background(new BackgroundFill(background,CornerRadii.EMPTY,Insets.EMPTY)));
        label.setAlignment(Pos.CENTER);

        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
