package com.broky.commonClass.exer;

import org.junit.jupiter.api.Test;

/**
 * StringBuffer 的常用方法
 *
 * @author 13roky
 * @date 2021-05-07 13:27
 */

public class StringBufferMethod {
    /*
    StringBuffer的常用方法:
    StringBuffer append(xx):提供了很多的 append()方法,用于进行字符拼接
    StringBuffer delete( int start, int end):删除指定位置的内容，本身发生改变，并返回值。
    StringBuffer replace( int start, int end, String str):把 start,end)位置替换为str
    StringBuffer insert( int offset,xxx):在指定位置插入xxx
    StringBuffer reverse():把当前字符序列逆转
    public int indexof(string str)
    pubLic String substring (int start, int end) 返回一个从Start开始到End结束的左闭右开区间的子字符串，本身值并未变化
    public int Length
    public char charAt(int n)
    public void setcharAt (int n, char ch)
    总结：
        增：append(xx)
        删：delete( int start, int end)
        改：setCharAt(int n,char ch) / replace( int start, int end, String str)
        查：charAt(int n)
        插：insert( int offset,xxx)
        长度：Length()
        遍历：for() + charAt() / toString()
    方法链的原理：s1.append().append().append(); s1调用完append后返回的依旧是s1，可以继续调用append
     */

    @Test
    public void test() {
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append("234");
        System.out.println(s1.delete(2, 4));
        System.out.println(s1);
        System.out.println(s1.replace(2, 4, "hello"));
        System.out.println(s1.reverse());

    }

}
