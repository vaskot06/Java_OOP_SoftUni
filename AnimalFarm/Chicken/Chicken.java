package Chicken;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        name = name.trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
            this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    private double calculateProductPerDay(){
        if (getAge() < 6){
            return 2.0;
        }else if (getAge() >11){
            return 0.75;
        }
        return 1;
    }

    public double productPerDay(){
        return calculateProductPerDay();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",getName(), getAge(), productPerDay());
    }
}
