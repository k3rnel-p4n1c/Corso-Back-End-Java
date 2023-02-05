//Generare randomicamente la cartellina e simulare, sempre random, le estrazioni dei numeri
package modulo3;

import metodi_utili.MetodiUtili;
import java.util.Arrays;
import java.util.Random;

public class Tombola {
    public static void main(String[] args) {

        int[][] cartella = generaCartella();
        int[] estrazioni = generaEstrazioni(30);

        //Ordino le estrazioni solo per una questione grafica, non è necessario
        Arrays.sort(estrazioni);

        MetodiUtili.stampaMatrice(cartella);
        System.out.println("\nEstrazioni: " +Arrays.toString(estrazioni));
        System.out.println(controlloTombola(cartella, estrazioni));
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

    private static int[][] generaCartella() {
        Random random = new Random();

        //Memorizza semi compresi tra 1 e 10 che saranno la base per decidere le colonne della cartella
        int[] seeds = generaNumeriCasuali(5, 1, 9);
        int[][] cartella = new int[3][5];
        int[] colonna_cartella;

        //I semi devono essere ordinati, poiché lo sono nelle cartelle di gioco reali
        Arrays.sort(seeds);

        for (int j=0; j<5; j++) {       //Ciclo per le colonne

            colonna_cartella = generaNumeriCasuali(3, seeds[j]*10, seeds[j]*10+9);
            Arrays.sort(colonna_cartella);

            //Questa condizione serve per trasformare, a volte, il numero 89 in 90 (ultima colonna)
            if (j==4 && colonna_cartella[2]==99)
                colonna_cartella[2] += random.nextInt(2);     //Sommo a 99 un numero compreso tra 0 e 1

            /* Questo ciclo serve per evitare che il primo elemento della cartella sia 0. Per evitare ciò è necessario andare a generare
             * nuovamente l'intera colonna, in maniera da assicurarsi che tutti i numeri siano diversi tra loro, quindi il ciclo continua
             * finché la generazione non va a buon fine. Per escludere lo 0 bisogna confrontare il primo valore del vettore con 10, poiché
             * in seguito questo valore verrà decrementato di 10 (come nel caso di 99).
             */
            while (j==0 && colonna_cartella[0]==10) {
                colonna_cartella = generaNumeriCasuali(3, seeds[j]*10, seeds[j]*10+9);
                Arrays.sort(colonna_cartella);
            }

            for (int i=0; i<3; i++) {     //Ciclo per le righe
                cartella[i][j] = colonna_cartella[i] - 10;
            }
        }
        return cartella;
    }

    //Genera un vettore di numeri estratti, tutti diversi e casuali
    private static int[] generaEstrazioni(int quanti_numeri) {
        return generaNumeriCasuali(quanti_numeri, 1, 90);
    }

    //lower_bound e upper_bound sono i limiti inferiore e superiore (compresi) del range per generare numeri casuali
    private static int[] generaNumeriCasuali(int quanti_numeri, int lower_bound, int upper_bound) {
        Random random = new Random();
        int[] numeri_casuali = new int[quanti_numeri];
        int numero_casuale, indice=1;

        //Inserisco il primo elemento casuale nel vettore dei numeri casuali
        numeri_casuali[0] = lower_bound + random.nextInt(upper_bound-lower_bound+1);

        //Il ciclo do-while continua ad essere eseguito finché tutti i numeri nel vettore non sono diversi
        do {
            numero_casuale = lower_bound + random.nextInt(upper_bound-lower_bound+1);

            /* Se il numero casuale generato viene trovato in una posizione i-esima nel vettore, esco dal for e ripeto il ciclo do-while
             * in momo da generare nuovamente un altro numero. Nel caso in cui il numero casuale non è presente, viene aggiunto nel vettore
             * e viene aggiornato l'indice. La variabile "indice", alla fine, conterrà la dimensione del vettore, dunque l'ultima cella utile
             * sarà data da "indice-1".
             */
            for (int i=0; i<indice; i++) {
                if (numeri_casuali[i] == numero_casuale)
                    break;
                else if (i == indice-1) {
                    numeri_casuali[indice] = numero_casuale;
                    indice++;
                }
            }
        } while (indice < quanti_numeri);

        return numeri_casuali;
    }
}