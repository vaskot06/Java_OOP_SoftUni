package PizzaCalories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
        this.setDough(dough);
    }

    private void setName(String name) {
        if (name.length() > 15 || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void addTopping(Topping topping) {
        getToppings().add(topping);
    }

    public String getName() {
        return name;
    }

    public Dough getDough() {
        return dough;
    }

    private List<Topping> getToppings() {
        return this.toppings;
    }


    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public Double getOverallCalories(){

        double result = 0;

        for (Topping topping : toppings) {
            result += topping.calculateCalories();
        }

       // String numberInString = String.format("%.2f",getDough().calculateCalories() + result);
        //result = Double.parseDouble(numberInString);

        return result + getDough().calculateCalories();
    }
}
