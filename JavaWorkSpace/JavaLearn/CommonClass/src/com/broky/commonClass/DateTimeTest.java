package com.broky.commonClass;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * JDK8 之前的日期和时间的 api 测试
 *
 * @author 13roky
 * @date 2021-05-08 9:15
 */
public class DateTimeTest {

    /*
    System类提供的 public static long currentTimeMillis()
    用来返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
     */
    @Test
    public void test() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    /*
    java.util.Date 类
            |---java.sql.Date 类 数据库
    1. 两个构造器的使用
        > 构造器一：Date()：创建一个对应当前时间的Date对象
        > 构造器二：创建指定毫秒数的Date对象
    2. 两个方法的使用
        > toString()：显示当前的年、月、日、时、分、秒
        > getTime()：获取当前Date对象对应的毫秒数。（时间戳）

    3. java.sql.Date 对应这数据库中的日期类型的变量
        > 实例化
        > 将 sql.date 转换 util.date: 多态直接赋值
        > 将 util.date 转换 sql.date: 通过共同的getTime()时间戳实现
     */

    @Test
    public void test02() {
        // 构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        // 构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1620437519431L);

        java.sql.Date date3 = new java.sql.Date(1620437519431L);
        System.out.println(date3);

        // 将 util.date 转换 sql.date:
        // 情况一
        Date date4 = new java.sql.Date(1620437519431L);
        java.sql.Date date5 = (java.sql.Date) date4;
        // 情况二
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());

        /*
        当new的是父类的时候，如果强转为子类，那么编译时不会报错，运行时会报错，因为new的父类缺少子类特有的属性和方法
        当new的是子类的时候，但是赋给了父类，这时候是可以强转成子类的，如情况一
         */

    }

    // Date中的偏移量
    @Test
    public void test01() {
        /*
        由于构造方法存在一个偏移量，年份是从1990年开始，月份是从0开始所以构造时应该减去偏移量
         */
        Date date1 = new Date(2020, 9, 8);
        System.out.println(date1);  // Fri Oct 08 00:00:00 CST 3920
        date1 = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date1);  // Tue Sep 08 00:00:00 CST 2020
    }
}