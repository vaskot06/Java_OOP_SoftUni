package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {

        String format = String.format(("Cannot place %s on top of your pizza."), toppingType);

        if (toppingType.equals("Meat") || toppingType.equals("Veggies") || toppingType.equals("Cheese") || toppingType.equals("Sauce")){

            this.toppingType = toppingType;
        }else {
            throw new IllegalArgumentException(format);
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", getToppingType()));
        }
        this.weight = weight;
    }

    private String getToppingType() {
        return this.toppingType;
    }

    private double getWeight() {
        return this.weight;
    }

    public double calculateCalories(){
        double calculatedCalories = 0;

        switch (getToppingType()) {
            case "Meat":
                calculatedCalories = (2 * getWeight()) * 1.2;
                break;
            case "Veggies":
                calculatedCalories = (2 * getWeight()) * 0.8;
                break;
            case "Cheese":
                calculatedCalories = (2 * getWeight()) * 1.1;
                break;
            case "Sauce":
                calculatedCalories = (2 * getWeight()) * 0.9;
                break;
        }

        return calculatedCalories;
    }
}
