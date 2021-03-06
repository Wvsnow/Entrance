package com.ins.spiration.concurrent.buffer;

/**
 * @author: wentaoli214022
 * @since: 2018/3/5 14:22
 * @Des: ...
 */
public class Producer implements Runnable {

    private static volatile boolean wholeSwitch = true;

    private volatile boolean runSwitch = true;

    private Buffer buffer;

    Producer(Buffer b) {
        buffer = b;
    }

    public static boolean isWholeSwitch() {
        return wholeSwitch;
    }

    public static void setWholeSwitch(boolean wholeSwitch) {
        Producer.wholeSwitch = wholeSwitch;
    }

    public boolean isRunSwitch() {
        return runSwitch;
    }

    public void setRunSwitch(boolean runSwitch) {
        this.runSwitch = runSwitch;
    }

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName() + " Starting. " + "\n");
        while (wholeSwitch && runSwitch) {
            buffer.put();
        }
        System.out.print(Thread.currentThread().getName() + " Terminated. " + "\n");
    }

}
