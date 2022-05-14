package xyz.xiaogai.service;

import xyz.xiaogai.bean.Page;
import xyz.xiaogai.bean.User;

import java.util.List;

public interface UserService {
    public boolean userLogin(User user);

    public Page getPage(int page, int pageSize);
    public Page getSelPage(int page, int pageSize, User user);

    public boolean deleteUser(int id);

    public boolean deleteUser(List<User> users);

    public boolean updateUser(User user);

    public boolean addUser(User user);

    public List<User> getUser(User user);
    public List<User> getUserForName(String username);


}
