package org.westos.iostream;

public class TestPattern {

    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(1);
        Integer i2 = Integer.valueOf(1);

        System.out.println(i1 == i2);

        Integer i3 = Integer.valueOf(200);
        Integer i4 = Integer.valueOf(200);
        System.out.println(i3 == i4);

        // 享元 模式 ,节省内存的使用, 重复利用一些对象
        String a = "hello";
        String b = "hello";
    }
}
