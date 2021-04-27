package com.broky.oop.demo04;
/*封装
1. 提高程序的安全性, 保护数据
2. 隐藏代码的实现细节
3. 统一接口
4. 提高系统的可维护性
 */
public class Application {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.setName("13roky");

        System.out.println(s1.getName());

        s1.setAge(999); // 非法值 可在setAge方法中写规则
        System.out.println(s1.getAge());

    }
}
