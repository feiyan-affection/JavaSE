package org.westos.exception;

public class MyException2 extends RuntimeException { // 未检查异常


    public MyException2(String message) {
        super(message);
    }


    public static void main(String[] args) {
        throw new MyException2("自定义的异常");
    }
}
