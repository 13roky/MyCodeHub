package com.broky.oop.demo01;

public class Demo03 {
    public static void main(String[] args) {
        // 非静态方法如是调用
        // new Demo03().add(a,b);

        //当为静态方法时可直接调用
        Demo03.add(1,3);
    }

    public static int add(int a,int b){
        return a+b;
    }
}
