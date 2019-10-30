package Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {


    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void refueling(double litres) {
        double result = getFuelQuantity() + (litres * 0.95);
        if (litres <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (result > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            super.setFuelQuantity(result);
        }
    }

    @Override
    public void driving(double distance) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formatted = decimalFormat.format(distance);
        if (getFuelQuantity() < distance * getFuelConsumption()) {
            System.out.println("Truck needs refueling");
        } else {
            super.setFuelQuantity(getFuelQuantity() - (distance * getFuelConsumption()));
            System.out.println("Truck travelled " + formatted + " km");
        }
    }
}
