package practicum2.counter;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Counter extends Application {
    // GUI components
    private Label lblCurrValue = new Label("Current Value");
    private TextField tfValue = new TextField();
    private Button btnPlus = new Button("+");
    private Button btnMinus = new Button("-");
    private Button btnReset = new Button("Reset");
    private Button btnQuit = new Button("Quit");

    // other components
    private int value = 0;

    private CounterObserver observer = newValue -> tfValue.setText(String.valueOf(newValue));

    @Override       
    public void start(Stage stage) throws Exception {

        VBox root = new VBox(8);

        // top row
        FlowPane fpTop = new FlowPane(8, 8);
        fpTop.setAlignment(Pos.CENTER);
        tfValue.setPrefColumnCount(5);
        fpTop.getChildren().addAll(lblCurrValue, tfValue);
        root.getChildren().add(fpTop);

        // middle row
        FlowPane fpMid = new FlowPane(8, 8);
        fpMid.setAlignment(Pos.CENTER);
        fpMid.getChildren().addAll(btnPlus, btnMinus);
        
        btnPlus.setOnAction(e -> {
            value++;
            observer.update(value);
        });

        btnMinus.setOnAction(e -> {
            value--;
            observer.update(value);
        });
        root.getChildren().add(fpMid);

        // bottom row
        FlowPane fpBot = new FlowPane(8, 8);
        fpBot.setAlignment(Pos.CENTER);
        fpBot.getChildren().addAll(btnReset, btnQuit);

        btnReset.setOnAction(e -> {
            value = 0;
            observer.update(value);
        });

        btnQuit.setOnAction(e -> {
            System.exit(0);
        });

        root.getChildren().add(fpBot);

        // initial value
        tfValue.setText("" + value);



        Scene scene = new Scene(root, 300, 100);
        stage.setScene(scene);
        stage.setTitle("Mukul's counter");

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}