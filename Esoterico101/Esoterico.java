import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Esoterico {

    static int magicConstant1;
    static int magicConstant2;

    public static boolean checkMatrix(Integer[][] square) {
        int n = square.length;

        // Crear un conjunto con números del 1 al n^2
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 1; i <= n * n; i++) {
            numberSet.add(i);
        }

        // Recorrer la matriz y eliminar los números encontrados del conjunto
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                numberSet.remove(square[i][j]);
            }
        }

        // Si el conjunto está vacío, todos los números pertenecen al rango
        return numberSet.isEmpty();
    }

    public static boolean esDiabolico(Integer[][] square){

        int diagonalSum=0;
        int horizontalSum=0;
        int verticalSum=0;

        for (int i = 0; i < square.length; i++) {
            magicConstant1 = magicConstant1 + square[i][i];
        }

        for (int i = square.length-1; i >=0; i--) {
            diagonalSum = diagonalSum + square[i][i];
        }

        if (diagonalSum != magicConstant1) {
            return false;
        }
        
        

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                horizontalSum = horizontalSum + square[i][j];
                verticalSum = verticalSum + square[j][i];
            }
            if(horizontalSum != magicConstant1 || verticalSum != magicConstant1) return false;
            horizontalSum=0;
            verticalSum=0;
        }

        return true;
    }

    public static boolean esEsoterico(Integer[][] square){

        if (!checkMatrix(square)) return false;

        int magicConstant2 = square[0][0] + square[square.length-1][square.length-1] + square[0][square.length-1] + square[square.length-1][0];
        int squareSize = square.length * square.length;
        int init = Math.round(square.length/2);

        if(magicConstant1*4/square.length != magicConstant2) return false;

        if(squareSize%2 != 0){
            
            int centerSum= 4 * square[init][init];

            if(magicConstant2 != centerSum) return false;

            int sideSum =   square[0][init] +  
                            square[square.length-1][init]  +
                            square[init][0] + 
                            square[init][square.length-1];

            if (sideSum != magicConstant2) return false;
        }
        else{

            int centerSum= square[init][init] + square[init+1][init+1] + square[init+1][init] + square[init][init+1];

            if(magicConstant2 != centerSum) return false;

            int sideSum =   square[0][init] + square[0][init-1] + 
                            square[square.length-1][init] + square[square.length-1][init-1] +
                            square[init][0] + square[init-1][0] + 
                            square[init][square.length-1] + square[init-1][square.length-1];

            if (sideSum != 2*magicConstant2) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        //CUIDADO TOMA LA SALIDA COMO ENTRADA
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            Integer[][] square = new Integer[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    square[i][j] = scanner.nextInt();
                }
            }


            if (esDiabolico(square)) {
                if (esEsoterico(square)) {
                    System.out.println("ESOTERICO");
                } else {
                    System.out.println("DIABOLICO");
                }
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }

    
}
