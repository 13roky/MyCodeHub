package com.broky.oop.demo04;

public class Student {
    //属性私有
    private String name;
    private int age;//名字
    private  int id;        //学号
    private char sex;       //性别

    //提供一些可以操作这个属性的方法
    // 提供一些public的 get , set方法

    //get 获得这个数据

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>120||age<0){
            this.age = 3;
        }else {
            this.age = age;
        }
    }
}
