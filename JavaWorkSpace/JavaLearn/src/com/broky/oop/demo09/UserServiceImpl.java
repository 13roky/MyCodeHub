package com.broky.oop.demo09;

//类可以实现接口 implements 接口
//实现了接口的类， 就需要重写接口中的方法

//多继承~利用接口实现多继承~
public class UserServiceImpl implements UserService, TimeService {

    public void add(String name) {
        System.out.println(name);
    }

    public void delete(String name) {
        System.out.println(name);
    }

    public void update(String name) {
        System.out.println(name);
    }

    public void query(String name){
        System.out.println(name);
    }

    public void time(){
        System.out.println("TimeService has runned");
    }

}