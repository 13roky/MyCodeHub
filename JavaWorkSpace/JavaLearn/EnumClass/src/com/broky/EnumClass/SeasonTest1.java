package com.broky.EnumClass;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 自定义枚举类
 *
 * 一, 枚举类的使用
 * 1.枚举类的理解: 类的对象只有有限个, 确定的. 我们称此类为枚举类.
 * 2.当需要定义一组常量时, 强烈建议使用枚举类.
 * 3.如果枚举类中只有一个对象, 则可以作为单例模式的实现.
 *
 * 二, 如何定义枚举类
 * 方式一 : jdk5.0之前, 自定义枚举类.
 * 方式二 : jdk5.0时,可以使用 enum 关键字定义枚举类.
 *
 * 三，Enum类 中的常用方法
 * values() ：返回枚举类型的对象数组。该方法可以很方便地遍历所有的 枚举值。
 * valueOf(String str) ：可以把一个字符串转为对应的枚举类对象。要求字符 串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
 * toString()：返回当前枚举类对象常量的名称。
 *
 * 四, 使用 enum 关键字定义的枚举类实现接口的情况
 *
 * @author 13roky
 * @date 2021-05-13 18:32
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
        System.out.println(Season1.class.getSuperclass());

        System.out.println("************************************");
        // values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
        Season1[] values = Season1.values();
        System.out.println(Arrays.toString(values));

        Thread.State[] values1 = Thread.State.values();
        System.out.println(Arrays.toString(values1));

        System.out.println("************************************");
        // valueOf(String str) ：返回枚举类中对象名是objName的对象。
        // 可以把一个字符串转为对应的枚举类对象。
        // 要求字符 串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
        Season1 winter1= Season1.valueOf("WINTER");
        System.out.println(winter1);

        System.out.println("************************************");

        // toString()：返回当前枚举类对象常量的名称。
        System.out.println(winter1.toString());
    }

    @Test
    public void test(){
        Season1 spring = Season1.SPRING;
        spring.show();
        Season1.SUMMER.show();
    }
}

interface info{
    void show();
}

enum Season1 implements info{
    // 1. 提供当前枚举类的对象, 多个对象之间用","隔开, 末尾对象用";"结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋高气爽");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("凛冬已至");
        }
    };

    // 2. 声明 Season 对象的属性 : private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    // 3. 私有化类的构造器, 并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4. 其它诉求1 : 获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }

    // 5. 其他诉求2 : 提供toString（）
    // 不重写 toString 时, 如果 enum 类继承的是 Object 类, 那么打印时应该使用 Object 的 toString 打印的是地址值.
    // 但是经过实践得知, 打印出的不是地址值, 由 Season1.class.getSuperclass() 知, 其父类是 java.lang.Enum

    //    @Override
    //    public String toString() {
    //        return "Season{" + "seasonName='" + seasonName + '\'' + ", seasonDesc='" + seasonDesc + '\'' + '}';
    //    }
}
