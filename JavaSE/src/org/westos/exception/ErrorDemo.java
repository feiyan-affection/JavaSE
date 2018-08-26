package org.westos.exception;

import java.util.*;

public class ErrorDemo {

    private static List<String[]> list = new ArrayList<>();

    public static void main(String[] args) {
        // test1();

        test2();
    }


    // java.lang.StackOverflowError 错误
    public static void test1(){
        test1();
    }


    // java.lang.OutOfMemoryError: Java heap space 错误
    public static void test2(){
        String[] strs = null;
        for (int i = 0; i < 10000; i++) {
           list.add(new String[1000000]);
        }
    }
}
