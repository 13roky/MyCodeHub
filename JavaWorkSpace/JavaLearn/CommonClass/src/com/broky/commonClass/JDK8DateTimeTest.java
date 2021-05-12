package com.broky.commonClass;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * jdk 8 中的时间日期 api
 *
 * @author 13roky
 * @date 2021-05-10 7:05
 */
public class JDK8DateTimeTest {

    /*
    LocalDate、LocalTime、LocalDateTime 类的使用:

     */

    @Test
    public void test01() {
        // 实例化方式一：使用静态方法 now() / now(zoneld zone) 获取当前的日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);

        // 实例化方式二：of() 可以自定义时间，无 Date 中偏移量的问题

        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 1, 4, 23, 43);
        System.out.println(localDateTime1);

        // getXxx() 获取相关属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        // withXxxx() 设置相关属性， 具有不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(20);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(16);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //plusXxx() 在现有基础上加上指定数据
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        // minusXxx() 在现有基础上减去指定数据
        LocalDateTime localDateTime4 = localDateTime.minusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    /*
    Instant 的使用
     */

    @Test
    public void test02() {
        // now : 获取本初子午线的时间
        Instant instant = Instant.now(); //格林威治时间
        System.out.println(instant);

        // 添加 默认时区 与 当前需要时区 的 时间 的 偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        // 获取 1970年1月1日0时0分0秒 (UTC) 开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        // ofEpochMilli 通过给定的毫秒数获取 Instant 的实例
        Instant instant1 = Instant.ofEpochMilli(1620783200875L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
     */

    @Test
    public void test03() {
        // 方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String s = formatter.format(localDateTime);
        System.out.println(s);
        // 因为使用标准格式进行格式化，所以 localDateTime 格式化前后的值基本没有变化，但是类型变变为了 String
        // 解析：字符串-->日期
        TemporalAccessor parse = formatter.parse("2021-05-12T20:48:52.1539765");
        System.out.println(parse);

        // 方式二：
        // 本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG);
        // FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String s1 = formatter1.format(localDateTime);
        System.out.println(s1);

        // 本地化相关的格式。如：ofLocalizedDate()
        // FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDateTime
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String s2 = formatter2.format(LocalDate.now());
        System.out.println(s2);

        /*
        可能会报错 ： java.time.DateTimeException: Unable to extract ZoneId from temporal
        参考：https://stackoverflow.com/questions/59531046/java-time-datetimeexception-unable-to-extract-zoneid-from-temporal
         */

        // 方式三：自定义的格式。如：ofPattern("yyyy-MM-dd hh:mm:ss E");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String s3 = formatter3.format(localDateTime);
        System.out.println(s3);

        // 解析
        TemporalAccessor parse1 = formatter3.parse("2021-05-12 09:24:47");
        System.out.println(parse1);
    }
}
