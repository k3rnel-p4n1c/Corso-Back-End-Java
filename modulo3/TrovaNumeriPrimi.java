/* Un numero primo è un numero che è divisibile solo per se stesso e 1. Scrivete un programma che dato un numero N, scopre tutti
 * i numeri primi fino a N. Provate a ottimizzare il programma per renderlo il più veloce possibile, ci sono diversi trick che potete
 * fare per velocizzarlo!
 */
package modulo3;

import java.util.Arrays;

public class TrovaNumeriPrimi {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(numeriPrimi(100)));
    }

    private static boolean isPrime(int numero) {

        if (numero == 2)
            return true;
        else if (numero%2 == 0)     //I numeri pari (escluso 2) non sono primi
            return false;
        else {
            for (int i=3; i<=(int)Math.sqrt(numero); i+=2)    //Incremento di 2 per saltare i numeri pari
                if (numero%i == 0)
                    return false;

            return true;
        }
    }

    private static int[] numeriPrimi(int numero) {
        if (numero <= 1)
            return null;
        else {
            //La dimensione è numero/2 poiché non vanno considerati tutti i numeri pari. Anche così avanza spazio
            int[] array_numeri_primi = new int[numero/2];
            int[] array_definitivo; //Conterrà il numero esatto di celle con i vari numeri primi
            int contatore=0;        //Conta i numeri primi trovati, in modo da creare in seguito un vettore delle giuste dimensioni

            //Partendo da "numero" controllo all'indietro se i numeri sono primi, se si, li inserisco nel vettore
            for (int i=numero; i>=2; i--) {
                if (isPrime(i)) {
                    array_numeri_primi[contatore] = i;
                    contatore++;
                }
            }

            //Questo metodo copia gli elementi compresi in un intervallo dell'array passato come argomento, in un altro array
            array_definitivo = Arrays.copyOfRange(array_numeri_primi, 0, contatore);
            Arrays.sort(array_definitivo);

            return array_definitivo;
        }
    }
}