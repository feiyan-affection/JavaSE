package org.westos.exception;

import java.util.Scanner;

// 有返回值的方法 与  try-catch连用出现的问题
public class Exception5 {
    public static int test(){
        try {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int r = 1/n;
            return r;
        } catch (Exception e ) {
            System.out.println(e.getMessage());
            return -1; // 解决方法1: 在catch也写一个return返回结果
//            throw e; // 解决方法2: 把异常重新抛出
        }
    }

    public static void main(String[] args) {
        int r = test();
        System.out.println(r);
    }
}
