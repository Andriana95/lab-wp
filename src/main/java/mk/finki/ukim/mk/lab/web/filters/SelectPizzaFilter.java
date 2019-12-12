//package mk.finki.ukim.mk.lab.web.filters;
//
//import mk.finki.ukim.mk.lab.model.Order;
//import org.springframework.http.HttpRequest;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter
//public class SelectPizzaFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
//
//        String path = httpRequest.getServletPath();
//
//        if(!path.equals("") && !path.equals("/selectPizza.do")) {
//            Order pizza =(Order)(httpRequest.getSession().getAttribute("order"));
//            if(pizza == null || pizza.getPizzaType() == null) {
//                httpResponse.sendRedirect("/");
//            }
//            else
//            {
//                filterChain.doFilter(servletRequest, servletResponse);
//            }
//        }
//        else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//
//
//    }
//}