package org.westos.mysql.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.Connection;
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
 * @Date: Created in 2018/8/24 15:48
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class JDBCUtils2 {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useSSL=false" +
            "useUnicode=true&characterEncoding=utf8"
            + "&useServerPrepStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true&useCursorFetch=true&defaultFetchSize=100";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static DruidDataSource dataSource =  new DruidDataSource();

    static {
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
    }

    public static Connection getConnection(){
        DruidPooledConnection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
