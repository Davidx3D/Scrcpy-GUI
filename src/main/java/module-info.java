module com.sobermind.works {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sobermind.works to javafx.fxml;
    exports com.sobermind.works;
}
