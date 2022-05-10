package xyz.xiaogai.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
    //获取mysql连接
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}