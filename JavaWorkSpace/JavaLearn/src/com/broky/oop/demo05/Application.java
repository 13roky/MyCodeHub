package com.broky.oop.demo05;

public class Application {

    //静态方法和方法区别很大
    //静态方法: 方法的调用只和左边,定义的数据类型有关
    //非静态:
    public static void main(String[] args) {

        A a = new A();
        a.test();       //调用a类方法

        //父类的引用指向了子类
        B b = new A();      //子类重写了父类的方法
        b.test();       //调用b类方法

    }
}
