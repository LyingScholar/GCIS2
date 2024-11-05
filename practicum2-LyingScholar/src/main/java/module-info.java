module practicum2 {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;

    opens practicum2 to javafx.fxml;
    exports practicum2;
    exports practicum2.counter;
}