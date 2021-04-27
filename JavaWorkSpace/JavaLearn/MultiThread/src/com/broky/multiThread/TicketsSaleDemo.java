package com.broky.multiThread;

/**
 * 多窗口抢票
 *
 * @author 13roky
 * @date 2021-04-20 21:23
 */
public class TicketsSaleDemo {
    public static void main(String[] args) {
        TicketsThread t1 = new TicketsThread("窗口1");
        t1.start();

        TicketsThread t2 = new TicketsThread("窗口2");
        t2.start();

        TicketsThread t3 = new TicketsThread("窗口3");
        t3.start();
        /*输出结果呈先输出了100再输入的99
        Thread-1:	票号:99	剩余票数:98
        Thread-0:	票号:100	剩余票数:99
        这种原因是因为,输出需要显示到页面上, Thread-0先抢占了线程,但是在页面上没有及时的显示出来
        */
    }
}

class TicketsThread extends Thread {
    private static int tiketsNum = 100;

    public TicketsThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            if (tiketsNum > 0) {
                System.out.println(Thread.currentThread().getName() + ":\t票号:" + tiketsNum + "\t剩余票数:" + --tiketsNum);
            } else {
                break;
            }
        }
    }
}
