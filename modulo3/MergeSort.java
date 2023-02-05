package modulo3;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] vettore1 = {10, 9, 8, 5, 4, 6, 2, 0, 1, 3};
        int[] vettore2 = {9, 18, 7, 5, 4, 6, 2, 0, 1};

        vettore1 = mergeSort(vettore1);
        vettore2 = mergeSort(vettore2);

        System.out.println(Arrays.toString(vettore1));
        System.out.println(Arrays.toString(vettore2));
    }

    //Questo è il metodo che verrà richiamato nel main
    private static int[] mergeSort(int[] vettore) {
        if (vettore.length == 0 || vettore.length == 1)     //Passo base: il vettore è stato scomposto fino ad 1 elemento
            return vettore;
        else if (vettore.length == 2)                       //Passo base: se il vettore ha 2 elementi, vengono ordinati
            return sort(vettore);
        else                                                //Passo ricorsivo: il vettore viene suddiviso in 2 sub-array minori
            return mergeSort(Arrays.copyOf(vettore, vettore.length/2), Arrays.copyOfRange(vettore, vettore.length/2, vettore.length));
    }

    //Questo metodo serve solo per ordine, ovvero per distinguere la parte ricorsiva di "mergeSort" dalla chiamata al metodo "merge"
    private static int[] mergeSort(int[] vettore_sx, int[] vettore_dx) {
        return merge(mergeSort(vettore_sx), mergeSort(vettore_dx));   //Unione dei 2 sub-array
    }

    //Questo metodo serve per creare un vettore ordinato partendo da 2 sub-array disordinati
    private static int[] merge(int[] vettore_sx, int[] vettore_dx) {
        int[] vettore_ordinato = new int[vettore_sx.length + vettore_dx.length];
        int i=0, j=0;
        int indice=0;

        //Questo ciclo continua finché uno dei 2 indici non arriva a fine vettore
        while (i<vettore_sx.length && j<vettore_dx.length) {

            /* Eseguo l'inserimento nel vettore ordinato nel caso in cui nel vettore_dx ci sia un numero maggiore di quello del vettore_sx.
             * Ogni sub-array ha l'elemento più piccolo nella prima posizione. Al sub-array che ha l'elemento più piccolo viene incrementato
             * l'indice, cosicché tale elemento più piccolo possa essere confrontato con l'elemento successivo del sub-array che prima ha
             * avuto l'elemento più grande. In altre parole, dati 2 sub-array, il primo elemento del primo viene confrontato con il primo
             * del secondo, l'elemento più piccolo tra i due entra a far parte dell'array ordinato. Dopodiché il primo elemento del primo
             * sub-array viene confrontato con il secondo, e così via.
             */
            if (vettore_sx[i] < vettore_dx[j]) {
                vettore_ordinato[indice] = vettore_sx[i];
                i++;
            }
            else {
                vettore_ordinato[indice] = vettore_dx[j];
                j++;
            }

            indice++;   //Indice del vettore ordinato
        }

        /* Questi due while servono quando uno dei due sub-array ha un numero inferiore di elementi. In questo caso non sono più necessari
        * confronti, dal momento che uno dei due sub-array sarà vuoto. Ragion per cui gli elementi del sub-array rimanente, essendo ordinati,
        * vengono copiati così come sono nel vettore ordinato a partire dall'ultima cella utile.
        */
        while (j<vettore_dx.length) {
            vettore_ordinato[indice] = vettore_dx[j];
            indice++;
            j++;
        }

        while (i<vettore_sx.length) {
            vettore_ordinato[indice] = vettore_sx[i];
            indice++;
            i++;
        }

        return vettore_ordinato;
    }

    //Questo metodo serve per ordinare un sub-array di soli 2 elementi. Nel caso sia di 1 elemento, lo restituisce
    private static int[] sort(int[] vettore) {

        if (vettore[0] < vettore[1])
            return vettore;
        else {
            int temp = vettore[0];
            vettore[0] = vettore[1];
            vettore[1] = temp;
        }

        return vettore;
    }
}