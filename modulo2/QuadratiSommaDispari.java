/* Il quadrato di un numero N non è altro che la somma dei primi N numeri dispari. Per esempio:
 * 9 = 5+3+1
 * 36 = 11+9+7+5+3+1
 */
package modulo2;
import java.util.Scanner;

public class QuadratiSommaDispari {
    public static void main(String[] args) {

        int n, risultato=0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci numero: ");
        n = scanner.nextInt();

        if (n <= 0)
            System.out.println("Errore. Il numero inserito non è valido.");
        else
            for (int i=0; i<n; i++)
                risultato += 2*i+1;     //I numeri dispari si ottengono con 2n+1

        System.out.println("Il quadrato di " +n+ " è: " +risultato);
    }
}