package app;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

 class Devices extends OutputStream {
    private JTextArea print;


    public Devices(JTextArea textArea) {
        this.print = textArea;

    }

 
    public void write(int b) throws IOException {
        
        print.append(String.valueOf((char)b));// redirects data to the text area
        
        print.setCaretPosition(print.getDocument().getLength());// scrolls the text area to the end of data
        
       
        print.update(print.getGraphics());// keeps the textArea up to date
        
    }
}