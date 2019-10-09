package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;


    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {

        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {

        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
            }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private String getFlourType() {
        return this.flourType;
    }

    private String getBakingTechnique() {
        return bakingTechnique;
    }

    private double getWeight() {
        return weight;
    }

    public double calculateCalories() {
        double calculatedCalories = 0;

        if (getFlourType().equals("White") && getBakingTechnique().equals("Crispy")) {
            calculatedCalories = (2 * getWeight()) * 1.5 * 0.9;
        } else if (getFlourType().equals("White") && getBakingTechnique().equals("Chewy")) {
            calculatedCalories = (2 * getWeight()) * 1.5 * 1.1;
        } else if (getFlourType().equals("White") && getBakingTechnique().equals("Homemade")) {
            calculatedCalories = (2 * getWeight()) * 1.5 * 1.0;
        } else if (getFlourType().equals("Wholegrain") && getBakingTechnique().equals("Crispy")) {
            calculatedCalories = (2 * getWeight()) * 1.0 * 0.9;
        } else if (getFlourType().equals("Wholegrain") && getBakingTechnique().equals("Chewy")) {
            calculatedCalories = (2 * getWeight()) * 1.0 * 1.1;
        } else if (getFlourType().equals("Wholegrain") && getBakingTechnique().equals("Homemade")) {
            calculatedCalories = (2 * getWeight()) * 1.0 * 1.0;
        }

        return calculatedCalories;
    }
}
