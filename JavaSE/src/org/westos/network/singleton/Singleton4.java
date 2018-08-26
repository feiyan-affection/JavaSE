package org.westos.network.singleton;

// 饿汉式
public enum Singleton4 {

    ME;

    private Singleton4(){
        System.out.println("Singleton4 的构造方法被调用");
    }

    public static void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        Singleton4.test();
    }
}
