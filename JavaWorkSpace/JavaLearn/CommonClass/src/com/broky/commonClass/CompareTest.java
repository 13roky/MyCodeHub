package com.broky.commonClass;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 1) 说明: Java中的对象, 正常情况下, 只能进行比较:==或!= 不能使用>或<
 *          但是在开发场景中, 我们需要对多个对象进行排序, 言外之意, 就需要比较对象的大小
 *          如何实现? 使用两个接口中的任何一个: Comparable 或 Comparator
 * 2) Comparable 接口的使用
 *
 * @author 13roky
 * @date 2021-05-12 22:15
 */
public class CompareTest {
    /*
    Comparable 接口的使用举例:
    1. 像 String, 包装类等实现了 Comparable 接口, 重写了 compareTo(obj) 方法, 给出了比较两个对象
    2. 像 String, 包装类重写了compareTo()方法以后,进行了从小到大的排列
    3. 重写 compareTo(obj) 的规则:
        如果当前对象 this 等于形参对象 obj, 则返回为零
        如果当前对象 this 小于形参对象 obj, 则返回负整数
        如果当前对象 this 大于形参对象 obj, 则返回正整数

     */
    @Test
    public void test01(){
        String[] arr = new String[]{"aa","cc","kk","mm","gg","jj","dd"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
