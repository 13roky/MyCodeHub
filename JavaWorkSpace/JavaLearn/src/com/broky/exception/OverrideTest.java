package com.broky.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverrideTest {
    public void display(SuperClass s) {
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OverrideTest overrideTest = new OverrideTest();
        overrideTest.display(new SubClass());
    }
}

class SuperClass {
    public void method() throws IOException {
        System.out.println("super");
    }
}

class SubClass extends SuperClass {
    public void method() throws FileNotFoundException {
        System.out.println("sub");
    }
}
