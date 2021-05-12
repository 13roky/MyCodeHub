package com.broky.commonClass.exer;

import org.junit.jupiter.api.Test;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Objects;

/**
 * 四道常见String算法题目
 * 1. 模拟一个 trim 方法，去除字符串两端的空格。
 *
 * @author 13roky
 * @date 2021-05-08 10:06
 */
public class Algorithms {
    @Test
    public void testMyTrim() {
        String s1 = "   123   ";
        s1.trim();
        s1 = myTrim(s1);
        System.out.println(s1);
    }

    // 模拟一个 trim 方法，去除字符串两端的空格。
    public String myTrim(String str) {
        if (str != null) {
            int start = 0;// 用于记录从前往后首次索引位置不是空格的位置的索引
            int end = str.length() - 1;// 用于记录从后往前首次索引位置不是空格的位置的索引

            while (start < end && str.charAt(start) == ' ') {
                start++;
            }

            while (start < end && str.charAt(end) == ' ') {
                end--;
            }
            if (str.charAt(start) == ' ') {
                return "";
            }

            return str.substring(start, end + 1);
        }
        return null;
    }

    @Test
    public void testMyReverse() {
        System.out.println(myReverse01("abcdefg", 2, 5));
        System.out.println(myReverse02("abcdefg", 2, 5));
        System.out.println(myReverse03("abcdefg", 2, 5));
    }

    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为“abfedcg”
     */
    // 方式一：转换为char[]
    public String myReverse01(String str, int start, int end) {
        if (str != null) {
            char[] chars = str.toCharArray();
            char tmp = 0;
            for (int s = start, e = end; s < e; s++, e--) {
                tmp = chars[s];
                chars[s] = chars[e];
                chars[e] = tmp;
            }
            return new String(chars);
        }
        return null;
    }

    // 方式二：使用String的拼接
    public String myReverse02(String str, int start, int end) {
        if (str != null) {
            String partOne = str.substring(0, start);
            String parThree = str.substring(end + 1);
            for (int i = end; i >= start; i--) {
                partOne += str.charAt(i);
            }
            partOne += parThree;
            return partOne;
        }
        return null;
    }

    // 方式三：使用StringBuffer 或 StringBuilder 替换String
    public String myReverse03(String str, int start, int end) {
        StringBuilder builder = new StringBuilder(str.length());
        builder.append(str.substring(0, start));
        for (int i = end; i >= start; i--) {
            builder.append(str.charAt(i));
        }
        builder.append(str.substring(end + 1));
        return String.valueOf(builder);
    }

    /*
    获取一个字符串在另一个字符串中出现的次数。
    如：获取 "ab" 在 “abkkcakabkebfkabkskab” 出现的次数
     */
    @Test
    public void testGetCount() {
        getCount01("ab", "abkkcakabkebfkabkskab");
        getCount02("ab", "abkkcakabkebfkabkskab");
    }
    // 方法一：
    public int getCount01(String mainStr, String subStr) {
        int n = 0;
        for (int i = 0; i < subStr.length() - mainStr.length() + 1; i++) {
            if (mainStr.charAt(0) == subStr.charAt(i)) {
                if (mainStr.equals(subStr.substring(i, i + mainStr.length()))) {
                    n++;
                }
            }
        }
        System.out.println(n);
        return n;
    }
    // 方法二：
    public int getCount02(String mainStr, String subStr) {
        int count = 0;
        int index = 0;
        if (subStr.length() >= mainStr.length()) {
//            while ((index = subStr.indexOf(mainStr)) != -1) {
//                count++;
//                subStr = subStr.substring(index + mainStr.length());
//            }
            // 改进
            while ((index = subStr.indexOf(mainStr,index)) != -1) {
                count++;
                index += mainStr.length();
            }
            System.out.println(count);
            return count;
        } else {
            return 0;
        }
    }
}