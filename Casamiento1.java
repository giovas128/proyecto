package casamiento;

/**
 *
 * @author Ingeniero Karen Rangel Miguel
 */

   
import java.util.Scanner;

public class Casamiento1  {

    public static void main(String[] args) {
        boolean hasBaptism = false;
        boolean hasConfirmation = false;
        boolean hasCommunion = false;
        
        System.out.println("¡Bienvenido al registro de bodas!");
        Scanner scanner = new Scanner(System.in);
        
        while (!hasBaptism || !hasConfirmation || !hasCommunion) {
            boolean invalidInput = false;
            
            if (!hasBaptism) {
                System.out.println("¿Has tenido tu bautismo? (Si/No): ");
                String baptismInput = scanner.nextLine();
                
                if (baptismInput.equalsIgnoreCase("Si")) {
                    hasBaptism = true;
                } else {
                    invalidInput = true;
                }
            }
            
            if (!hasConfirmation && !invalidInput) {
                System.out.println("¿Has tenido tu confirmación? (Si/No): ");
                String confirmationInput = scanner.nextLine();
                
                if (confirmationInput.equalsIgnoreCase("Si")) {
                    hasConfirmation = true;
                } else {
                    invalidInput = true;
                }
            }
            
            if (!hasCommunion && !invalidInput) {
                System.out.println("¿Has tenido tu comunión? (Si/No): ");
                String communionInput = scanner.nextLine();
                
                if (communionInput.equalsIgnoreCase("Si")) {
                    hasCommunion = true;
                } else {
                    invalidInput = true;
                }
            }
            
            if (!hasBaptism || !hasConfirmation || !hasCommunion || invalidInput) {
                System.out.println("Lo siento, no tienes todos los trámites requeridos.Por favor, vuelva a hacer esos trámites.");
                hasBaptism = false;
                hasConfirmation = false;
                hasCommunion = false;
            }
        }
        
        System.out.println("Felicidades, tienes todos los trámites requeridos para el registro de tu boda.¡Procedamos con el registro!");
    }
}
    
    

