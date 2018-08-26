package org.westos.network.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class Server2 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            ExecutorService threadPool = Executors.newCachedThreadPool();
            // 集合用来存储客户端的Socket和地址
            ConcurrentHashMap<Socket, SocketAddress> map = new ConcurrentHashMap<>();

            System.out.println("Waiting for connecting...");

            while (true) {
                Socket accept = serverSocket.accept();
                SocketAddress clientAddress = accept.getRemoteSocketAddress();
                System.out.println(clientAddress + " is connected!");
                map.put(accept, clientAddress);

                // 线程池利用多线程处理多用户的任务请求
                threadPool.submit(() -> {
                    try {
                        InputStream inputStream = accept.getInputStream();
                        SocketAddress address = accept.getRemoteSocketAddress();

                        int len = -1;
                        byte[] bytes = new byte[1024];
                        while ((len = inputStream.read(bytes)) != -1) {
                            for (Socket clientSocket : map.keySet()) {
                                //if(clientSocket.equals(accept)){
                                OutputStream outputStream = clientSocket.getOutputStream();
                                outputStream.write(new String(map.get(clientSocket) + " say:").getBytes());
                                outputStream.write(bytes, 0, len);
                                //}
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
