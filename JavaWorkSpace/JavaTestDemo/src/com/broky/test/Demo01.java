package com.broky.test;

/*
123321是一个非常特殊的数，它从左边读和从右边读是一样的。
输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n。
*/

import java.util.Scanner;

public class Demo01 {

    public static void checkPalindromeNum(int n){
        String s;

        // 五位数
        System.out.println("所要求的的五位回文数为: ");
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if ((i+j)*2+k==n) {
                        // 零填充
                        s = Integer.toString(i)+Integer.toString(j)+Integer.toString(k)+Integer.toString(j)+Integer.toString(i);
                        System.out.print(s+"\t");
                    }
                }
            }
            if(2*i==n){
                break;
            }
        }

        // 六位数
        System.out.println("\n所要求的六位回文数为: ");
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if((i+j+k)*2==n){
                        // 零填充
                        s = Integer.toString(i)+Integer.toString(j)+Integer.toString(k)+Integer.toString(k)+Integer.toString(j)+Integer.toString(i);
                        System.out.print(s+"\t");
                    }
                }
            }
            if(2*i==n){
                break;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("请输入一个整数: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        checkPalindromeNum(num);

    }
}