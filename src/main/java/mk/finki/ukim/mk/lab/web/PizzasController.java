package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzasController {
    @Autowired
    private PizzaService pizzaService;

    @PostMapping("/pizzas")
    public Pizza createPizza(@RequestBody PizzaDTO pizzaDTO) {
        return pizzaService.create(pizzaDTO);
    }

    @PutMapping("/pizzas/{id}")
    public Pizza updatePizza(@PathVariable String id, @RequestBody PizzaDTO pizzaDTO) {
        return pizzaService.update(id, pizzaDTO);
    }

    @DeleteMapping("/pizzas/{id}")
    public void deletePizza(@PathVariable String id) {
        pizzaService.delete(id);
    }

    @GetMapping("/pizzas")
    public List<Pizza> getPizzas() {
        return pizzaService.findAll();
    }

    @GetMapping("/pizzas/{id}")
    public Pizza getPizza(@PathVariable String id) {
        return pizzaService.getPizza(id);
    }
}

