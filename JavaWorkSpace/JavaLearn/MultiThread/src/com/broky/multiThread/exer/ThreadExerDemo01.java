package com.broky.multiThread.exer;

/**
 * @author 13roky
 * @date 2021-04-19 22:43
 */
public class ThreadExerDemo01 {
    public static void main(String[] args) {
        new Thread01().start();
        new Thread02().start();
    }
}

class Thread01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ":\t" + i);
        }
    }
}

class Thread02 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) System.out.println(Thread.currentThread().getName() + ":\t" + i);
        }
    }
}
