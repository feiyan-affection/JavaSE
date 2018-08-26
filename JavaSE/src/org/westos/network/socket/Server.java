package org.westos.network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/15 13:34
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description： Server模型演示
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Waiting for connecting...");
            Socket accept = serverSocket.accept();
            SocketAddress acceptInetAddress = accept.getRemoteSocketAddress();
            System.out.println("Welcome " + acceptInetAddress + ".");
            while (true) {
                byte[] bytes = new byte[1024];
                InputStream inputStream = accept.getInputStream();
                int len = -1;
                while ((len = inputStream.read(bytes)) != -1) {
                    System.out.println(acceptInetAddress + " say :");
                    System.out.println(new String(bytes, 0, len));
                }


                System.out.println(InetAddress.getLocalHost() + " say :");
                String info = scanner.nextLine();
                accept.getOutputStream().write(info.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
