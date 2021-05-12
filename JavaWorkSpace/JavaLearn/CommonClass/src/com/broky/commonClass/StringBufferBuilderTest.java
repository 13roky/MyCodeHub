package com.broky.commonClass;

import org.junit.jupiter.api.Test;

/**
 * String、StringBuffer、StringBuilder：三者的异同
 *
 * @author 13roky
 * @date 2021-05-03 15:42
 */
public class StringBufferBuilderTest {
    /*
    String、StringBuffer、StringBuilder：三者的异同
    String：不可变的字符序列，底层使用char[]进行存储
    StringBuffer：可变的字符序列，线程安全的，效率低，底层使用char[]进行存储
    StringBuilder：可变的字符序列，线程不安全的，效率高，jdk5.0新特性，底层使用char[]进行存储

    源码分析：
        String：
            String str = new String();  // 底层代码为 char[] value = new char[0];
            String str1 = new String("abc");    // 底层代码为 char[] value = new char[]{'a','b','c'};
        StringBuffer:
            String sb1 = new StringBuffer();    // char[] value = new char[16];底层创建了一个长度是16的数组
            sb1.append('a');    // value[0] = 'a';
            sb1.append('b');    // value[1] = 'b';
    问题1：System.out.println(sb1.length()); 返回的是有的值count，而不是底层开辟的空间value.length.
    问题2：扩容问题，如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组。
            默认情况下，扩容为原来容量的2倍+2（源码中采用了位运算<<），同时将原有数组中的元素复制到新数组中。
    总结：1.开发中尽量不要用String，String不可变，效率最差，每次都会新造。而StringBuufer和StringBuilder只有长度不够用的时候才去扩容并复制。
            2.开发中如果知道会频繁使用append时，建议使用StringBuffer的指定容量的构造器，避免之后进行扩容。
     */

    @Test
    public void test() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println();

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());   //底层是16，但是返回的是count有的值
    }

    /**
     * String StringBuffer StringBuilder 效率测试
     */
    @Test
    public void timeTest() {
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer 执行时间" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder 执行时间" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + String.valueOf(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("String 执行时间" + (endTime - startTime));

    }

    @Test
    public void test2(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        //StringBuffer 的 append 方法会将null值转换为字符“null”加入
        sb.append(str);

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb2 = new StringBuffer(str);
        System.out.println(sb2);
    }
}
