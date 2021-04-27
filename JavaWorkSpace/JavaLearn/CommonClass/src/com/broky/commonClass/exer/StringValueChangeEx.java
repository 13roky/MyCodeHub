package com.broky.commonClass.exer;

import java.util.Arrays;

/**
 * @author 13roky
 * @date 2021-04-26 7:27
 */
public class StringValueChangeEx {
    String str = new String("good");
    char[]  ch = {'t','e','s','t'};

    public void change(String str,char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringValueChangeEx test01 = new StringValueChangeEx();
        test01.change(test01.str, test01.ch);
        //这里涉及字符串的拼接,所以会用toString方法,而char中的toString返回的是哈希值,所以要用arrays类
        System.out.println(test01.str + " and " + Arrays.toString(test01.ch));   //good and [C@2f4d3709
        System.out.println(test01.str); //good
        System.out.println(test01.ch);  //test
    }
}
