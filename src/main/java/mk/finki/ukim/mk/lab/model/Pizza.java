package mk.finki.ukim.mk.lab.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    private String name;
    private String description;

    @ManyToMany
    List<Ingredient> ingredients;
    boolean veggie;


    public Pizza(){}
    public Pizza (String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isVeggie() {
        return veggie;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }

    @Override
    public String toString() {
        return String.format("%s ( %s )",name,description);
    }
}
