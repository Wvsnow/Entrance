package com.ins.spiration.concurrent.buffer;

/**
 * @author: wentaoli214022
 * @since: 2018/3/5 14:21
 * @Des: ...
 */
public class Consumer implements Runnable {

    private static volatile boolean wholeSwitch = true;

    private volatile boolean runSwitch = true;

    private Buffer buffer;

    Consumer(Buffer b) {
        buffer = b;
    }

    public static boolean isWholeSwitch() {
        return wholeSwitch;
    }

    public static void setWholeSwitch(boolean wholeSwitch) {
        Consumer.wholeSwitch = wholeSwitch;
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
            buffer.take();
        }
        System.out.print(Thread.currentThread().getName() + " Terminated. " + "\n");
    }
}
