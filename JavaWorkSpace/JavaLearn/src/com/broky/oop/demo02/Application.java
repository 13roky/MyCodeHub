package com.broky.oop.demo02;

public class Application {
    public static void main(String[] args) {

        //new实例化了一个对象
        Person person = new Person("broky",13);

        System.out.println(person.name+"\n"+person.age);

    }
}
