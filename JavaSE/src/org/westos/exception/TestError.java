package org.westos.exception;

import java.util.ArrayList;
import java.util.List;

public class TestError {

    private static List<String[]> list = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            list.add(new String[10000]);
        }
    }

    public  static void test(){

        test();

    }

}
