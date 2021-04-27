package com.broky.array;

public class ArrayDemo05 {
    public static void main(String[] args) {
        //二维数组就相当于多个一维数组的嵌套
        /*array是一个4行2列的数组, array[行][列]
            1,2
            2,3
            3,4
            4,5
         */
        int[][] array = {{1,2},{2,3},{3,4},{4,5}};

        printArray(array[0]);
        System.out.println(array.length);
        //输出4的原因是二维数组就相当于多个一维数组的嵌套.
        //{{1,2},{2,3},{3,4},{4,5}}的外层只存放了四个一维数组分别为{1,2},{2,3},{3,4},{4,5}
        //在其一位数组中又存放了数
        //因此输出为4

    }

    public static void printArray(int[] arrays) {
        //普通for循环遍历数组
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i]+" ");
        }
        System.out.println();
    }
}
