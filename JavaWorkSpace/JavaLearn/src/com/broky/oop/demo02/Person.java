package com.broky.oop.demo02;

/*
构造器:
    1.和类名相同
    2.没有返回值
作用:
    1.new本质在调用构造方法
    2.初始化对象的值
注意:
    1.定义有参构造之后,如果想使用无参构造,显示的定义一个无参的构造
 */

// 快捷键 alt+insert

public class Person {

    //一个类即使什么都不写, 他也会存在一个默认的构造方法
    //显示的定义构造器
    String name;
    int age;

    //实例化初始值
    //1.使用new关键字,本质是在调用构造器,所以必须要有构造器
    public Person(){
        //this指的是上面的属性
        this.name = "13roky";
    }

    //有参构造:
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

}
