package com.broky.oop.demo07;

//Static
public class Student {
    private static int age; //静态的变量
    private double score;   //非静态变量

    public static void go() {

    }

    public static void main(String[] args) {
        Student s1 = new Student();

        //通过对象调用age
        System.out.println(s1.age);
        //通过类调用age, 但是必须是静态的
        System.out.println(Student.age);
        //System.out.println(Student.score); 由于score不是静态, 所以不可调用, 编译报错

        //非静态方法需要使用对象调用, 对象也可以调用静态方法
        s1.run();
        s1.go();

        //类可以直接调用静态方法,不需要进行实例化对象. 但是不可直接调用非静态方法
        Student.go();
        // Student.run();   //编译报错
    }

    public void run() {

    }

}