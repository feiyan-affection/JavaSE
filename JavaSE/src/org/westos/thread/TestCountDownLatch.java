package org.westos.thread;

import org.westos.collection.utils.CollectionUtilsDemo;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/15 9:54
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：${description}
 */
public class TestCountDownLatch {


    private static String arr[] = new String[10];
    private static Random random = new Random();

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j <= 100; j++) {
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (arr) {
                        arr[finalI] = j + "%";
                        System.out.print("\r" + Arrays.toString(arr));
                    }
                }
                countDownLatch.countDown();
            }).start();
        }


    }
}
