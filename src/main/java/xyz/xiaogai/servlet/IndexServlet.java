package xyz.xiaogai.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import xyz.xiaogai.bean.User;

import java.io.IOException;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null) {
            response.getWriter().write("<h1>未登录</h1>");
            response.getWriter().write("<a href='login.html'>登录</a>");
        }else {
            response.getWriter().write("<h1>欢迎" + user.getUsername() + "</h1>");
            response.getWriter().write("<a href='LogoutServlet'>注销</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request, response);
    }
}
