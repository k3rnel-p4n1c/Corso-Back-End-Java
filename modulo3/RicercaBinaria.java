package modulo3;

import metodi_utili.MetodiUtili;
import java.util.Random;
import java.util.Arrays;

public class RicercaBinaria {
    public static void main(String[] args) {

        Random random = new Random();

        int[] numeri_casuali = new int[20];                     //Vettore di numeri casuali
        int numero_da_cercare = random.nextInt(51);     //Numero casuale da cercare
        int risultato;                                          //Risultato della ricerca binaria

        //Riempio il vettore di numeri casuali da 0 a 50
        for (int i=0; i<numeri_casuali.length; i++)
            numeri_casuali[i] = random.nextInt(51);

        //Il vettore deve essere necessariamente ordinato per poter effettuare la ricerca binaria
        Arrays.sort(numeri_casuali);
        risultato = ricercaBinaria(numeri_casuali, numero_da_cercare);
        MetodiUtili.stampaVettore(numeri_casuali);

        if (risultato != -1)
            System.out.println("Il numero " +numero_da_cercare+ " si trova nella posizione " +risultato);
        else
            System.err.println("Il numero " +numero_da_cercare+ " non è presente nel vettore");
    }

    //Cerca un certo elemento di tipo intero nel vettore e ne restituisce LA POSIZIONE. Funziona solo su vettori ordinati
    private static int ricercaBinaria(int[] vettore, int low, int high, int elemento_da_cercare) {

        if (low <= high) {
            int middle = (high+low)/2;      /* Alla prima chiamata, high = length. High memorizza l'estremo superiore del vettore considerato,
             * "low" invece l'estremo inferiore. "middle" memorizza la metà del vettore considerato (tronca
             * la parte decimale).
             */

            if (elemento_da_cercare == vettore[middle])
                return middle;

            //Caso in cui l'elemento da cercare si trova nella parte dx del vettore
            if (elemento_da_cercare > vettore[middle]) {
                low = middle + 1;
                return ricercaBinaria(vettore, low, high, elemento_da_cercare);
            }

            //Caso in cui l'elemento da cercare si trova nella parte sx del vettore
            if (elemento_da_cercare < vettore[middle]) {
                high = middle - 1;
                return ricercaBinaria(vettore, low, high, elemento_da_cercare);
            }
        }
        return -1;
    }

    private static int ricercaBinaria(int[] vettore, int elemento_da_cercare) {
        return ricercaBinaria(vettore, 0, vettore.length, elemento_da_cercare);
    }
}