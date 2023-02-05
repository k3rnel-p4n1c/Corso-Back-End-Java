/* Scrivete una funzione che dato in input un numero di secondi, restituisce una stringa che dice:
 * «Giorni: numero di giorni
 * Ore: numero di ore etc…»
 */
package modulo2;
import java.util.Scanner;

public class SecondiMinutiOre {
    public static void main(String[] args) {

        int secondi;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di secondi: ");
        secondi = scanner.nextInt();

        System.out.println(calcolaTempo(secondi));
    }

    private static String calcolaTempo(int secondi) {
        int minuti = secondi/60;
        int ore = minuti/60;
        int giorni = ore/24;;

        if (secondi < 0)
            return "Errore";
        else if (secondi < 60)
            return "Secondi: " +secondi;
        else if (secondi>=60 && minuti<60)
            return "Minuti: " +minuti+ "\n" +calcolaTempo(secondi%60);
        else if (minuti>=60 && ore<24)
            return "Ore: " +ore+ "\n" +calcolaTempo(secondi%(60*60));
        else
            return "Giorni: " +giorni+ "\n" +calcolaTempo(secondi%(24*60*60));
    }
}