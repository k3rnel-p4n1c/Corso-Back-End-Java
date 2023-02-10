/* Progettare una classe Classifica che permetta di gestire la classifica di Serie A costruita a partire da 20 squadre di calcio.
 * Ogni squadra di calcio ha i seguenti attributi:
 * id
 * nome
 * rosa di giocatori
 * punteggio
 * gol fatti
 * gol subiti
 *
 * Ogni giocatore ha un id, un nome e un cognome. In particolare, deve essere possibile gestire le seguenti operazioni:
 * esitoPartita(squadraCasa, golCasa, squadraOspite, golOspite): gestisce il punteggio delle due squadre in base all'esito
 * getClassifica(): ritorna la classifica attuale, ordinata per punteggio
 * getMigliorAttacco(): ritorna la squadra che ha segnato più gol
 * getPeggiorDifesa(): ritorna la squadra che ha concesso più gol
 */
package modulo5.serie_a;

public class Main {
    public static void main(String[] args) {
        Giocatore[] giocatori1 = new Giocatore[11];
        Giocatore[] giocatori2 = new Giocatore[11];

        //Questo oggetto serve solamente per far giocare una partita a due squadre
        Partita partita = new Partita();

        //Inizializzo i nomi e i cognomi dei giocatori
        for (int i=0; i<11; i++) {
            giocatori1[i] = new Giocatore("Nome" +(i+1), "Cognome" +(i+1));
            giocatori2[i] = new Giocatore("Nome" +(i+12), "Cognome" +(i+12));
        }

        Squadra squadra1 = new Squadra("Squadra1", giocatori1);
        Squadra squadra2 = new Squadra("Squadra2", giocatori2);

        Classifica classifica = new Classifica();

        classifica.aggiungiSquadraAllaClassifica(squadra1);
        classifica.aggiungiSquadraAllaClassifica(squadra2);

        partita.giocaPartita(squadra1, squadra2);
        classifica.stampaClassifica();
    }
}