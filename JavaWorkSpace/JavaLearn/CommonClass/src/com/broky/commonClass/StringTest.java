package com.broky.commonClass;

import org.junit.jupiter.api.Test;

/**
 * String 的使用
 *
 * @author 13roky
 * @date 2021-04-24 10:34
 */
public class StringTest {
    public static void main(String[] args) {

    }

    /*
        String:字符串,使用一对""来表示.
        1.String类是被声明为final的,不可被继承.
        2.String实现了Serializable接口:标识字符串是支持序列化的. (io流)
                实现了Comparable接口:可以比较大小.
        3.String内部定义了final char[] value用于存储字符串数字. final表示数组和其元素不能被修改。(为了节省jvm的内存空间jdk9已经改为byte[]类型数组)
        4.String:代表不可变的字符序列。简称：不可变性。
                体现:1.当对字符串重新赋值时,需要重新指定内存区域赋值,不能使用原有的value进行赋值.(因为原有的value是final的)
                    2.当对现有的字符串进行连接操作时,需要重新指定内存区域赋值,不能使用原有的value赋值.
                    3.当调用String的replace()方法修改字符或字符串时,也必须重新指定内存区域赋值,不能使用原有的value赋值.
        5.通过字面量的方式(区别于new)给一个字符串赋值,此时的字符串值生命在字符串常量池中.
        6.字符串常量池中是不会存储相同内容的字符串的.
     */
    @Test
    public void test01() {
        //字面量的定义方式, 在内存中用的是同一个内存地址
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);//true
        //
        s1 = "hello";
        //==比较的是地址值,为true说明s1和s2在内存中指向的是同一个位置
        System.out.println(s1);//hello
        System.out.println(s2);//abc

        System.out.println("================================================");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef
        System.out.println(s2);//abc

        System.out.println("================================================");

        String s4 = "adb";
        String s5 = s4.replace('a', 'm');

        System.out.println(s4);//abc
        System.out.println(s5);//mbc
    }

    /*
    String实例化方式测试:
    方式一: 通过字面量定义的方式
    方式二: 通过new + 构造器的方式

    面试题：String s = new String("abc);方式创建对象，在内存中创建了几个对象？
            两个：一个是堆空间中new结构，另一个是char[]对应的常量池中的数据"abc"
     */
    @Test
    public void test2() {
        //通过字面量定义的方式:此时的s1和s2的数据javaEE生命在方法区中的字符串常量池中.
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new + 构造器的方式:此时的s3和s4保存的地址值是数据在堆空间中开辟空间后对应的地址值.
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false
        System.out.println(s3.equals(s4));//true

        System.out.println("=================================================");

        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);

        System.out.println(p1.name.equals(p2.name));//true
        System.out.println(p1.name == p2.name);//true
    }

    /*
    1.常量与常量的拼接结果在常量池。且常量池中不会存在享同内容的常量。
    2.只要其中有一个是变量，结果就在堆中。
    3.如果拼接的结果调用intern()方法，返回值就会在常量池中。
     */
    @Test
    public void test03() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";//引号中的为字面量，这里是字面量的拼接
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        final String s8 = "hadoop";
        String s9 = "javaEE" + s8;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false
        System.out.println(s3 == s9);//true

        String s10 = s5.intern();//返回值得到的s8使用的常量值中已经存在的”javaEEhadoop“（s5.intern返回的时常量池中对应的内存地址）
        System.out.println(s3 == s10);//true
    }
}

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
