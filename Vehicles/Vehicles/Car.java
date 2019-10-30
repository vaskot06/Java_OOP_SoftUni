package Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
    }


    @Override
    public void refueling(double litres) {
        double result = getFuelQuantity() + litres;
        super.setFuelQuantity(result);
    }

    @Override
    public void driving(double distance) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formatted = decimalFormat.format(distance);
        if (getFuelQuantity() < distance * getFuelConsumption()) {
            System.out.println("Car needs refueling");
        } else {
            super.setFuelQuantity(getFuelQuantity() - (distance * getFuelConsumption()));
            System.out.println("Car travelled " + formatted + " km");
        }
    }
}
