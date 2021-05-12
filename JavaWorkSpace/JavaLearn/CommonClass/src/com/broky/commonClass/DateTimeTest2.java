package com.broky.commonClass;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8 之前的日期时间的API测试
 * 1. System类中currentTimeMillis();
 * 2. java.util.Date 和 子类 java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calendar
 *
 * @author 13roky
 * @date 2021-05-09 12:53
 */
public class DateTimeTest2 {
    /*
    SimpleDateFormat 的使用：SimpleDateFormat对日期 Date 类的格式化和解析

    1. 两个操作
    1.1 格式化：日期 ---> 字符串
    1.2 解析：格式化的逆过程，字符串 ---> 日期

    2. SimpleDateFormat 的实例化
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        // 实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        // 格式化：日期 ---> 字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        // 解析： 格式化的逆过程，字符串 ---> 日期
        String str = "2021/5/9 下午1:04";
        Date date1 = null;

        date1 = sdf.parse(str);

        System.out.println(date1);

        //*********************************
        // SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);

        Date date2 = sdf1.parse("2021-05-09 01:09:56");
        System.out.println(date2);

    }

    @Test
    public void ex() throws ParseException {
        //练习一：字符串“2020-02-23”转化为java.sql.Date
        String str = "2020-02-23";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = sdf.parse(str);
        System.out.println(date);

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        System.out.println(sqlDate);
    }

    @Test
    public void testEx() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("1990-01-01");

        long oneDay = sdf.parse("1990-01-02").getTime() - startDate.getTime();
        long period = oneDay * 5;
        //        long now = sdf.parse(sdf.format(new Date())).getTime() - startDate.getTime();
        long now = sdf.parse("1990-01-06").getTime() - startDate.getTime() + oneDay;

        if (now % period > 3 * oneDay || now % period == 0) {
            System.out.println("晒网");
        } else {
            System.out.println("打鱼");
        }

    }
     /*
        Calendar 日历类（抽象类）的使用
     */
    @Test
    public void testCalendar(){
        // 1. 实例化
        // 方式一： 创建其子类 （GregorianCalendar）的对象
        // 方式二：调用其静态方法getInstance()
        // 两种创建方法本质上一样
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        // 2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime(): 日历类-->Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime(): Date--->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}
