package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class ShowPizzas extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private PizzaService pizzaService;

    public ShowPizzas(SpringTemplateEngine springTemplateEngine, PizzaService pizzaService) {
        this.springTemplateEngine = springTemplateEngine;
        this.pizzaService = pizzaService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pizza> pizzas = this.pizzaService.findAll();
        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("pizzas", pizzas);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("listPizzas.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        List<Pizza> pizzas = this.pizzaService.findAll();

        String newPizza = req.getParameter("newPizza");
        String  newDescription = req.getParameter("newDescription");
        Pizza pizza = new Pizza();
        pizza.setName(newPizza);
        pizza.setDescription(newDescription);
        pizzas.add(pizza);
        resp.sendRedirect("/");

    }
}

