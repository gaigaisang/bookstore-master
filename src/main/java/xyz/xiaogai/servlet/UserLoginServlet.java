package xyz.xiaogai.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import xyz.xiaogai.bean.User;
import xyz.xiaogai.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(name = "userlogin", value = "/userlogin")
public class UserLoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie[] cookies = req.getCookies();
//            User loginUser = new User();
//        for (Cookie cookie :
//                cookies) {
//            String username = cookie.getName();
//            String password = cookie.getValue();
//            loginUser.setUsername(username);
//            loginUser.setPassword(password);
//        }
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
//        String[] loginCheck = req.getParameterValues("logincheck");
            System.out.println(username);
            System.out.println(password);
            User u1 = new User(username, password);
            UserServiceImpl userService = new UserServiceImpl();

            if (!userService.userLogin(u1)){
                resp.sendRedirect("login.html");
            }else {
                req.getSession().setAttribute("user",u1);
        }


//            if (loginCheck!=null&&loginCheck[0].equals("on")){
////            System.out.println(loginCheck[0]);
//                Cookie user = new Cookie("username",username);
//                Cookie pwd = new Cookie("password",password);
//                user.setMaxAge(-9);
//                pwd.setMaxAge(24*60*60*10);
//                user.setMaxAge(24*60*60*10);
//                resp.addCookie(user);
//                resp.addCookie(pwd);
//                resp.sendRedirect("index.html");
//
//            }else {
//            resp.sendRedirect("index.html");
//            }
        }else {
            resp.sendRedirect("index.html");
        }



//
//
//        UserDaoImpl userDaoImpl = new UserDaoImpl();
//        if (userDaoImpl.selUser(user) != null) {
//            resp.sendRedirect("/");
//        } else {
//            resp.sendRedirect("https://www.baidu.com");
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
