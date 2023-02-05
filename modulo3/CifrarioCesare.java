/* Data una frase e una chiave numerica, il cifrario sposta le lettere in avanti delle posizioni della chiave. La parola «ciao» usando
 * come chiave il 3 diventa quindi «fldr». Per decriptare basterà fare il procedimento inverso usando la stessa chiave. Scrivete voi le
 * funzioni cripta e decripta. Le lettere sono codificate seguendo il sistema ASCII. Cercate di fare questo programma senza ripetere
 * codice tra cripta e decripta
 */
package modulo3;

public class CifrarioCesare {
    public static void main(String[] args) {

        System.out.println(criptaStringa("abxyz", 3));
        System.out.println(decriptaStringa("deabc", 3));
    }

    private static String criptaStringa(String messaggio, int chiave) {
        char[] caratteri = messaggio.toLowerCase().toCharArray();

        for (int i=0; i<caratteri.length; i++) {

            /* Se la chiave è positiva sto criptando il messaggio. In questo caso viene sommata la chiave al carattere, dopodiché
             * viene sottratto 96, ovvero tutti i caratteri che vengono prima della 'a' (97). In questa maniera verrà un valore compreso
             * tra 1 e 26, ragion per cui facendo il modulo con 26 (numero di lettere dell'alfabeto) verrà restituita la posizione della
             * lettera all'interno dell'alfabeto. A questo punto bisogna ri-sommare l'offset di 96 per tornare nel range 'a' - 'z' ASCII.
             *
             * Nel caso la chiave sia negativa bisogna ripetere il ragionamento al contrario: si somma la chiave al carattere, dopodiché
             * si somma 26 che è il numero di lettere dell'alfabeto, infine si somma 97 che è il valore di 'a'. A questo punto si otterrà
             * un valore che, modulo 26, restituirà la posizione del carattere all'interno dell'alfabeto. Sommandogli l'offset di 97 ('a')
             * si ritorna nel range di codifica ASCII dei caratteri.
             */
            if (chiave>0)
                caratteri[i] = (char)(((int)caratteri[i] + chiave - 96) % 26 + 96);
            else {
                caratteri[i] = (char)(((int)caratteri[i] + chiave + 26 - 97) % 26 + 97);
            }
        }
        /* Inizializzo nuovamente la stringa in modo che ora contenga il messaggio cifrato. Il costruttore della classe
         * String può ricevere anche un vettore di caratteri
         */
        return new String(caratteri);
    }

    private static String decriptaStringa(String messaggio, int chiave) {
        return criptaStringa(messaggio, -chiave);
    }
}