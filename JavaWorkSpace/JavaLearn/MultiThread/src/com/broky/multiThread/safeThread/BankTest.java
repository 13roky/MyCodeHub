package com.broky.multiThread.safeThread;

/**
 * @author 13roky
 * @date 2021-04-22 7:24
 */
public class BankTest {
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {
        //方式一：效率性差，每个等待线程都会进入同步代码块
        //        synchronized (Bank.class) {
        //            if (instance == null) {
        //                instance = new Bank();
        //            }
        //        }

        //方式二：在同步代码块外层在判断一次，就防止所有线程进入同步代码块。
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
