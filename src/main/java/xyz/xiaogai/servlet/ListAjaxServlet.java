package xyz.xiaogai.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import xyz.xiaogai.bean.User;
import xyz.xiaogai.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListAjaxServlet", value = "/ListAjaxServlet")
public class ListAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println(username);
        if (!username.isEmpty()) {
            UserServiceImpl userService = new UserServiceImpl();
            List<User> users = userService.getUserForName(username);
            if (users!=null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(response.getOutputStream(), users);
            }else {
                response.getWriter().write("false");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
