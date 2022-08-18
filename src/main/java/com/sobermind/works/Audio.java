package com.sobermind.works;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class Audio {

    public static void Bluetooth() {
        try {
            Process p = Runtime.getRuntime().exec("audio.exe");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void Sndcpy() {
        try {
            Process p = Runtime.getRuntime().exec("cmd.exe /c sndcpy");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void BTCon() {
        Alert BT = new Alert(Alert.AlertType.CONFIRMATION);
        BT.setTitle("Bluetooth Confirmation");
        BT.setHeaderText("Ensure Your PC/Laptop Has Bluetooth Turned On");
        BT.setContentText("Please Ensure That Your Device Has Already Been Paired To The Computer!");

        Optional<ButtonType> result = BT.showAndWait();
        if (result.get() == ButtonType.OK){

            Bluetooth();
        }
    }
    public static void SndCon() {

        Alert Sndcpy = new Alert(Alert.AlertType.CONFIRMATION);
        Sndcpy.setTitle("Sndcpy Confirmation");
        Sndcpy.setHeaderText("Ensure Your PC Has VLC Installed");
        Sndcpy.setContentText("Please Ensure That Your Device Is Running Android 10 Or Above!");

        Optional<ButtonType> result = Sndcpy.showAndWait();
        if (result.get() == ButtonType.OK){
        Sndcpy();
        }
    }
}