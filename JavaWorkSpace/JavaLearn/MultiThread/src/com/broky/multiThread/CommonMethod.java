package com.broky.multiThread;

/**
 * @author 13roky
 * @date 2021-04-20 7:12
 */
public class CommonMethod {
    public static void main(String[] args) {
        Thread01 t1 = new Thread01("构造函数改的线程一");

        /*t1.setName("线程一");*/
        t1.start();

        Thread.currentThread().setName("main线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ":\t" + i);

            if (i == 20) {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class Thread01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ":\t" + i);
        }
    }

    public Thread01(String name) {
        super(name);
    }
}
