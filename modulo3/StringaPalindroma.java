/* Controllare se una stringa data in input è palindroma utilizzando la ricorsione.
 * Una stringa palindroma è una stringa che si legge allo stesso modo sia da destra verso sinistra che da sinistra verso destra.
 */
package modulo3;

import java.util.Arrays;

public class StringaPalindroma {
    public static void main(String[] args) {

        String stringa1 = "I topi non avevano nipoti";  //palindroma
        String stringa2 = "ciao";
        String stringa3 = "ada";
        String stringa4 = "abba";

        System.out.println(isPalindromeRecursive(stringa1));        //true
        System.out.println(isPalindromeRecursive(stringa2));        //false
        System.out.println(isPalindromeRecursive(stringa3));        //true
        System.out.println(isPalindromeRecursive(stringa4));        //true
    }


    private static boolean isPalindromeRecursive(char[] caratteri, int low, int high) {

        if (low >= high)                                    /* Condizione precedente: (high-1) == low+2 || (high-1) == low+1
                                                             * con low >= high viene controllato il caso in cui la stringa è stata
                                                             * controllata fino a metà. Se è arrivata fino a questo punto, allora è
                                                             * sicuramente palindroma.
                                                             */
            return caratteri[low] == caratteri[high-1];
        else
            if (caratteri[low] == caratteri[high-1])
                return isPalindromeRecursive(caratteri, low+1, high-1);

            return false;
    }

    private static boolean isPalindromeRecursive(String stringa) {
        char[] caratteri = stringToCharArray(stringa);

        if (caratteri.length == 0)
            return false;
        else if (caratteri.length == 1)
            return true;

        return isPalindromeRecursive(caratteri, 0, caratteri.length);
    }

    /* Un'altra implementazione di questo metodo poteva essere utilizzando il metodo split() per dividere la stringa in base agli spazi,
     * quindi creare una nuova stringa concatenando quelle ottenute dallo split(). A questo punto, senza creare un vettore di caratteri,
     * si utilizza il metodo charAt(i) per confrontare i vari caratteri della stringa.
     */
    private static char[] stringToCharArray(String stringa) {
        char[] caratteri = new char[stringa.length()];  //Conterrà i caratteri della stringa
        int indice=0;                                   //Conterrà l'ultima cella utile del vettore di caratteri

        //Riempio il vettore di caratteri avendo cura di non memorizzare gli spazi e di rendere i caratteri minuscoli
        for (int i=0; i<stringa.length(); i++)
            if (stringa.charAt(i) != ' ') {
                caratteri[indice] = stringa.toLowerCase().charAt(i);
                indice++;
            }

        //Se indice==0 significa che la stringa non conteneva spazi
        if (indice!=0)
            //Restituisce il vettore di caratteri, senza spazi, di dimensione corretta
            return Arrays.copyOfRange(caratteri, 0, indice);
        else
            return caratteri;
    }

    private static boolean isPalindromeIterative(String stringa) {
        if (stringa.length() == 0)
            return false;
        else if (stringa.length() == 1)
            return true;
        else {
            char[] caratteri = stringToCharArray(stringa);  //Elimina gli spazi

            //Confronto gli estremi della stringa. Ad ogni ciclo, gli estremi si avvicinano al centro, fino ad indice/2
            for (int i=0; i<caratteri.length/2; i++)
                if (caratteri[i] != caratteri[caratteri.length-i-1])
                    return false;

            return true;
        }
    }
}