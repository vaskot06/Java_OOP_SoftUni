package Vehicles;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            this.fuelQuantity = fuelQuantity;
        }
    }

    public void setFuelConsumption(double fuelConsumption) {


        this.fuelConsumption = fuelConsumption;

    }

    double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    double getFuelConsumption() {
        return this.fuelConsumption;
    }

    abstract void refueling(double litres);

    abstract void driving(double distance);

}
