package org.westos.iostream;

import java.io.File;

public class TestSeparator {

    public static void main(String[] args) throws InterruptedException {
        File file = new File("D:\\6.23实训班共享");
        File[] files = file.listFiles();
        for(File f: files) {
            System.out.println(f);
        }
        System.out.println("============================");
        File[] files2 = file.listFiles((dir, name) -> {
            if (name.startsWith("笔")) {
                return true;
            } else {
                return false;
            }
        });
        // lambda 语法格式: (方法参数)              -> { 方法体 }
        /*               (File dir, String name) -> {
                            if (name.startsWith("笔")) {
                                return true;
                            } else {
                                return false;
                            }
                         }

        */
        for(File f :files2) {
            System.out.println(f);
        }

        // 测试重命名和移动
        new File("D:\\6.23实训班共享\\测试.txt").renameTo(new File("c:\\测试2.txt"));

//        Thread.sleep(5000);
    }
}
