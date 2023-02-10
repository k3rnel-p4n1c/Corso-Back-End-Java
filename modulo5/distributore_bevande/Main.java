/* Scrivere un programma in grado di modellare la gestione di un distributore di bevande. Il distributore gestirà una lista di 2 tipi
 * diversi di prodotti: Caffè e Cappuccino. Progettare la classe DistributoreDiBevande, costruito con un intero n, che determina il
 * numero di prodotti nel distributore. Ogni tipo di prodotto può avere un codice univoco e un prezzo uguali nel tempo (ossia per uno
 * stesso tipo di prodotto).
 *
 * La classe prevede i seguenti metodi:
 * caricaProdotto: dato un Prodotto p in input, lo carica nel distributore
 * inserisciImporto: permette di inserire un importo nella macchinetta
 * scegliProdotto: dato in ingresso un codice di prodotto, restituisca il prodotto associato a quel codice (se l’importo inserito lo
 * consente) e decrementi il saldo disponibile nel distributore
 * saldoAttuale: restituisce il saldo attuale del distributore
 * getResto: restituisce il resto dovuto e azzeri il saldo
 */
package modulo5.distributore_bevande;

import modulo5.distributore_bevande.bevande.Caffe;
import modulo5.distributore_bevande.bevande.Cappuccino;

public class Main {
    public static void main(String[] args) {

        DistributoreDiBevande distributore = new DistributoreDiBevande();
        Caffe caffe = new Caffe();
        Cappuccino cappuccino = new Cappuccino();

        distributore.caricaProdotto(caffe, 40);
        distributore.caricaProdotto(cappuccino, 9);

        System.out.println("Numero di prodotti nel distributore: " +distributore.getNumeroBevande());
        System.out.println("\n" +caffe);
        System.out.println("\n" +cappuccino);

        System.out.println("\nNumero di caffè: " +caffe.getNumeroProdotti());
        System.out.println("Numero di cappuccini: " +cappuccino.getNumeroProdotti());

        System.out.println("\nInserisco un saldo di 5€ per acquistare 2 caffè (" +caffe.getPrezzo()+ "€):");
        distributore.inserisciImporto(5);
        distributore.scegliProdotto("C4FF3");
        distributore.scegliProdotto("C4FF3");
        distributore.getResto();
    }
}