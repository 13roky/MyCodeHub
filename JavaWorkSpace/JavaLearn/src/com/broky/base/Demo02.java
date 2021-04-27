package com.broky.base;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        double sum = 0.0;       //用于计算总和

        int i = 0;              //计算输入的多少个数字

        //通过循环判断是否还有输入,并在里面对每一次进行求和统计
        while (scanner.hasNextDouble()) {
            
            sum = sum + scanner.nextDouble();

            sum++;
            i++;

        }

        scanner.close();

        System.out.println(sum);
        System.out.println(i);

    }
}
