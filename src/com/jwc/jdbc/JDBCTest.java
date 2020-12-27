package com.jwc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Auther: jiangwc
 * @Date: 2020/12/27 - 12 - 27 - 20:54
 * @Description: com.jwc.jdbc
 * @version: 1.0
 */
public class JDBCTest {
    //定义MySQL的数据库驱动程序
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    //定义MySQL数据库的连接地址
    public static final String DBURL = "jdbc:mysql://localhost:3306/test";
    //MySQL数据库的连接用户名
    public static final String DBUSER = "root";
    //MySQL数据库的连接密码
    public static final String DBPASS = "123456";

    public static void main(String[] args) throws Exception {
        // 1)加载驱动
        Class.forName(DBDRIVER);
        // 2）建立连接，要写上连接的用户名和密码
        Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        // 3) 测试连接是否成功
        System.out.println(connection);
        // 4) 写sql语句
        String selectSql = "select * from emp";
        // 5) 准备静态处理块对象（将SQL语句放置其中）
        Statement statement = connection.createStatement();
        // 6) 执行sql语句,并接受返回值
        ResultSet resultSet = statement.executeQuery(selectSql);
        // 7) 处理返回结果集
        while (resultSet.next()) {
            String empNo = resultSet.getString(1);
            System.out.println(empNo);
            String empName = resultSet.getString(2);
            System.out.println(empName);
            int depNo = resultSet.getInt(3);
            System.out.println(depNo);
            String depName = resultSet.getString(4);
            System.out.println(depName);
            System.out.println("-------------");
        }
        // 8）关闭操作
        statement.close();
        // 9) 关闭db连接
        connection.close();
    }
}
