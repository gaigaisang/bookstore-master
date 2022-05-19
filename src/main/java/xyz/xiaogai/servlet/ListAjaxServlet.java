package xyz.xiaogai.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import xyz.xiaogai.bean.Page;
import xyz.xiaogai.bean.User;
import xyz.xiaogai.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListAjaxServlet", value = "/ListAjaxServlet")
public class ListAjaxServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String i = request.getParameter("pageIndex");
        int pageIndex = 1;
        try {
            pageIndex = Integer.parseInt(i);
        } catch (NumberFormatException ignored) {
        }
        System.out.println(username);
        System.out.println(i);
        if (username != null && pageIndex != 1) {
            User user = new User(username);
            Page page = userService.getSelPage(pageIndex, 6, user);
            objectMapper.writeValue(response.getWriter(), page);
            return;
        }

        if (username != null) {
            User user = new User(username);
            Page page = userService.getSelPage(pageIndex, 6, user);
            objectMapper.writeValue(response.getWriter(), page);
            return;
        }

        Page page = userService.getPage(pageIndex, 6);
        objectMapper.writeValue(response.getWriter(), page);
        return;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
