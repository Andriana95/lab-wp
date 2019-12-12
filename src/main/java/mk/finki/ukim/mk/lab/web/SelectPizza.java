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

@WebServlet(urlPatterns = "/selectPizza.do")
public class SelectPizza extends HttpServlet {
   private OrderService orderService;
    private SpringTemplateEngine springTemplateEngine;

    public SelectPizza(OrderService orderService,SpringTemplateEngine springTemplateEngine){
        this.orderService = orderService;
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selektiranaPizza = req.getParameter("pizza");
        Order order = new Order();
        order.setPizzaType(selektiranaPizza);
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("order",order);
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("selectedType", selektiranaPizza);
        System.out.println(selektiranaPizza);
        springTemplateEngine.process("selectPizzaSize.html", context, resp.getWriter());

    }


}
