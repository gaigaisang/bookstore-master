package xyz.xiaogai.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import xyz.xiaogai.bean.User;
import xyz.xiaogai.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AjaxServlet", value = "/AjaxServlet")
public class RegisterAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        if (!username.isEmpty()) {
            System.out.println(username);
            User user = new User(username);
            UserServiceImpl userService = new UserServiceImpl();
            List<User> users = userService.getUser(user);
            if (users != null) {
                response.getWriter().write("true");

            } else {
                response.getWriter().write("false");

            }
        }

    }
}
