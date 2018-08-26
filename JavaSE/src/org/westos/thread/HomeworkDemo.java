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
 * @Date: Created in 2018/8/12 9:01
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class HomeworkDemo {

    public static final Object OBJ = new Object();

    public static void main(String[] args) {

        // test3();

        // test4();

        // test5();

        // test6();

        //test7();

        // test8();

        test9();
    }

    @Test
    public void test1() {
        class Example implements Runnable {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }


        Example ex1 = new Example();
        Example ex2 = new Example();
        Example ex3 = new Example();
        ex1.run();
        ex2.run();
        ex3.run();
    }

    @Test
    public void test2() {
        class Example extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName());
                }

            }
        }

        Thread t = new Example();
        t.start();
//        t.start();
//        t.start();
    }


    public static void test3() {
        class Example extends Thread {

            private String data;

            public Example(String data) {
                this.data = data;
            }

            @Override
            public void run() {
                synchronized (OBJ) {
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep((int) (Math.random() * 1000));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread().getName() + " " + data);
                    }
                }
            }
        }


        Thread t1 = new Example("hello");
        Thread t2 = new Example("world");
        t1.start();
        t2.start();
    }


    public static void test4() {
        Number n1 = new Number();
        new Thread(() -> {
            n1.a();
        }).start();

        new Thread(() -> {
            n1.b();
        }).start();
    }

    public static void test5() {
        Number n1 = new Number();
        new Thread(() -> {
            n1.a();
        }).start();

        new Thread(() -> {
            n1.b();
        }).start();

        new Thread(() -> {
            n1.c();
        }).start();
    }

    public static void test6() {
        Number n1 = new Number();
        Number n2 = new Number();
        new Thread(() -> {
            n1.a();
        }).start();

        new Thread(() -> {
            n2.b();
        }).start();
    }

    public static void test7() {
        Number n1 = new Number();
        new Thread(() -> {
            n1.a();
        }).start();

        new Thread(() -> {
            n1.b();
        }).start();
    }

    public static void test8() {
        Number n1 = new Number();
        Number n2 = new Number();
        new Thread(() -> {
            n1.a();
        }).start();

        new Thread(() -> {
            n2.b();
        }).start();
    }


    public static void test9() {

        final Object obj = new Object();

        class T1 extends Thread {
            @Override
            public void run() {
                synchronized (obj) {
                    for (int i = 0; i < 100; i++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }
        new T1().start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        obj.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    for (int i = 0; i < 100; i++) {
                        System.out.print("#");
                    }
                    System.out.println();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (obj) {
                try {
                    obj.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < 100; i++) {
                    System.out.print("+");
                }
                System.out.println();
            }
        }).start();
    }
}


class Number {
    public synchronized static void a() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(1);
    }

    public synchronized void b() {
        System.out.println(2);
    }

    public void c() {
        System.out.println(3);
    }
}