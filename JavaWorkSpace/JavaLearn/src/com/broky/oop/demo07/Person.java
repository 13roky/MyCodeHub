package com.broky.oop.demo07;

//静态代码块
//被final的类不能被继承
public class Person {

    {
        //代码块(匿名代码块)
        //程序执行时无法主动调用
        //当实例化对象时会自动创建
    }

    static {
        //静态代码块
        //当类一加载就执行
        //永久只执行一次
    }

    //2|在构造方法之前执行,可以通过这个方法来赋初始值
    {
        System.out.println("匿名代码块");
    }

    //1|最早执行, 但是只执行一次
    static{
        System.out.println("静态代码块");
    }

    //3|最后执行
    public Person(){
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("================");
        Person person1 = new Person();

    }
}
