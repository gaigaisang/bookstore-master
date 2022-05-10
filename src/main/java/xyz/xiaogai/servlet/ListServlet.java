package xyz.xiaogai.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.junit.Test;
import xyz.xiaogai.bean.Page;
import xyz.xiaogai.bean.User;
import xyz.xiaogai.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServlet", value = "/ListServlet")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        UserServiceImpl userService = new UserServiceImpl();

        String p = request.getParameter("indexPage");
        int indexPage;
        try {
            //当前页数
            indexPage = Integer.valueOf(p);
        } catch (NumberFormatException e) {
            indexPage = 1;
        }
        //删除单个用户
        String i = request.getParameter("userId");
        int userId;
        try {
            //用户id
            userId = Integer.valueOf(i);
        } catch (NumberFormatException e) {
            userId = 0;
        }
        if (userId != 0) {
            userService.deleteUser(userId);
        }
        //删除整页用户
        String d = request.getParameter("deleteAll");
        int deleteAll;
        try {
            deleteAll = Integer.valueOf(d);
        } catch (NumberFormatException e) {
            deleteAll = 0;
        }
        if (deleteAll != 0) {
            Page page = userService.getPage(indexPage, 6);

            userService.deleteUser(page.getUsers());
        }
        //添加用户
        String au = request.getParameter("addUser");

        int addUser;
        try {
            addUser = Integer.valueOf(au);
        } catch (NumberFormatException e) {
            addUser = 0;
        }
        if (addUser != 0) {
            String addUsername = request.getParameter("addUsername");
            String addPassword = request.getParameter("addPassword");
            String addEmail = request.getParameter("addEmail");
            User user = new User(addEmail,addUsername, addPassword );
            userService.addUser(user);
        }
        //更新用户
        String eu = request.getParameter("editUser");
        int editUser;
        try {
            editUser = Integer.valueOf(eu);

        }
        catch (NumberFormatException e) {
            editUser = 0;
        }
        if (editUser != 0) {
            String editUsername = request.getParameter("editUsername");
            String editPassword = request.getParameter("editPassword");
            String editEmail = request.getParameter("editEmail");
            User user = new User(editEmail,editUsername, editPassword );
            Page page = userService.getPage(indexPage, 6);
            List<User> users = page.getUsers();
            user.setId(users.get(editUser - 1).getId());
            userService.updateUser(user);
        }



        //查询用户
//        String un = request.getParameter("username");
//        if (un != null) {
//            System.out.println(un);
//            User user = new User();
//            user.setUsername(un);
//            Page page1 = userService.getSelPage(indexPage, 6, user);
////            if (!users.isEmpty()) {
////                Page page = new Page(1,users.size(),1,users);
//                request.setAttribute("indexPage", indexPage);
//                request.setAttribute("page", page1);
//                String url = "list.jsp";
//                String newurl = response.encodeRedirectURL(url);
//                request.getRequestDispatcher(newurl).forward(request, response);
////            }
//        }

        System.out.println("当前页数：" + indexPage);
        request.setAttribute("indexPage", indexPage);

        Page page = userService.getPage(indexPage, 6);
        if (page.getUsers().isEmpty()) {
            indexPage -= 1;
        }
        Page page1 = userService.getPage(indexPage, 6);
        request.setAttribute("indexPage", indexPage);
        request.setAttribute("page", page1);
        String url = "list.jsp";
        String newurl = response.encodeRedirectURL(url);
        request.getRequestDispatcher(newurl).forward(request, response);

//      request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Test
    public void test() {
        System.out.println("ListServlet测试");
        UserServiceImpl userService = new UserServiceImpl();
        Page page = userService.getPage(1, 6);
        List<User> users = page.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        userService.deleteUser(page.getUsers());
    }
}
