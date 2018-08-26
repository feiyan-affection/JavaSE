package org.westos.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/15 11:04
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：${description}
 */
public class TestReentrantLock {

    private static int NUM = 10;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{

                try {
                    reentrantLock.lock();
                    NUM++;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }

                System.out.println(NUM);

            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(()->{

                try {
                    reentrantLock.lock();
                    NUM--;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }

                System.out.println(NUM);

            }).start();
        }
    }
}
