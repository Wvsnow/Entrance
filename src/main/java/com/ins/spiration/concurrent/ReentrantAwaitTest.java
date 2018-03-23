package com.ins.spiration.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: rain
 * @since: 2018/2/23 11:16
 * @Des: ...
 */
public class ReentrantAwaitTest {
    private ReentrantLock myLock = new ReentrantLock();

    private Condition condition = myLock.newCondition();

    private Condition condition2 = myLock.newCondition();


    private List<Integer> listBuffer = new ArrayList<Integer>();

    private List<Integer> bufferNoEdge = new ArrayList<Integer>();

    private volatile boolean runFlag = true;

    /**
     * 生产者 生产数据
     */
    public void produce() {
        Random random = new Random(System.currentTimeMillis());
        int incrCount = 0;
        while (runFlag) {
            myLock.lock();
            try {
                // 生产者检查容器中是否有数据，如果容器中有数据则生产者等待
                // 如果容器中没有数据则生产数据放入容器中并通知消费者
                if (listBuffer.size() > 0) {
                    try {
                        // 调用await()方法，生产者线程阻塞并释放锁，之后进入该条件的等待集中
                        // 直到消费者调用signalAll()方法之后，生产者线程解除阻塞并重新竞争锁
                        // 生产者线程获得锁之后，重新开始从被阻塞的地方继续执行程序
                        condition2.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    int topCount = random.nextInt(100) + 1;
                    for (int count = 0; count < topCount; count++) {
                        listBuffer.add(++incrCount);
                    }
                    System.out.println("Thread-" + Thread.currentThread().getName() + " : add Integer from " + (incrCount + 1 - topCount) + " TO " + incrCount);
                    // 生产者线程调用signalAll()方法，通知消费者线程容器中有数据
                    condition.signalAll();
                }
            } finally {
                myLock.unlock();
            }
        }
    }

    /**
     * 消费者 读取数据
     */
    public void consume() {
        while (runFlag) {
            myLock.lock();
            try {
                // 消费者检查容器中是否有数据，如果没有数据消费者等待
                // 如果容器中有数据则读取数据，读完之后通知生产者
                if (listBuffer.size() == 0) {
                    try {
                        // 同生产者线程一样，消费者线程调用await()方法阻塞并进入该条件等待集中
                        condition.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    StringBuffer buffer = new StringBuffer(10);
                    buffer.append("Thread-" + Thread.currentThread().getName() + " : remove ");
                    while (!listBuffer.isEmpty()) {
                        buffer.append(listBuffer.remove(0) + ", ");
                    }
                    System.out.println(buffer.toString());
                    // 消费者线程调用signalAll()方法，通知生产者生产数据
                    condition2.signalAll();
                }
            } finally {
                myLock.unlock();
            }
        }
    }


    public boolean isRunFlag() {
        return runFlag;
    }

    public void setRunFlag(boolean runFlag) {
        this.runFlag = runFlag;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final ReentrantAwaitTest test = new ReentrantAwaitTest();

        Thread produce = new Thread(new Runnable() {
            public void run() {
                test.produce();
            }
        }, "Pro");

        Thread consume = new Thread(new Runnable() {
            public void run() {
                test.consume();
            }
        }, "Con");

        produce.start();
        consume.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        test.setRunFlag(false);
    }
}