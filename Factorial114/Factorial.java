package Factorial114;

import java.util.Scanner;

public class Factorial {

    // Función que retorna el último dígito del factorial de un número dado
    public static int getLastDigitOfFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 6;
        } else if (n == 4) {
            return 4;
        } else {
            return 0; // Para n >= 5 el último dígito siempre es 0
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCase = scanner.nextInt();

        for (int i = 0; i < numCase; i++) {
            System.out.println(getLastDigitOfFactorial(scanner.nextInt()));
        }
        scanner.close();
    }
}
