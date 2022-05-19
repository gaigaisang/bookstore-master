package xyz.xiaogai.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import xyz.xiaogai.bean.User;
import xyz.xiaogai.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(name = "ListAddUserServlet", value = "/ListAddUserServlet")
public class ListAddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(email,username,password);
        if (email!=null&&user!=null&&password!=null){
            UserServiceImpl userService = new UserServiceImpl();
            boolean b = userService.addUser(user);
            response.getWriter().write(b+"");
        }

    }
}
