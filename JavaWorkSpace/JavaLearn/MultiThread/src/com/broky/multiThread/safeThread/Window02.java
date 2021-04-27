package com.broky.multiThread.safeThread;

/**
 * @author 13roky
 * @date 2021-04-21 22:39
 */
public class Window02 {
    public static void main(String[] args) {
        Window02Thread ticketsThread02 = new Window02Thread();
        Thread t1 = new Thread(ticketsThread02);
        Thread t2 = new Thread(ticketsThread02);
        Thread t3 = new Thread(ticketsThread02);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window02Thread implements Runnable {
    private int tiketsNum = 100;

    @Override
    public void run() {
        while (tiketsNum > 0) {
            show();
        }
    }

    private synchronized void show() { //同步监视器：this
        if (tiketsNum > 0) {
            try {
                //手动让线程进入阻塞,增大安全性发生的概率
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":\t票号:" + tiketsNum + "\t剩余票数:" + --tiketsNum);
        }
    }
}