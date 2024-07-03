package TorneoPadel109;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import TorneoPadel109.Match;

/**
 * TorneoPadel
 */

public class TorneoPadel {
    private static Scanner scanner = new Scanner(System.in);
    private static String inputLine;
    static List<Match> matchs = new ArrayList<>();
    static Map<String, Integer> teamNamePoints = new HashMap<>();

    public static void calculateWinner() {
        for (Match match : matchs) {
            if (match.getHomeSets() > match.getVisitantSets()) {

                if (teamNamePoints.get(match.getHomeTeam()) != null) {
                    teamNamePoints.put(match.getHomeTeam(), 2);
                } else {
                    teamNamePoints.put(match.getHomeTeam(), teamNamePoints.get(match.getHomeSets()) + 2);
                }

                if (teamNamePoints.get(match.getVisitantTeam()) != null) {
                    teamNamePoints.put(match.getVisitantTeam(), 1);
                } else {
                    teamNamePoints.put(match.getVisitantTeam(), teamNamePoints.get(match.getVisitantSets()) + 1);
                }

            } else {

                if (teamNamePoints.get(match.getHomeTeam()) != null) {
                    teamNamePoints.put(match.getHomeTeam(), 1);
                } else {
                    teamNamePoints.put(match.getHomeTeam(), teamNamePoints.get(match.getHomeSets()) + 1);
                }

                if (teamNamePoints.get(match.getVisitantTeam()) != null) {
                    teamNamePoints.put(match.getVisitantTeam(), 2);
                } else {
                    teamNamePoints.put(match.getVisitantTeam(), teamNamePoints.get(match.getVisitantSets()) + 2);
                }
            }
        }
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // Recorrer el mapa para encontrar el mayor valor
        for (Map.Entry<String, Integer> entry : teamNamePoints.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        int noPlayedGames = teamNamePoints.size() * (teamNamePoints.size() - 1) - matchs.size();

        System.out.println(maxKey + " " + noPlayedGames);

    }

    public static void main(String[] args) {
        while (!(inputLine = scanner.nextLine()).equals("FIN")) {
            while (!(inputLine = scanner.nextLine()).equals("FIN")) {
                // Procesar los resultss de la categoría
                Match aMatch = new Match();
                String[] results = inputLine.split(" ");
                aMatch.setHomeTeam(results[0]);
                aMatch.setHomeSets(Integer.parseInt(results[1]));
                aMatch.setVisitantTeam(results[2]);
                aMatch.setVisitantSets(Integer.parseInt(results[3]));

                matchs.add(aMatch);
            }
            for (Match m : matchs) {
                System.out.println(m.getHomeTeam());
            }
            calculateWinner();
        }
    }
}
