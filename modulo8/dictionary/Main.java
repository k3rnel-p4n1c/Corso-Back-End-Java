/* Scrivere un programma per gestire un dizionario. In particolare, ad ogni lettera dell'alfabeto è associata una lista di parole che
 * iniziano con quella lettera e ad ogni parola è, a sua volta, associata una lista di significati diversi della parola.
 * Esempio:
 * c -> calcio -> sport
 * c -> calcio -> elemento chimico
 *
 * Devono essere possibili le seguenti operazioni:
 * inserisci parola (con almeno un significato associato)
 * aggiungi significato per una certa parola
 * stampa dizionario, che ritorna una stringa contenente ogni parola e significato (in ordine lessicografico ascendente in base alla lettera)
 * nella forma:
 * lettera1:[parola1: (significato1;significato2;...;), parola2: (significato1;...;...;)]
 * lettera2:[parola1: significato1;significato2;...;), parola2: (significato1;...;...;)]
 * ...
 * letteraN:[parola1: significato1;significato2;...;),parola2: (significato1;...;...;)]
 *
 * Prevedere il sollevamento delle seguenti eccezioni:
 * LetterNotPresentException: lanciata nel caso la lettera da cercare o rimuovere non sia contenuta nella struttura dati
 * WordNotPresentException: lanciata nel caso in cui la parola da cercare o rimuovere non sia contenuta
 * ElementAlreadyContainedException: lanciata nel caso in cui la chiave da aggiungere sia già contenuta
 */
package modulo8.dictionary;

import modulo8.dictionary.eccezioni.LetteraNonPresenteException;
import modulo8.dictionary.eccezioni.ParolaNonPresenteException;

public class Main {
    public static void main(String[] args) {

        String parola1 = "calcio";
        String definizione1_1 = "La parte inferiore della cassa del fucile";
        String definizione1_2 = "Gioco di squadra che prevede di tirare calci ad un pallone e inseguirlo";
        String definizione1_3 = "Elemento chimico (numero atomico 20)";

        String parola2 = "coda";
        String definizione2_1 = "Parte terminale posteriore, assottigliata, del corpo dei vertebrati";
        String definizione2_2 = "Lunga fila di macchine - sinonimo di \"traffico\"";

        String parola3 = "tramoggia";
        String definizione3_1 = "Apparecchio costituito da un recipiente a pareti inclinate munito di un'apertura sul fondo";

        Dizionario dizionario = new Dizionario();

        dizionario.aggiungiParola(parola1, definizione1_1);
        dizionario.aggiungiDefinizione(parola1, definizione1_2);
        dizionario.aggiungiDefinizione(parola1, definizione1_3);

        dizionario.aggiungiParola(parola2, definizione2_1);
        dizionario.aggiungiDefinizione(parola2, definizione2_2);

        dizionario.aggiungiParola(parola3, definizione3_1);

        System.out.println(dizionario);

        System.out.println("Cerco le parole che iniziano per \"x\":");
        try {
            dizionario.cercaLetteraIniziale('x');
        } catch (LetteraNonPresenteException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Cerco la parola \"cane\":");
        try {
            dizionario.cercaParola("cane");
        } catch (ParolaNonPresenteException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Rimuovo la parola \"calcio\"");
        try {
            dizionario.rimuoviParola("calcio");
        } catch (ParolaNonPresenteException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\nStampa dizionario:\n" +dizionario);
    }
}