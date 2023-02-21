/* Scrivere un programma per gestire gli interessi in comune tra le persone. In particolare, deve essere possibile gestire una quantità
 * potenzialmente infinita di utenti, ognuno con i propri interessi (a ciascun utente può essere associato uno o più interessi). Ogni interesse
 * ha un codice e un testo. Devono essere possibili le seguenti operazioni:
 * inserire un utente e i suoi interessi;
 * cancellare un utente (e i suoi interessi associati);
 * dato un utente u1, ottenere l'utente u2 con più interessi in comune con u1.
 */
package modulo7.tinder_like;

public class Main {
    public static void main(String[] args) {
        //Creo un'istanza di Tinder
        Tinder tinder = new Tinder();

        //Creo gli utenti
        Utente utente1 = new Utente("utente1");
        Utente utente2 = new Utente("utente2");
        Utente utente3 = new Utente("utente3");
        Utente utente4 = new Utente("utente4");
        Utente utente5 = new Utente("utente5");

        //Assegno degli interessi agli utenti
        utente1.aggiungiInteresse(Interesse.PALESTRA);
        utente1.aggiungiInteresse(Interesse.CALCIO);
        utente2.aggiungiInteresse(Interesse.CALCIO);
        utente3.aggiungiInteresse(Interesse.RUGBY);
        utente4.aggiungiInteresse(Interesse.GIARDINAGGIO);
        utente5.aggiungiInteresse(Interesse.LETTURA);

        //Aggiungo gli utenti su tinder
        tinder.inserisciUtente(utente1);
        tinder.inserisciUtente(utente2);
        tinder.inserisciUtente(utente3);
        tinder.inserisciUtente(utente4);
        tinder.inserisciUtente(utente5);

        //Stampo gli utenti presenti su Tinder
        tinder.utenteConPiuInteressiInComune(utente2);
    }
}