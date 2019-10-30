package Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
    }


    @Override
  public void refueling(double litres) {
        super.setFuelQuantity(getFuelQuantity() + (litres * 0.95));
    }

    @Override
   public void driving(double distance) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formatted = decimalFormat.format(distance);
        if (getFuelQuantity() < distance * getFuelConsumption()) {
            System.out.println("Truck needs refueling");
        }else {
            super.setFuelQuantity(getFuelQuantity() - (distance * getFuelConsumption()));
            System.out.println("Truck travelled " + formatted + " km");
        }
    }
}
