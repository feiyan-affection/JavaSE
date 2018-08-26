package org.westos.iostream;

import java.io.*;
import java.util.Arrays;

public class TestInputStreamReader {
    public static void main(String[] args) throws IOException {
        // 1. 将字节流转换为字符流
        FileInputStream fis = new FileInputStream("1.txt");
        // 注意:实际文件编码要与读取时的文件编码一致
        InputStreamReader reader = new InputStreamReader(fis, "utf-8");

        // 2. 读取
        /*while(true) {
            int c = reader.read();
            if(c == - 1) {
                break;
            }
            System.out.println((char)c);
        }*/
        while(true) {
            char[] buf = new char[1024];
            int len = reader.read(buf);
            if(len == -1) {
                break;
            }
            System.out.println(Arrays.toString(buf));
        }

        // 3. 关闭, 只需要关闭外层的流, 内部会帮我们关掉内层的流
        reader.close();
    }
}
