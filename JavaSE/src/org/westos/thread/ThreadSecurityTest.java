package org.westos.thread;


/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/12 11:38
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：${description}
 */

class SaleStick extends Thread {

    public static int stick = 50;
    public static final Object OBJ = new Object();

    public SaleStick(String name){
        super(name);
    }

    @Override
    public void run() {
        synchronized (OBJ) {

            while (true) {
                if (stick > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出了"
                            + stick + "号票.");
                    stick--;

                    try {
                        OBJ.wait(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.println("卖完了。。。");
                    break;
                }
            }
        }

    }

}

public class ThreadSecurityTest {
    public static void main(String[] args) {
        SaleStick t1 = new SaleStick("1号窗口");
        SaleStick t2 = new SaleStick("2号窗口");
        SaleStick t3 = new SaleStick("3号窗口");

        t1.start();
        t2.start();
        t3.start();
    }
}
