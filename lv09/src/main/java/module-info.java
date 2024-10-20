module com.example.lv09 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; // Ako koristite rad s bazom podataka

    opens controller to javafx.fxml; // Omogućava FXML refleksiju na controller paket
    exports com.example.lv09;
}