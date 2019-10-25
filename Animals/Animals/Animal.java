package Animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

   public abstract String explainSelf();

    private String getName() {
        return name;
    }

    private String getFavouriteFood() {
        return favouriteFood;
    }

    protected String baseExplain() {
        return String.format("I am %s and my favourite food is %s", getName(), getFavouriteFood());
    }
}
