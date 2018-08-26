package org.westos.mysql.jdbc;

import org.junit.Test;
import org.westos.mysql.utils.JDBCUtils;

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
 * @Date: Created in 2018/8/24 10:13
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class PreparedStatementDemo {

    @Test
    public void testPreparedStatement(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();

            connection.setAutoCommit(false);

            String sql = "select * from emp where empno=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 7876);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet.getInt("empno"));
                System.out.println(resultSet.getString("ename"));
                System.out.println(resultSet.getString("job"));
            }

            preparedStatement.setInt(1, 7566);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet.getInt("empno"));
                System.out.println(resultSet.getString("ename"));
                System.out.println(resultSet.getString("job"));
            }

            // 手动提交事务
            connection.commit();

        } catch (SQLException e) {
            // 如果事务执行过程中发生异常，就之前的执行的事物回滚
            if(connection != null){
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }
}
