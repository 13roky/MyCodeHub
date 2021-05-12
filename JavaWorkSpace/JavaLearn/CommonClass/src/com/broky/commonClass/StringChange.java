package com.broky.commonClass;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String类与其他结构之间的转换
 * String 与 char[] 之间的转换
 * String 与 byte[] 之间的转换
 *
 * @author 13roky
 * @date 2021-05-02 19:33
 */
public class StringChange {
    /*
    复习：String与其他数据类型，包装类之间的转换
    String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
    基本数据类型、包装类 ——》String：调用String重载的valueOf(xxx) 或者直接拼接“”
     */
    @Test
    public void test(){
        String str = "123";
        //int num = (int) str;   只有子父类的关系才可以使用强制类型转换

        int num = Integer.parseInt(str);

        String str2 = String.valueOf(num);
        String str3 = num + "";
    }

    /*
    String 与 char[] 之间的转换

    String --> char[] ：String类中的toCharArray()方法
    char[] --> String ：String的构造器
     */
    @Test
    public void test02(){
        String str = "abcde";

        char[] c1 = str.toCharArray();

        for (int i = 0; i < c1.length; i++) {
            System.out.println(c1[i]);
        }

        char[] c2 = new char[]{'f','s','c','a'};

        String str2 = new String(c2);
        System.out.println(str2);
    }

    /*
    String 与 byte[] 之间的转换
    编码：String --> byte[] ：调用String的getBytes()
    解码：

    转化的时候会涉及编码和解码
    编码：字符串 --> 字节 （看得懂转换为看不懂的二进制数据）
    解码 字节 --> 字符串 （看不懂的二进制数据转换为看得懂）

     */
    @Test
    public void test03() throws UnsupportedEncodingException {
        String str = "abc123此方";
        // 使用ide默认的编码集进行转换
        byte[]  b1 = str.getBytes();
        // 字节byte类型 采用ASCLL编码 由于ASCLL中没有中文编码，所以中文会转为默认的编码如（UTF-8，UTF-8中一个汉字占三位）然后再转为ASCLL
        System.out.println(Arrays.toString(b1));
        // 使用 gbk 字符集进行编码，需要处理异常
        byte[] b2 = str.getBytes("gbk");

        System.out.println(Arrays.toString(b2));
        System.out.println("=======================================");
        // 使用ide默认的编码集进行解码
        String str2 = new String(b1);
        System.out.println(str2);
        // 出现乱码。原因：编码及和解码集不一致倒置的
        String str3 = new String(b2);
        System.out.println(str3);

        // 指定编码集
        String str4 = new String(b2, "gbk");
        System.out.println(str4);
    }
}
