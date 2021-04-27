package com.broky.exception.customExceptions;

public class MyException extends RuntimeException{
    static final long serialVersionUID = -1234719074324978L;

    public MyException(){

    }

    public MyException(String message){
        super(message);
    }

    public static void main(String[] args) {
        throw new MyException("自定义运行时异常");
        /*Exception in thread "main" com.broky.exception.MyException: 自定义运行时异常
        at com.broky.exception.MyException.main(MyException.java:15)*/
    }
}
