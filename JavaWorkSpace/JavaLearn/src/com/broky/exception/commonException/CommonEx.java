package com.broky.exception.commonException;

import java.util.Scanner;

public class CommonEx {
    static void ArithmeticExceptionDemo(){
        int a = 10;
        int b = 0;
        int c = a / b;
        /*Exception in thread "main" java.lang.ArithmeticException: / by zero
        at com.broky.exception.ArithmeticEx.main(ArithmeticEx.java:7)*/
    }

    static void ClassCastExceptionDemo(){
        Object obj = new Double(1);
        String str = (String)obj;
        /*Exception in thread "main" java.lang.ClassCastException: class java.lang.Double cannot be cast to class java.lang.String (java.lang.Double and java.lang.String are in module java.base of loader 'bootstrap')
        at com.broky.exception.ClassCastEx.main(ClassCastEx.java:7)*/
    }

    static void InputMismatchExceptionDemo(){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println(num);
        /*asd
        Exception in thread "main" java.util.InputMismatchException
        at java.base/java.util.Scanner.throwFor(Scanner.java:939)
        at java.base/java.util.Scanner.next(Scanner.java:1594)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        at com.broky.exception.InputMismatchEx.main(InputMismatchEx.java:8)*/
    }

    static void NullPointerExceptionDemo(){
        int[] arr = null;
        System.out.println(arr[3]);

        /*Exception in thread "main" java.lang.NullPointerException: Cannot load from int array because "arr" is null
        at com.broky.exception.NullPointerEx.main(NullPointerEx.java:6)*/
    }

    static void NumberFormatExceptionDemo(){
        String str = "abc";
        int a = Integer.parseInt(str);
        /*Exception in thread "main" java.lang.NumberFormatException: For input string: "abc"
        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        at java.base/java.lang.Integer.parseInt(Integer.java:660)
        at java.base/java.lang.Integer.parseInt(Integer.java:778)
        at com.broky.exception.NumberMismatchEx.main(NumberMismatchEx.java:6)*/
    }

    static void ArrayIndexOutOfBoundExceptionDemo(){
        int[] arr = new int[3];
        System.out.println(arr[3]);
        /*Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
        at com.broky.exception.XIndexOutOfBoundEx.main(XIndexOutOfBoundEx.java:6)*/

        String str = "abc";
        System.out.println(str.charAt(3));
        /*Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 3
        at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:48)
        at java.base/java.lang.String.charAt(String.java:711)
        at com.broky.exception.XIndexOutOfBoundEx.main(XIndexOutOfBoundEx.java:11)*/
    }

    public static void main(String[] args) {
        ArrayIndexOutOfBoundExceptionDemo();
    }
}
