package org.westos.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream1 {

    // 测试文件输入流,读取外部文件的内容
    public static void main(String[] args) throws IOException {
        // 1. 创建输入流对象
        FileInputStream fis = new FileInputStream(new File("1.txt"));
//        FileInputStream fis = new FileInputStream("1.txt")

        // 2. 读取内容
        /*int read = fis.read();// 一次读取一个字节, 返回int中只用了一个字节
        System.out.println((char)read);
        read = fis.read();
        System.out.println((char)read);
        read = fis.read();
        System.out.println((char)read);
        read = fis.read();
        System.out.println(read);*/
        while(true) {
            int read = fis.read();
            if(read == -1) {
                break;
            }
            System.out.println(read);
        }
    }
}
