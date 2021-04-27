package com.broky.oop.demo06;

public class Student extends Person {

    @Override
    public void run() {
        System.out.println("son跑了");
    }

    public void eat() {
        System.out.println("son吃了");
    }

    public void go() {
        System.out.println("GO");
    }
}
