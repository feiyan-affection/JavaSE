package org.westos.exception;

// 积极处理
public class Exception1 {
    public static void main(String[] args) {

        try {
            // 有可能出现异常的代码
            System.out.println(1111);
            int i = 1/0; /// 1

            int[] array = new int[3];
            System.out.println(array[3]); /// 2
            System.out.println(2222);
        } catch (ArithmeticException e) {
            // 捕获异常的代码
            System.out.println(3333);
        } catch (Exception e) {
            System.out.println(5555);
        }
        System.out.println(4444);
    }

    public static void test1(String[] args) {

        try {
            // 有可能出现异常的代码
            System.out.println(1111);
//            int i = 1/0;

            int[] array = new int[3];
            System.out.println(array[3]);
            System.out.println(2222);
        } catch (ArithmeticException  | ArrayIndexOutOfBoundsException e) {
            System.out.println(5555);
        }
        System.out.println(4444);
    }

    public static void test2() {
        try {
            int i = 1 / 0;
        } catch (ArithmeticException e) {

        }
    }

    public static void test3(){
        int i = 1/0;
    }
}
