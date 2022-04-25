package com.sobermind.works;

import java.io.IOException;
import java.io.OutputStream;
import javafx.scene.control.TextArea;

class Output extends OutputStream {
    
    private final TextArea output;

    public Output(TextArea textArea) {
        
        this.output = textArea;

    }
    
 public void write(int b) throws IOException {
     
        output.appendText(String.valueOf((char)b)); 
        
    }
}
