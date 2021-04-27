package com.broky.exception.practice;

/*
编写应用程序 EcmDef java,接收命令行的两个参数,要求不能输入负数,计算两数相除对数据类型不一致( Number FormatException)、
缺少命令行参数(ArraylndexOutofBounds Exception、除0( Arithmetic EXception)及输入负数( EcDef自定义的异常)进行异常处理。
        提示:
        (1)在主类( EcmDef)中定义异常方法(ecm)完成两数相除功能。
        (2)在man(方法中使用异常处理语句进行异常处理
        (3)在程序中,自定义对应输入负数的异常类( EcDef)。
        (4)运行时接受参数 java EcmDef2010∥args[0]=“20“ args[1]=”10“
        (5) Interger类的 static方法 parseInt( String s)将s转换成对应的int值
*/
public class EcmDef {
    public static int ecm(int a, int b) throws EcDef, ArithmeticException {
        if (a < 0 || b < 0)
            throw new EcDef("输入的数据小于0");
        if (b == 0)
            throw new ArithmeticException("除数不能等于0");
        return a / b;
    }

    public static void main(String[] args) {
        int a = 0;
        int b = 0;

        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);

            System.out.println(ecm(a, b));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (EcDef ecDef) {
            ecDef.printStackTrace();
        }

    }
}
