package com.broky.oop.demo07;

//静态导入包,导入后可以直接用代码random()调用Math的random方法
import static java.lang.Math.random;
import static java.lang.Math.PI;

public class Test {
    public static void main(String[] args) {
        System.out.println(Math.random());
        System.out.println(random());
        System.out.println(PI);
    }
}
