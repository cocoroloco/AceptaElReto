package Ventas105;

import java.util.Locale;
import java.util.Scanner;

/**
 * Ventas
 */
public class Ventas {
  private static double[] days = new double[6];
  private static double[] input = new double[36];
  private static int biggestDayIncome;
  private static int lowestDayIncome;
  private static boolean sundayBiggerThanWeekly;

  public static void printSwitchDay(int day) {
    switch (day) {
      case 0:
        System.out.print("MARTES ");
        break;

      case 1:
        System.out.print("MIERCOLES ");
        break;

      case 2:
        System.out.print("JUEVES ");
        break;

      case 3:
        System.out.print("VIERNES ");
        break;

      case 4:
        System.out.print("SABADO ");
        break;

      case 5:
        System.out.print("DOMINGO ");
        break;

      default:
        break;
    }
  }

  public static void printWeeklyData() {
    if (biggestDayIncome != lowestDayIncome) {
      printSwitchDay(biggestDayIncome);
      printSwitchDay(lowestDayIncome);
    } else {
      System.out.print("EMPATE ");
    }

    if (sundayBiggerThanWeekly) {
      System.out.println("NO");
    } else {
      System.out.println("SI");
    }

  }

  public static void calculateStadistic() {
    // Inicializamos el valor máximo con el primer elemento del array
    double biggestIncome = days[0];
    double lowestIncome = days[0];
    double average = 0;

    for (int i = 0; i < 6; i++) {
      // Recorremos el array para encontrar el valor máximo
      if (days[i] > biggestIncome) {
        biggestDayIncome = i;
        biggestIncome = days[i];
      }
      if (days[i] < lowestIncome) {
        lowestDayIncome = i;
        lowestIncome = days[i];
      }
      average = average + days[i];
    }
    if (average > days[5]) {
      sundayBiggerThanWeekly = false;
    } else {
      sundayBiggerThanWeekly = true;
    }
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    //ESTA LINEA FORMATEA LA SEPARACION DECIMAL DE . A ,
    scanner.useLocale(Locale.US);
    boolean end = false;
    int iterator = 0;
    double bill;

    while (!end) {
      bill = scanner.nextDouble();
      if (bill == -1) {
        end = true;
      }
      input[iterator] = bill;
      iterator++;
    }

    for (int i = 0; i < iterator-1; i=i+6) {
      days[0] = input[i];
      days[1] = input[i+1];
      days[2] = input[i+2];
      days[3] = input[i+3];
      days[4] = input[i+4];
      days[5] = input[i+5];

      calculateStadistic();
      printWeeklyData();
    }

    scanner.close();
  }
}
