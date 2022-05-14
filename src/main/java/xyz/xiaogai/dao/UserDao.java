package xyz.xiaogai.dao;

import xyz.xiaogai.bean.User;

import java.util.List;

public interface UserDao {
    public int insUser(User user);
    public int delUser(String username);
    public int delUser(User user);
    public int delUser(int id);
    public int updUser(User user);
    public List<User> selUser(User user);
    public User selUserById(int id);
    public List<User> selUser(int index,int size);
    public List<User> selUser();
    public List<User> selUser(String username);
    public List<User> selPageUser(int index,int size,User user);

}
