package com.broky.exception.practice;

public class ExceptionTest {
    static void methodA() {
        try {
            System.out.println("运行A方法");
            throw new RuntimeException("A方法手动抛出运行时异常");
        } finally {
            System.out.println("用A方法的finally");
        }
    }

    static void methodB() {
        try {
            System.out.println("进入B方法");
            return;
        } finally {
            System.out.println("用B方法的finally");
        }
    }


    public static void main(String[] args) {

        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        methodB();
    }
}
