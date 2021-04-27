package com.broky.oop.demo01;

import java.io.IOException;

//Demo01类
public class Demo01 {
    //main方法
    public static void main(String[] args) {

    }

    /*
    修饰符  返回值类型  方法名(....){
        //方法体
        return 返回值;
    }
     */
    //return返回一个结果
    public String sayHello() {
        return "Hello,world.";
    }

    //默认返回值为空那么返回的就是空
    public void print(){
        return;
    }

    public int max(int a, int b) {
        return a > b ? a : b;   //三元运算符
    }

    //数组下标越界异常: Arrayindexoutofbounds
    public void readFile(String file) throws IOException{

    }
}
