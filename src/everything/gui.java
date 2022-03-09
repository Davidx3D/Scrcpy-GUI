package everything;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class gui extends javax.swing.JFrame {


    public gui() {
        initComponents();
        
         this.setLocationRelativeTo(null);
                
         try {
        	 	File Scrcpy = new File("/snap/scrcpy/current/usr/local/bin/scrcpy");
        	 	File Terminal = new File("/usr/bin/xterm");
        	 
        	 if (Terminal.exists()){
        		 platform.setText("Linux Detected");
        		 
        	}else {
	   			platform.setText("Windows Detected"); 

        	}


   } 	catch(Exception e) {
	   			e.printStackTrace();
}
     
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkbox1 = new java.awt.Checkbox();
        pnl2 = new javax.swing.JPanel();
        pnl1 = new javax.swing.JPanel();
        lbl2 = new javax.swing.JLabel();
        run = new javax.swing.JButton();
        lbl3 = new javax.swing.JLabel();
        fs = new javax.swing.JCheckBox();
        off = new javax.swing.JCheckBox();
        on = new javax.swing.JCheckBox();
        no = new javax.swing.JCheckBox();
        offcl = new javax.swing.JCheckBox();
        show = new javax.swing.JCheckBox();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bitrate = new javax.swing.JTextField();
        lbl12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        max = new javax.swing.JTextField();
        lbl11 = new javax.swing.JLabel();
        shortmod = new javax.swing.JCheckBox();
        lbl10 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        pnl = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        platform = new javax.swing.JLabel();
        scrcpy = new javax.swing.JLabel();

        checkbox1.setLabel("checkbox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl2.setBackground(new java.awt.Color(0, 0, 128));

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnl1.setBackground(new java.awt.Color(204, 204, 204));
        pnl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));
        pnl1.setForeground(new java.awt.Color(102, 102, 102));
        pnl1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl2.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        lbl2.setText("SCRCPY SETTINGS");
        pnl1.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        run.setBackground(new java.awt.Color(255, 255, 255));
        run.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        run.setForeground(new java.awt.Color(0, 51, 255));
        run.setText("Run Scrcpy");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });
        pnl1.add(run, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, 110, 30));

        lbl3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lbl3.setText("*Only Select Options You Need*");
        pnl1.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        fs.setBackground(new java.awt.Color(204, 204, 204));
        fs.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fs.setText("Full Screen Mode");
        pnl1.add(fs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        off.setBackground(new java.awt.Color(204, 204, 204));
        off.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        off.setText("Turn Off Screen");
        pnl1.add(off, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        on.setBackground(new java.awt.Color(204, 204, 204));
        on.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        on.setText("Stay Awake");
        pnl1.add(on, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        no.setBackground(new java.awt.Color(204, 204, 204));
        no.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        no.setText("No Control");
        pnl1.add(no, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        offcl.setBackground(new java.awt.Color(204, 204, 204));
        offcl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        offcl.setText("Turn Screen Off On Close");
        pnl1.add(offcl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        show.setBackground(new java.awt.Color(204, 204, 204));
        show.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        show.setText("Show Touches");
        pnl1.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        lbl4.setText("*Turns Off Screen On Physical Device*");
        pnl1.add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        lbl5.setText("*Prevents Device From Sleeping*");
        pnl1.add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lbl6.setText("*Disables Keyboard/Mouse Passthrough*");
        pnl1.add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        lbl7.setText("*Turns Phone Screen Off When Scrcpy Closes*");
        pnl1.add(lbl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        lbl8.setText("*Show Physical Touches & Clicks On Screen*");
        pnl1.add(lbl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        lbl9.setText("*Start Scrcpy In Full Screen Mode*");
        pnl1.add(lbl9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Max Bit Rate (MB)");
        pnl1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));
        pnl1.add(bitrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 70, -1));

        lbl12.setText("*Leave Empty If No Change*");
        pnl1.add(lbl12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, 20));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Max Screen Size");
        pnl1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));
        pnl1.add(max, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 70, -1));

        lbl11.setText("*Leave Empty If No Change*");
        pnl1.add(lbl11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, 20));

        shortmod.setBackground(new java.awt.Color(204, 204, 204));
        shortmod.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        shortmod.setText("Shortcut Mod");
        pnl1.add(shortmod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        lbl10.setText("*Adds Changes Shortcut Key (Default = Left Alt)*");
        pnl1.add(lbl10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));
        pnl1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 610, 20));

        exit.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 0, 0));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        pnl1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 490, 60, 30));

        pnl.setBackground(new java.awt.Color(204, 204, 204));
        pnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));

        lbl.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        lbl.setText("SCRCPY-GUI v1.0");

        lbl1.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        lbl1.setForeground(new java.awt.Color(51, 51, 51));
        lbl1.setText("GUI For Scrcpy v1.23");

        platform.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        scrcpy.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addComponent(platform, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrcpy, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl)
                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrcpy, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(platform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl1)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
