package com.broky.multiThread;

/**多窗口卖票,实现Runnable接口方式
 * 不存在安全问题
 * @author 13roky
 * @date 2021-04-20 23:41
 */
public class TicketsSalesDemo02 {
    public static void main(String[] args) {
        TicketsThread02 ticketsThread02 = new TicketsThread02();
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

class TicketsThread02 implements Runnable {
    private int tiketsNum = 100;

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
