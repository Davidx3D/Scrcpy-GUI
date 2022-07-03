package com.sobermind.works;

import java.io.*;
import java.net.URL;
import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;

import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class Controller implements Initializable {

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

        if (IP!= "") {
            try {
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                Script.write(" --tcpip="+IP);
                Script.close();
            } catch (Exception x) {}

        } else if (Port!= "") {
            try {
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                Script.write(" --tcpip="+IP+":"+Port);
                Script.close();
            } catch (Exception x) {}

        }if (Off) {
            try{
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                Script.write(" -S");
                Script.close();
            }catch (Exception x) {}
        } if (On) {
            try{
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                Script.write(" -w");
                Script.close();
            }catch (Exception x) {}
        }    if (Offcl) {
            try{
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                Script.write(" --power-off-on-close");
                Script.close();
            }catch (Exception x) {}
        } if (Show) {
            try{
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                Script.write(" --show-touches");
                Script.close();
            }catch (Exception x) {}

        } if (Fs) {
            try{
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                Script.write(" -f");
                Script.close();
            }catch (Exception x) {}

        } if (Short) {
            try{
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                Script.write(" --shortcut-mod=lalt");
                Script.close();
            }catch (Exception x) {}
        } if (Bit.equals("")){

        } else if (Bit.matches("[0-9]+") && Bit.length() < 3) {
            try{
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                Script.write(" -b "+Bit+"M");
                Script.close();
            }catch (Exception x) {}
        } if (Max.equals("")){

        } else if (Max.matches("[0-9]+") && Max.length() > 2) {
            try{
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                Script.write(" --max-size "+Max);
                Script.close();
            } catch (Exception x) {}
        }

        //Below Is The Important Stuff

        try {
            BufferedReader Test = new BufferedReader(new FileReader(new File("scripts.txt")));
            //Reads The File Where All The Changes Are Made
            String mods = "";

            while((mods = Test.readLine()) != null){
                Process p = Runtime.getRuntime().exec("cmd.exe /c scrcpy " + mods + " "+Adv);
                    //Opens Cmd And Runs Scrcpy With Added Scripts
                    String sr = null;
                    BufferedReader rs = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    while ((sr = rs.readLine()) != null) {

                        PrintStream printStream = new PrintStream(new TextOut(output));
                        System.setOut(printStream);
                        System.out.println(sr);//Shows Progress And Potential Errors On a Field
                        output.setWrapText(true);

                    }
                while ((sr = rs.readLine()) != null) {
                    System.out.println(sr);

                }
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                    PrintWriter writer = new PrintWriter(Script);
                    writer.print("");
                    //To Clear The File Used To Store Scripts...
                    writer.close();
                }

        } catch (IOException e) {
            System.out.println("There Was An Error (The Dev Is Clueless)");
            //Just Incase There Is a Problem Viewing The File
            e.printStackTrace();

        }

    }
    @FXML
    protected  void onExitbtn(){
        try {
            File Exit = new File("scripts.txt");
            PrintWriter writer = new PrintWriter(Exit);
            writer.print("");//To Clear The File Used To Store Scripts...
            writer.close();}

        catch (FileNotFoundException e) {}
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

            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Wireless (Wi-Fi)");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Please Ensure That Both Computer & Device Are Connected To The Same Wi-Fi");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();

                applicable.setVisible(true);
                devip.setVisible(true);
                iplabel.setVisible(true);
                port.setVisible(true);
                portlabel.setVisible(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AndroidDebugBridge.init(false);
        devices.setText("Please Connect An Android Device");
        devices.setEditable(false);

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

                String a = ""; //Created To Avoid Empty Character Literal Error
                devices.setText(a);

                String s = String.format("%s Disconnected", device.getSerialNumber());
                devices.setText(s);

                try {

                    String ss = null;

                    Process p = Runtime.getRuntime().exec("cmd.exe /c /Files/adb devices");
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

        output.setEditable(false);
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