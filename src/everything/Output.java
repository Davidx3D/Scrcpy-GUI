
package everything;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

//@author SoberMind Works Made This
public class Output extends OutputStream {
    private JTextArea print1;


    public Output(JTextArea textArea) {
        this.print1 = textArea;

    }

 
    public void write(int b) throws IOException {
        
        print1.append(String.valueOf((char)b));// redirects data to the text area
        
        print1.setCaretPosition(print1.getDocument().getLength());// scrolls the text area to the end of data
        
       
        print1.update(print1.getGraphics());// keeps the textArea up to date
        
    }
}