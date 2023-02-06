/* Progettare una classe Lampadina che rappresenti una lampadina elettrica
 * La lampadina può essere accesa, spenta o rotta. Espone due metodi:
 * stato() che indica lo stato corrente della lampadina
 * click() che cambia lo stato da accesa a spenta o da spenta ad accesa, oppure rompe la lampadina
 * Una lampadina si rompe dopo un numero di click definito dal produttore
 * La classe deve contenere uno o più campi che ne descrivano lo stato
 * Un costruttore
 *
 * Progettare una classe Interruttore che rappresenta un interruttore per la lampadina fatta precedentemente
 * Ogni interruttore è collegato ad una lampadina e ne regola accensione e spegnimento
 * Definite quali campi, metodi e costruttori siano opportuni
 * Creare un metodo di test che istanzia due interruttori e li collega alla stessa lampadina e poi offre all’utente ripetutamente
 * la possibilità di cliccare uno dei due interruttori oppure di terminare l’esecuzione
 *
 * Modificare la classe Lampadina facendo in modo che tutte le lampadine condividano l’informazione sulla presenza di corrente all’interno
 * dell’impianto (immaginate che tutte le lampadine siano collegate allo stesso impianto di corrente)
 * Le lampadine devono comportarsi coerentemente con la presenza o meno di elettricità nell’impianto
 * Quindi quando non c’è corrente una lampadina può essere soltanto nello stato «spento» o «rotto»
 * Scrivere un metodo di test che testi la funzione di ’’staccare’’ o ‘’riattaccare’’ la corrente
 */
package modulo4.lampadina;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int scelta;
        Scanner scanner = new Scanner(System.in);
        Lampadina lampadina = new Lampadina();
        Interruttore interruttore1 = new Interruttore(lampadina);    //Associo la lampadina a questo interruttore
        Interruttore interruttore2 = new Interruttore(lampadina);    //Associo la stessa lampadina a quest'altro interruttore

        lampadina.ripristinaAlimentazione();        //Faccio in modo che ci sia corrente nell'impianto (vale per tutte le lampadine)
        System.out.println(lampadina.getStato());

        do {
            System.out.print("\n0 -> ESCI" +
                               "\n1 -> PREMI INTERRUTTORE 1" +
                               "\n2 -> PREMI INTERRUTTORE 2" +
                               "\nInserisci scelta: ");
            scelta = scanner.nextInt();

            if (scelta == 1) {
                interruttore1.premiInterruttore();
                System.out.println("\n" +lampadina.getStato());
            }
            else if (scelta == 2) {
                interruttore2.premiInterruttore();
                System.out.println("\n" +lampadina.getStato());
            }

        } while (scelta!=0);

        lampadina.interrompiAlimentazione();
        System.out.println("\n" +lampadina.getStato());
        lampadina.ripristinaAlimentazione();
        System.out.println("\n" +lampadina.getStato());
    }
}