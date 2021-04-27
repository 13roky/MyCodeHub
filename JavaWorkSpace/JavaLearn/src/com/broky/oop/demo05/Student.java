package com.broky.oop.demo05;

// 学生 is 人
public class Student extends Person{

    private String name = "13roky";

    //如果父类没有无参构造那么子类根本无法写无参构造
    //但是可以在子类无参构造的一开始就调用父类的有参构造以消除错误
    //总之子类构造器必须调用父类构造器
    public Student() {
        //隐藏代码: 调用了父类的无参构造
        //调用父类的构造器必须在子类构造器的第一行
        super("asd");
        System.out.println("Student无参构造执行");
    }
    /*
    super:
    1.super调用父类的构造方法, 必须在构造方法的第一个
    2.super必须只能出现在子类的方法或者构造方法中
    3.super和this不能同时调用构造方法

    vs this:
        代表的对象不同:
            this:本身调用者这个对象
            super:代表父类对象的应用
        前提
            this:没哟继承也可以使用
            super:只能在继承条件才可以使用
        构造方法
            this();本类的构造
            super():父类的构造!
     */

    public void test(String name){
        System.out.println("输出传递进来的name: "+name);
        System.out.println("输出当前类的name: "+this.name);
        System.out.println("输出父类的name: "+super.name);
    }

    public void print(){
        System.out.println("Student");
    }

    /*
    测试重名方法的调用
    如果本类中和父类中都有print()方法
    那么在本类中调用print()优先调用本类中的print(),效果与this.print()类似
    如果想调用父类的print()那么需要使用super.print()
     */
    public void testPrint(){
        print();
        this.print();
        super.print();
    }

}
