import Vehicles.Car;
import Vehicles.Truck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens= bufferedReader.readLine().split(" ");
        String[] truckTokens= bufferedReader.readLine().split(" ");

        int numberOfCommands = Integer.parseInt(bufferedReader.readLine());

        Car car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));
        Truck truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = bufferedReader.readLine().split(" ");
            if (tokens[0].equals("Drive")) {
                if (tokens[1].equals("Car")) {
                   car.driving(Double.parseDouble(tokens[2]));
                }else if (tokens[1].equals("Truck")){
                    truck.driving(Double.parseDouble(tokens[2]));
                }

            }else if (tokens[0].equals("Refuel")){
                if (tokens[1].equals("Car")) {
                    car.refueling(Double.parseDouble(tokens[2]));
                } else if (tokens[1].equals("Truck")) {
                    truck.refueling(Double.parseDouble(tokens[2]));
                }
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f", truck.getFuelQuantity());
    }
}
