package com.broky.multiThread;

/**
 * @author 13roky
 * @date 2021-04-20 20:49
 */
public class ThreadPriorityDemo {
    public static void main(String[] args) {
        PriorityDemoThread01 t1 = new PriorityDemoThread01();
        //设置优先级为最小
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        //设置主线程优先级为最大
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ":\t" + i+"\tPriority:\t"+Thread.currentThread().getPriority());
        }

        System.out.println(Thread.currentThread().isAlive());
    }
}

class PriorityDemoThread01 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //当i=20时,将优先级改为6
            if (i == 20) Thread.currentThread().setPriority(6);
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ":\t" + i+"\tPriority:\t"+Thread.currentThread().getPriority());
        }
    }
}
