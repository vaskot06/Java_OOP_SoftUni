import FootballTeamGenerator.Player;
import FootballTeamGenerator.Team;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Team> teams = new HashMap<>();

        while (!line.equals("END")) {
            String[] tokens = line.split(";");

            try {
                if ("Team".equals(tokens[0])) {
                    teams.putIfAbsent(tokens[1], new Team(tokens[1]));
                } else if ("Add".equals(tokens[0])) {
                    if (teams.containsKey(tokens[1])) {
                        Player player = new Player(tokens[2], Integer.parseInt(tokens[3])
                                , Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5])
                                , Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]));

                        teams.get(tokens[1]).addPlayer(player);
                    } else {
                        System.out.println("Team " + tokens[1] + "does not exist.");
                    }
                } else if ("Remove".equals(tokens[0])) {
                    String teamName = tokens[1];
                    String playerName = tokens[2];
                    if (teams.get(teamName).hasPlayer(playerName)) {
                        teams.get(teamName).removePlayer(playerName);
                    } else {
                        System.out.printf("Player %s is not in %s team.%n", playerName, teamName);
                    }
                } else if ("Rating".equals(tokens[0])) {
                    if (teams.containsKey(tokens[1])) {
                        int rating = (int) Math.round(teams.get(tokens[1]).getRating());
                        System.out.println(tokens[1] + " - " + rating);
                    } else {
                        System.out.println("Team " + tokens[1] + " does not exist.");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            line = scanner.nextLine();
        }
    }
}
