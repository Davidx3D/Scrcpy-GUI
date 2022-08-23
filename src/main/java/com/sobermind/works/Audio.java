package com.sobermind.works;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

/**
 * Authors: Davidx3D & Asandax6
 */

public class Audio {

    public static void Bluetooth() {
        //Runs BT Audio Connector If The Confirmation On Line 28 Is Yes
        try {
            Process p = Runtime.getRuntime().exec("audio.exe");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void Sndcpy() {
        //Runs Sndcpy If The Confirmation Is Yes From Line 41
        try {
            Process p = Runtime.getRuntime().exec("cmd.exe /c sndcpy");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void BTCon() {
        //Confirmation Box For When The Bluetooth Radio Button Is Clicked
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
        //Confirmation Box For When The Sndcpy Radio Button Is Clicked
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