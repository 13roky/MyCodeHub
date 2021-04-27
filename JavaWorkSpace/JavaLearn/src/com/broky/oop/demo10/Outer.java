package com.broky.oop.demo10;

import java.io.ObjectInputStream.GetField;

public class Outer {

    private int id;
    public void out() {
        System.out.println("this is the outer method");
    }
    //内部类
    class Inner{
        public void in() {
            System.out.println("this is the inner method");
        }

        //内部类可以获得外部类的私有属性
        public void getId() {
            System.out.println(id);
        }
    }

    public static class Inner1 {
        public void getId() {
            //System.out.println(id);  这里编译报错，无法获取id，因为静态内部类生成在id生成之前。
        }
    }

    //局部内部类, 可以没有名字
    public void method(){
        class Inner2{
            public void innerMethod(){

            }
        }
    }
}

// 一个java类中可以有多个class类，但是只能有一个public class
class A{

}