package com.broky.Collection;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author 13roky
 * @date 2021-05-15 13:20
 */
public class CollectionTest {
    @Test
    public void test01(){
        Collection coll = new ArrayList();

        //add(Object e) : 将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());

        //size() : 获取添加的元素个数
        System.out.println(coll.size());

        //addAll(Collection coll1) : 将coll1中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();

        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size());
        System.out.println(coll);

        //isEmpty() : 判断当前集合是否为空
        System.out.println(coll.isEmpty());

        //clear() : 清空集合元素
        coll.clear();
        System.out.println(coll.isEmpty());
        System.out.println(coll);

        //contains() : 是通过元素的equals方法来判断是否是同一个对象
        coll.add(new String("Tom"));
        coll.add(new Person("13roky",21));
        coll.add(new Person("niko",22));

        System.out.println(coll.contains("Tom"));
        //这里是true, contains判断的是内容, 因为使用的是String重写的equals方法
        System.out.println(coll.contains(new String("Tom")));
        //这里是false, contains判断的是内存地址 因为Person类没有重写equals方法, 所以用的是父类Object的equals
        System.out.println(coll.contains(new Person("13roky", 21)));
        System.out.println(coll.contains(new Person("niko", 22)));

        /*
        这里可以看出, contains调用了两次 Person 的 equals 方法.
        其原理为, 依次拿要判断的 Person 对象去和集合中所存在的元素比对, 直到比对到出现 true 停止.
        也就是说将集合中的值依次放入 new Person("13roky", 21).equals() 中, 调用的次数为出现 true 时所调用的次数
         */

        //containsAll(Collection coll) : 判断形参coll中的所有元素是否都存在于集合中
        Collection coll2 = Arrays.asList(new Person("niko", 22),"Tom");
        System.out.println(coll.containsAll(coll2));

        //boolean remove(Object obj) ：通过元素的equals方法判断是否是, 要删除的那个元素。只会删除找到的第一个元
        System.out.println(coll);
        coll.remove("Tom");
        System.out.println(coll);
        /*
        如果对象所在类没有重写 equals 方法, 那么就无法删除
         */

        //boolean removeAll(Collection coll)：取当前集合的差集, 从当前集合中移除和 coll 集合共有的元素
        System.out.println(coll2);
        coll.removeAll(coll2);
        System.out.println(coll);

    }

    @Test
    void test02() {
        // boolean retainAll(Collection c)：把交集的结果存在当前集合中，不影响c
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(789);

        Collection coll1 = Arrays.asList(456,789,91011);
        coll.retainAll(coll1);
        System.out.println(coll);

        //boolean equals(Object obj) : 集合是否相等, 传入的是形参obj, 所以必须也得是形参集合才可返回true

        System.out.println(coll.equals(Arrays.asList(456, 789)));
        // 由于Collection 中 new 的是 ArrayList 类型的对象, 但是 ArrayList 存在顺序, 所以顺序不同会返回false
        System.out.println(coll.equals(Arrays.asList(789, 456)));

        //hashCode() : 获取当前对象的哈希值
        System.out.println(coll.hashCode());

        //Object[] toArray() : 集合转换成数组, 添加的时候添加的obj返回的时候也返回obj数组
        Object[] array = coll.toArray();
        System.out.println(Arrays.toString(array));

        //拓展 : 数组转集合, 调用Arrays类的静态方法asList()
        List<String> strings = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(strings);

        //这里使用基本数据类型会将整个数组识别为一个整体存入集合
        List ints = Arrays.asList(new int[]{123, 456});
        System.out.println(ints);

        //可以采用包装类的形式传入
        List ints2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(ints2);

        //也可一这样直接传入, 默认使用包装类包装
        List list = Arrays.asList(123, 456);
        System.out.println(list);

        //iterator()：返回Iterator接口的实例，用于集合遍历. 凡在IteratorTest.java中测试
        coll.iterator();
    }
}

class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("调用Person的equals方法");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

