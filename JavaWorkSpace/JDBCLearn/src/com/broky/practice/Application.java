package com.broky.practice;

public class Application {
    public static void main(String[] args) {
        JdbcUtilsPractice.ExecUpdate("insert into users(id,name,password)" +
                "values('4','testInsert','12345678')");

        // JdbcUtilsPractice.ExecUpdate("UPDATE users SET `name`='13roky1',`email`='215029692@qq.com' WHERE id=4");

        // JdbcUtilsPractice.ExecUpdate("delete from users where id=4");
    }
}
