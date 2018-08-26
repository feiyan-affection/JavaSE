package org.westos.network.singleton;
// 单例模式 (饿汉式单例)
public class Singleton {
    // 1. 把构造方法变为私有，这样就限制了其它类创建Singleton的实例
    private Singleton(){

    }

    // 2. Singleton类自己创建唯一的一个实例
    private static Singleton me = new Singleton();

    // 3. 提供一个公共方法返回此唯一实例
    public static Singleton getInstance() {
        return me;
    }
}
