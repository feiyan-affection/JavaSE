package org.westos.exception;

public class Exception7 {

    public static void main(String[] args) throws Exception{
        a();
    }

    public static void a() throws Exception {
        b();
    }

    public static void b() throws Exception {
        c();
    }

    public static void c() throws Exception {
        d();
    }

    public static void d() {
        try {
            throw new Exception("检查异常...");
        } catch (Exception e) {
            // 将检查异常包装传递给未检查异常，保留原有的异常信息
            throw new RuntimeException(e);
        }
    }
}
