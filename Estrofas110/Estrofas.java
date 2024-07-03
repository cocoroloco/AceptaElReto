package Estrofas110;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Estrofas
 */

public class Estrofas {
    private static Scanner scanner = new Scanner(System.in);
    private static String inputLine;
    private static int numberOfRhymes;
    private static String rhymeVerse[] = new String[4];
    static String regex = "[a-z]";
    static String regexAs = "aeiou";
    // Crear el patrón a partir de la expresión regular
    static Pattern pattern = Pattern.compile(regex);
    static Pattern patternAs = Pattern.compile(regexAs);


    public static void checkRhymes() {
        switch (numberOfRhymes) {
            case 2:
                if (rhymeVerse[0].equals(rhymeVerse[1])) {
                    System.out.println("PAREADO");
                } else {
                    System.out.println("DESCONOCIDO");
                }
                break;
            case 3:
                if (rhymeVerse[0].equals(rhymeVerse[2]) && !rhymeVerse[1].equals(rhymeVerse[0]) && rhymeVerse[0].charAt(1) != rhymeVerse[1].charAt(1)) {
                    System.out.println("TERCETO");
                } else {
                    System.out.println("DESCONOCIDO");
                }
                break;
            case 4:
                // TODO el RTE se encuentra en este fragmento
                if (rhymeVerse[0].equals(rhymeVerse[1]) && rhymeVerse[1].equals(rhymeVerse[2])
                        && rhymeVerse[2].equals(rhymeVerse[3])) {
                    System.out.println("CUADERNA VIA");
                } else if (rhymeVerse[0].equals(rhymeVerse[2]) && rhymeVerse[1].equals(rhymeVerse[3])) {
                    System.out.println("CUARTETA");
                } else if (rhymeVerse[0].equals(rhymeVerse[3]) && rhymeVerse[1].equals(rhymeVerse[2])) {
                    System.out.println("CUARTETO");
                } else if (rhymeVerse[1].charAt(1) == rhymeVerse[3].charAt(1)
                        && rhymeVerse[1].charAt(0) != rhymeVerse[3].charAt(0)
                        && rhymeVerse[0].charAt(1) != rhymeVerse[1].charAt(1)
                        && rhymeVerse[0].charAt(1) != rhymeVerse[2].charAt(1)) {
                    System.out.println("SEGUIDILLA");
                } else {
                    System.out.println("DESCONOCIDO");
                }

                break;

            default:
                System.out.println("DESCONOCIDO");
                break;
        }
    }

    public static void main(String[] args) {
        while ((numberOfRhymes = scanner.nextInt()) != 0) {
            scanner.nextLine();
            for (int i = 0; i < numberOfRhymes; i++) {
                inputLine = scanner.nextLine();
                // Procesar los resultss de la categoría
                String[] results = inputLine.split(" ");
                String lastWord = results[results.length - 1];
                String lastLetter = String.valueOf(lastWord.charAt(lastWord.length() - 1));
                Matcher matcher = pattern.matcher(lastLetter);
                int lastWordLength = lastWord.length();
                if (matcher.matches() && numberOfRhymes <= 4) {
                    if (lastWordLength > 1) {
                        rhymeVerse[i] = lastWord.charAt(lastWordLength - 2) + lastLetter;
                    }
                } else if (numberOfRhymes <= 4) {
                    if (lastWordLength > 2) {
                        rhymeVerse[i] = String.valueOf(lastWord.charAt(lastWordLength - 3) +
                                lastWord.charAt(lastWord.length() - 2));
                    }
                }
            }
            checkRhymes();
        }
        scanner.close();
    }
}
