package com.broky.exception;

import java.io.FileNotFoundException;

public class ThrowsEx {
    public static void throwsExTest() throws FileNotFoundException{
        throw new FileNotFoundException();
    }
    public static void main(String[] args) {
        try {
            ThrowsEx.throwsExTest();
            System.out.println();
        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }
    }
}
