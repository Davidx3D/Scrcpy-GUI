module com.sobermind.works {
    requires javafx.controls;
    requires javafx.fxml;
    requires ddmlib;

    opens com.sobermind.works to javafx.fxml;
    exports com.sobermind.works;
}
