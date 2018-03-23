package com.ins.spiration.rural.test;


import java.text.SimpleDateFormat;
import java.util.Date;


public class Entrance extends Thread {

    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
    }

}
