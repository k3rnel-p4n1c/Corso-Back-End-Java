/* Scrivere un programma in grado di modellare la gestione di diversi tipi di veicoli: automobili e autocarri. In particolare,
 * create le classi Autocarro e Automobile entrambe con le seguenti caratteristiche: Ogni veicolo è caratterizzato da:
 * Targa
 * Numero di posti
 *
 * Gli autocarri hanno una proprietà aggiuntiva: la capacità massima di carico (espressa in quintali).
 * Le automobili, invece, il numero di porte.
 * Il metodo toString degli oggetti Automobile deve ritornare il numero di targa e il numero di porte, separati dal carattere «:».
 * Il metodo toString degli oggetti Autocarro, invece, deve ritornare il numero di targa e la massima capacità in quintali,
 * separati dal carattere «:».
 */
package modulo5.gestore_veicoli;

import modulo5.gestore_veicoli.veicoli.Autocarro;
import modulo5.gestore_veicoli.veicoli.Automobile;

public class Main {
    public static void main(String[] args) {
        Automobile automobile = new Automobile("cf123rm", 4, 4);
        Autocarro autocarro = new Autocarro("ca133sm", 4, 2);

        System.out.println("Automobile: " +automobile.toString());
        System.out.println("Autocarro: " +autocarro.toString());
    }
}