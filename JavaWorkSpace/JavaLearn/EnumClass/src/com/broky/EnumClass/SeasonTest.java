package com.broky.EnumClass;

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
 *
 * @author 13roky
 * @date 2021-05-13 17:16
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}

// 自定义枚举类
class Season{
    // 1. 声明 Season 对象的属性
    // final 不能使用初始化赋值, 可以手动 显式赋值, 构造器赋值, 代码块赋值
    // 现式赋值和代码块赋值 会导致创建当前类的不同对象时 他们的这些属性都是一样的
    // 构造器赋值 可以在实例化的时候设置属性
    private final String seasonName;
    private final String seasonDesc;

    // 2. 私有化类的构造器, 并给对象属性赋值
    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3. 提供当前枚举类的多个对象 : public static final 的
    public static Season SPRING = new Season("春天","春暖花开");
    public static Season SUMMER = new Season("夏天","夏日炎炎");
    public static Season AUTUMN = new Season("秋天","秋高气爽");
    public static Season WINTER = new Season("冬天","冰天雪地");

    // 4. 其它诉求1 : 获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 5. 其他诉求2 : 提供toString（）

    @Override
    public String toString() {
        return "Season{" + "seasonName='" + seasonName + '\'' + ", seasonDesc='" + seasonDesc + '\'' + '}';
    }
}
