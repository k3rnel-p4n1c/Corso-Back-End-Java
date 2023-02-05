/* Progettare una classe Contatore che permetta di:
 * Istanziare la classe con un valore iniziale
 * Istanziare la classe senza un valore iniziale
 * Incrementare il conteggio attuale
 * Ottenere il conteggio attuale
 * Resettare il conteggio a zero
 * Resettare il conteggio ad un altro valore
 */
package modulo4.contatore;

public class Main {
    public static void main(String[] args) {

        Contatore contatore1 = new Contatore(10);
        Contatore contatore2 = new Contatore();

        contatore1.incrementaConteggio();
        System.out.println(contatore1.getValore());
        contatore1.setValore(0);
        contatore1.setValore(40);
    }
}