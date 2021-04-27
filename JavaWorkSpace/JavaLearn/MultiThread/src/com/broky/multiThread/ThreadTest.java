package com.broky.multiThread;

/**多线程的创建，方式一：继承于Thread类
 * 1. 创建一个继承于Thread类的子类。
 * 2. 重写Thread类的run()方法。
 * 3. 创建Thread类的子类的对象。
 * 4. 通过此对象调用start()来启动一个线程。
 * @author 13roky
 * @date 2021-04-19 21:22
 */
public class ThreadTest extends Thread{
    @Override
    //线程体,启动线程时会运行run()方法中的代码
    public void run() {
        //输出100以内的偶数
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":\t"+i);
            }
        }
    }

    public static void main(String[] args) {
        //创建一个Thread类的子类对象
        ThreadTest t1 = new ThreadTest();
        //通过此对象调用start()：①启动当前线程 ②调用当前线程的run()
        //注意如果这里直接t1.run()并不会启动线程，指挥调用run()方法,是运行在main线程中的
        t1.start();

        //另一种调用方法,此方法并没有给对象命名
        new ThreadTest().start();

        //以下操作都是在main线程中执行的
        System.out.println("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":\t"+i);
            }
        }
    }
}
