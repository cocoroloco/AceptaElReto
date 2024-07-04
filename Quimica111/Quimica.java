package Quimica111;

import java.util.Scanner;

public class Quimica {
    static String levels[] = { "1s", "2s", "2p", "3s", "3p", "4s", "3d", "4p", "5s", "4d", "5p", "6s", "4f", "5d", "6p",
            "7s",
            "5f", "6d", "7p" };

    static String aLevel;

    public static int getMaxLevelAtoms(String level) {
        int maxNumAtoms = 0;
        switch (level) {
            case "s":
                maxNumAtoms = 2;
                break;
            case "p":
                maxNumAtoms = 6;
                break;
            case "d":
                maxNumAtoms = 10;
                break;
            case "f":
                maxNumAtoms = 14;
                break;

            default:
                maxNumAtoms = 0;
                break;
        }
        return maxNumAtoms;
    }

    public static void main(String[] args) {
        int number = 118;
        int result = number;
        int difference;
        int maxAtoms;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (scanner.nextLine().equals("Exit")) {
                break;
            }
            result = Integer.parseInt(scanner.nextLine());
            if (result == 0) {
                System.out.print("1s0");
            }
            for (int i = 0; result > 0; i++) {
                aLevel = String.valueOf(levels[i].charAt(1));
                maxAtoms = getMaxLevelAtoms(aLevel);
                result = result - maxAtoms;

                if (result > 0) {
                    System.out.print(levels[i] + maxAtoms + " ");
                } else {
                    difference = maxAtoms + result;
                    System.out.print(levels[i] + difference);
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
