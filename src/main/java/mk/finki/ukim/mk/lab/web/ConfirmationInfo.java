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

@WebServlet(urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfo extends HttpServlet {
    private OrderService orderService;
    private SpringTemplateEngine springTemplateEngine;
    public ConfirmationInfo(OrderService orderService, SpringTemplateEngine springTemplateEngine) {
        this.orderService = orderService;
         this.springTemplateEngine = springTemplateEngine;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pizzaName = req.getParameter("clientName");
        String clientAdress = req.getParameter("clientAddress");
        String ipAdres = req.getRemoteAddr();
        String browser = req.getHeader("user-agent");
        HttpSession httpSession = req.getSession();
        Order order = (Order) httpSession.getAttribute("order");
        order.setClientAddress(clientAdress);
        order.setClientName(pizzaName);
        httpSession.setAttribute("order", order);
        resp.setContentType("text/html; charset=UTF-8");
        orderService.placeOrder(order.getPizzaType(),order.getPizzaType(),pizzaName,clientAdress);
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("pizzaType", order.getPizzaType());
        context.setVariable("pizzaSize", order.getPizzaSize());
        context.setVariable("clientAdres", order.getClientAddress());
        context.setVariable("clientName", order.getClientName());
        context.setVariable("idAdres", ipAdres);
        context.setVariable("browser ", browser);
        springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());


    }

}

