package com.broky.commonClass;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1) 说明: Java中的对象, 正常情况下, 只能进行比较:==或!= 不能使用>或<
 *          但是在开发场景中, 我们需要对多个对象进行排序, 言外之意, 就需要比较对象的大小
 *          如何实现? 使用两个接口中的任何一个: Comparable 或 Comparator
 * 2) Comparable 接口与 Comparator 的使用的对比
 *          Comparable 接口的方式一旦实现,保证 Comparable 接口实现类的对象在任何位置都可以比较大小
 *          Comparator 接口属于临时性的比较.
 *
 * @author 13roky
 * @date 2021-05-12 22:15
 */
public class CompareTest {
    /*
    Comparable 接口的使用举例: 自然排序
    1. 像 String, 包装类等实现了 Comparable 接口, 重写了 compareTo(obj) 方法, 给出了比较两个对象
    2. 像 String, 包装类重写了compareTo()方法以后,进行了从小到大的排列
    3. 重写 compareTo(obj) 的规则:
        如果当前对象 this 等于形参对象 obj, 则返回为零
        如果当前对象 this 小于形参对象 obj, 则返回负整数
        如果当前对象 this 大于形参对象 obj, 则返回正整数
    4. 对于自定义类来说, 如果需要排序, 我们可以让自定义类实现 Comparable 接口, 重写compareTo(obj) 方法
        在 compareTO(obj) 方法中知名如何排序
     */
    @Test
    public void test01(){
        String[] arr = new String[]{"aa","cc","kk","mm","gg","jj","dd"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test02() {
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[3] = new Goods("MicroSoftiMouse",12);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /*
    Comparator 接口的使用： 定制排序
    1. 背景
    当元素的类型没有实现java.lang.Comparable 接口而又不方便修改代码，
    或者实现了java.lang.Comparable 接口的排序规则不适合当前的操作
    那么可以使用 Compare(obj o1,obj o2)方法, 比较o1和o2的大小
    2. 重写 Compare(obj o1,obj o2) 方法, 比较o1和o2的大小
    如果方法返回正数,则表示o1大于o2
    如果方法返回负数,则表示01小于02
    如果方法返回0, 则表示相等
     */
    @Test
    public void test03(){
        // test1
        String[] arr = new String[]{"aa","cc","kk","mm","gg","jj","dd"};
        // 从大到小排序
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test04() {

        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("huaweiMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("microSoftiMouse",12);

        Arrays.sort(arr,new Comparator(){
            // 指明商品比较大小的方式：再按照产品名称从第到高排序, 按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
