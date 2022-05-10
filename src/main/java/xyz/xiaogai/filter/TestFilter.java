package xyz.xiaogai.filter;//package xyz.xiaogai.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.*;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import xyz.xiaogai.bean.User;
//
//import java.io.IOException;
//
//@WebFilter("/*")
//public class TestFilter implements Filter {
//    public void init(FilterConfig config) throws ServletException {
//        System.out.println("UserFilter init");
//
//    }
//
//    public void destroy() {
//        System.out.println("UserFilter destroy");
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(request, response);
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=utf-8");
//
//        String requestURI = req.getRequestURI();
//        System.out.println("requestURI:" + requestURI);
//        System.out.println(requestURI.contains("/userregister"));
//        if (requestURI.contains("/login.html") || requestURI.contains("/register.html") || requestURI.contains("/static/")||requestURI.contains("/css/")||requestURI.contains("/js/")||requestURI.contains("/img/")||requestURI.contains("/userlogin")||requestURI.contains("/userregister")||requestURI.contains("/IndexServlet")) {
//            chain.doFilter(req, resp);
//            resp.sendRedirect("index.html");
//        }else {
//            HttpSession session = req.getSession();
//            User user = (User) session.getAttribute("user");
//            if (user == null) {
//                resp.sendRedirect("login.html");
//            }else{
//                chain.doFilter(req, resp);
//            }
//        }
//    }
//}
