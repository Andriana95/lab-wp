package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.web.PizzaDTO;

import java.util.List;

public interface PizzaService {
    Pizza create(PizzaDTO pizzaDTO);

    Pizza update(String id, PizzaDTO pizzaDTO);

    void delete(String id);

    List<Pizza> findAll();

    Pizza getPizza(String id);
}
