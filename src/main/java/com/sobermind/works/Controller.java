package com.sobermind.works;

import java.io.*;
import java.net.URL;
import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import com.sobermind.works.Audio;

public class Controller implements Initializable{

    @FXML private CheckBox offscrn,stay,offcl,showt,fsmode,shortmod;
    @FXML private TextField bitrate,port,devip,maxsize,advpanel;
    @FXML private TextArea devices,output;
    @FXML private Label iplabel,applicable,portlabel;
    @FXML private RadioButton wired,wireless,bt,snd;
    
    //Button Functions
    @FXML
    void onRunbtn() throws Exception {
    
        boolean Off = offscrn.isSelected();
        boolean On = stay.isSelected();
        boolean Offcl = offcl.isSelected();
        boolean Show = showt.isSelected();
        boolean Fs = fsmode.isSelected();
        boolean Short = shortmod.isSelected();
    
        String Bit = bitrate.getText();
        String Max = maxsize.getText();
        String Adv = advpanel.getText();
        String IP  = devip.getText();
        String Port= port.getText();
        
        ArrayList<String> cmd = new ArrayList<>();
        
        if (IP!="") {
            cmd.add(" --tcpip="+IP);}
        else if (Port!="") {
            cmd.add(" --tcpip="+IP+":"+Port);}
        if(Off) cmd.add(" -S");
        if(On) cmd.add(" -w");
        if(Offcl) cmd.add(" --power-off-on-close");
        if(Show) cmd.add(" --show-touches");
        if(Fs) cmd.add(" -f");
        if(Short) cmd.add(" --shortcut-mod=lalt");
        if(Bit.matches("[0-9]+") && Bit.length() < 3) cmd.add("-b "+Bit+"M");
        if(Max.matches("[0-9]+") && Max.length() > 2) cmd.add("--max-size "+Max);
    
        String Script = cmd.toString()
                              .replace(",", "")
                              .replace("[", "")
                              .replace("]", "")
                              .trim();
    
        //Below Is The Important Stuff
        String mods = Script;
        Process p = Runtime.getRuntime().exec("cmd.exe /c scrcpy " + Script + " "+Adv);
        //Opens Cmd And Runs Scrcpy With Added Scripts
        String sr = null;
        BufferedReader rs = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((sr = rs.readLine()) != null) {

            PrintStream printStream = new PrintStream(new TextOut(output));
            System.setOut(printStream);
            System.out.println(sr);//Shows Progress And Potential Errors On a Field
            output.setWrapText(true);
            }
        }
    @FXML
    protected  void onExitbtn(){
        System.exit(0);
    }
    public void onWired(ActionEvent actionEvent) {
        if (wired.isSelected()) {
            wireless.setSelected(false);
        }
        applicable.setVisible(false);
        devip.setVisible(false);
        iplabel.setVisible(false);
        port.setVisible(false);
        portlabel.setVisible(false);
    }
    public void onWireless(ActionEvent actionEvent) {

        if (wireless.isSelected()){
            wired.setSelected(false);
        }
        if (wireless.isSelected()){
            Alert BT = new Alert(Alert.AlertType.WARNING);
            BT.setTitle("Wireless (Wi-Fi)");
            BT.setContentText("Please Ensure That Both Computer & Device Are Connected To The Same Wi-Fi");
            Optional<ButtonType> result = BT.showAndWait();

                applicable.setVisible(true);
                devip.setVisible(true);
                iplabel.setVisible(true);
                port.setVisible(true);
                portlabel.setVisible(true);
        }
    }
    //The Code Below Uses IDevice To Check If a Device Has Been Connected Or Disconnected From The PC
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
 
        AndroidDebugBridge.init(false);
        devices.setEditable(false);
        output.setEditable(false);
    
        AndroidDebugBridge debugBridge = AndroidDebugBridge.createBridge("adb.exe", true);
        if (debugBridge == null) {
            System.exit(1);
        }
        AndroidDebugBridge.addDeviceChangeListener(new AndroidDebugBridge.IDeviceChangeListener() {
            
            public void deviceChanged(IDevice device, int arg1) {
                //Not Necessary For Now
            }
            public void deviceConnected(IDevice device) {
                try {
                    devices.setText("");
                    String ss = null;
                    Process p = Runtime.getRuntime().exec("cmd.exe /c adb devices");
                    BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

                    while ((ss = r.readLine()) != null) {
                        PrintStream P = new PrintStream(new TextOut(devices));
                        System.setOut(P);
                        System.out.println(ss);
                        devices.setEditable(false);
                        devices.setWrapText(true);
                    }
                    while ((ss = r.readLine()) != null) {
                        System.out.println(ss);
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
            public void deviceDisconnected(IDevice device) {

                devices.setText("");
                devices.setText(String.format("%s Disconnected", device.getSerialNumber()));
                try {
                    String ss = null;
                    Process p = Runtime.getRuntime().exec("cmd.exe /c adb devices");
                    BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

                    while ((ss = r.readLine()) != null) {
                        PrintStream P = new PrintStream(new TextOut(devices));
                        System.setOut(P);
                        System.out.println("\n "+ss);
                        devices.setEditable(false);
                        devices.setWrapText(true);
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        wired.setSelected(true);
        applicable.setVisible(false);
        devip.setVisible(false);
        iplabel.setVisible(false);
        port.setVisible(false);
        portlabel.setVisible(false);
    }
    public void onBT(ActionEvent actionEvent) {
        if (bt.isSelected()){
            snd.setSelected(false);
            Audio.BTCon();
        }
    }
    public void onSndcpy(ActionEvent actionEvent) {
        if (snd.isSelected()){
            bt.setSelected(false);
            Audio.SndCon();
             }
        }
    }