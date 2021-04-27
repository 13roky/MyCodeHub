package com.broky.multiThread;

/**
 * @author 13roky
 * @date 2021-04-19 22:53
 */
public class AnonymousSubClass {
    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ":\t" + i);
                }
            }
        }.start();

    }
}
