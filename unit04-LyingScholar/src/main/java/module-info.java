module unit04 {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;

    opens unit04 to javafx.fxml;
    exports unit04;
    exports unit04.reversi.model;
    exports unit04.reversi.view;
    exports unit04.ttt.model;
    exports unit04.ttt.view;
}
