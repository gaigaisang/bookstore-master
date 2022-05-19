package xyz.xiaogai.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import xyz.xiaogai.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(name = "ListDeleteUserServlet", value = "/ListDeleteUserServlet")
public class ListDeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String i = request.getParameter("userId");
        System.out.println(i);
        int userId = 0;
        try {
            userId = Integer.parseInt(i);
        } catch (NumberFormatException ignored) {
        }
        if (userId != 0) {
            UserServiceImpl userService = new UserServiceImpl();
            boolean b = userService.deleteUser(userId);
            response.getWriter().write(b+"");
        }

    }
}
