module unit09 {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;

    opens unit09.filters to javafx.fxml;
    exports unit09.filters;
}
