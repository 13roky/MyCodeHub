package com.broky.oop.demo01;
//引用传递: 对象, 本质还是值传递

//不理解对象和内存可能会晕.
public class Demo05 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.name); //null

        Demo05.change(person);
        System.out.println(person.name);
    }

    public static void change(Person person){
        //person是一个对象: 指向的--->Person person = new Person();这是一个具体的人,可以改变属性.
        person.name = "13roky"; //此处修改的是Person类中的name, 而不是此方法中的形式参数.
    }

}
//一个类只能有一个public class可以有多个class
class Person{
    String name; //默认值为null
}
