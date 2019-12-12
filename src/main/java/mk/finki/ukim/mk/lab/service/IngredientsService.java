package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IngredientsService {
    Ingredient create(Ingredient ingredient);

    Ingredient update(String id, Ingredient ingredient);

    void delete(String id);

    Page<Ingredient> getPage(Pageable pageable);

    Ingredient getIngredient(String id);
}
