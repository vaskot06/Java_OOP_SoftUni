import Vehicles.Bus;
import Vehicles.Car;
import Vehicles.Truck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = bufferedReader.readLine().split(" ");
        String[] truckTokens = bufferedReader.readLine().split(" ");
        String[] busTokens = bufferedReader.readLine().split(" ");

        int numberOfCommands = Integer.parseInt(bufferedReader.readLine());

        Car car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]), Double.parseDouble(carTokens[3]));
        Truck truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]), Double.parseDouble(truckTokens[3]));
        Bus bus = new Bus(Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]), Double.parseDouble(busTokens[3]));

        for (int i = 0; i < numberOfCommands; i++) {
            try {
                String[] tokens = bufferedReader.readLine().split(" ");
                if (tokens[0].equals("Drive")) {
                    if (tokens[1].equals("Car")) {
                        car.driving(Double.parseDouble(tokens[2]));
                    } else if (tokens[1].equals("Truck")) {
                        truck.driving(Double.parseDouble(tokens[2]));
                    } else if (tokens[1].equals("Bus")) {
                        bus.drivingWithPeople(Double.parseDouble(tokens[2]));
                    }

                } else if (tokens[0].equals("Refuel")) {
                    if (tokens[1].equals("Car")) {
                        car.refueling(Double.parseDouble(tokens[2]));
                    } else if (tokens[1].equals("Truck")) {
                        truck.refueling(Double.parseDouble(tokens[2]));
                    } else if (tokens[1].equals("Bus")) {
                        bus.refueling(Double.parseDouble(tokens[2]));
                    }
                }else if (tokens[0].equals("DriveEmpty")){
                    bus.driving(Double.parseDouble(tokens[2]));
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f", bus.getFuelQuantity());
    }
}
