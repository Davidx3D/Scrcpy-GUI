package app;

// @author SoberMind Works
 
public class Sndcpy {
  public static void Sndcpy() {
    try {
         Process p = Runtime.getRuntime().exec("cmd.exe /c sndcpy");
        } 
    catch(Exception e) {
         e.printStackTrace();
  		       }
}  
}
