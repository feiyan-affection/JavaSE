package org.westos.exception;

public class Exception3 {

    public static void m1(int n) {
        if(n <= 0 ){
            // 主动产生一个异常
//            int[] a = new int[10];
//            System.out.println(a[11]);
            throw new RuntimeException("n必须大于0");
        }
        System.out.println("执行计算");
    }

    public static void main(String[] args) {
        try {
            m1(0);
        } catch (RuntimeException e) { // e异常对象
//            System.out.println(e);
//            System.out.println(e.getMessage()); // 获取异常信息
            e.printStackTrace(); // 打印异常的跟踪链信息
        }
    }
}
