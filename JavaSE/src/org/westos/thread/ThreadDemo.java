package org.westos.thread;

import org.junit.Test;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/11 9:43
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description： 多线程的创建
 */
public class ThreadDemo {

    public static int COUNT = 0;
    public static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {


    }

    @Test
    public void test1() {
        new MyThread1().start();
    }

    @Test
    public void test2() throws InterruptedException {

        final Object obj = new Object();

        Thread thread1 = new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    synchronized (obj) {
                        COUNT++;
                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (obj) {
                        COUNT--;
                    }
                }
            }
        };

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(COUNT);
    }


    @Test
    public void test3() throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (flag) {
                i++;
                System.out.println(i);
            }
        }).start();

        Thread.sleep(2000);
        flag = false;
    }


    @Test
    public void test4() {

        Object A = new Object();
        Object B = new Object();

        new Thread(() -> {
            synchronized (A) {
//                try {
                    System.out.println(Thread.currentThread().getName() + "跑啊跑啊跑啊跑...");
//                    A.notify();
//                    A.wait();

                    synchronized (B) {
                        System.out.println(Thread.currentThread().getName() + "有电线，没电脑...");
                        B.notify();
                    }

//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();

        new Thread(() -> {
            synchronized (B) {
//                try {
                    System.out.println(Thread.currentThread().getName() + "跑啊跑啊跑啊跑...");
//                    B.notify();
//                    B.wait();

                    synchronized (A) {
                        System.out.println(Thread.currentThread().getName() + "有电脑，没电线...");
                        A.notify();
                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {

            if (i == 100) {
                try {
                    Thread.sleep(6000);
                    MyThread2 myThread2 = new MyThread2();
                    myThread2.start();
                    myThread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + i);
            System.out.print("妈妈在做蛋炒饭。。。");
            System.out.println("");
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            System.out.print("我来了。。。");
        }
    }
}

