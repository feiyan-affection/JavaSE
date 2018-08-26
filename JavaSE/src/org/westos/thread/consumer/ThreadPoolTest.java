package org.westos.thread.consumer;

import java.util.concurrent.*;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/14 12:52
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description： 线程池
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ExecutorService workStealingPool = Executors.newWorkStealingPool();

        /*
        public ThreadPoolExecutor(int corePoolSize,
                                    int maximumPoolSize,
                                    long keepAliveTime,
                                    TimeUnit unit,
                                    BlockingQueue<Runnable> workQueue) {
               this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                    Executors.defaultThreadFactory(), defaultHandler);
        }
        */

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1,
                1, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2));

//        cachedThreadPool.submit(()->{
//            System.out.println(Thread.currentThread().getName() + "线程执行");
//        });
//
//        fixedThreadPool.submit(()->{
//            System.out.println(Thread.currentThread().getName() + "线程执行");
//        });
//
//        scheduledExecutorService.submit(()->{
//            System.out.println(Thread.currentThread().getName() + "线程执行");
//        });
//
//        workStealingPool.submit(()->{
//            System.out.println(Thread.currentThread().getName() + "线程执行");
//        });


        poolExecutor.submit(()->{
            System.out.println(Thread.currentThread().getName() + "线程执行");
        });

        poolExecutor.submit(()->{
            System.out.println(Thread.currentThread().getName() + "线程执行");
        });

        poolExecutor.submit(()->{
            System.out.println(Thread.currentThread().getName() + "线程执行");
        });

        poolExecutor.submit(()->{
            System.out.println(Thread.currentThread().getName() + "线程执行");
        });

    }
}
