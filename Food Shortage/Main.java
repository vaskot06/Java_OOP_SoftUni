import FoodShortage.Citizen;
import FoodShortage.Rebel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels= new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = bufferedReader.readLine().split(" ");

            if (tokens.length == 4) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                String birthDate = tokens[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                citizens.add(citizen);
            }else {
                Rebel rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                rebels.add(rebel);
            }
        }

        String name = bufferedReader.readLine();

        while (!name.equals("End")) {

            for (Citizen citizen : citizens) {
                if (citizen.getName().equals(name)) {
                    citizen.buyFood();
                }
            }
            for (Rebel rebel : rebels) {
                if (rebel.getName().equals(name)) {
                    rebel.buyFood();
                }
            }
            name = bufferedReader.readLine();
        }

        int sum = 0;

        for (Citizen citizen : citizens) {
            sum += citizen.getFood();
        }
        for (Rebel rebel : rebels) {
            sum += rebel.getFood();
        }

        System.out.println(sum);
    }
}
