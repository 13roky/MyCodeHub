package com.broky.multiThread.safeThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 13roky
 * @date 2021-04-22 9:36
 */
public class SafeLock {
    public static void main(String[] args) {
        SafeLockThread safeLockThread = new SafeLockThread();
        Thread t1 = new Thread(safeLockThread);
        Thread t2 = new Thread(safeLockThread);
        Thread t3 = new Thread(safeLockThread);

        t1.start();
        t2.start();
        t3.start();
    }
}

class SafeLockThread implements Runnable{
    private int tickets = 100;
    //实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (tickets>0) {
            try {
                //在这里锁住，有点类似同步监视器
                lock.lock();
                if (tickets > 0) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + ":\t票号:" + tickets + "\t剩余票数:" + --tickets);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //操作完成共享数据后在这里解锁
                lock.unlock();
            }
        }
    }
}
