package com.broky.array;

import java.util.Arrays;

public class ArrayDemo06 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 9090, 31231, 543, 21, 3, 23};

        System.out.println(a); //打印出了哈希值[I@16b98e56

        //通过Arrays的同String方法打印数组元素
        System.out.println(Arrays.toString(a));

        //Arrays的sort排序方法
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        //Arrays的fill填充方法
        Arrays.fill(a, 2, 4, 0);
        System.out.println(Arrays.toString(a));

        //Arrays的其他方法自行百度
    }
}
