package com.sobermind.works;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

class Output extends OutputStream {
    private TextArea output;

    public Output(TextArea textArea) {
        this.output = textArea;

    } public void write(int b) throws IOException {
        
        output.appendText(String.valueOf((char)b));  
    }
}
class Devices extends OutputStream {
    private TextArea devices;

    public Devices(TextArea textArea) {
        this.devices = textArea;

    } public void write(int b) throws IOException {
        
        devices.appendText(String.valueOf((char)b));  
    }
}

public class PrimaryController {

    @FXML
    private CheckBox to;
    private CheckBox on;
    private CheckBox no;
    private CheckBox offcl;
    private CheckBox show;
    private CheckBox fs;
    private CheckBox shortmod;
   
    private TextField bitrate;
    private TextField max;
    private TextField adv;
    
    private TextArea devices;
    private TextArea output;
    private Label platform;
    
    private Button run;
    private Button ext;
    
    
    private String generateCMD(){
        
        boolean To = to.isSelected();
        boolean Sa = on.isSelected();
        boolean Nc = no.isSelected();
        boolean Ts = offcl.isSelected();
        boolean St = show.isSelected();
        boolean Fs = fs.isSelected();
        boolean Sm = shortmod.isSelected();

        String Bit = bitrate.getText();
        String Max = max.getText();
        String Adv = adv.getText();
        String str = OS.isWindows
                ? "scrcpy.exe"
                : "scrcpy";
        List<String> cmd = new ArrayList<>();

        if(To) cmd.add(" -s");
        if(Sa) cmd.add(" -w");
        if(Nc) cmd.add(" --no-control");
        if(Ts) cmd.add(" --power-off-on-close");
        if(St) cmd.add(" -t");
        if(Fs) cmd.add(" -f");
        if(Sm) cmd.add(" --shortcut-mod=lalt");
        if(Bit.matches("[0-9]+") && Bit.length() < 2) cmd.add(" -b "+Bit+"M");
        if(Max.matches("[0-9]+") && Max.length() > 2) cmd.add(" --max-size "+Max);
        for(String i : cmd) str += " " + i;
        return str;
    }

    //Helper Functions
    static void copy(InputStream in, OutputStream out) throws Exception {
        while (true) {
            int c = in.read();
            if (c == -1) break;
            out.write((char)c);
        }
    }

    //Button Functions
    @FXML
     void onRunButtonClick() throws Exception {
        ProcessBuilder builder = new ProcessBuilder("scrcpy.exe");
        builder.redirectErrorStream(true); //merge input and error streams
        Process process = builder.start();
            int exitCode = -1;
            //read from the merged stream
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                //read until the stream is exhausted, meaning the process has terminated
                while ((line = reader.readLine()) != null) {
                    output.setText(line); //use the output here
                }
                //get the exit code if required
                exitCode = process.waitFor();
            } catch (Exception e) { }

    }
    @FXML
    protected  void onExitButtonClick(){
      
    }
}