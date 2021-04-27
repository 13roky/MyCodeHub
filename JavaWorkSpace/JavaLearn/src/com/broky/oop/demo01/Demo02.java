package com.broky.oop.demo01;

public class Demo02 {

    //静态方法 static

    public static void main(String[] args) {
        //如果其他类的方法是静态方法可以如下调用
        // Student.say();

        //非静态方法必须实例化对象,然后通过对象调用
        Student student = new Student();
        student.say();
    }
    //如果方法a都是静态的或都是非静态的那么两个方法可以相互调用
    public void a(){
        b();
    }

    public void b(){

    }
    /*
    如果方法a和方法b一个是静态一个是非静态,那么二者不可以相互调用
    因为静态方法是和类一起加载的,当类存在时静态方法就存在了
    非静态方法是类实例化(new)之后才存在
     */

}
