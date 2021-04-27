package com.broky.oop.demo08;

//abstract 抽象类: 类 extends: 单继承~ 不可以多继承   但是接口可以多继承
public abstract class Action {

    public static void main(String[] args) {
        //抽象类不能new, 只能靠再累去实现它; 约束;
        //new Action();     //编译报错
    }

    //约束~有人帮我们实现~
    //abstract, 抽象方法, 只有方法名字, 没有方法的实现!
    public abstract void doSomething();

    //抽象类中可以有正常的方法
    public void hello() {
        System.out.println("hello");
    }
}
//1| 抽象类不能new, 只能靠再累去实现它; 约束;
//2| 抽象类中可以写普通方法
//3| 抽象方法必须卸载抽象方法中
//抽象的抽象: 约束~
//思考: 抽象类存在构造器吗?
//抽象类存在的意义  抽象出来  提高代码的开发效率