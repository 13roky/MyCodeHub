package com.broky.Collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author 13roky
 * @date 2021-05-18 21:52
 */
public class SetTest {

    /*
    Set 存储无序的, 不可重复的数据

    1.无序性 :
    不等于随机性.
    hashset 底层也是用数组存储, 无序性就是向数组中添加元素, 不是按照数据索引顺序添加的, 而是按照添加元素的哈希值添加的

    2.不可重复性 :
    保证添加的元素按照equals方法判断时不能返回true. 即相同的元素不能添加进来
     */
    @Test
    void Test01() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("tom", 12));
        set.add(new User("tom", 12));
        set.add(129);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //自然排序
    @Test
    void test02() {
        TreeSet set = new TreeSet();

        //举例一
        //        set.add(34);
        //        set.add(-34);
        //        set.add(43);
        //        set.add(11);
        //        set.add(8);

        //举例二
        set.add(new User("tom", 12));
        set.add(new User("jerry", 12));
        set.add(new User("jim", 12));
        set.add(new User("mike", 12));
        set.add(new User("tom", 65));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //定制排序
    @Test
    void test03() {

        TreeSet set = new TreeSet();

        set.add(new User("tom", 12));
        set.add(new User("jerry", 12));
        set.add(new User("jim", 12));
        set.add(new User("mike", 12));
        set.add(new User("tom", 65));

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o1 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                } else {
                }
                    throw new RuntimeException("输入的数据类型不匹配");
            }

            ;

        };
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
