package com.broky.array;

//123321是一个非常特殊的数，它从左边读和从右边读是一样的。
//输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n。

import java.util.Scanner;

public class Test {

    public static void checkPalindromeNum(int n){
        int sum;

        // 五位数
        System.out.println("所要求的的五位回文数为: ");
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if ((i+j)*2+k==n) {
                        sum = i * 10000 + j * 1000 + k * 100 + j;
                        System.out.print(sum+"\t");
                    }
                }
            }
        }

        System.out.println("\n所要求的六位回文数为: ");
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if((i+j+k)*2==n){
                        sum=i*100000+j*10000+k*1000+k*100+j*10+i;
                        System.out.print(sum+"\t");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n % 2 == 1) {
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j <= 9; j++) {
                    int m = n - (2 * i) - (2 * j);
                    if (m <= 9) {
                        System.out.print(i + j + m + j + i);
                    }
                    System.out.println();
                }
            }

        }*/
        System.out.println("请输入一个整数: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        checkPalindromeNum(num);
    }
}