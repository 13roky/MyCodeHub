package com.broky.array;

import java.util.Arrays;

public class ArrayDemo07 {
    public static void main(String[] args) {

        int[] array = {5,4,3,2,1};
        array = sort(array);

        System.out.println(Arrays.toString(array));
    }

    //冒泡排序
    //1.比较数组中,两个相邻的元素,如果第一个比第二个数大,我们就调换他们的位置
    //2.每一次比较都会产生一个最大,或者最小的数字;
    //3.下一轮则可以少一次排序
    //4.依次循环直到结束
    public static int[] sort(int[] arr){
        //临时变量
        int temp = 0;
        boolean flag = false;   //通过flag标识位减少没有意义的比较
        //外层循环,判断我们这个要走多少次
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环,比较判断两个数, 如果第一个数比第二个数字大.则交换位置
            //内层循环没进行一个回合,数组中最大的数都会被排到最后,可使用debug观察数组变化情况
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                    //只要flag为true说明进入了这个if语句进行了比较
                    //如果flag为flase那么说明没有进入if语句,也就说明已经是排好序的了
                }

                if(!flag){
                    break;
                }
            }
        }
        return arr;
    }

}
