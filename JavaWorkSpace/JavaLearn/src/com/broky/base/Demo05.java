package com.broky.base;

public class Demo05 {

    public static int num(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * num(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(num(5));

    }
}
