//Attualmente si conoscono solo 51 numeri perfetti, tutti pari. Escludo i numeri dispari
package modulo3;

import java.util.Arrays;

public class NumeriPerfetti {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(trovaNumeriPerfetti(8128)));     //8128, 496, 28, 6
    }

    private static int[] trovaNumeriPerfetti(int numero) {
        if (numero <= 1)            //1 non ha divisori escluso se stesso. I numeri negativi non si considerano
            return null;

        int[] numeri_perfetti = new int[numero/2];
        numeri_perfetti = trovaNumeriPerfetti(numero, numeri_perfetti, 0);

        if (numeri_perfetti != null) {
            for (int i=0; i<numeri_perfetti.length; i++)
                if (numeri_perfetti[i] == 0) {
                    numeri_perfetti = Arrays.copyOfRange(numeri_perfetti, 0, i);
                    break;
                }
            Arrays.sort(numeri_perfetti);
        }

        return numeri_perfetti;
    }

    private static int[] trovaNumeriPerfetti(int numero, int[] numeri_perfetti, int indice) {

        if (numero <= 1)                //Passo base
            return numeri_perfetti;
        else {
            int[] divisori = trovaDivisori(numero);

            if (sommaElementiArray(divisori) == numero) {
                numeri_perfetti[indice] = numero;
                indice++;
            }
        }

        return trovaNumeriPerfetti(numero-1, numeri_perfetti, indice);  //Paso ricorsivo
    }

    private static int[] trovaDivisori(int numero) {

        int[] divisori = new int[numero/2];     //Ci saranno meno divisori di "numero/2"
        int indice=0;                           //Questo indice memorizza l'ultima cella utile del vettore "divisore"

        for (int i=1; i<=numero/2; i++) {
            if (numero%i == 0) {
                divisori[indice] = i;
                indice++;
            }
        }

        //Restituisco il vettore fino all'ultima cella utile, contenente il più grande divisore
        return Arrays.copyOfRange(divisori, 0, indice);
    }

    private static int sommaElementiArray(int[] vettore) {
        int somma=0;

        for (int elemento : vettore)
            somma += elemento;

        return somma;
    }
}