/* Scrivete una funzione che prende in input una cartella della tombola sotto forma di matrice 3*5 e un array di numeri estratti
 * (almeno 20 numeri, non ripetuti). La funzione controllerà quanti ambi, terni, quaterne e cinquine sono presenti nella scheda e
 * restituirà la stringa «il giocatore ha totalizzato ambi: numero ambi etc.. In caso di tombola invece, la funzione restituirà
 * direttamente la stringa «TOMBOLA!!»
 */
package modulo2;

public class Tombola {
    public static void main(String[] args) {

        int[][] cartella1 = {{1, 3, 9, 21, 24}, {5, 37, 41, 60, 67}, {42, 71, 86, 87, 90}};         //Ambo e terna nelle righe 1 e 3
        int[][] cartella2 = {{42, 48, 55, 56, 4}, {72, 84, 86, 88, 90}, {60, 63, 20, 50, 89}};      //Quaterna e cinquina nelle righe 1 e 2
        int[][] cartella3 = {{1, 5, 11, 23, 24}, {30, 39, 42, 48, 55}, {56, 61, 62, 69, 70}};       //Tombola
        int[] estrazioni = {1, 5, 11, 23, 24, 30, 39, 42, 48, 55, 56, 61, 62, 69, 70, 72, 84, 86, 88, 90};

        System.out.println(controlloTombola(cartella1, estrazioni));
    }

    private static String controlloTombola(int[][] cartella, int[] estrazioni) {
        int contatore=0;
        int ambi=0, terne=0, quaterne=0, cinquine=0;

        for (int i=0; i<cartella.length; i++) {
            for (int j=0; j<cartella[0].length; j++) {
                for (int valore : estrazioni) {

                    if (cartella[i][j] == valore)
                            contatore++;
                }
            }
            switch (contatore) {
                case 2 -> ambi++;
                case 3 -> terne++;
                case 4 -> quaterne++;
                case 5 -> cinquine++;
            }
            contatore=0;
        }

        if (cinquine == 3)
            return "Tombola!";
        else
            return "\nAmbi: " +ambi+ "\nTerne: " +terne+ "\nQuaterne: " +quaterne+ "\nCinquine: " +cinquine;
    }
}