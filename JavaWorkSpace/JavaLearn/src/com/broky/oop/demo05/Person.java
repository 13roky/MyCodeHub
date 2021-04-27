package com.broky.oop.demo05;

//在java中所有的类都默认直接或间接继承object类
public class Person {

    //一般属性都设置为私有,添加get和set让外界操作
    private int money = 10_0000_0000;

    protected String name = "father";

    public Person(String name) {
        System.out.println("Person无参构造执行");
    }

    //公共的方法可以被子类调用, 私有的方法不可以被子类调用
    public void say() {
        System.out.println("说了一句话");
    }

    public void print(){
        System.out.println("Person");
    }

    public int getMoney() {
        return money;
    }
}
