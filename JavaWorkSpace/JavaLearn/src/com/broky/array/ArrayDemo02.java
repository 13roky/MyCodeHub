package com.broky.array;

public class ArrayDemo02 {
    public static void main(String[] args) {
        //静态初始化:创建+赋值    基本类型
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(a[0]);

        //动态初始化:包含默认初始化
        int[] b = new int[10];
        b[0] = 10;
        System.out.println(b[0]);

        //默认初始化:不赋值,会默认赋值
        int[] c = new int[10];
        System.out.println(c[0]);

    }
}
