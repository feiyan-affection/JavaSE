package org.westos.network.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/15 14:16
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class Client2 {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.10.123", 8888);
            Scanner scanner = new Scanner(System.in);
            new Thread(() -> {
                try {
                    byte[] bytes = new byte[1024];
                    InputStream inputStream = socket.getInputStream();
                    int len = -1;
                    while ((len = inputStream.read(bytes)) != -1) {
                        System.out.println(new String(bytes, 0, len));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            while (true) {
                System.out.println(InetAddress.getLocalHost() + " say:");
                String info = scanner.nextLine();
                socket.getOutputStream().write(info.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
