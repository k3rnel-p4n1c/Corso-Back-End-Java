package modulo2;
import java.util.Scanner;

public class ContaVocaliConsonanti {
    public static void main(String[] args) {

        String parola;
        int risultato;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci parola: ");
        parola = scanner.nextLine();

        risultato = ContaVocaliConsonanti.contaVocali(parola);

        System.out.println("Il numero di vocali nella parola \"" +parola+ "\" è: " +risultato);
        System.out.println("Mentre il numero di consonanti è: " +(parola.length()-risultato));
    }

    private static int contaVocali(String parola) {
        int numero_vocali = 0;

        for (int i=0; i<parola.length(); i++) {
            if (parola.charAt(i) == 'a' || parola.charAt(i) == 'e' || parola.charAt(i) == 'i' || parola.charAt(i) == 'o' || parola.charAt(i) == 'u')
                numero_vocali += 1;
        }

        return numero_vocali;
    }
}