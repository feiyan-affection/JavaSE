package org.westos.exception;

public class MyException1 extends Exception{

    //  可以从构造方法传递一个异常信息
    public MyException1(String message) {
        super(message);
    }

    // 可以从构造方法传递一个异常信息, 原始的异常对象
    public MyException1(String message, Throwable cause) {
        super(message, cause);
    }

    public static void main(String[] args) {
        try {
            throw new MyException1("自定义的异常信息");
        } catch (MyException1 myException1) {
            // 吞掉异常
            myException1.printStackTrace();
        }
    }
}
