package org.westos.exception;

// 异常的传播方向与方法的调用方向相反
public class Exception4 {

    public static void main(String[] args) {
        System.out.println(1);
        c();
        System.out.println(2);
    }
    public static void c() {
        System.out.println(3);
        b();
        System.out.println(4);
    }
    public static void b() {
        System.out.println(5);
        try {
            a();
        } catch (Exception e) {

        }
        System.out.println(6);
    }
    public static void a() {
        System.out.println(7);
        throw new RuntimeException("最初的异常");
    }


}
