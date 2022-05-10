package xyz.xiaogai.filter;//package xyz.xiaogai.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import xyz.xiaogai.bean.User;
//
//import java.io.IOException;
//
//@WebFilter("/*")
//public class LoginFilter implements Filter {
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(request, response);
//
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//
//        resp.setContentType("text/html;charset=utf-8");
//        resp.setCharacterEncoding("utf-8");
//
//        String uri = req.getRequestURI();
////        System.out.println(uri);
////        System.out.println(uri.contains("userlogin"));
//        if (uri.contains("register.html")||uri.contains("userlogin")||uri.contains("userregister")||uri.contains("static")||uri.contains("css")||uri.contains("js")||uri.contains("img")) {
//            chain.doFilter(req, resp);
//        }else {
//            HttpSession session = req.getSession();
//            User user = (User) session.getAttribute("user");
//            if (user == null) {
//                resp.sendRedirect("login.html");
//            }else {
//                chain.doFilter(req, resp);
//            }
//        }
//
//
//    }
//}
