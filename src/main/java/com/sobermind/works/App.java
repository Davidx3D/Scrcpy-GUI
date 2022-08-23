package com.sobermind.works;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Authors: Davidx3D & Asandax6
 */

public class App extends Application {

    private static Scene scene;
    private static Scene scene1;

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

        scene = new Scene(loadFXML("primary"), 947, 699);
        stage = new Stage();
        stage.getIcons().add(new Image("file:icon.png"));
        stage.setTitle("Scrcpy-GUI (SoberMind Works)");
        stage.setScene(scene);
        stage.show();

        //Code Below Ensures That By Default The App Is At The Center Of The Screen
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch();
    }

}