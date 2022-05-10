package xyz.xiaogai.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "userregister", value = "/userregister")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("1");
//        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h1>你好</h1>");
//        String url = "UserLoginServlet";
//        String newurl = response.encodeRedirectURL(url);
//        response.sendRedirect(newurl);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
