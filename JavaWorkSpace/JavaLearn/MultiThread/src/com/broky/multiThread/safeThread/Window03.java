package com.broky.multiThread.safeThread;

/**
 * @author 13roky
 * @date 2021-04-21 22:59
 */
public class Window03 {
    public static void main(String[] args) {
        Window03Thread t1 = new Window03Thread();
        Window03Thread t2 = new Window03Thread();
        Window03Thread t3 = new Window03Thread();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window03Thread extends Thread {
    public static int tiketsNum = 100;

    @Override
    public void run() {
        while (tiketsNum > 0) {
            show();
        }
    }

    public static synchronized void show() {//同步监视器：Winddoe03Thread.class  不加static话同步监视器为t1 t2 t3所以错误
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
