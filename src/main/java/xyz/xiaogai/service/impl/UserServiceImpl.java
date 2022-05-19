package xyz.xiaogai.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import xyz.xiaogai.bean.Page;
import xyz.xiaogai.bean.User;
import xyz.xiaogai.dao.impl.UserDaoImpl;
import xyz.xiaogai.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    public boolean userLogin(User user) {
        List<User> users = userDaoImpl.selUser(user);
        if (users != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Page getPage(int page, int pageSize) {
        List<User> users = userDaoImpl.selUser(page, pageSize);
        int size = userDaoImpl.selUser().size();
        int totalPage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;
        Page newPage = new Page(page, pageSize, size, totalPage, users);
        return newPage;
    }

    @Override
    public Page getSelPage(int page, int pageSize, User user) {
        List<User> users = userDaoImpl.selUser(user);
        int size = users.size();
        int totalPage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;
        Page newPage = new Page(page, pageSize, size, totalPage, users);
        return newPage;
    }

    @Override
    public boolean deleteUser(int id) {
        int b = userDaoImpl.delUser(id);
        if (b > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(List<User> users) {
        int i = 0;
        for (User user : users) {
            i = userDaoImpl.delUser(user);
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        int i = userDaoImpl.updUser(user);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addUser(User user) {
        int i = userDaoImpl.insUser(user);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> getUser(User user) {
        List<User> users = userDaoImpl.selUser(user);
        if (users != null) {
            return users;
        }
        return null;
    }

    @Override
    public List<User> getUserForName(String username) {
        List<User> users = userDaoImpl.selUser("%"+username+"%");
        if (users != null) {
            return users;
        }
        return null;
    }

    @Test
    public void test() {
        int size = userDaoImpl.selUser().size();
        System.out.println(size);
    }

    @Test
    public void test1() {
        List<User> users = userDaoImpl.selUser(3, 3);
        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test2() throws JsonProcessingException {
        User user = new User(1, "小明", "123456", "男");

        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(user);
        System.out.println(s);

    }


}
