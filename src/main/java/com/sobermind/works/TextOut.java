package com.sobermind.works;

import java.io.IOException;
import java.io.OutputStream;
import javafx.scene.control.TextArea;

 class TextOut extends OutputStream {
    private TextArea devices;
    private TextArea output;

    public TextOut(TextArea textArea) {
        this.devices = textArea;
        this.output = textArea;
    }
    public void write(int b) throws IOException {
        
        devices.appendText(String.valueOf((char)b));
    }
    public static void Out(){



    }
}