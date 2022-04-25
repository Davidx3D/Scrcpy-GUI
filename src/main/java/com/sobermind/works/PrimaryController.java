package com.sobermind.works;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class PrimaryController {

    @FXML private CheckBox to;
    @FXML private CheckBox on;
    @FXML private CheckBox no;
    @FXML private CheckBox offcl;
    @FXML private CheckBox show;
    @FXML private CheckBox fs;
    @FXML private CheckBox shortmod;
   
    @FXML private TextField bitrate;
    @FXML private TextField max;
    @FXML private TextField adv;
    
    @FXML private TextArea devices;
    @FXML private TextArea output;
    @FXML private Button ext;

    
    //Button Functions
    @FXML
    void onRunButtonClick() throws Exception {
         
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
        String ReadStream = null;
         
        //Creates ArrayList And Store Data From Selected Scripts
        List<String> cmd = new ArrayList<>();

        if(To) cmd.add(" -s");
        if(Sa) cmd.add(" -w");
        if(Nc) cmd.add(" --no-control");
        if(Ts) cmd.add(" --power-off-on-close");
        if(St) cmd.add(" -t");
        if(Fs) cmd.add(" -f");
        if(Sm) cmd.add(" --shortcut-mod=lalt");
        // if(Bit != null) cmd.add(" -b "+Bit+"M");
        // if(Max != null) cmd.add(" --max-size "+Max);
        // if(Adv != null) cmd.add(Adv);
        
        //Runs Scrpy With Scripts Stored In The Array
        for (String i:cmd){
            String list = String.join(", ",cmd);           
            String read = null;    
            System.out.println(list);
        
        Process terminal = Runtime.getRuntime().exec("cmd.exe /c scrcpy ");
        BufferedReader Read = new BufferedReader(new InputStreamReader(terminal.getInputStream()));
        
        // Reads The Output From CMD When Scrcpy Is Running And Displays On TextArea
        while ((read = Read.readLine()) != null) {
        // output.setText(read);
        PrintStream printStream = new PrintStream(new Output(output));
        System.setOut(printStream);
        System.out.println(Read);
        output.setWrapText(true);
        output.setEditable(false);
           }
        }
    }
    @FXML
    protected  void onExitButtonClick(){
        Stage stage = (Stage) ext.getScene().getWindow();
        stage.close();
    }
}