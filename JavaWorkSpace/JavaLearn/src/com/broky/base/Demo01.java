package com.broky.base;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {

        int i = 0;
        
        int b = 0;

        Scanner scan = new Scanner(System.in);

        if(scan.hasNextInt()){

            System.out.println("test");
        }
        
        i = scan.nextInt();

        System.out.println(i);

        b = scan.nextInt();

        System.out.println(b);       

        scan.close();

    }
}
