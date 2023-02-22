/* Spesso è interessante analizzare uno o più file di testo in una determinata lingua per comprendere quali siano le parole più
 * frequenti (o anche le lettere più frequenti). Questo tipo di lavoro è molto utilizzato in vari ambiti, dalla crittografia, alla
 * linguistica, al Natural Language Processing. Vogliamo realizzare la classe FileAndParole, che effettua alcune di queste operazioni
 * ed è composta dai seguenti metodi:
 * stampaParole(Path file): questo metodo prende in input un oggetto della classe Path del package java.nio.file rappresentante un
 * file di testo e stampa riga per riga tutte le parole contenute nel testo. Si supponga che ogni parola sia separata da spazio e non
 * vi siano segni di punteggiatura.
 * occorrenzeParole(Path file): questo metodo prende in input un oggetto della classe Path del package java.nio.file rappresentante un
 * file di testo e ritorna una HashMap dove le chiavi sono le parole e i valori sono il numero di occorrenze delle parole stesse nel
 * testo. Si supponga che ogni parola sia separata da spazio, siano tutte minuscole e non vi siano segni di punteggiatura.
 * occorrenzeParoleTesto(Path file): questo metodo prende in input un oggetto della classe Path del package java.nio.file rappresentante
 * un file di testo e ritorna una HashMap dove le chiavi sono le parole e i valori sono il numero di occorrenze delle parole stesse nel
 * testo. In questo caso il testo può comprendere punteggiatura e lettere maiuscole. SUGGERIMENTO: per eliminare la punteggiatura da una
 * riga di testo utilizzare il metodo riga.split("\W+").
 */
package modulo9.file_parole;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Path file = Paths.get("src", "modulo9", "file_parole", "file.txt");
        Path rime = Paths.get("src", "modulo9", "file_parole", "rime.txt");
        HashMap<String, Integer> occorrenze_parole = GestoreParole.contaOccorrenzeParole(file);
        HashMap<String, ArrayList<String>> parole_in_rima = GestoreParole.paroleInRima(rime);

        for (String parola : occorrenze_parole.keySet())
            System.out.println("Parola: " +parola+ "\nOccorrenze: " +occorrenze_parole.get(parola)+ "\n");

        GestoreParole.stampaContenutoFile(file);
        System.out.println("\n");
        GestoreParole.stampaParoleSeparateDaSpazi(file);
        System.out.println("\n");

        for (String parola : parole_in_rima.keySet())
            System.out.println("Dittongo: " +parola+ "\nParole: " +parole_in_rima.get(parola)+ "\n");
    }
}