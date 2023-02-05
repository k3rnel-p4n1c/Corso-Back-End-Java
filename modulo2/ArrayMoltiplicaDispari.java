/* Scrivete una funzione che, dato un array di valori, ne restituisce una copia dove i numeri dispari sono stati moltiplicati per 2
 */
package modulo2;

import metodi_utili.MetodiUtili;

import java.util.Arrays;
import java.util.Random;

public class ArrayMoltiplicaDispari {
    public static void main(String[] args) {

        final int SIZE = 10;                 //Costante, dimensione del vettore
        int[] vettore = new int[SIZE];
        int[] vettore_copia;

        //Istanzio un oggetto della classe Random per generare un numero casuale
        Random random = new Random();

        //Riempio un vettore di DIM elementi casuali
        for (int i=0; i<SIZE; i++)
            vettore[i] = random.nextInt(50);    //Passando 50, genera numeri tra 0 e 49

        vettore_copia = moltiplicaNumeriDispari(vettore);
        System.out.println(Arrays.toString(vettore));
        System.out.println(Arrays.toString(vettore_copia));
    }

    private static int[] moltiplicaNumeriDispari(int[] vettore) {
        int[] vettore_copia = new int[vettore.length];

        for (int i=0; i<vettore.length; i++)
            if (vettore[i]%2 != 0)
                vettore_copia[i] = vettore[i]*2;
            else
                vettore_copia[i] = vettore[i];

        return vettore_copia;
    }
}