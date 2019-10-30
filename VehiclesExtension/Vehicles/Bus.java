package Vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle {


    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void refueling(double litres) {
        if (litres <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        double result = getFuelQuantity() + litres;
        if (result > getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        } else {
            super.setFuelQuantity(result);
        }
    }

    @Override
    public void driving(double distance) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formatted = decimalFormat.format(distance);
        if (getFuelQuantity() < distance * getFuelConsumption()) {
            System.out.println("Bus needs refueling");
        } else {
            super.setFuelQuantity(getFuelQuantity() - (distance * getFuelConsumption()));
            System.out.println("Bus travelled " + formatted + " km");
        }
    }

    public void drivingWithPeople(double distance) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formatted = decimalFormat.format(distance);
        if (getFuelQuantity() < distance * (getFuelConsumption() + 1.4)) {
            System.out.println("Bus needs refueling");
        } else {
            super.setFuelQuantity(getFuelQuantity() - (distance * (getFuelConsumption() + 1.4)));
            System.out.println("Bus travelled " + formatted + " km");
        }
    }
}
