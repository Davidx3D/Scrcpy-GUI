package everything;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.Timer;




import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

//@author SoberMind Works
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

class Output extends OutputStream {
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
 //@author SoberMind Works

public class gui extends javax.swing.JFrame {

    public gui() {
        
        ActionListener task = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                 try {
                     print.setText("");
                     
                     String ss = null;
                     Process p = Runtime.getRuntime().exec("cmd.exe /c adb devices");
                     BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
       
                 while ((ss = r.readLine()) != null) {
                      PrintStream printStream = new PrintStream(new Devices(print));
                      System.setOut(printStream);
                      System.setErr(printStream);
                      System.out.println(ss);
                      print.setEditable(false);

                     }
                 while ((ss = r.readLine()) != null) {
                      System.out.println(ss);
                      
                    }
                } 
                 catch(Exception e) {
                      e.printStackTrace();
  		}}};
                      Timer timer = new Timer(650 ,task);//Timer Updates Once Every 650
                      timer.setRepeats(true);
                      timer.start();
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        try {
            File Scrcpy = new File("/snap/scrcpy/current/usr/local/bin/scrcpy");
            File Terminal = new File("/usr/bin/xterm");
        	 
        if (Terminal.exists()){
             platform.setText("Linux Detected");
        		 
       } else {
	   platform.setText("Windows Detected"); 

       }
   } 	catch(Exception e) {
	      e.printStackTrace();
}
         
   
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        platform = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        print = new javax.swing.JTextArea();
        lbl16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        off = new javax.swing.JCheckBox();
        lbl4 = new javax.swing.JLabel();
        on = new javax.swing.JCheckBox();
        lbl5 = new javax.swing.JLabel();
        no = new javax.swing.JCheckBox();
        lbl6 = new javax.swing.JLabel();
        offcl = new javax.swing.JCheckBox();
        lbl7 = new javax.swing.JLabel();
        show = new javax.swing.JCheckBox();
        lbl8 = new javax.swing.JLabel();
        fs = new javax.swing.JCheckBox();
        lbl9 = new javax.swing.JLabel();
        shortmod = new javax.swing.JCheckBox();
        lbl10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bitrate = new javax.swing.JTextField();
        lbl11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        max = new javax.swing.JTextField();
        lbl12 = new javax.swing.JLabel();
        run = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl13 = new javax.swing.JLabel();
        lbl14 = new javax.swing.JLabel();
        adv = new javax.swing.JTextField();
        lbl15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        print1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204), 2));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Scrcpy-GUI v1.2");

        platform.setBackground(new java.awt.Color(204, 204, 204));
        platform.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        platform.setForeground(new java.awt.Color(255, 153, 153));

        print.setEditable(false);
        print.setBackground(new java.awt.Color(51, 51, 51));
        print.setColumns(20);
        print.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        print.setForeground(new java.awt.Color(204, 204, 204));
        print.setRows(5);
        jScrollPane1.setViewportView(print);

        lbl16.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lbl16.setForeground(new java.awt.Color(204, 204, 204));
        lbl16.setText("*Based On Scrcpy v1.23 By Genymobile*");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(platform, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(platform, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl16)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 2, true));

        lbl2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lbl2.setForeground(new java.awt.Color(204, 204, 204));
        lbl2.setText("SCRCPY SETTINGS");

        lbl3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lbl3.setForeground(new java.awt.Color(204, 204, 204));
        lbl3.setText("*Only Select Options You Need*");

        off.setBackground(new java.awt.Color(51, 51, 51));
        off.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        off.setForeground(new java.awt.Color(204, 204, 204));
        off.setText("Turn Off Screen");

        lbl4.setForeground(new java.awt.Color(255, 153, 153));
        lbl4.setText("*Turns Off Screen On Physical Device*");

        on.setBackground(new java.awt.Color(51, 51, 51));
        on.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        on.setForeground(new java.awt.Color(204, 204, 204));
        on.setText("Stay Awake");

        lbl5.setForeground(new java.awt.Color(255, 153, 153));
        lbl5.setText("*Prevents Device From Sleeping*");

        no.setBackground(new java.awt.Color(51, 51, 51));
        no.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        no.setForeground(new java.awt.Color(204, 204, 204));
        no.setText("No Control");

        lbl6.setForeground(new java.awt.Color(255, 153, 153));
        lbl6.setText("*Disables Keyboard/Mouse Passthrough*");

        offcl.setBackground(new java.awt.Color(51, 51, 51));
        offcl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        offcl.setForeground(new java.awt.Color(204, 204, 204));
        offcl.setText("Turn Screen Off On Close");

        lbl7.setForeground(new java.awt.Color(255, 153, 153));
        lbl7.setText("*Turns Phone Screen Off When Scrcpy Closes*");

        show.setBackground(new java.awt.Color(51, 51, 51));
        show.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        show.setForeground(new java.awt.Color(204, 204, 204));
        show.setText("Show Touches");

        lbl8.setForeground(new java.awt.Color(255, 153, 153));
        lbl8.setText("*Show Physical Touches & Clicks On Screen*");

        fs.setBackground(new java.awt.Color(51, 51, 51));
        fs.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fs.setForeground(new java.awt.Color(204, 204, 204));
        fs.setText("Full Screen Mode");

        lbl9.setForeground(new java.awt.Color(255, 153, 153));
        lbl9.setText("*Start Scrcpy In Full Screen Mode*");

        shortmod.setBackground(new java.awt.Color(51, 51, 51));
        shortmod.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        shortmod.setForeground(new java.awt.Color(204, 204, 204));
        shortmod.setText("Shortcut Mod");

        lbl10.setForeground(new java.awt.Color(255, 153, 153));
        lbl10.setText("*Adds Changes Shortcut Key (Default = Left Alt)*");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Max Bit Rate (MB)");

        bitrate.setBackground(new java.awt.Color(102, 102, 102));
        bitrate.setForeground(new java.awt.Color(204, 204, 204));

        lbl11.setForeground(new java.awt.Color(255, 153, 153));
        lbl11.setText("*Leave Empty If No Change*");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Max Screen Size");

        max.setBackground(new java.awt.Color(102, 102, 102));
        max.setForeground(new java.awt.Color(204, 204, 204));

        lbl12.setForeground(new java.awt.Color(255, 153, 153));
        lbl12.setText("*Leave Empty If No Change*");

        run.setBackground(new java.awt.Color(102, 102, 102));
        run.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        run.setForeground(new java.awt.Color(0, 51, 255));
        run.setText("Run Scrcpy");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(102, 102, 102));
        exit.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 0, 0));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        label.setForeground(new java.awt.Color(204, 204, 204));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lbl13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lbl13.setForeground(new java.awt.Color(204, 204, 204));
        lbl13.setText("Advanced User Panel");

        lbl14.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lbl14.setForeground(new java.awt.Color(204, 204, 204));
        lbl14.setText("*Add Custom Scripts Ontop Of The Optional Ones Provided*");

        adv.setBackground(new java.awt.Color(102, 102, 102));
        adv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        adv.setForeground(new java.awt.Color(204, 204, 204));

        lbl15.setForeground(new java.awt.Color(255, 153, 153));
        lbl15.setText("*Leave Empty If No Change*");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl13)
                        .addComponent(lbl14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adv))
                    .addComponent(lbl15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lbl13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Display Output");

        print1.setBackground(new java.awt.Color(51, 51, 51));
        print1.setColumns(20);
        print1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        print1.setForeground(new java.awt.Color(204, 204, 204));
        print1.setRows(5);
        jScrollPane2.setViewportView(print1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl2)
                            .addComponent(lbl3)
                            .addComponent(off)
                            .addComponent(on)
                            .addComponent(no)
                            .addComponent(offcl)
                            .addComponent(show)
                            .addComponent(fs)
                            .addComponent(shortmod)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl6)
                                    .addComponent(lbl7)
                                    .addComponent(lbl8)
                                    .addComponent(lbl9)
                                    .addComponent(lbl10)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(bitrate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(lbl11))
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(max, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(lbl12))
                                    .addComponent(lbl4)
                                    .addComponent(lbl5))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl3)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(off))
                                .addComponent(on))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(lbl5)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(no)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbl6)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbl7))
                            .addComponent(offcl))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(show)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbl8)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbl9))
                            .addComponent(fs))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbl10))
                            .addComponent(shortmod))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bitrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed

        boolean Off = off.isSelected();
    	boolean On = on.isSelected();
    	boolean No = no.isSelected();
    	boolean Offcl = offcl.isSelected();
    	boolean Show = show.isSelected();
    	boolean Fs = fs.isSelected();
    	boolean Short = shortmod.isSelected();
 
    	String Bit = bitrate.getText();
    	String Max = max.getText();
        String Label = label.getText();
        String Adv = adv.getText();

  if (Off) {
    try{ 
        label.setText("-S");
    	String FILE ="scripts.txt";
    	FileWriter test = new FileWriter(FILE, true);
    	test.write(" -S");
    	test.close();    
        }catch (Exception x) {
        	
        }
} if (On) {
	
    try{ 
        label.setText(Label+" -w");
    	String FILE ="scripts.txt";
    	FileWriter test = new FileWriter(FILE, true);
    	test.write(" -w");
    	test.close();   
        }catch (Exception x) {
        	
        }
}  if (No) {
	
    try{ 
 	String FILE ="scripts.txt";
    	FileWriter test = new FileWriter(FILE, true);
    	test.write(" --no-control");
    	test.close();  
        }catch (Exception x) {
        	
        }
       
}  if (Offcl) {
	
    try{ 
    	String FILE ="scripts.txt";
    	FileWriter test = new FileWriter(FILE, true);	
    	test.write(" --power-off-on-close");
    	test.close();  
        }catch (Exception x) {
        	
        }
} if (Show) {
	
    try{ 
        String FILE ="scripts.txt";
	FileWriter test = new FileWriter(FILE, true);
	test.write(" --show-touches");
        test.close(); 
        }catch (Exception x) {
        	
        }
        
} if (Fs) {
	
    try{ 
        String FILE ="scripts.txt";
	FileWriter test = new FileWriter(FILE, true);
        test.write(" -f");
        test.close();
        }catch (Exception x) {

        } 
    
} if (Short) {
	
    try{ 
	String FILE ="scripts.txt";
	FileWriter test = new FileWriter(FILE, true);
        test.write(" --shortcut-mod=lalt");
        test.close();
        }catch (Exception x) {
        	
        }
} if (Bit.equals("")){

} else if (Bit.matches("[0-9]+") && Bit.length() < 3) {
	
    try{  
        String FILE ="scripts.txt";
        FileWriter test = new FileWriter(FILE, true);
        test.write(" -b "+Bit+"M");
        test.close();
        }catch (Exception x) {
        }
      } else {
              JOptionPane.showMessageDialog(null, "Numbers Below 100 For Bit Rate (Numbers Only)");
    
} if (Max.equals("")){

} else if (Max.matches("[0-9]+") && Max.length() > 2) {
	
    try{ 
        String FILE ="scripts.txt";
        FileWriter test = new FileWriter(FILE, true);
        test.write(" --max-size "+Max);
        test.close();
        } catch (Exception x) {
        }
      } else {
             JOptionPane.showMessageDialog(null, "Numbers Above 99 Only For Max Size (Numbers Only)");
}


