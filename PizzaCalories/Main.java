import PizzaCalories.Dough;
import PizzaCalories.Pizza;
import PizzaCalories.Topping;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzas = scanner.nextLine().split(" ");
        String[] doughes = scanner.nextLine().split(" ");


        Pizza pizza = new Pizza(pizzas[1], Integer.parseInt(pizzas[2]));
        Dough dough = new Dough(doughes[1], doughes[2], Double.parseDouble(doughes[3]));
        pizza.setDough(dough);


        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String[] tokens = input.split(" ");
            Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
            pizza.addTopping(topping);
            input = scanner.nextLine();
        }

        System.out.println(pizza.getName() + " - " + pizza.getOverallCalories());

    }
}
