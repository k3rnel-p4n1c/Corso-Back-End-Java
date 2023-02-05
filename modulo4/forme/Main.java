/* Progettare una classe Quadrato, che permetta di:
 * Istanziare la classe con la dimensione del lato del quadrato
 * Ottenere il perimetro del quadrato
 * Stampare il quadrato sulla console

Progettare una classe Cerchio, che permetta di:
 * Istanziare la classe con un costruttore che accetta un parametro
 * Ottenere la circonferenza del cerchio
 * Ottenere l’area del cerchio
 *
 * Progettare una classe Colore, che permette di:
 * rappresentare un colore con i valori RGB (0-255) (un colore è una tripla di valori)
 * esporre due costanti, BIANCO e NERO
 * aggiungere il colore alle classi Quadrato e Cerchio
 * che di default sia NERO
 * che sia modificabile
 */
package modulo4.forme;

public class Main {
    public static void main(String[] args) {

        Quadrato quadrato = new Quadrato(10);
        Cerchio cerchio = new Cerchio(5);

        quadrato.stampaQuadrato();
        System.out.println("\nCirconferenza cerchio: " +cerchio.calcolaCirconferenza());
        System.out.println("Area cerchio: " +cerchio.calcolaArea());
        System.out.println("Colore cerchio");
        System.out.println("R: " +cerchio.getColore().getR()+ "\nG: " +cerchio.getColore().getG()+ "\nB: " +cerchio.getColore().getB());
    }
}