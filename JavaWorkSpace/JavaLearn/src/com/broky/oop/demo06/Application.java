package com.broky.oop.demo06;

public class Application {
    public static void main(String[] args) {

        //Object > String
        //Object > Person > Teacher
        //Object > Person > Student
        Object object = new Student();

        System.out.println(object instanceof Student);  //true
        System.out.println(object instanceof Person);   //true
        System.out.println(object instanceof Object);   //true
        System.out.println(object instanceof Teacher);  //false
        System.out.println(object instanceof String);   //false
        System.out.println("=============================");

        Person person = new Student();

        System.out.println(person instanceof Student);  //true
        System.out.println(person instanceof Person);   //true
        System.out.println(person instanceof Object);   //true
        System.out.println(person instanceof Teacher);  //false
        // instanceof比较的是两者有关系的情况, 如果两者没有任何关系会直接报错
        // System.out.println(person instanceof String);   //编译报错

        System.out.println("=============================");

        Student student = new Student();

        System.out.println(student instanceof Student);  //true
        System.out.println(student instanceof Person);   //true
        System.out.println(student instanceof Object);   //true
        // System.out.println(student instanceof Teacher);  //编译报错
        // instanceof比较的是两者有关系的情况, 如果两者没有任何关系会直接报错
        // System.out.println(person instanceof String);   //编译报错

        //类型之间的转化: 父 子
        //子类转化为父类可能会丢失自己本来的一些方法
        Person obj = new Student();
        // student1.go();   person中没有go方法所以无法执行
        //将person类型的对象转换为student类型就可以使用student方法了

        //将obj强制转换成student类型
        Student student1 = (Student) obj;
        student1.go();
        //以上两行代码转换成一行
        ((Student) obj).go();

        //低转高不用强制转换
        Person person1 = student1;

    }
}
/*
1| 存在条件: 父类的引用指向子类的对象.
2| 把子类转换为父类, 向上转型; 不用强制转换.
3| 把父类转换为子类, 向下转型; 需要强制转换; 可能会丢失自己本来的方法.
4| 方便方法的调用, 减少重复的代码! 使代码更加简洁!

抽象: 封装, 继承, 多态!
 */