//Below Is The Important Stuff

ActionListener task = new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        
          try {
               BufferedReader Test = new BufferedReader(new FileReader(new File("scripts.txt")));//Reads The File Where All The Changes Are Made
               String mods = "";
			
          while((mods = Test.readLine()) != null){
               label.setText("Used Scripts : Scrcpy "+ mods+ " "+Adv); // Prints Selections On Label
                    }
                } 
          catch(Exception e) {
                e.printStackTrace();}}};

                Timer timer = new Timer(650 ,task);//Timer Updates Once Every 650
                timer.setRepeats(true);
                timer.start();

try {
     BufferedReader Test = new BufferedReader(new FileReader(new File("scripts.txt")));//Reads The File Where All The Changes Are Made
     String mods = "";
			
     while((mods = Test.readLine()) != null){
           File Terminal = new File("/usr/bin/xterm");//Linux Terminal (Not Default So It Looks Weird)
			 
     if (Terminal.exists()){
        try {
	     Runtime r = Runtime.getRuntime();
	     String[] cmdArray = {"xterm", "-e", "scrcpy" + mods + " "+Adv +" ; le_exec"};//Opens Terminal And Run Scrcpy On Linux
	     r.exec(cmdArray).waitFor();
             
      } catch (InterruptedException ex){
               ex.printStackTrace();
               
      } catch (IOException ex) {
	       ex.printStackTrace();
      }
				 
   } else { Process p = Runtime.getRuntime().exec("cmd.exe /c scrcpy " + mods + " "+Adv); //Opens Cmd And Runs Scrcpy With Added Scripts
       String sr = null;
       BufferedReader rs = new BufferedReader(new InputStreamReader(p.getInputStream()));
       
       while ((sr = rs.readLine()) != null) {
           label.setText("Used Scripts : Scrcpy "+ mods+ " "+Adv); // Prints Selections On Label

           PrintStream printStream = new PrintStream(new Output(print1));
           System.setOut(printStream);
           System.setErr(printStream);
    	   System.out.println(sr);//Shows Progress And Potential Errors On a Field
           print1.setEditable(false);
           print1.setLineWrap(true);
        }

        try {
             BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
             String line;
             while (true) {
             line = r.readLine();
                        	 
        if  (line == null) { break; 
            } 
        }
   } catch(Exception e) {e.printStackTrace();
} 
           File we = new File("scripts.txt"); 
           PrintWriter writer = new PrintWriter(we);
           writer.print("");//To Clear The File Used To Store Scripts...
           writer.close();
                     }
           }
   } catch (FileNotFoundException e) {
            System.out.println("File With Scripts Still Has Content or Not Found");//Well If This Fails Then The File That Stores Scripts Isnt Cleared
            e.printStackTrace();
            
   } catch (IOException e) {
            System.out.println("Check Output Errors");//Just Incase There Is a Problem Viewing The File
            e.printStackTrace();
            
   }              
    }//GEN-LAST:event_runActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
try {File we = new File("scripts.txt");

     PrintWriter writer = new PrintWriter(we);
     writer.print("");//To Clear The File Used To Store Scripts...
     writer.close();}

catch (FileNotFoundException e) {
       System.out.println("File With Scripts Still Has Content or Not Found");//Well If This Fails Then The File That Stores Scripts Isnt Cleared
       e.printStackTrace();
   }
       System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adv;
    private javax.swing.JTextField bitrate;
    private javax.swing.JButton exit;
    private javax.swing.JCheckBox fs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl13;
    private javax.swing.JLabel lbl14;
    private javax.swing.JLabel lbl15;
    private javax.swing.JLabel lbl16;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JTextField max;
    private javax.swing.JCheckBox no;
    private javax.swing.JCheckBox off;
    private javax.swing.JCheckBox offcl;
    private javax.swing.JCheckBox on;
    private javax.swing.JLabel platform;
    private javax.swing.JTextArea print;
    private javax.swing.JTextArea print1;
    private javax.swing.JButton run;
    private javax.swing.JCheckBox shortmod;
    private javax.swing.JCheckBox show;
    // End of variables declaration//GEN-END:variables
}
