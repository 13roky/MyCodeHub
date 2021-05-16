package com.broky.EnumClass;

import org.ietf.jgss.Oid;

import java.util.ArrayList;

/**
 * @author 13roky
 * @date 2021-05-14 8:16
 */
public class AnnotationTest {
    @MyAnnotation()
    @MyAnnotation()
    void test(){

    }
}

// 在自定义注解的@Target中加入参数TYPE_PARAMETER
class Generic<@MyAnnotation T>{
    // 在自定义注解的@Target中加入参数TYPE_USE
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10L;
    }
}