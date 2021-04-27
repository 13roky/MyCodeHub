package com.broky.test;

public class Demo02 {
    public static void main(String[] args) {
        String aa=String.format("%5d", 11).replace(" ", "0");//5代表总共是几位数
        System.out.println(aa);//输出结果00001
    }
}
