package org.westos.network.singleton;

// 懒汉式单例，更优雅的写法 effective java
public class Singleton3 {

    private Singleton3() {
        System.out.println("Singleton3 构造方法被调用");
    }

    private static class Holder {
        private static Singleton3 ME = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return Holder.ME;
    }
    public static void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        Singleton3 s1 = Singleton3.getInstance();
        Singleton3 s2 = Singleton3.getInstance();
        System.out.println(s1 == s2);
    }
}
