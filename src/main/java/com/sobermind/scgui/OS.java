package com.sobermind.scgui;

//Platform class to find OS Based on the one in Dart
public class OS{
    private static String OS = System.getProperty("os.name", "generic").toLowerCase();
    public static boolean isLinux = OS.indexOf("nux") >= 0;
    public static boolean isMacOS = OS.indexOf("mac") >= 0 || OS.indexOf("darwin") >= 0;
    public static boolean isWindows = OS.indexOf("win") >= 0;
    public static boolean isAndroid = OS.indexOf("roid") >= 0;
    public static boolean isIOS = OS.indexOf("ios") >= 0;
    public static boolean isFuchsia = OS.indexOf("fuc") >= 0;
}