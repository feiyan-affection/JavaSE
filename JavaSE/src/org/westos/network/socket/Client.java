package org.westos.network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
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
 * @Date: Created in 2018/8/15 14:01
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.10.123", 8888);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println(InetAddress.getLocalHost() + " say:");
                String info = scanner.nextLine();
                socket.getOutputStream().write(info.getBytes());

                System.out.println(socket.getRemoteSocketAddress() + " say :");
                byte[] bytes = new byte[1024];
                InputStream inputStream = socket.getInputStream();
                int len = -1;
                while ((len = inputStream.read(bytes)) != -1) {
                    System.out.println(new String(bytes, 0, len));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
