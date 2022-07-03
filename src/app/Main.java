package app;

import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

// @author Davidx3D

public class Main extends javax.swing.JFrame {

    
    public Main() {
        
     initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Scrcpy-GUI By Davidx3D");
     
        ImageIcon img = new ImageIcon("src/needed/icon.png");
        this.setIconImage(img.getImage());
        
        DisplayOutput.setEditable(false);
        Wired.setSelected(true);
        AndroidDebugBridge.init(false);
        ShowDevices.setText("Please Connect An Android Device");
        
        arrow.setVisible(false);
        ip.setVisible(false);
        iplabel.setVisible(false);
        port.setVisible(false);
        portlabel.setVisible(false);
        
        
        
        AndroidDebugBridge debugBridge = AndroidDebugBridge.createBridge("adb.exe", true);
        if (debugBridge == null) {
            System.exit(1);
        }

        AndroidDebugBridge.addDeviceChangeListener(new AndroidDebugBridge.IDeviceChangeListener() {

            public void deviceChanged(IDevice device, int arg1) {
                
                //Not Necessary For Now
            }

            public void deviceConnected(IDevice device) {
             
        
               try {
                     ShowDevices.setText("");
                     String ss = null;
                     
                    Process p = Runtime.getRuntime().exec("src/scrcpy/cmd.exe /c adb devices");
                     BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
       
                 while ((ss = r.readLine()) != null) {
                      PrintStream P = new PrintStream(new Devices(ShowDevices));
                      System.setOut(P);
                      System.out.println(ss);
                      ShowDevices.setEditable(false);
                      ShowDevices.setLineWrap(true);

                     }
                 while ((ss = r.readLine()) != null) {
                      System.out.println(ss);
                      
                    }
                } 
                 catch(Exception e) {
                      e.printStackTrace();
  		}
                
            }

            public void deviceDisconnected(IDevice device) {
                
                String a = ""; //Created To Avoid Empty Character Literal Error
                ShowDevices.setText(a);
                
                String s = String.format("%s Disconnected", device.getSerialNumber());
                ShowDevices.setText(s);
                
                 try {
                     
                     String ss = null;
                    
                     Process p = Runtime.getRuntime().exec("cmd.exe /c adb devices");
                     BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
       
                 while ((ss = r.readLine()) != null) {
                      PrintStream P = new PrintStream(new Devices(ShowDevices));
                      System.setOut(P);
                      System.out.println("\n "+ss);
                      ShowDevices.setEditable(false);
                      ShowDevices.setLineWrap(true);

                     }
 
                } 
                 catch(Exception e) {
                      e.printStackTrace();
  		}

            }

        });
        
        /* The Commented Code Below Was The Old Method Of Checking Connected Devices, It Was Resource Heavy
            Since It Kept Repeating The Same Code To Keep Up To Date
        */
        

/*
 *        ActionListener task = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                 try {
                     print.setText("");
                     
                     String ss = null;
                    
                     Process p = Runtime.getRuntime().exec("cmd.exe /c adb devices -l");
                     BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
       
                 while ((ss = r.readLine()) != null) {
                      PrintStream printStream = new PrintStream(new Devices(print));
                      System.setOut(printStream);
                      System.setErr(printStream);
                      System.out.println(ss);
                      print.setEditable(false);
                      print.setLineWrap(true);

                     }
                 while ((ss = r.readLine()) != null) {
                      System.out.println(ss);
                      
                    }
                } 
                 catch(Exception e) {
                      e.printStackTrace();
  		}}};
                      Timer timer = new Timer(1000 ,task);//Timer Updates Once Every 650
                      timer.setRepeats(true);
                      timer.start();
        *
        */
        
        try {
            File Scrcpy = new File("/snap/scrcpy/current/usr/local/bin/scrcpy");
            File Terminal = new File("/usr/bin/xterm");
        	 
        if (Terminal.exists()){
             Platform.setText("Linux Detected");
        		 
       } else {
	   Platform.setText("Windows Detected"); 

       }
   } 	catch(Exception e) {
	      e.printStackTrace();
}
         
   
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        Side = new javax.swing.JPanel();
        Top = new javax.swing.JPanel();
        Platform = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        Description = new javax.swing.JLabel();
        Devices = new javax.swing.JScrollPane();
        ShowDevices = new javax.swing.JTextArea();
        Everything = new javax.swing.JPanel();
        AdvancedPanel = new javax.swing.JPanel();
        AdvancedLabel = new javax.swing.JLabel();
        AdvancedDescription = new javax.swing.JLabel();
        AdvancedEditable = new javax.swing.JTextField();
        Leave = new javax.swing.JLabel();
        Audio = new javax.swing.JLabel();
        audio = new javax.swing.JComboBox<>();
        ConnectionType = new javax.swing.JLabel();
        Wired = new javax.swing.JRadioButton();
        Wireless = new javax.swing.JRadioButton();
        ScrcpySettings = new javax.swing.JPanel();
        ScreenOffLabel = new javax.swing.JLabel();
        SettingsLabel = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        TurnOffScreen = new javax.swing.JCheckBox();
        StayAwake = new javax.swing.JCheckBox();
        StayAwakeLabel = new javax.swing.JLabel();
        OffOnClose = new javax.swing.JCheckBox();
        OffOnCloseLabel = new javax.swing.JLabel();
        FullScreen = new javax.swing.JCheckBox();
        FullScreenLabel = new javax.swing.JLabel();
        ShortcutMod = new javax.swing.JCheckBox();
        ShortcutLabel = new javax.swing.JLabel();
        MaxBitrateLabel = new javax.swing.JLabel();
        BitrateEditable = new javax.swing.JTextField();
        BitrateEmptyLabel = new javax.swing.JLabel();
        MaxScreenLabel = new javax.swing.JLabel();
        MaxScreenEditable = new javax.swing.JTextField();
        MaxScreenEmptyLabel = new javax.swing.JLabel();
        ShowTouches = new javax.swing.JCheckBox();
        ShowTouchesLabel = new javax.swing.JLabel();
        OutputLabel = new javax.swing.JLabel();
        OutputPanel = new javax.swing.JPanel();
        Output = new javax.swing.JScrollPane();
        DisplayOutput = new javax.swing.JTextArea();
        RunButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        arrow = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        iplabel = new javax.swing.JLabel();
        ip = new javax.swing.JTextField();
        port = new javax.swing.JTextField();
        portlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Main.setBackground(new java.awt.Color(0, 0, 0));

        Side.setBackground(new java.awt.Color(51, 51, 51));
        Side.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        javax.swing.GroupLayout SideLayout = new javax.swing.GroupLayout(Side);
        Side.setLayout(SideLayout);
        SideLayout.setHorizontalGroup(
            SideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        SideLayout.setVerticalGroup(
            SideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Top.setBackground(new java.awt.Color(51, 51, 51));
        Top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        Platform.setBackground(new java.awt.Color(204, 204, 204));
        Platform.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        Platform.setForeground(new java.awt.Color(255, 255, 255));

        Name.setBackground(new java.awt.Color(0, 0, 0));
        Name.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));
        Name.setText("Scrcpy-GUI v1.3.1");

        Description.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        Description.setForeground(new java.awt.Color(255, 255, 255));
        Description.setText("*Based On Scrcpy v1.24 By Genymobile*");

        ShowDevices.setEditable(false);
        ShowDevices.setBackground(new java.awt.Color(102, 102, 102));
        ShowDevices.setColumns(20);
        ShowDevices.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        ShowDevices.setForeground(new java.awt.Color(255, 255, 255));
        ShowDevices.setRows(5);
        ShowDevices.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        ShowDevices.setSelectionColor(new java.awt.Color(102, 102, 102));
        Devices.setViewportView(ShowDevices);

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopLayout.createSequentialGroup()
                        .addComponent(Platform, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(TopLayout.createSequentialGroup()
                        .addComponent(Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Description, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Devices, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Devices, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addGroup(TopLayout.createSequentialGroup()
                        .addComponent(Platform, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Description)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Everything.setBackground(new java.awt.Color(51, 51, 51));
        Everything.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        AdvancedPanel.setBackground(new java.awt.Color(51, 51, 51));
        AdvancedPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        AdvancedLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        AdvancedLabel.setForeground(new java.awt.Color(255, 255, 255));
        AdvancedLabel.setText("Advanced Panel");

        AdvancedDescription.setForeground(new java.awt.Color(255, 255, 255));
        AdvancedDescription.setText("*Add Custom Scripts Ontop Of The Optional Ones Provided*");

        AdvancedEditable.setBackground(new java.awt.Color(102, 102, 102));
        AdvancedEditable.setForeground(new java.awt.Color(255, 255, 255));

        Leave.setForeground(new java.awt.Color(255, 153, 153));
        Leave.setText("*Leave Empty If No Change*");

        Audio.setForeground(new java.awt.Color(255, 255, 255));
        Audio.setText("*Captures Audio Via Bluetooth (A2DP SINK) Or Sndcpy*");

        audio.setBackground(new java.awt.Color(102, 102, 102));
        audio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        audio.setForeground(new java.awt.Color(102, 102, 102));
        audio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Audio Capture (Default = Off)", "Bluetooth Audio Capture ( Windows 10 2004+)", "Sndcpy Method (Android 10+ Required)" }));
        audio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                audioMousePressed(evt);
            }
        });
        audio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                audioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdvancedPanelLayout = new javax.swing.GroupLayout(AdvancedPanel);
        AdvancedPanel.setLayout(AdvancedPanelLayout);
        AdvancedPanelLayout.setHorizontalGroup(
            AdvancedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdvancedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdvancedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdvancedPanelLayout.createSequentialGroup()
                        .addGroup(AdvancedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AdvancedLabel)
                            .addComponent(AdvancedDescription)
                            .addComponent(Leave)
                            .addComponent(Audio))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(audio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdvancedEditable))
                .addContainerGap())
        );
        AdvancedPanelLayout.setVerticalGroup(
            AdvancedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdvancedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AdvancedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AdvancedDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AdvancedEditable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Leave, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Audio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(audio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ConnectionType.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        ConnectionType.setForeground(new java.awt.Color(255, 255, 255));
        ConnectionType.setText("Connection Type");

        Wired.setForeground(new java.awt.Color(255, 255, 255));
        Wired.setText("Wired (Default)");
        Wired.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WiredActionPerformed(evt);
            }
        });

        Wireless.setForeground(new java.awt.Color(255, 255, 255));
        Wireless.setText("Wireless (Wi-Fi)");
        Wireless.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WirelessActionPerformed(evt);
            }
        });

        ScrcpySettings.setBackground(new java.awt.Color(51, 51, 51));
        ScrcpySettings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        ScreenOffLabel.setForeground(new java.awt.Color(255, 153, 153));
        ScreenOffLabel.setText("*Turns Off Screen On Physical Device*");

        SettingsLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        SettingsLabel.setForeground(new java.awt.Color(255, 255, 255));
        SettingsLabel.setText("Scrcpy Settings");

        DescriptionLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        DescriptionLabel.setForeground(new java.awt.Color(255, 255, 255));
        DescriptionLabel.setText("*Only Select Options You Need*");

        TurnOffScreen.setForeground(new java.awt.Color(255, 255, 255));
        TurnOffScreen.setText("Turn Off Screen");

        StayAwake.setForeground(new java.awt.Color(255, 255, 255));
        StayAwake.setText("Stay Awake");

        StayAwakeLabel.setForeground(new java.awt.Color(255, 153, 153));
        StayAwakeLabel.setText("*Prevents Device From Sleeping*");

        OffOnClose.setForeground(new java.awt.Color(255, 255, 255));
        OffOnClose.setText("Turn Off Screen On Close");

        OffOnCloseLabel.setForeground(new java.awt.Color(255, 153, 153));
        OffOnCloseLabel.setText("*Turns Phone Screen Off When Scrcpy Closes*");

        FullScreen.setForeground(new java.awt.Color(255, 255, 255));
        FullScreen.setText("Full Screen Mode");

        FullScreenLabel.setForeground(new java.awt.Color(255, 153, 153));
        FullScreenLabel.setText("*Start Scrcpy In Full Screen Mode*");

        ShortcutMod.setForeground(new java.awt.Color(255, 255, 255));
        ShortcutMod.setText("Shortcut Mod");

        ShortcutLabel.setForeground(new java.awt.Color(255, 153, 153));
        ShortcutLabel.setText("*Adds Changes Shortcut Key (Default = Left Alt)*");

        MaxBitrateLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MaxBitrateLabel.setForeground(new java.awt.Color(255, 255, 255));
        MaxBitrateLabel.setText("Max Bitrate (MB)");

        BitrateEditable.setBackground(new java.awt.Color(102, 102, 102));
        BitrateEditable.setForeground(new java.awt.Color(255, 255, 255));

        BitrateEmptyLabel.setForeground(new java.awt.Color(255, 153, 153));
        BitrateEmptyLabel.setText("*Leave Empty If No Change*");

        MaxScreenLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MaxScreenLabel.setForeground(new java.awt.Color(255, 255, 255));
        MaxScreenLabel.setText("Max Screen Size");

        MaxScreenEditable.setBackground(new java.awt.Color(102, 102, 102));
        MaxScreenEditable.setForeground(new java.awt.Color(255, 255, 255));
        MaxScreenEditable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxScreenEditableActionPerformed(evt);
            }
        });

        MaxScreenEmptyLabel.setForeground(new java.awt.Color(255, 153, 153));
        MaxScreenEmptyLabel.setText("*Leave Empty If No Change*");

        ShowTouches.setForeground(new java.awt.Color(255, 255, 255));
        ShowTouches.setText("Show Touches");

        ShowTouchesLabel.setForeground(new java.awt.Color(255, 153, 153));
        ShowTouchesLabel.setText("*Show Physical Touches & Clicks On Screen*");

        javax.swing.GroupLayout ScrcpySettingsLayout = new javax.swing.GroupLayout(ScrcpySettings);
        ScrcpySettings.setLayout(ScrcpySettingsLayout);
        ScrcpySettingsLayout.setHorizontalGroup(
            ScrcpySettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScrcpySettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ScrcpySettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SettingsLabel)
                    .addComponent(DescriptionLabel)
                    .addComponent(TurnOffScreen)
                    .addComponent(StayAwake)
                    .addComponent(OffOnClose)
                    .addComponent(ShortcutMod)
                    .addComponent(FullScreen)
                    .addComponent(ShowTouches)
                    .addGroup(ScrcpySettingsLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(ScrcpySettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScreenOffLabel)
                            .addComponent(OffOnCloseLabel)
                            .addComponent(StayAwakeLabel)
                            .addComponent(ShortcutLabel)
                            .addGroup(ScrcpySettingsLayout.createSequentialGroup()
                                .addGroup(ScrcpySettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(BitrateEditable, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MaxBitrateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BitrateEmptyLabel))
                            .addGroup(ScrcpySettingsLayout.createSequentialGroup()
                                .addGroup(ScrcpySettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(MaxScreenEditable, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MaxScreenLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MaxScreenEmptyLabel))
                            .addComponent(FullScreenLabel)
                            .addComponent(ShowTouchesLabel))))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        ScrcpySettingsLayout.setVerticalGroup(
            ScrcpySettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScrcpySettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SettingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TurnOffScreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScreenOffLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StayAwake)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StayAwakeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OffOnClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OffOnCloseLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShowTouches)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShowTouchesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShortcutMod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShortcutLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FullScreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FullScreenLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MaxBitrateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ScrcpySettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BitrateEditable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BitrateEmptyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MaxScreenLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ScrcpySettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MaxScreenEditable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaxScreenEmptyLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        OutputLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        OutputLabel.setForeground(new java.awt.Color(255, 255, 255));
        OutputLabel.setText("Display Output");

        OutputPanel.setBackground(new java.awt.Color(51, 51, 51));
        OutputPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        DisplayOutput.setBackground(new java.awt.Color(102, 102, 102));
        DisplayOutput.setColumns(20);
        DisplayOutput.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        DisplayOutput.setForeground(new java.awt.Color(255, 255, 255));
        DisplayOutput.setRows(5);
        Output.setViewportView(DisplayOutput);

        javax.swing.GroupLayout OutputPanelLayout = new javax.swing.GroupLayout(OutputPanel);
        OutputPanel.setLayout(OutputPanelLayout);
        OutputPanelLayout.setHorizontalGroup(
            OutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Output)
        );
        OutputPanelLayout.setVerticalGroup(
            OutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Output)
        );

        RunButton.setBackground(new java.awt.Color(102, 102, 102));
        RunButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        RunButton.setForeground(new java.awt.Color(0, 51, 255));
        RunButton.setText("Run Scrcpy");
        RunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunButtonActionPerformed(evt);
            }
        });

        ExitButton.setBackground(new java.awt.Color(102, 102, 102));
        ExitButton.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        ExitButton.setForeground(new java.awt.Color(255, 0, 0));
        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        arrow.setForeground(new java.awt.Color(255, 255, 255));
        arrow.setText("--------------->");

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("jLabel1");

        jTextField1.setBackground(new java.awt.Color(51, 51, 51));
        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        iplabel.setForeground(new java.awt.Color(255, 255, 255));
        iplabel.setText("Device IP Address");

        ip.setBackground(new java.awt.Color(102, 102, 102));
        ip.setForeground(new java.awt.Color(255, 255, 255));
        ip.setText("e.g. 192.168.x.x");
        ip.setToolTipText("");
        ip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ipMousePressed(evt);
            }
        });
        ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipActionPerformed(evt);
            }
        });

        port.setBackground(new java.awt.Color(102, 102, 102));
        port.setForeground(new java.awt.Color(255, 255, 255));

        portlabel.setForeground(new java.awt.Color(255, 255, 255));
        portlabel.setText("Port (Default: 5555) ");

        javax.swing.GroupLayout EverythingLayout = new javax.swing.GroupLayout(Everything);
        Everything.setLayout(EverythingLayout);
        EverythingLayout.setHorizontalGroup(
            EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EverythingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EverythingLayout.createSequentialGroup()
                        .addComponent(Wired)
                        .addGap(82, 82, 82)
                        .addComponent(Wireless)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arrow))
                    .addComponent(ConnectionType)
                    .addComponent(ScrcpySettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(EverythingLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                        .addComponent(RunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EverythingLayout.createSequentialGroup()
                        .addGroup(EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iplabel))
                        .addGap(18, 18, 18)
                        .addGroup(EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(portlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(OutputLabel)
                    .addComponent(OutputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdvancedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        EverythingLayout.setVerticalGroup(
            EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EverythingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EverythingLayout.createSequentialGroup()
                        .addGroup(EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConnectionType, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Wired)
                            .addComponent(Wireless)
                            .addComponent(arrow)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EverythingLayout.createSequentialGroup()
                        .addGroup(EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iplabel)
                            .addComponent(portlabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(EverythingLayout.createSequentialGroup()
                        .addComponent(AdvancedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OutputLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OutputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ScrcpySettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(EverythingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Side, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Everything, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Side, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(Top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Everything, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipActionPerformed

    private void ipMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ipMousePressed
        ip.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_ipMousePressed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        try {File we = new File("scripts.txt");

            PrintWriter writer = new PrintWriter(we);
            writer.print("");//To Clear The File Used To Store Scripts...
            writer.close();}

        catch (FileNotFoundException e) {

        }
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void RunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunButtonActionPerformed

        boolean Off = TurnOffScreen.isSelected();
        boolean On = StayAwake.isSelected();
        boolean Offcl = OffOnClose.isSelected();
        boolean Show = ShowTouches.isSelected();
        boolean Fs = FullScreen.isSelected();
        boolean Short = ShortcutMod.isSelected();

        String Bit = BitrateEditable.getText();
        String Max = MaxScreenEditable.getText();
        String Adv = AdvancedEditable.getText();
        String IP  = ip.getText();
        String Port= port.getText();

        if (IP!= "") {
            try {
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                Script.write(" --tcpip="+IP);
                Script.close();
            } catch (Exception x) {}

        } else if (Port!= "") {
            try {
                String FILE ="scripts.txt";
                FileWriter Script = new FileWriter(FILE, true);
                Script.write(" --tcpip="+IP+":"+Port);
                Script.close();
            } catch (Exception x) {}

        }

        if (Off) {
            try{
                String FILE ="scripts.txt";
                FileWriter test = new FileWriter(FILE, true);
                test.write(" -S");
                test.close();
            }catch (Exception x) {

            }
        } if (On) {

            try{
                String FILE ="scripts.txt";
                FileWriter test = new FileWriter(FILE, true);
                test.write(" -w");
                test.close();
            }catch (Exception x) {

            }
        }    if (Offcl) {

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

                        PrintStream printStream = new PrintStream(new Output(DisplayOutput));
                        System.setOut(printStream);
                        System.out.println(sr);//Shows Progress And Potential Errors On a Field
                        DisplayOutput.setLineWrap(true);

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
    }//GEN-LAST:event_RunButtonActionPerformed

    private void MaxScreenEditableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxScreenEditableActionPerformed

    }//GEN-LAST:event_MaxScreenEditableActionPerformed

    private void WirelessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WirelessActionPerformed
        if (Wireless.isSelected()){
            Wired.setSelected(false);
        }

        if (Wireless.isSelected()){
            int BT1 = JOptionPane.showConfirmDialog (null, "Please Ensure That Both Computer & Device Are Connected To The Same Wi-Fi","Confirmation",JOptionPane.YES_NO_OPTION);

            if(BT1 == JOptionPane.YES_OPTION){

                arrow.setVisible(true);
                ip.setVisible(true);
                iplabel.setVisible(true);
                port.setVisible(true);
                portlabel.setVisible(true);

            }
        }                        String a = ip.getText();
        if (a.equals("e.g. 192.168.x.x")){

            try{
                String FILE ="scripts.txt";
                FileWriter test = new FileWriter(FILE, true);
                test.write(" --shortcut-mod=lalt");
                test.close();
            }catch (Exception x) {

            }
        }
    }//GEN-LAST:event_WirelessActionPerformed

    private void WiredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WiredActionPerformed
        if (Wired.isSelected()) {
            Wireless.setSelected(false);
        }
        arrow.setVisible(false);
        ip.setVisible(false);
        iplabel.setVisible(false);
        port.setVisible(false);
        portlabel.setVisible(false);
    }//GEN-LAST:event_WiredActionPerformed

    private void audioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_audioActionPerformed
        String Box = audio.getSelectedItem().toString();

        if (Box.equals("Bluetooth Audio Capture ( Windows 10 2004+)")){
            int BT1 = JOptionPane.showConfirmDialog (null, "Does Your PC/Laptop Have Bluetooth?","Bluetooth Audio Confirmation",JOptionPane.YES_NO_OPTION);

            if(BT1 == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Please Ensure That Your Device Has Already Been Paired To The Computer","Further Confirmation",JOptionPane.DEFAULT_OPTION);

                BT BT = new BT();
                BT.show();
            }
        }
        if (Box.equals("Sndcpy Method (Android 10+ Required)")){

            int BT1 = JOptionPane.showConfirmDialog (null, "VLC Is Required To Use This Method!","Sndcpy Audio Confirmation",JOptionPane.YES_NO_OPTION);

            if(BT1 == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Process Started","Further Confirmation",JOptionPane.DEFAULT_OPTION);
                Sndcpy.Sndcpy();

            }

        }
    }//GEN-LAST:event_audioActionPerformed

    private void audioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_audioMousePressed

    }//GEN-LAST:event_audioMousePressed



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdvancedDescription;
    private javax.swing.JTextField AdvancedEditable;
    private javax.swing.JLabel AdvancedLabel;
    private javax.swing.JPanel AdvancedPanel;
    private javax.swing.JLabel Audio;
    private javax.swing.JTextField BitrateEditable;
    private javax.swing.JLabel BitrateEmptyLabel;
    private javax.swing.JLabel ConnectionType;
    private javax.swing.JLabel Description;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JScrollPane Devices;
    private javax.swing.JTextArea DisplayOutput;
    private javax.swing.JPanel Everything;
    private javax.swing.JButton ExitButton;
    private javax.swing.JCheckBox FullScreen;
    private javax.swing.JLabel FullScreenLabel;
    private javax.swing.JLabel Leave;
    private javax.swing.JPanel Main;
    private javax.swing.JLabel MaxBitrateLabel;
    private javax.swing.JTextField MaxScreenEditable;
    private javax.swing.JLabel MaxScreenEmptyLabel;
    private javax.swing.JLabel MaxScreenLabel;
    private javax.swing.JLabel Name;
    private javax.swing.JCheckBox OffOnClose;
    private javax.swing.JLabel OffOnCloseLabel;
    private javax.swing.JScrollPane Output;
    private javax.swing.JLabel OutputLabel;
    private javax.swing.JPanel OutputPanel;
    private javax.swing.JLabel Platform;
    private javax.swing.JButton RunButton;
    private javax.swing.JPanel ScrcpySettings;
    private javax.swing.JLabel ScreenOffLabel;
    private javax.swing.JLabel SettingsLabel;
    private javax.swing.JLabel ShortcutLabel;
    private javax.swing.JCheckBox ShortcutMod;
    private javax.swing.JTextArea ShowDevices;
    private javax.swing.JCheckBox ShowTouches;
    private javax.swing.JLabel ShowTouchesLabel;
    private javax.swing.JPanel Side;
    private javax.swing.JCheckBox StayAwake;
    private javax.swing.JLabel StayAwakeLabel;
    private javax.swing.JPanel Top;
    private javax.swing.JCheckBox TurnOffScreen;
    private javax.swing.JRadioButton Wired;
    private javax.swing.JRadioButton Wireless;
    private javax.swing.JLabel arrow;
    private javax.swing.JComboBox<String> audio;
    private javax.swing.JTextField ip;
    private javax.swing.JLabel iplabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField port;
    private javax.swing.JLabel portlabel;
    // End of variables declaration//GEN-END:variables
}
