package com.broky.array;

public class ArrayDemo01 {
    public static void main(String[] args) {
        int[] nums;     //1.声明一个数组,Java标准语法
        int nums2[];    //C和C++风格,在java初期为了让C和C++程序员快速熟悉java而存在.

        nums = new int[10];     //2.创建一个数组 这里面可以存放十个int类型的数字

        //3.给数组元素中赋值,注意数组从第0个开始数起
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = i + 1;
        }

        System.out.println(nums[8]);
        System.out.println(nums[9]);    //不赋值的地方是类型的默认值,这里是0

        //计算所有元素总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        System.out.println("总和为" + sum);

    }
}
