package com.broky.array;

public class ArrayDemo03 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};

        //打印全部数组元素
        System.out.println("打印全部数组元素:");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("----------------------");

        //计算所有数组的和
        System.out.println("计算所有数组的和:");
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        System.out.println(sum);
        System.out.println("------------------------");

        //查找最大数组
        System.out.println("查找最大数组:");
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        System.out.println(max);
    }
}
