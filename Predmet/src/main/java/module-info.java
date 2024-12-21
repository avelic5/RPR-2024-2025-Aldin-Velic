module com.example.predmet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.predmet to javafx.fxml;
    exports com.example.predmet;
}