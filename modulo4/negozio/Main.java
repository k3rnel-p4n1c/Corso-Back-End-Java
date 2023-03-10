/* Creare un sistema in grado di gestire i prodotti venduti in un negozio. Si tratta di un negozio in pieno centro storico, quindi
 * potrà gestire al massimo 100 tipi diversi di prodotto. In particolare, si tratta di un supermercato dove si vendono sia beni
 * alimentari che non. Inoltre, il proprietario ha deciso di fare uno sconto del 20% sui prodotti di genere alimentare tutti i lunedì e
 * mercoledì per i clienti con più di 60 anni. Ogni prodotto ha un nome e un prezzo. E' ovviamente possibile acquistare più prodotti
 * simultaneamente.
 *
 * Deve essere possibile per il negoziante:
 * aggiungere un nuovo prodotto (Se un prodotto è già presente, va aggiornata solo la quantità rimanente)
 * rimuovere un prodotto
 * ottenere la quantità rimanente di ogni prodotto
 *
 * Deve essere possibile per il cliente:
 * Acquistare uno o più prodotti (ottenendo il totale da pagare)
 * Non deve essere possibile acquistare un prodotto se la quantità rimanente è 0
 *
 * INFO: questo programma potrebbe essere gestito creando una classe ad hoc, ovvero "Carrello". In questa maniera si "delega" ad un'altra
 * classe la funzione di gestione del carrello
 */
package modulo4.negozio;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Giorno giorno = Main.impostaGiornoDellaSettimanaCasuale();
        Negozio negozio = new Negozio();
        Cliente cliente1 = new Cliente("Mario", 60);
        Cliente cliente2 = new Cliente("Luca", 25);

        negozio.aggiungiProdotto("tubo", 8, 5);
        negozio.aggiungiProdotto("tubo", 8, 5);
        negozio.aggiungiProdottoAlimentare("pizza", 5, 10);
        negozio.aggiungiProdottoAlimentare("pane", 1, 22);

        negozio.riempiCarrello(cliente1, "tubo", 2);
        negozio.riempiCarrello(cliente1, "pane", 10);

        System.out.println("Giorno della settimana: " +giorno+ "\n");
        cliente1.stampaCarrello();
        System.out.println("Totale da pagare: " +cliente1.totaleDaPagare(giorno)+ "€");
    }


    /**
     * In base ad un valore casuale, genera un giorno della settimana che servirà per poter usufruire degli sconti riservati ai clienti
     * con più di 60 anni che acquistano un prodotto alimentare di LUN o MER
     * @return restituisce il giorno della settimana generato
     */
    private static Giorno impostaGiornoDellaSettimanaCasuale() {
        Random random = new Random();
        int giorno = random.nextInt(7)+1;   //Genera un giorno casuale da 1 a 7

        return switch (giorno) {
            case 1 -> Giorno.LUNEDI;
            case 2 -> Giorno.MARTEDI;
            case 3 -> Giorno.MERCOLEDI;
            case 4 -> Giorno.GIOVEDI;
            case 5 -> Giorno.VENERDI;
            case 6 -> Giorno.SABATO;
            case 7 -> Giorno.DOMENICA;
            default -> throw new IllegalStateException("Unexpected value: " + giorno);
        };
    }
}