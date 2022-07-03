package app;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BTAudio {
  
  
public static void Bluetooth() {
    try {
         Process p = Runtime.getRuntime().exec("audio.exe");
        } 
    catch(Exception e) {
         e.printStackTrace();
  		       }
}
}
