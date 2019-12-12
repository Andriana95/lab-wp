package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.IngredientsRepository;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.web.PizzaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Override
    public Pizza create(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza();
        pizza.setName(pizzaDTO.name);
        pizza.setDescription(pizzaDTO.description);
        pizza.setVeggie(pizzaDTO.veggie);

        List<Ingredient> ingredients = new ArrayList<>();
        if (pizzaDTO.ingredientIds != null) {
            for (String ingredientId : pizzaDTO.ingredientIds) {
                Ingredient ingredient = ingredientsRepository.findById(ingredientId).get();
                ingredients.add(ingredient);
            }
        }
        pizza.setIngredients(ingredients);

        return pizzaRepository.save(pizza);
    }

    @Override
    public Pizza update(String id, PizzaDTO pizzaDTO) {
        Pizza toUpdate = pizzaRepository.findById(id).get();
        toUpdate.setDescription(pizzaDTO.description);
        toUpdate.setVeggie(pizzaDTO.veggie);

        List<Ingredient> ingredients = new ArrayList<>();
        if (pizzaDTO.ingredientIds != null) {
            for (String ingredientId : pizzaDTO.ingredientIds) {
                Ingredient ingredient = ingredientsRepository.findById(ingredientId).get();
                ingredients.add(ingredient);
            }
        }
        toUpdate.setIngredients(ingredients);

        return pizzaRepository.save(toUpdate);
    }

    @Override
    public void delete(String id) {
        Pizza toDelete = pizzaRepository.findById(id).get();
        ;
        pizzaRepository.delete(toDelete);
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza getPizza(String id) {
        return pizzaRepository.findById(id).get();
    }
}
