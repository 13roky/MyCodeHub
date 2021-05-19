package com.broky.Collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 13roky
 * @date 2021-05-18 7:11
 */
public class ListExer {
    @Test
    void test01(){
        ArrayList list = new ArrayList();
        //像list中存的数据是基本数据类型1234, 但实际上会将1234自动装箱, 以对象的形式存入list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //remove有两种使用方法 remove(int index) / remove(Object obj) 一个是List自己的,一个是Collection的
        //由于add添加的2是自动装箱后的对象, 但是remove不会自动装箱, 所以将2当成了index而不是obj, 因此remove(2)删除的是索引.
        list.remove(2);
        System.out.println(list);
        //这里因为形参是一个对象, 所以也就会匹配remove(Object obj), 删除list中相符的对象
        list.remove(new Integer(2));
        System.out.println(list);

    }
}
