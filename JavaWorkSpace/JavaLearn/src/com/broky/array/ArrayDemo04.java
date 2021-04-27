package com.broky.array;

public class ArrayDemo04 {
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5};

        //for-Each循环
        //arrays.for快捷操作
        //JDK1.5之后才增加对增强型for的支持
        System.out.println("for-Each循环:");
        for (int n : arrays) {
            System.out.println(n);
        }
        System.out.println("---------------------------");

        //作为方法导入
        System.out.println("作为方法导入数组:");
        printArray(arrays);
        System.out.println("----------------------------");

        ///反转数组
        System.out.println("反转数组:");
        printArray(reverse(arrays));

    }

    //作为方法导入
    public static void printArray(int[] arrays) {
        //普通for循环遍历数组
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

    //反转数组,数组作为返回值

    public static int[] reverse(int[] arrays) {
        int[] result = new int[arrays.length];

        //反转操作
        for (int i = 0, j = arrays.length - 1; i < arrays.length; i++, j--) {
            result[i] = arrays[j];
        }

        return result;
    }
}
