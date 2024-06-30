import java.util.Scanner;

public class Encriptacion {

    public static int decrypt(String encryptMsg){
        int vocalCont=0;
        char pCode = encryptMsg.charAt(0);
        char actualChar;
        boolean isLowerCase = Character.isLowerCase(pCode);
        int cesarNumber;

        if (isLowerCase) {
            cesarNumber = 'p' - pCode;
        } else {
            cesarNumber = 'P' - pCode;
        }

        if (    (char) encryptMsg.charAt(1) + cesarNumber == 'F' &&
                (char) encryptMsg.charAt(2) + cesarNumber == 'I' && 
                (char) encryptMsg.charAt(3) + cesarNumber == 'N') {

            return -1;
        }

        //System.out.println(cesarNumber);

        for (int i = 1; i <= encryptMsg.length()-1; i++) {

            actualChar = encryptMsg.charAt(i);

            if(cesarNumber + actualChar > 122 || cesarNumber + actualChar > 90 && cesarNumber + actualChar < 97 ){
                actualChar = (char) (actualChar -26 + cesarNumber);
            }
            else {
                actualChar = (char) (actualChar + cesarNumber);   
            }

            if (actualChar == 'a' || actualChar == 'A' || 
                actualChar == 'e' || actualChar == 'E' || 
                actualChar == 'i' || actualChar == 'I' || 
                actualChar == 'o' || actualChar == 'O' ||
                actualChar == 'u' || actualChar == 'U') {
                
                vocalCont++;
            }

        }

        return vocalCont;
    }
    
    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);
        String input;
        int result;

        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            result = decrypt(input);
            if (result == -1) {
                break;
            }
            System.out.println(result);
        }
        scanner.close();
    }
}
