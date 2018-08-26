package org.westos.iostream;

import java.io.File;

public class TestRelativePath {

    public static void main(String[] args) {
        // 绝对路径
        File file = new File("D:\\6.23实训班共享\\代码\\Day16-IO\\1.txt");

        System.out.println(file.exists());

        System.out.println(System.getProperty("user.dir")); // 当前目录
        File file2 = new File("1.txt"); // 相对路径
        System.out.println(file2.exists());
        System.out.println(file2.getAbsoluteFile());

    }
}
