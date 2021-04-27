package com.broky.array;

import java.util.Arrays;

//稀疏数组
public class ArrayDemo08 {
    public static void main(String[] args) {

        //1.创建一个二维数组 11*11 0:没有棋子 1:黑棋 2:白棋
        System.out.println("1.创建一个二维数组:");
        int[][] array1 = new int[11][11];
        //为数组赋值
        array1[1][2] = 1;
        array1[2][3] = 2;
        int sum = 0;    //记录有效数据个数

        //foreach遍历数组并将其打印
        for (int[] ints : array1) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
                //记录有效数据出现的次数
                if (anInt != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.println("=================================================");

        //2.转化成稀疏数组
        System.out.println("2.将创建的数组转化为稀疏数组:");
        //创建稀疏数组
        int[][] array2 = new int[sum + 1][3];
        array2[0][0] = 11;
        array2[0][1] = 11;
        array2[0][2] = sum;

        //记录有效数据存在稀疏数组的行数
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i][j] != 0) {
                    count++;
                    array2[count][0] = i;
                    array2[count][1] = j;
                    array2[count][2] = array1[i][j];
                }
                //优化遍历
                if (count == sum) {
                    break;
                }
            }
            //优化遍历
            if (count == sum) {
                break;
            }
        }
        //打印稀疏数组
        for (int[] ints : array2) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        System.out.println("=================================================");

        //3.将稀疏数组再转化回二维数组
        System.out.println("3.将稀疏数组转化为二维数组");
        //创建用于返回的数组
        int[][] array3 = new int[array2[0][0]][array2[0][1]];
        //遍历稀疏数组并将其中的有效值还原
        for (int i = 1; i < array2.length; i++) {
            array3[array2[i][0]][array2[i][1]] = array2[i][2];
        }

        //打印还原后的二维数组
        for (int[] ints : array3) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        //Arrays.equals只能比较一维数组
        int[] arr1 = new int[11];
        int[] arr2 = new int[11];
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("Arrays.equals只能比较一维数组");
        } else {
            System.out.println("Arrays.equals只能比较一维数组");
        }
        //arr.equal则不能比较数组
        if (arr1.equals(arr2)) {
            System.out.println("arr1.equals不能比较数组");
        } else {
            System.out.println("arr1.equals不能比较数组");
        }

        //综上, 二维数组的比较需要自己写方法.

    }
}