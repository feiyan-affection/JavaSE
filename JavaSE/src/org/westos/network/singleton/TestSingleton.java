package org.westos.network.singleton;

public class TestSingleton {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);

        Singleton2 ss1 = Singleton2.getInstance();
        Singleton2 ss2 = Singleton2.getInstance();
        System.out.println(ss1 == ss2);
    }
}
