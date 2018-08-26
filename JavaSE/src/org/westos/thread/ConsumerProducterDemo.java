package org.westos.thread;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/12 15:05
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
enum Fruit {
    Apple, Group, Banana, malean
}

class Storage {
    LinkedBlockingQueue<Product> queue = new LinkedBlockingQueue<>(10);

    /**
     * 生产产品
     *
     * @param p
     * @throws InterruptedException
     */
    public void push(Product p) throws InterruptedException {
        queue.put(p);
    }

    /**
     * 消费产品
     *
     * @param
     * @return
     * @throws InterruptedException
     */
    public Product pop() throws InterruptedException {
        return queue.take();
    }

}

class Product {
    private String name;
    private double price;

    public Product(double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " : " + price;
    }
}

class Productor implements Runnable {
    private String username;
    private Storage s = null;

    public Productor(String username, Storage s) {
        this.username = username;
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Random random = new Random();
                Fruit[] fruits = Fruit.values();

                Product product = new Product(
                        2.5*random.nextInt(5));
                s.push(product);
                System.out.println("生产者--" + username +"生产了--" + product);

                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private String username;
    private Storage s = null;

    public Consumer(String username, Storage s) {
        this.username = username;
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Product product = s.pop();

                System.out.println("消费者--" + username + "消费了--" + product);

                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ConsumerProducterDemo {

    public static void main(String[] args) {

        Storage storage = new Storage();
        Productor productor = new Productor("张三", storage);
        Consumer consumer = new Consumer("李四", storage);

        new Thread(productor).start();
        new Thread(consumer).start();

    }
}
