package org.westos.thread;

import java.util.concurrent.Semaphore;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/15 10:58
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：${description}
 */
public class TestSemaphore {

    public static void main(String[] args) {
        // 限制了能同时运行的线程上限
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("我是线程" + Thread.currentThread().getName());

                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }).start();
        }
    }
}
