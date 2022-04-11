module com.sobermind.scgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.sobermind.scgui to javafx.fxml;
    exports com.sobermind.scgui;
}