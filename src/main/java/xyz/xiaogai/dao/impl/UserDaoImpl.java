package xyz.xiaogai.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import xyz.xiaogai.bean.User;
import xyz.xiaogai.dao.UserDao;
import xyz.xiaogai.utils.DruidUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtil.getDataSource());



    @Override
    public int insUser(User user) {
        String sql = "INSERT INTO user(email,username,password) VALUES(?,?,?)";
        int update = jdbcTemplate.update(sql, user.getEmail(), user.getUsername(), user.getPassword());
        return update;
    }
    @Test
    public void test1() {
        User user = new User("geliao233@163.com", "2", "2");
        for (int i = 0; i < 20; i++) {
            insUser(user);
        }
    }

    @Override
    public int delUser(String username) {
        String sql = "delete from user where username=?";
        int update = jdbcTemplate.update(sql, username);
        return update;
    }

    @Override
    public int delUser(User user) {
        String sql = "delete from user where id=? and username=? and password=?";
        int update = jdbcTemplate.update(sql,user.getId(), user.getUsername(), user.getPassword());
        return update;
    }

    @Override
    public int delUser(int id) {
        String sql = "delete from user where id=?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }
    @Test
    public void test2() {
        String sql = "delete from user limit ?";
        int update = jdbcTemplate.update(sql, 60);

    }

    @Override
    public int updUser(User user) {
        String sql = "update user set email=?,username=?,password=? where id=?";
        int update = jdbcTemplate.update(sql, user.getEmail(), user.getUsername(), user.getPassword(), user.getId());
        return update;
    }

    @Override
    public List<User> selUser(User user) {
        if (user.getPassword() == null) {
            String sql = "select * from user where username=?";
            List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername());
            if (list.isEmpty()) {
                return null;
            } else {
                return list;
            }
        } else {
            String sql = "select * from user where username=? and password=?";
            List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
            if (list.isEmpty()) {
                return null;
            } else {
                return list;
            }
        }

    }

    @Override
    public User selUserById(int id) {
        String sql = "select * from user where id=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<User> selUser() {
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public List<User> selUser(String username) {
        String sql = "select * from user where username like ?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), username);
        return list;
    }
    @Test
    public void test4() {
        List<User> users = selUser("%j%");
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Override
    public List<User> selUser(int page, int size) {
        int m;
        String sql = "select * from user limit ?,?";
        if (page==1){
            m = 0;
        }else {
            m = (page-1)*size;
        }
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), m, size);
        return list;
    }

    @Override
    public List<User> selPageUser(int page, int size,User user) {
        int m;
        String sql = "select * from user where username=? limit ?,?";
        if (page==1){
            m = 0;
        }
        else {
            m = (page-1)*size;
        }
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),user.getUsername(), m, size);
        return list;
    }

    @Test
    public void test() throws JsonProcessingException {
        String sql = "select * from user limit ?,?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), 1, 2);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(list);
        System.out.println(s);

//        for (User user : list) {
//            System.out.println(user);
//        }
    }
    @Test
    public void test3() {
        String sql = "SELECT * FROM user WHERE username=? LIMIT ?,?";
    }

}
