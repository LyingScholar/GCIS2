package unit04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GridPaneActivity extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();

        //row 0
        Label display = makeLabel("123.456");
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
        display.setBorder(new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
        grid.add(display, 0, 0,4,1);

        //row 1
        grid.add(makeLabel("AC"),0,1,2,1);
        grid.add(makeLabel("%"),2,1);
        grid.add(makeLabel("/"),3,1);

        //row 2
        grid.add(makeLabel("7"),0,2);
        grid.add(makeLabel("8"),1,2);
        grid.add(makeLabel("9"),2,2);
        grid.add(makeLabel("X"),3,2);

        //row 3
        grid.add(makeLabel("4"),0,3);
        grid.add(makeLabel("5"),1,3);
        grid.add(makeLabel("6"),2,3);
        grid.add(makeLabel("-"),3,3);
        
        //row 4
        grid.add(makeLabel("1"),0,4);
        grid.add(makeLabel("2"),1,4);
        grid.add(makeLabel("3"),2,4);
        grid.add(makeLabel("+"),3,4);
        
        //row 5
        grid.add(makeLabel("0"),0,5,2,1);
        grid.add(makeLabel("."),2,5);
        grid.add(makeLabel("="),3,5);


        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(grid));
        primaryStage.show();

        // display.setTop(makeLabel("Top",Color.YELLOW));
        // display.setLeft(makeLabel("Left",Color.LIGHTGREEN));
        // display.setCenter(makeLabel("Centre",Color.CORAL));
        // display.setRight(makeLabel("Right",Color.LIGHTBLUE));
        // display.setBottom(makeLabel("Top",Color.PINK));

    }

    private static Label makeLabel(String text){
        Label label = new Label(text);
        label.setFont(new Font("Arial", 24));
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(20));
        label.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        // label.setTextFill(Color.BLACK);

        label.setBackground(new Background
        (new BackgroundFill(Color.LIGHTGRAY,CornerRadii.EMPTY, new Insets(1))));

        return label;

    }

    public static void main(String[] args){
        launch(args);

    
    }

}
