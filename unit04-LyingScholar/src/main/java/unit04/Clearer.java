package unit04;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Clearer implements EventHandler<ActionEvent>{
    private final TextField textField;
    private final Label label;

    @SuppressWarnings("exports")
    public Clearer(TextField textField, Label label){
        this.textField = textField;
        this.label = label;

    }

    @Override
    public void handle(ActionEvent event) {
        textField.setText("");
        label.setText("");
    }

    
}
