package xyz.xiaogai.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import xyz.xiaogai.bean.User;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SqlConn {

    Properties pro = new Properties();
    InputStream resourceAsStream = SqlConn.class.getClassLoader().getResourceAsStream("Druid.properties");
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    public SqlConn() throws Exception {
        pro.load(resourceAsStream);
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        connection = ds.getConnection();
    }



    private int runsql(String sql) throws Exception {
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        int result = ps.executeUpdate();
        return result;
    }

    public int insUserSql(User user) throws Exception {
        String sql = "INSERT INTO user(username,password) VALUES(\"" +user.getUsername()+"\","+user.getPassword() + ")";
        return runsql(sql);
    }

    public int delUserSql(User user) throws Exception {
        String sql = "delete from user where username=\"" + user.getUsername()+"\"";
        return runsql(sql);
    }

    public int updUserSql(String username, User user) throws Exception {
        String sql = "update user set username=\"" + user.getUsername() + "\",password=\"" + user.getPassword() + "\" where username=\"" + username+"\"";
        return runsql(sql);
    }
    public int updUserSql(String username, String password) throws Exception {
        String sql = "update user set password=\"" + password + "\" where username=\"" + username+"\"";
        return runsql(sql);
    }

    public ResultSet selUserSql(User user) throws Exception {
        String sql = "select * from user where username  like \"" + user.getUsername() + "\"";
        PreparedStatement ps =connection.prepareStatement(sql);
        ResultSet rs =ps.executeQuery();
//        System.out.println(rs.getRow());
//        System.out.println(rs.last());
//        System.out.println(rs.getRow());;
        return rs;
    }
    public ResultSet selUserSql(String tab) throws SQLException {
        String sql = "select * from "+tab;
        PreparedStatement ps =connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
