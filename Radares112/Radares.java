package Radares112;

import java.util.Scanner;

public class Radares {

    public static void calculateSpeed(int dt, int sl, int tt) {
        float avgSpeed = (float) dt / tt * 3600 / 1000;
        double maxLimitPercentage = sl + sl * 0.2;

        if (avgSpeed < sl) {
            System.out.println("OK");
        } else if (avgSpeed < maxLimitPercentage) {
            System.out.println("MULTA");
        } else {
            System.out.println("PUNTOS");
        }
    }

    public static void main(String[] args) {
        int distanceTraveled;
        int speedLimit;
        int timeTraveled;
        String inputLine;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            inputLine = scanner.nextLine();

            String[] results = inputLine.split(" ");
            distanceTraveled = Integer.parseInt(results[0]);
            speedLimit = Integer.parseInt(results[1]);
            timeTraveled = Integer.parseInt(results[2]);

            if (distanceTraveled == 0 && speedLimit == 0 && timeTraveled == 0) {
                break;
            }

            if (distanceTraveled <= 0 || speedLimit <= 0 || timeTraveled <= 0) {
                System.out.println("ERROR");
            } else {
                calculateSpeed(distanceTraveled, speedLimit, timeTraveled);
            }
        }

        scanner.close();
    }

}
