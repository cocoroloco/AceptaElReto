package CodigoBarras106;

import java.util.Scanner;

public class CodigoBarras {

  public static void main(String[] args) {
    int[] ean8 = new int[8];
    int[] ean13 = new int[13];
    int inputLength = 0;
    String inputString;

    Scanner sc = new Scanner(System.in);
    Long input;
    while ((input = sc.nextLong()) != 0) {
      inputLength = String.valueOf(input).length();
      // Convertir el entero a una cadena
      inputString = String.valueOf(input);

      if (inputLength <= 8) {
        // Iterar sobre cada carácter de la cadena y convertirlo a entero
        for (int i = 0; i < 8; i++) {
          ean8[i] = 0;
        }
        for (int i = inputLength - 1; i >= 0; i--) {
          ean8[i] = Character.getNumericValue(inputString.charAt(i));
        }
        if (((ean8[1] + ean8[3] + ean8[5] + ean8[7]) * 3 + (ean8[2] + ean8[4] + ean8[6]) * 1 + ean8[0]) % 10 == 0) {
          System.out.println("SI");
        } else {
          System.out.println("NO");
        }

      } else if (inputLength <= 13) {
        // Iterar sobre cada carácter de la cadena y convertirlo a entero
        for (int i = 0; i < 13; i++) {
          ean13[i] = 0;
        }
        for (int i = inputLength - 1; i >= 0; i--) {
          ean13[i] = Character.getNumericValue(inputString.charAt(i));
        }
        if (((ean13[1] + ean13[3] + ean13[5] + ean13[7] + ean13[9] + ean13[11]) * 3
            + (ean13[2] + ean13[4] + ean13[6] + ean13[8] + ean13[10] + ean13[12]) * 1 + ean13[0]) % 10 == 0) {
          System.out.print("SI ");

          if (ean13[0] == 0) {
            System.out.print("EEUU");
          } else if (ean13[0] == 5 && ean13[1] == 0) {
            System.out.println("Inglaterra");
          } else if (ean13[0] == 7 && ean13[1] == 0) {
            System.out.println("Noruega");
          } else {
            int code = 0;

            for (int i = 0; i < 3; i++) {
              code = code * 10 + ean13[i];
            }
            switch (code) {
              case 380:
                System.out.println("Bulgaria");
                break;

              case 539:
                System.out.println("Irlanda");
                break;

              case 560:
                System.out.println("Portugal");
                break;

              case 759:
                System.out.println("Venezuela");
                break;

              case 850:
                System.out.println("Cuba");
                break;

              case 890:
                System.out.println("India");
                break;

              default:
                System.out.println("Desconocido");
                break;
            }
          }
        } else {
          System.out.println("NO ");
        }
      }
    }
    sc.close();
  }
}
