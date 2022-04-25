
package com.sobermind.works;

import java.io.IOException;
import java.io.OutputStream;
import javafx.scene.control.TextArea;

 class Devices extends OutputStream {
    private TextArea print;

    public Devices(TextArea textArea) {
        this.print = textArea;

    }
 
    public void write(int b) throws IOException {
        
        print.appendText(String.valueOf((char)b));
               
    }
}