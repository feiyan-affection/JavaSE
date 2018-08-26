package org.westos.thread.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/14 10:11
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class ProductTest {

    private static List<Productss> productsses = new ArrayList<>();

    private static Random random = new Random();

    public static BlockingQueue<Productss> blockingQueue = new ArrayBlockingQueue<Productss>(10);

    public static void main(String[] args) {

        /*
        // 生产者
        new Thread(() -> {
            synchronized (productsses) {
                while (true) {
                    while (productsses.size() >= 5) {
                        try {
                            System.out.println("生产者在等待...");
                            productsses.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Productss p = new Productss();
                    productsses.add(p);
                    System.out.println(Thread.currentThread().getName() + "生产者生产了" + p);
                    productsses.notifyAll();
                }
            }
        }).start();


        for (int i = 0; i < 10; i++) {
            // 多个消费者并发
            new Thread(() -> {
                synchronized (productsses) {
                    while (true) {
                        while (productsses.size() == 0) {
                            try {
                                System.out.println(Thread.currentThread().getName() + "在等待...");
                                productsses.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        try {
                            Thread.sleep(random.nextInt(500));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Productss p = productsses.remove(0);
                        System.out.println(Thread.currentThread().getName() + "消费者消费了" + p);
                        productsses.notifyAll();
                    }
                }
            }).start();
        }
        */

        new Thread(()->{
            while (true){
                if(blockingQueue.isEmpty()){
                    Productss product = new Productss();
                    System.out.println(Thread.currentThread().getName() + "生产了" + product);
                    blockingQueue.offer(product);
                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    if(blockingQueue.size() > 0){
                        try {
                            Productss product= blockingQueue.take();
                            System.out.println(Thread.currentThread().getName() + "消费了" + product);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}


enum Eat {
    Apple, grape, noddles, meat
}

class Productss {

    private Random random = new Random();

    private Eat[] eat = Eat.values();

    private String name;

    public Productss() {
        name = eat[random.nextInt(4)].toString();
    }

    @Override
    public String toString() {
        return "Productss{" +
                "name='" + name + '\'' +
                '}';
    }
}
