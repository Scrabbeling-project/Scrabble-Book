module com.example.scrrable_lastversion {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens View to javafx.fxml;
    exports com.example.demo;
    opens com.example.demo to javafx.fxml;
}