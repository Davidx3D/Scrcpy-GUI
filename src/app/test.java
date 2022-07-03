/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.awt.List;
import java.io.File;
import java.util.Arrays;

/**
 *
 * @author desti
 */
public class test {
   
    public static void main(String args[]) {
    try {
    ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c","scrcpy");
    Process proc = builder.start();
        } 
    catch(Exception e) {
         e.printStackTrace();
  		       }
}
}
