package com.broky.Collection;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author 13roky
 * @date 2021-05-20 12:16
 */

import java.util.HashMap;
import java.util.Map;

/**
 * |----Map:双列数据，存储key-value对的数据     --类似于高中的函数：y=f(x)
 * |----HashMap:作为Map的主要实现类；线程不安全的，效率高；可以存储null的key和value
 * |----LinkedHashMap: 保证在遍历map元素时, 可以安装添加的顺序实现遍历
 * 原因: 在原有的HashMap底层结构基础上, 添加了一堆指针, 指向前一个和后一个元素
 * 对于频繁的遍历操作, 此类的执行效率高于HashMap
 * HashMap底层: 数组+链表(jdk7之前)
 * 数组+链表+红黑树(jdk8)
 * |----TreeMap:保证按照添加的key-value对进行潘旭, 实现排序遍历. 此时考虑key的自然排序或定制排序
 * 底层使用红黑树
 * |----Hashtable:作为古老的实现类；线程安全的，效率低；不可以存储null的key和value
 * |----Properties: 常用来处理配置文件. key和value都是String类型
 * <p>
 * 面试题:
 * 1. HashMap的底层实现原理?
 * 2. HashMap和Hashtablede的异同?
 * 3. CurrentHashMap（分段锁）和Hashtable的异同?
 * <p>
 * HashMap的底层原理 : 以jdk7为例说明:
 * <p>
 * HashMap map = new HashMap() :
 * 在实例化以后, 底层创建了长度是16的一维数组 Entry[] table
 * ...可能已经执行过多次put...
 * map.put(key1,value1) :
 * 首先, 调用 key1 所在类的 hashCoed() 计算key1哈希值, 此哈希值经过某种算法计算后,得到在 Entry 数组中的存放位置
 * 如果此位置上数据为空, 此时的 key1-value1 添加成功     ----情况1
 * 如果此位置上的数据不为空, (意味着此位置上存在一个或多个数据(以链表形式存在)), 比较 key1 和已经存在的有个或多个数据的哈希值:
 * 如果key1的哈希值与已经存在的数据的哈希值都不相同, 此时key1-value1添加成功       ----情况2
 * 如果key1的哈希值和已经存在的某一个数据的哈希值相同, 继续比较: 调用key1所在类的equals()方法, 比较:
 * 如果equals()返回false : 此时key1-value1添加成功       ----情况3
 * 如果equals()返回true : 使用value1替换value2值
 * <p>
 * 补充: 关于情况2和情况3: 此时key1-value1和原来的数据以链表的方式存储
 * <p>
 * 在不断地添加过程中, 会涉及到扩容问题, 默认的扩容方式: 扩容为原来容量的2倍, 并将原有的数据复制过来.
 * <p>
 * jdk8 相较于 jdk7 在底层实现方面的不同
 * 1. new HashMap() : 底层没有创建一个长度为16的数组
 * 2. jdk8 底层的数组是 : Node[], 而非Entry[]
 * 3. 首次使用 put() 方法时, 底层创建长度为16的数组
 * 4. jdk7 底层结构只有: 数组+链表. jdk8 中底层结构: 数组+链表+红黑树
 * 当数组的某一个索引位置上的元素以链表的形式存在的数据个数 > 8 且当前数组的长度 > 64时,
 * 此时此索引位置上的所有数据改为使用红黑树存储.
 */

public class MapTest {

    @Test
    void test01() {

        Map map = new HashMap();

        //put()
        map.put("AA", 123);
        map.put("BB", 123);
        map.put(45, 56);
        map.put("AA", 87);
        System.out.println(map);

        //putAll()
        HashMap map1 = new HashMap();
        map1.put("CC", 98);
        map1.put("DD", 47);

        map.putAll(map1);
        System.out.println(map);

        //remove()
        Object remove = map.remove("CC");
        System.out.println(remove);
        System.out.println(map);

        //clear()
        System.out.println(map.size());
        map.clear();
        System.out.println(map.size());

    }

    @Test
    void test02() {

        Map map = new HashMap();
        map.put("AA", 123);
        map.put("BB", 123);
        map.put(45, 56);
        map.put("AA", 87);
        System.out.println(map);

        //get()
        System.out.println(map.get("AA"));

        //containsKey()
        System.out.println(map.containsKey("AA"));

        //containsValue()
        System.out.println(map.containsValue(87));

        //isEmpty()
        System.out.println(map.isEmpty());

        //size()
        System.out.println(map.size());

        //equals()
        Map map1 = map;
        System.out.println(map.equals(map1));

    }

    @Test
    void test03() {

        Map map = new HashMap();
        map.put("AA", 123);
        map.put("BB", 123);
        map.put(45, 56);
        map.put("AA", 87);
        System.out.println(map);

        //Set keySet()
        Set keySet = map.keySet();
        System.out.println(keySet);

        //Collection values()
        Collection values = map.values();
        System.out.println(values);

        //遍历key-values方式一
        //Set entrySet()
        Set entrySet = map.entrySet();
        System.out.println(entrySet);
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            //entrySet中的元素都是entry
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "------>" + entry.getValue());
        }

        //遍历key-values方式二
        Iterator iterator1 = keySet.iterator();
        while (iterator1.hasNext()) {
            Object key1 = iterator1.next();
            Object values1 = map.get(key1);
            System.out.println(key1 + "=====" + values1);
        }
    }

    //TreeMap自然排序
    @Test
    void testTreeMap() {
        TreeMap map = new TreeMap();
        User u1 = new User("Tom", 12);
        User u2 = new User("Jerry", 12);
        User u3 = new User("Bob", 12);
        User u4 = new User("TK", 12);
        map.put(u1, 12);
        map.put(u2, 89);
        map.put(u3, 48);
        map.put(u4, 34);
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---------------->" + entry.getValue());
        }
    }

    //TreeMap定制排序

    @Test
    void testTreeMap1() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                throw new RuntimeException("输入的类型不匹配");
            }
        });
        User u1 = new User("Tom", 12);
        User u2 = new User("Jerry", 19);
        User u3 = new User("Bob", 13);
        User u4 = new User("TK", 18);
        map.put(u1, 12);
        map.put(u2, 89);
        map.put(u3, 48);
        map.put(u4, 34);
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---------------->" + entry.getValue());
        }
    }

    @Test
    void testProperties() {
        FileInputStream fis = null;
        try {
            Properties properties = new Properties();

            fis = new FileInputStream("F:\\CodeHub\\JavaWorkSpace\\JavaLearn\\Collection\\src\\com\\broky\\Collection\\jdbc.properties");
            properties.load(fis);
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");

            System.out.println("name = " + name + " , password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}