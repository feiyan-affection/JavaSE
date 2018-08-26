package org.westos.iostream;


import java.io.*;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/10 9:30
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class TestBufferedStream {

    public static void main(String[] args) {

        // test1();

        // testSerializable();

        // testConle();

        testPrintWrite();
    }

    /**
     * 复制文件
     */
    public static void test1(){

        long start = System.currentTimeMillis();
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(
                    "C:\\Users\\Administrator\\Desktop\\JavaSE\\排序视屏示例\\舞动的排序算法 选择排序.flv"));

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(
                    "C:\\Users\\Administrator\\Desktop\\a\\b\\c\\selectSort.mov"));

            int len = -1;
            byte[] bytes = new byte[1024];
            while ((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes, 0, len);
                bufferedOutputStream.flush();
            }

            System.out.println("Copy files Successfully.");

            bufferedInputStream.close();
            bufferedOutputStream.close();

            long end = System.currentTimeMillis();
            System.out.println("cost times " + (end - start) / 1000 + " seconds");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 序列化测试
     */
    public static void testSerializable(){

        Student s1 = new Student("jack", 18);
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(
                    "src/org/westos/iostream/student.obj"));
            outputStream.writeObject(s1);
            outputStream.close();


            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(
                    "src/org/westos/iostream/student.obj"));
            Student obj = (Student) inputStream.readObject();
            System.out.println(obj.getName() + " : " + obj.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void testConle(){
        Student s = new Student("Amy", 20);

        try {
            Student s2 = (Student) s.clone();

            System.out.println(s2.getName() + " : " + s2.getAge());

            System.out.println(s == s2);
            System.out.println(s.equals(s2));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static void testPrintWrite(){
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(
                    "src/org/westos/iostream/info.txt"));
            printWriter.write("beautiful girls, i love you.");
            printWriter.close();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream("src/org/westos/iostream/info.txt"), "UTF-8"));

            String line = bufferedReader.readLine();
            System.out.println(line);
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
