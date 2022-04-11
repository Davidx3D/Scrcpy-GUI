package com.sobermind.scgui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Controller{
    /* Declarations to link FXML controls with Controller.
     * Please note this is user generated unlike in NetBeans.
     * In JavaFX there's no need for ActionListeners like in Swing.
     * All Buttons and Actions just link automatically to functions.
     * All functions that need to be run by Components in FXML must be
     * annotated with @FXML so they can be visible to SceneBuilder
     */
    @FXML private CheckBox to;
    @FXML private CheckBox sa;
    @FXML private CheckBox nc;
    @FXML private CheckBox ts;
    @FXML private CheckBox st;
    @FXML private CheckBox fs;
    @FXML private CheckBox sm;

    @FXML private TextField bit;
    @FXML private TextField max;

    @FXML private TextArea dispOut;
    @FXML private Label cmdUsed;

    private String generateCMD(){
        boolean To = to.isSelected();
        boolean Sa = sa.isSelected();
        boolean Nc = nc.isSelected();
        boolean Ts = ts.isSelected();
        boolean St = st.isSelected();
        boolean Fs = fs.isSelected();
        boolean Sm = sm.isSelected();

        String Bit = bit.getText();
        String Max = max.getText();
        String str = OS.isWindows
                ? "scrcpy.exe"
                : "scrcpy";
        List<String> cmd = new ArrayList<>();

        if(To) cmd.add("-s");
        if(Sa) cmd.add("-w");
        if(Nc) cmd.add("--no-control");
        if(Ts) cmd.add("--power-off-on-close");
        if(St) cmd.add("-t");
        if(Fs) cmd.add("-f");
        if(Sm) cmd.add("--shortcut-mod=lalt");
        if(Bit.matches("[0-9]+") && Bit.length() < 2) cmd.add("-b "+Bit+"M");
        if(Max.matches("[0-9]+") && Max.length() > 2) cmd.add("--max-size "+Max);
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
    protected void onRunButtonClick() throws Exception {
        ProcessBuilder builder = new ProcessBuilder("scrcpy");
        builder.redirectErrorStream(true); //merge input and error streams
        Process process = builder.start();

            int exitCode = -1;
            //read from the merged stream
            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                //read until the stream is exhausted, meaning the process has terminated
                while ((line = reader.readLine()) != null) {
                    dispOut.setText(line); //use the output here
                }
                //get the exit code if required
                exitCode = process.waitFor();
            } catch (Exception e) { }

    }
    @FXML
    protected  void onExitButtonClick(){
        Platform.exit();
    }
}