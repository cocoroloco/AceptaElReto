import java.util.Arrays;
import java.util.Scanner;

public class Kaprekar {

    // Función para ordenar los dígitos de un número en orden ascendente
    public static String ordenarAscendente(String num) {
        char[] numChars = num.toCharArray();
        Arrays.sort(numChars);
        return new String(numChars);
    }

    // Función para ordenar los dígitos de un número en orden descendente
    public static String ordenarDescendente(String num) {
        char[] numChars = num.toCharArray();
        Arrays.sort(numChars);
        StringBuilder numOrdenadoDes = new StringBuilder(new String(numChars));
        return numOrdenadoDes.reverse().toString();
    }

    // Función para calcular el número de iteraciones de la rutina de Kaprekar
    public static int iteracionesKaprekar(int num) {
        if (num == 6174) return 0;
        int iteraciones = 0;
        String numStr = String.format("%04d", num); // Convertimos a cadena con 4 dígitos, rellenando con ceros si es necesario
        while (num != 6174) {
            String ascendenteStr = ordenarAscendente(numStr);
            String descendenteStr = ordenarDescendente(numStr);

            int ascendente = Integer.parseInt(ascendenteStr);
            int descendente = Integer.parseInt(descendenteStr);

            num = descendente - ascendente;
            numStr = String.format("%04d", num); // Convertimos el resultado a cadena con 4 dígitos, rellenando con ceros si es necesario

            if (num == 0) return 8;

            iteraciones++;
        }
        return iteraciones;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int casos = scanner.nextInt();
        for (int i = 0; i < casos; i++) {
            int numero = scanner.nextInt();
            System.out.println(iteracionesKaprekar(numero));
        }

        scanner.close();
    }
}
