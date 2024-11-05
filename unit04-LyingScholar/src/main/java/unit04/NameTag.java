package unit04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NameTag extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label hello = new Label("HELLO MY NAME IS");
        hello.setAlignment(Pos.CENTER);
        hello.setFont(new Font("Impact",20));
        hello.setPadding(new Insets(10));
        hello.setTextFill(Color.BLUE);
        hello.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        

        Label name = new Label("Your Name");
        name.setAlignment(Pos.CENTER);
        name.setFont(new Font("Comic Sans MS",48));
        name.setPadding(new Insets(20));
        name.setTextFill(Color.RED);
        name.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        
        
        VBox nameTag = new VBox();
        nameTag.setBorder(new Border(new BorderStroke(Color.BLUE,
        BorderStrokeStyle.SOLID, new CornerRadii(10),
        BorderStroke.THICK)));

        nameTag.getChildren().addAll(
            hello,
            name
        );

        TextField field = new TextField();
        field.setPromptText("Enter Your Name");
        field.setAlignment(Pos.CENTER);
        field.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

        Button update = new Button("Updating Name Tag");
        update.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        update.setOnAction(new Updater(field, name));

        Button clear = new Button("Clear");
        clear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        update.setOnAction(new Clearer(field, name));

        VBox box = new VBox();
        box.getChildren().addAll(
            nameTag,
            field,
            update,
            clear
        );

        primaryStage.setTitle("Your Name");
        primaryStage.setScene(new Scene(box));
        primaryStage.show();
        
    }

    public static void main(String[] args){
        launch(args);
    }

    
}
