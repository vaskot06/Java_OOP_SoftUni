package Vehicles;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption= fuelConsumption;
    }

  public    double getFuelQuantity(){
        return this.fuelQuantity;
     }

    void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelConsumption(){
         return this.fuelConsumption;
     }

    abstract void refueling(double litres);

    abstract void driving(double distance);

}
