package org.westos.mysql.jdbc;

import org.junit.Test;
import org.westos.mysql.utils.JDBCUtils;

import java.sql.*;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/22 10:02
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class JDBCDemo1 {

    @Test
    public void testJDBC1() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 1.加载驱动
            // Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2.连接
            connection = JDBCUtils.getConnection();

            // 3.创建Statement对象
            statement = connection.createStatement();

            // 4.执行SQL语句
            String sql = "select * from student";
            resultSet = statement.executeQuery(sql);

            // 5.分析结果集数据
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("sid") + "\t");
                System.out.print(resultSet.getString("sname") + "\t");
                System.out.print(resultSet.getString("birthday") + "\t");
                System.out.println(resultSet.getString("sex"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, statement, connection);
        }
    }

    public static boolean login(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from users where username=? and password=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            resultSet = statement.executeQuery();
            boolean isSuccess = resultSet.next();
            if (isSuccess) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }

            return isSuccess;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, statement, connection);
        }

        return false;
    }

    public static void main(String[] args) {
        String username = "Jack";
        String password = "123";
        boolean login = login(username, password);
        System.out.println(login);
    }
}
