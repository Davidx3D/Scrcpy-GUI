package com.sobermind.works;

public class OS {
public String getOS() {
    String os = System.getProperty("os.name");
    // System.out.println(os);
    return os;
    }
}