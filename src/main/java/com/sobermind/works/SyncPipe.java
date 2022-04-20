package com.sobermind.works;

import java.io.InputStream;
import java.io.OutputStream;

public class SyncPipe implements Runnable{
    public SyncPipe(InputStream istrm, OutputStream ostrm){
        istrm_ = istrm;
        ostrm_ = ostrm;
    }
    public void run(){
        try {
            final byte[] buffer = new byte[1024];
            for(int length = 0; (length = istrm_.read(buffer)) != -1;){
                ostrm_.write(buffer, 0, length);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private final InputStream istrm_;
    private final OutputStream ostrm_;

}
