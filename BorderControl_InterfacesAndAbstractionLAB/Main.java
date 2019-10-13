import BorderControl.Citizen;
import BorderControl.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );

        List<Citizen> citizens = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();

        String input;
        while (!(input = reader.readLine()).equals("End")) {

            String[] data = input.split("\\s+");

            if (data.length == 3) {
                Citizen citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2]);
                citizens.add(citizen);

            } else if (data.length == 2) {
                Robot robot = new Robot(data[0], data[1]);
                robots.add(robot);
            }

        }

        String retainedIDs = reader.readLine();

        StringBuilder builder = new StringBuilder();
        for (Citizen citizen : citizens) {
            if(verifyID(citizen.getId(), retainedIDs)){
                builder.append(citizen.getId())
                        .append(System.lineSeparator());
            }
        }

        for (Robot robot : robots) {
            if( verifyID(robot.getId(), retainedIDs)){
                builder.append(robot.getId())
                        .append(System.lineSeparator());
            }

        }

        System.out.println(builder.toString());

    }

    private static boolean verifyID(String id, String retainedIDs) {
        String lastDigits =  id.substring(id.length()-retainedIDs.length());
        return lastDigits.equals(retainedIDs);
    }
}
