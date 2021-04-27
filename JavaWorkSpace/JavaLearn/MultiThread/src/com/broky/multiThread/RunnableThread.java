package com.broky.multiThread;

/**
 * @author 13roky
 * @date 2021-04-20 23:16
 */
public class RunnableThread {
    public static void main(String[] args) {
        //创建实现类的对象
        RunnableThread01 runnableThread01 = new RunnableThread01();
        //创建Thread类的对象,并将实现类的对象当做参数传入构造器
        Thread t1 = new Thread(runnableThread01);
        //使用Thread类的对象去调用Thread类的start()方法:①启动了线程 ②Thread中的run()调用了Runnable中的run()
        t1.start();

        //在创建一个线程时，只需要new一个Thread类就可,不需要new实现类
        Thread t2 = new Thread(runnableThread01);
        t2.start();
    }
}

//RunnableThread01实现Runnable接口的run()抽象方法
class RunnableThread01 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ":\t" + i);
        }
    }
}
