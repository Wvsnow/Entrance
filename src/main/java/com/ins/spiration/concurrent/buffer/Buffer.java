package com.ins.spiration.concurrent.buffer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wentaoli214022
 * @since: 2018/3/5 14:18
 * @Des: ...
 */
public class Buffer {

    private final Lock lock;
    private final Condition notFull;
    private final Condition notEmpty;
    private int maxSize;
    private List<String> storage;

    private long flag = 0;

    Buffer(int size) {
        //使用锁lock，并且创建两个condition，相当于两个阻塞队列
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        maxSize = size;
        storage = new LinkedList<String>();
    }

    public void put() {
        lock.lock();
        try {
            while (storage.size() == maxSize) {//如果队列满了
                System.out.print(Thread.currentThread().getName() + ": wait \n");
                notFull.await();//阻塞生产线程
            }
            String addOne = Thread.currentThread().getName() + " ADD " + (flag++);
            storage.add(addOne);
            System.out.println(addOne);
            notEmpty.signalAll();//唤醒消费线程
        } catch (InterruptedException e) {
            System.out.println(" ++++++++++++++++++++++ Put has been interrupted - " + Thread.currentThread().getName());
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            while (storage.size() == 0) {//如果队列满了
                System.out.print(Thread.currentThread().getName() + ": wait \n");
                notEmpty.await();//阻塞消费线程
            }
            String consumeOne = storage.remove(0);
            System.out.print(Thread.currentThread().getName() + " REMOVE " + consumeOne + "\n");
            notFull.signalAll();//唤醒生产线程
        } catch (InterruptedException e) {
            System.out.println(" ---------------------- Take has been interrupted - " + Thread.currentThread().getName());
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] arg) {
        Buffer buffer = new Buffer(10000);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        List<Thread> threadList = new LinkedList<Thread>();
        for (int i = 0; i < 3; i++) {
            threadList.add(new Thread(producer, "Pro-" + i));
        }
        for (int i = 0; i < 3; i++) {
            threadList.add(new Thread(consumer, "Con-" + i));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Producer.setWholeSwitch(false);
            Consumer.setWholeSwitch(false);
        }

        for (Thread thread : threadList) {
            if (null != thread) {
                System.out.println(" Status of Thread " + thread.getName() + " is " + thread.getState());
                if (thread.isAlive()) {
                    System.out.println("Interrupt Thread " + thread.getName());
                    thread.interrupt();
                }
            }
        }

        System.out.println("Progress end");

    }
}
