package org.westos.iostream;

import java.io.FileOutputStream;

public class TestFileOutputStream {

    public static void main(String[] args) throws Exception{
        // 1.创建了输出流
        FileOutputStream fos = new FileOutputStream("2.txt");

        // 2. 向输出流写入内容
        // 一次写入一个字节
//        fos.write(97);
//        fos.write(98);
//        fos.write(99);

        // 覆盖原有内容  一次写入多个字节
//        fos.write(new byte[]{100,100,100,101});

        // 一次写入多个字节, 写入数组的一部分, off 代表下班, len 代表长度
        fos.write(new byte[]{100,100,100,101,102}, 0, 3 );

        // 3. 关闭输出流
        fos.close();
    }
}
