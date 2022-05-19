package xyz.xiaogai.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import xyz.xiaogai.bean.User;
import xyz.xiaogai.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(name = "ListEditUserServlet", value = "/ListEditUserServlet")
public class ListEditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int userId = -1;
        try {
            userId = Integer.parseInt(id);
        } catch (NumberFormatException ignored) {
        }
        User user = new User(userId, email, username, password);
        if (userId != -1) {
            UserServiceImpl userService = new UserServiceImpl();
            boolean b = userService.updateUser(user);
            response.getWriter().write(b+"");
        }else {
            response.getWriter().write("false");
        }
    }
}
