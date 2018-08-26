package org.westos.iostream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/8 10:30
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description： File文件API测试
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {
        // test1();

        // File file = new File("C:\\Users\\Administrator\\Desktop\\a\\b\\c");
        // test2(file);

        // test3();

        // test4();

        test5();
    }

    /**
     * 文件的读写
     * @throws IOException
     */
    public static void test1() throws IOException {
        File dir = new File("C:\\Users\\Administrator\\Desktop\\a\\b\\c");
        if (!dir.exists()) {
            dir.mkdirs();
        }


        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.getName().equals("1.txt")) {
                FileOutputStream out = new FileOutputStream(f);
                java.lang.String info = "beautiful girls, i love you.";
                out.write(info.getBytes(), 0, info.getBytes().length);
                out.close();
            }
        }

        for (File f : files) {
            if (f.getName().equals("1.txt")) {
                FileInputStream in = new FileInputStream(f);
                int len = 0;
                byte[] bytes = new byte[1024];
                len = in.read(bytes);
                System.out.println(new String(bytes, 0, len));
                in.close();
            }
        }

    }

    /**
     * 递归列出目录下的所有文件
     * @param file
     */
    public static void test2(File file) {

        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                test2(f);
            }

            if (f.isFile()) {
                System.out.println(f);
            }
        }
    }

    /**
     * 文件的复制
     */
    public static void test3() {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            String filePath = "C:\\Users\\Administrator\\Desktop\\a\\b\\c\\";
            in = new FileInputStream(new File(filePath.concat("1.txt")));
            out = new FileOutputStream(new File(filePath.concat("3.txt")));

            int len = -1;
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 利用JDK的API复制文件
     */
    public static void test4() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\a\\b\\c\\";
        String sour = filePath.concat("1.txt");
        String dest = filePath.concat("4.txt");

        try {
            Files.copy(Paths.get(sour), Paths.get(dest));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 复制一份视频
     */
    public static void test5(){
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(new File(
                    "C:\\Users\\Administrator\\Desktop\\JavaSE\\排序视屏示例\\舞动的排序算法 冒泡排序.flv"));
            out = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\movie.mp4"));

            int len = -1;
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
