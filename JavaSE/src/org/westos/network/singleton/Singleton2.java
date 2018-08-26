package org.westos.network.singleton;
// 单例模式 (懒汉式单例)  刚开始不创建，第一次用到时才创建
public class Singleton2 {

    private Singleton2() {

    }

    private volatile static Singleton2 me; // null  设为volatile保证它的可见性


    // 潜在问题， 需要考虑线程安全, 可以使用synchronized来解决
    public static synchronized Singleton2 getInstance() { // 锁住了Singleton2.class
        // 先判断是不是第一次使用me（是否为null）
        if( me == null ) { // 线程1. null  // 线程2. null
            me = new Singleton2();
        }
        return me;
    }

    // double check 方式
    public static Singleton2 getInstance2() {
        if( me == null ) {
            // 优化，进一步缩小了synchronized的范围，仅在第一次调用getInstance2方法时才会同步
            synchronized (Singleton2.class) {
                if( me == null ) {
                    me = new Singleton2();
                }
            }
        }
        return me;
    }
}
