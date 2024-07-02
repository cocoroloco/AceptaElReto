package BarJavier108;

import java.util.Scanner;

public class BarJavier {
    private static String input;
    private static double NumericInput;
    static Scanner s = new Scanner(System.in);
    static double totalAverage = 0;
    static double mealAverage = 0;
    static double totalDayProfit = 0;
    static double biggestIncome = 0;
    static double lowestIncome = 2147483647;
    static int totalSellsNum = 0;
    static int totalMealsNum = 0;
    static int biggestDayIndex = -1;
    static int lowestDayIndex = -1;
    static boolean biggestDayTie = false;
    static boolean lowestDayTie = false;
    // TODO COMPROBAR CASO A 100.00 N 0
    // EN ESTE CASO DEBERIA SALIR NO PERO EN EL MIO SALE SI
    // Ejemplo, si solo hay cena, sería empate entre los 0 o solo esa categoria

    // 0 D Desayunos
    // 1 A Comidas
    // 2 M Meriendas
    // 3 I Cenas
    // 4 C Copas
    private static double[] categories = new double[5];

    public static void printCategories(int index) {

        switch (index) {
            case 0:
                System.out.print("DESAYUNOS#");
                break;

            case 1:
                System.out.print("COMIDAS#");
                break;

            case 2:
                System.out.print("MERIENDAS#");
                break;

            case 3:
                System.out.print("CENAS#");
                break;

            case 4:
                System.out.print("COPAS#");
                break;

            default:
                System.out.print("EMPATE#");
                break;
        }
    }

    public static void printResults() {

        totalDayProfit = categories[0] + categories[1] + categories[2] + categories[3] + categories[4];
        mealAverage = categories[1] / totalMealsNum;
        totalAverage = totalDayProfit / totalSellsNum;

        for (int i = 0; i < categories.length; i++) {
            if (categories[i] > biggestIncome) {
                biggestDayIndex = i;
                biggestIncome = categories[i];
            }
            if (categories[i] < lowestIncome) {
                lowestDayIndex = i;
                lowestIncome = categories[i];
            }
        }

        for (int i = 0; i < categories.length; i++) {
            if (categories[i] == biggestIncome && i != biggestDayIndex) {
                biggestDayTie = true;
            }
            if (categories[i] == lowestIncome && i != lowestDayIndex) {
                lowestDayTie = true;
            }
        }

        if (biggestDayTie) {
            System.out.print("EMPATE#");
        } else {
            printCategories(biggestDayIndex);
        }

        if (lowestDayTie) {
            System.out.print("EMPATE#");
        } else {
            printCategories(lowestDayIndex);
        }

        if (mealAverage > totalAverage) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean checkEnd() {
        input = s.nextLine();
        NumericInput = Double.parseDouble(input.substring(2));
        if (NumericInput == 0 && input.charAt(0) == 'N') {
            printResults();
            for (int i = 0; i < 5; i++) {
                categories[i] = 0;
            }
            totalAverage = 0;
            mealAverage = 0;
            totalDayProfit = 0;
            biggestIncome = 0;
            lowestIncome = 2147483647;
            totalSellsNum = 0;
            totalMealsNum = 0;
            biggestDayIndex = -1;
            lowestDayIndex = -1;
            biggestDayTie = false;
            lowestDayTie = false;
            return true;
        } else {
            switch (input.charAt(0)) {
                case 'D':
                    categories[0] = categories[0] + NumericInput;
                    break;
                case 'A':
                    categories[1] = categories[1] + NumericInput;
                    totalMealsNum = totalMealsNum + 1;
                    break;
                case 'M':
                    categories[2] = categories[2] + NumericInput;
                    break;
                case 'I':
                    categories[3] = categories[3] + NumericInput;
                    break;

                case 'C':
                    categories[4] = categories[4] + NumericInput;
                    break;
                default:
                    break;
            }
            totalSellsNum = totalSellsNum + 1;

            return false;
        }
    }

    public static void main(String[] args) {

        while (s.hasNextLine()) {
            checkEnd();
        }

        s.close();
    }
}