File we = new File("test.txt");

     we.deleteOnExit(); 
     if (we.delete()) { 
          } 
     else {
         System.out.println("Failed");}
     
         System.exit(0);       
    }//GEN-LAST:event_exitActionPerformed

    private void runActionPerformed(java.awt.event.ActionEvent evt) {                                    

    	boolean Off = off.isSelected();
    	boolean On = on.isSelected();
    	boolean No = no.isSelected();
    	boolean Offcl = offcl.isSelected();
    	boolean Show = show.isSelected();
    	boolean Fs = fs.isSelected();
    	boolean Short = shortmod.isSelected();
 
    	String Bit = bitrate.getText();
    	String Max = max.getText();



if (Off) {
	
    try{ 
    	String FILE ="test.txt";
    	FileWriter test = new FileWriter(FILE, true);
    	test.write(" -S");
    	test.close();    
        }catch (Exception x) {
        	
        }
}
if (On) {
	
    try{ 
    	String FILE ="test.txt";
    	FileWriter test = new FileWriter(FILE, true);
    	test.write(" -w");
    	test.close();   
        }catch (Exception x) {
        	
        }
    
}  if (No) {
	
       try{ 
    	   String FILE ="test.txt";
    	   FileWriter test = new FileWriter(FILE, true);
    	   test.write(" -n,");
    	   test.close();  
        }catch (Exception x) {
        	
        }
       
}  if (Offcl) {
	
       try{ 
    	   String FILE ="test.txt";
    	   FileWriter test = new FileWriter(FILE, true);	
    	   test.write(" --power-off-on-close");
    	   test.close();  
        }catch (Exception x) {
        	
        }
} if (Show) {
	
	  try{ 
		  String FILE ="test.txt";
		  FileWriter test = new FileWriter(FILE, true);
		  test.write(" -t,");
		  test.close(); 
        }catch (Exception x) {
        	
        }
        
} if (Fs) {
	
	  try{ 
		  String FILE ="test.txt";
		  FileWriter test = new FileWriter(FILE, true);
		  test.write(" -f");
		  test.close();
        }catch (Exception x) {

        } 
    
} if (Short) {
	
	  try{ 
		  String FILE ="test.txt";
		  FileWriter test = new FileWriter(FILE, true);
		  test.write(" --shortcut-mod=lalt");
		  test.close();
            
        }catch (Exception x) {
        	
        }
} if (Bit.equals("")){

}
else if (Bit.matches("[0-9]+") && Bit.length() < 3) {
        try{  
        	String FILE ="test.txt";
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
        	
        	String FILE ="test.txt";
        	FileWriter test = new FileWriter(FILE, true);
            test.write(" --max-size "+Max);
            test.close();
            
        } catch (Exception x) {
        	
        }
}
else {
    JOptionPane.showMessageDialog(null, "Numbers Above 99 Only For Max Size (Numbers Only)");
}
	try {
			
			BufferedReader Test = new BufferedReader(new FileReader(new File("test.txt")));//Reads The File Where All The Changes Are Made
			String mods = "";
			
			while((mods = Test.readLine()) != null)
				
			{
				
			 label.setText("Used Scripts : Scrcpy "+ mods); // Prints Selections On Label
			 
			 File Terminal = new File("/usr/bin/xterm");
			 
			 if (Terminal.exists()){
				 
				 try {
					 Runtime r = Runtime.getRuntime();
					 String[] cmdArray = {"xterm", "-e", "scrcpy" + mods +" ; le_exec"};
					 r.exec(cmdArray).waitFor();
					 
				 } catch (InterruptedException ex){
					 ex.printStackTrace();
				 } catch (IOException ex) {
					 ex.printStackTrace();
				 }
				 
				 
   }	else { ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","scrcpy"+mods); //Opens Cmd And Runs Scrcpy With Added Scripts
                         Process pc = pb.start();//Starts Process And Opens Cmd To Execute Scrcpy
                         File we = new File("test.txt"); 
                         we.deleteOnExit();
                       
                       if (we.delete()) { 
                    	   
                         System.out.println("Deleted the file: " + we.getName());
                       } 
                       else {
                    	
                         System.out.println("Failed");
                       }    }
           
			}
                        

                        
		} catch (FileNotFoundException e) {
			System.out.println("Well Fuck");//Well If This Fails Then Uhm The Scripts Wont Be Applied
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Check Output Errors");//Just Incase There Is a Problem Viewing The File
			e.printStackTrace();
		}       
    }

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
    private javax.swing.JTextField bitrate;
    private java.awt.Checkbox checkbox1;
    private javax.swing.JButton exit;
    private javax.swing.JCheckBox fs;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
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
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JButton run;
    private javax.swing.JLabel scrcpy;
    private javax.swing.JCheckBox shortmod;
    private javax.swing.JCheckBox show;
    // End of variables declaration//GEN-END:variables
}
