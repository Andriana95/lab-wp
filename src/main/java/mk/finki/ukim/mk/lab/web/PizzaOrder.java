package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/PizzaOrder.do")
public class PizzaOrder extends HttpServlet {
    private OrderService orderService;
    private SpringTemplateEngine springTemplateEngine;
    public PizzaOrder (OrderService orderService, SpringTemplateEngine springTemplateEngine){
        this.orderService = orderService;
        this.springTemplateEngine = springTemplateEngine;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String pizzaSize = req.getParameter("pizza_size");
        HttpSession httpSession = req.getSession();
        Order order = (Order) httpSession.getAttribute("order");
        order.setPizzaSize(pizzaSize);
        httpSession.setAttribute("order",order);

        resp.setContentType("text/html; charset=UTF-8");
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("pizzaType", order.getPizzaType());
        context.setVariable("pizzaSize",order.getPizzaSize());
        springTemplateEngine.process("deliveryInfo.html", context, resp.getWriter());
    }

}
