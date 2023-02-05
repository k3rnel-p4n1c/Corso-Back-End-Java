/* Scrivere un programma (ovviamente ricorsivo) che, dato un intero n restituisce l’array corrispondente alla n riga del triangolo di
 * tartaglia.
 * https://www.andreaminini.org/matematica/il-triangolo-di-tartaglia
 */
package modulo3;

import java.util.Arrays;

public class TriangoloTartaglia {
    public static void main(String[] args) {

        int profondita = 30;
        int[][] memo = new int[profondita+1][profondita+1];

        System.out.println(Arrays.toString(rigaTriangolo(profondita, memo)));
    }

    private static int[] rigaTriangolo(int riga_triangolo, int[][] memo) {
        int[] riga = new int[riga_triangolo+1];                             //La riga n-esima contiene n+1 numeri

        for (int i=0; i<riga.length; i++)
            riga[i] = coefficienteBinomiale(riga_triangolo, i, memo);       //n = riga, k = posizione nella riga

        return riga;
    }

    /* Formula: C(n k) = n!/(k!(n-k)!)
     * Casi particolari:
     *  C(n 0) = 1
     *  C(n n) = 1
     *  C(n 1) = 1
     * Può essere scritto anche come: C(n, k) = C(n-1, k-1) + C(n-1, k)
     * https://it.wikipedia.org/wiki/Coefficiente_binomiale#Propriet%C3%A0
     */
    private static int coefficienteBinomiale(int n, int k, int[][] memo) {
        if (k==0 || k==n)
            return 1;
        else if (memo[n][k] != 0)
            return memo[n][k];
        else
            memo[n][k] = coefficienteBinomiale(n-1, k-1, memo) + coefficienteBinomiale(n-1, k, memo);

        return memo[n][k];
    }
}