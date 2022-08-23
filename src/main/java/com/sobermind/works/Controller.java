package com.sobermind.works;

import com.android.ddmlib.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * Authors: Davidx3D & Asandax6
 */

public class Controller implements Initializable{

    @FXML private CheckBox offscrn,stay,offcl,showt,fsmode,shortmod,cmdOut;
    @FXML private TextField bitrate,port,devip,maxsize,advpanel;
    @FXML private TextArea devices,output;
    @FXML private Label iplabel,applicable,portlabel;
    @FXML private RadioButton wired,wireless,bt,snd;
    @FXML private ListView lists;
    @FXML private Label lbl;

    //Button Functions
    @FXML
    void onRunbtn() throws Exception {
        //Variable Declaration Below
        boolean Off = offscrn.isSelected();
        boolean On = stay.isSelected();
        boolean Offcl = offcl.isSelected();
        boolean Show = showt.isSelected();
        boolean Fs = fsmode.isSelected();
        boolean Short = shortmod.isSelected();
        boolean Cmd = cmdOut.isSelected();

        String Bit = bitrate.getText();
        String Max = maxsize.getText();
        String Adv = advpanel.getText();
        String IP  = devip.getText();
        String Port= port.getText();

        //Array List To Store All The Chosen Options
        ArrayList<String> cmd = new ArrayList<>();

        if (IP!="") { cmd.add(" --tcpip="+IP);}
        else if (Port!="") { cmd.add(" --tcpip="+IP+":"+Port);}
        if(Off) cmd.add(" -S");
        if(On) cmd.add(" -w");
        if(Offcl) cmd.add(" --power-off-on-close");
        if(Show) cmd.add(" --show-touches");
        if(Fs) cmd.add(" -f");
        if(Short) cmd.add(" --shortcut-mod=lalt");
        if (lists.getSelectionModel().selectedItemProperty().equals("")) {
        //Line 54 To 58 Is Buggy, Will Fix When I Have Free Time From Other Projects
        } else {
            cmd.add(" -s"+lists.getSelectionModel().getSelectedItem());
        }
        if(Bit.matches("[0-9]+") && Bit.length() < 3) cmd.add("-b "+Bit+"M");
        if(Max.matches("[0-9]+") && Max.length() > 2) cmd.add("--max-size "+Max);
        //Code Below Removes The Symbols That Interfere With The Scripts From The Array
        String Script = cmd.toString()
                              .replace(",", "")
                              .replace("[", "")
                              .replace("]", "")
                              .trim();

        //Below Is The Important Stuff Which Runs The Scrcpy App With The Scripts From The Array
        if (Cmd){
            //Opens Cmd And Runs Scrcpy With Added Scripts (Without Printing To Output TextArea)
            Process p = Runtime.getRuntime().exec("cmd.exe /c scrcpy " + Script + " "+Adv);
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        } else {
            //Opens Cmd And Runs Scrcpy With Added Scripts (While Printing To Output TextArea)
            Process p = Runtime.getRuntime().exec("cmd.exe /c scrcpy " + Script + " "+Adv);
            //Below Is The Code That Reads The Output From Cmd After Running Scrcpy And Display It On a TextArea
            String sr = null;
            BufferedReader rs = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((sr = rs.readLine()) != null) {

                PrintStream printStream = new PrintStream(new TextOut(output));
                System.setOut(printStream);
                System.out.println(sr);//Shows Progress And Potential Errors On a Field
                output.setWrapText(true);
            }
        }
        }
    @FXML
    protected  void onExitbtn(){
        //Will Exit App If Exit Button Is Clicked
        System.exit(0);
    }
    public void onWired(ActionEvent actionEvent) {
        if (wired.isSelected()) {
            wireless.setSelected(false);
        }
        //The Simple Code Below Will Allow The Hidden Wireless Functions To Appear And Be Usable
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
        //Line 126 To 128 Currently Not Working
        if (devices.getText() != ""){
            lbl.setText("");
        }
        //The Below Are Set To False As They Are Options For Wireless And Wired Is Default
        wired.setSelected(true);
        applicable.setVisible(false);
        devip.setVisible(false);
        iplabel.setVisible(false);
        port.setVisible(false);
        portlabel.setVisible(false);
        //Uhm....Beep...Bop...Boop
        AndroidDebugBridge.init(false);
        devices.setEditable(false);
        output.setEditable(false);
        cmdOut.setSelected(true);

        AndroidDebugBridge debugBridge = AndroidDebugBridge.createBridge("adb.exe", true);
        if (debugBridge == null) {
            System.exit(1);
        }
        //The Code Below Uses ddmlib To Check For Inserted Adb Devices On The Computer And Display The Serial Number
        AndroidDebugBridge.addDeviceChangeListener(new AndroidDebugBridge.IDeviceChangeListener() {

            public void deviceChanged(IDevice device, int arg1) {
                //Not Necessary For Now
            }
            public void deviceConnected(IDevice device) {
                //When a Device Is Connected The App Will Run The Command Adb Devices To Check Connected Adb Devices
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
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                //Code Below Takes Device Serial Number From Adb And Places Inside a List View
                lists.getItems().add(device.getSerialNumber());
            }
            public void deviceDisconnected(IDevice device) {
                //When a Device Is Disconnected It Will Be Removed From The List View Of Available Devices
                lists.getItems().remove(device.getSerialNumber());
                devices.setText("");
                devices.setText(String.format("%s Disconnected",device.getSerialNumber()));
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
    }
    public void onBT(ActionEvent actionEvent) {
        //When BT Radio Button Is Selected The Sndcpy Radio Button Will Be Off
        //And If The Confirmation Is Yes The It Will Run BT Audio Connector
        if (bt.isSelected()){
            snd.setSelected(false);
            Audio.BTCon();
        }
    }
    public void onSndcpy(ActionEvent actionEvent) {
        //When Sndcpy Radio Button Is Selected The BT Radio Button Will Be Off
        //And If The Confirmation Is Yes The It Will Run Sndcpy
        if (snd.isSelected()){
            bt.setSelected(false);
            Audio.SndCon();
             }
        }

    public void onDisp(ActionEvent actionEvent) {
        //This Is For The Alert When The Disable Display Out CheckBox Is Toggled To Off
        Alert Disp = new Alert(Alert.AlertType.CONFIRMATION);
        Disp.setTitle("Disable Output Page");
        Disp.setHeaderText("The App Will Hang When This Is Disabled");
        Disp.setContentText("The App Will Run Scrcpy Then Hang (It Will Still Work, Just Not Well)");

        Optional<ButtonType> result = Disp.showAndWait();
        if (result.get() == ButtonType.OK){
           cmdOut.setSelected(false);
        }
        else {
            cmdOut.setSelected(true);
        }
    }
}