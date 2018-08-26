package org.westos.thread;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/15 10:54
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class TestCyclicBarrier {

    public static void main(String[] args) {
        // CyclicBarrier   可循环的 屏障(栅栏)
        // 当满足CyclicBarrier设置的线程个数时，继续执行，没有满足则等待
        //与倒计时锁的区别：倒计时锁只能使用一次，倒计时结束这个对象就没用了。
        //而循环栅栏可以重复利用。

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                System.out.println("线程1开始.."+new Date());
                try {
                    cyclicBarrier.await(); // 当个数不足时，等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1继续向下运行..."+new Date());
            }).start();
        }
    }
}
