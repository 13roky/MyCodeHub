package com.broky.oop.demo09;
//抽象的思维~ Java

//interface 定义关键字，接口都需要有实现类
public interface UserService {
    //接口中定义的属性都是常量，一般没人在接口中定义常量
    int AGE = 99;
    //接口中的所有定义其实都是抽象的 如果不写那么默认和 public abstract的
    void add(String name);    //与public abstract void run()相似
    void delete(String name);
    void update(String name);
    void query(String name);

}