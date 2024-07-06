package NumKaprekar115;

import java.util.Scanner;

public class NumKaprekar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isKaprekar = false;
        long number;
        long elevatedNumber;
        long base;
        long rest;

        while ((number = scanner.nextInt()) != 0) {
            if (number != 1) {
                elevatedNumber = number * number;
                isKaprekar = false;
                for (long i = 10; i < elevatedNumber; i = i * 10) {
                    base = elevatedNumber / i;
                    rest = elevatedNumber % i;
                    if (base + rest == number && rest > 0) {
                        isKaprekar = true;
                        break;
                    }
                }
                if (isKaprekar) {
                    System.out.println("SI");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("SI");
            }
        }
        scanner.close();

    }

}
