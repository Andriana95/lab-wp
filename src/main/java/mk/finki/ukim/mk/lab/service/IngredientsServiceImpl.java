package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Override
    public Ingredient create(Ingredient ingredient) {
        return ingredientsRepository.save(ingredient);
    }

    @Override
    public Ingredient update(String id, Ingredient ingredient) {
        Ingredient toUpdate = ingredientsRepository.findById(id).get();
        toUpdate.setAmount(ingredient.getAmount());
        toUpdate.setSpicy(ingredient.isSpicy());
        toUpdate.setVeggie(ingredient.isVeggie());
        return ingredientsRepository.save(toUpdate);
    }

    @Override
    public void delete(String id) {
       Ingredient toDelete = ingredientsRepository.findById(id).get();
       ingredientsRepository.delete(toDelete);
    }

    @Override
    public Page<Ingredient> getPage(Pageable pageable) {
       return ingredientsRepository.findAll(pageable);
    }

    @Override
    public Ingredient getIngredient(String id) {
       return ingredientsRepository.findById(id).get();
    }
}
