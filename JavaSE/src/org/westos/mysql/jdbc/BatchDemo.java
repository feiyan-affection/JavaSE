package org.westos.mysql.jdbc;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.junit.Test;
import org.westos.mysql.utils.JDBCUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/24 13:34
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description： 批处理对数据库增删改
 */
public class BatchDemo {

    @Test
    public void testBatch() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        long start = System.currentTimeMillis();

        try {
            connection = JDBCUtils.getConnection();

            String sql = "insert into class(cid, cname) values(?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 5; i < 1000000; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, "java");

                // 将insert语句放入批处理包，满500次向服务器发送一次
                preparedStatement.addBatch();
                if ((i + 1) % 500 == 0) {
                    preparedStatement.executeBatch();
                }
            }
            preparedStatement.executeBatch();

            long end = System.currentTimeMillis();

            System.out.println("共花费时间：" + (end - start));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }

    public static int ma() {
        int b = 10;
        try {
            return b;
        } finally {
            for (int i = 0; i < 10; i++) {
                b++;
            }
            System.out.print("In Finally! ");
        }
    }

    // 求阶乘
    private int function(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * function(n - 1);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        int[] temp = new int[arr.length];

        // 将a数组复制到t数组中
        for (int k = low; k <= high; k++) {
            temp[k] = arr[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                arr[k] = temp[j++];
            } else if (j > high) {
                arr[k] = temp[i++];
            } else if (temp[j] < arr[i]) {
                arr[k] = temp[j++];
            } else {
                arr[k] = temp[i++];
            }
        }
    }

    public void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }


    @Test
    public void testWriteToDataBase() {
        Connection connection = null;
        BufferedReader bufferedReader = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = JDBCUtils.getConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream("C:\\Users\\Administrator\\Desktop\\output.txt")));

            String sql = "insert into hero(hid, hname, place, sex, birth, death, forceValue)" +
                    " values(?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = preparedStatement = connection.prepareStatement(sql);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strs = line.split("\t");

                preparedStatement.setInt(1, Integer.parseInt(strs[0]));
                preparedStatement.setString(2, strs[1]);
                preparedStatement.setString(3, strs[2]);
                preparedStatement.setString(4, strs[3]);
                preparedStatement.setInt(5, Integer.parseInt(strs[4]));
                preparedStatement.setInt(6, Integer.parseInt(strs[5]));
                preparedStatement.setInt(7, Integer.parseInt(strs[6]));

                // 批处理插入数据
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            JDBCUtils.close(preparedStatement, connection);
        }
    }

    @Test
    public void testWork() {
        // new B();

//        Cat cat = new SmallCat();
//        cat.mi();

        // System.out.println(ma());

        // System.out.println(function(3));

        int[] a = {3, 2, 5, 8, 6, 1, 7, 4};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}

class C {
    public C(String str) {
        System.out.print(str);
    }
}

class A {
    static C c1 = new C("1");
    C c2 = new C("2");

    static {
        new C("3");
    }

    public A() {
        new C("4");
    }
}

class B extends A {
    static C c5 = new C("5");
    C c6 = new C("6");

    static {
        new C("7");
    }

    public B() {
        new C("8");
    }
}

class Cat {
    void mi() throws Exception {
        System.out.println("Cat mi mi ..");
    }
}

class SmallCat extends Cat {
    int i = 8;

    @Override
    public void mi() {
        System.out.println("SmallCat mi mi ..");
    }

}

class Singleton {

    private static volatile Singleton singleton = null;

    private Singleton() {

    }

    public static Singleton getInstence() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
