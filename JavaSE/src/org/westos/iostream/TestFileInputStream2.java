package org.westos.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestFileInputStream2 {
    public static void main(String[] args) throws IOException {
// 1. 创建输入流对象
FileInputStream fis = new FileInputStream(new File("1.txt"));

// 2. 一次读取多个字节
byte[] buf = new byte[2];
/*int len = fis.read(buf);// 将读到的内容填充到byte数组中,返回的是读到的字节总数, 返回-1还是表示读取完毕了
System.out.println(len);
System.out.println(Arrays.toString(buf));

len = fis.read(buf);
System.out.println(len);
System.out.println(Arrays.toString(buf));

len = fis.read(buf);
System.out.println(len);*/
while(true) {
    int n = fis.read(buf);
    if(n == -1) {
        break;
    }
    System.out.println(Arrays.toString(buf));
}
    }
}
