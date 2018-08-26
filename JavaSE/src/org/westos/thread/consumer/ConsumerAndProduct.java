package org.westos.thread.consumer;

import java.util.Random;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/12 16:37
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class ConsumerAndProduct {

    // 标记是否生产产品 true : 是      false : 否
    public static boolean flag = false;

    public static final Object OBJ = new Object();

    private static Product product = null;

    static class Producter extends Thread {

        @Override
        public void run() {
            synchronized (OBJ) {
                while (true) {
                    if (!flag) {

                        Fruit[] fruits = Fruit.values();
                        Random random = new Random();

                        product = new Product(fruits[random.nextInt(4)].toString(),
                                3.5*random.nextInt(4));

                        flag = true;
                        System.out.println("生产者生产了--" + product);
                        OBJ.notify();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            OBJ.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    static class Consumer extends Thread {
        @Override
        public void run() {
            synchronized (OBJ) {
                while (true) {
                    if (!flag) {
                        try {
                            OBJ.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("消费者消费了--" + product);
                        flag = false;
                        OBJ.notify();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Producter producter = new Producter();
        Consumer consumer = new Consumer();

        producter.start();
        consumer.start();

    }
}

enum Fruit{
    Apple, Banana, Peak, Grape
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " : " + price;
    }
}

