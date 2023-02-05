/* Scrivete una funzione che, dato in input due numeri n ed m, crea un array lungo m che in ogni cella ha il valore di indice
 * della cella moltiplicato per n
 */
package modulo2;

import metodi_utili.MetodiUtili;

import java.util.Arrays;
import java.util.Scanner;

public class Tabelline {
    public static void main(String[] args) {

        int n, m;
        int[] vettore;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero n: ");
        n = scanner.nextInt();
        System.out.print("Inserisci dimensione del vettore (m): ");
        m = scanner.nextInt();
        System.out.println();

        vettore = creaVettore(n, m);
        System.out.println(Arrays.toString(vettore));
    }

    private static int[] creaVettore(int n, int m) {
        int[] vettore = new int[m];

        for (int i=1; i<m; i++)     //Parto da 1 poichè la cella 0 avrà sempre valore 0
            vettore[i] = i*n;

        return vettore;
    }
}