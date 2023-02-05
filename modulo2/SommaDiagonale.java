/* Scrivete una funzione che, data una matrice quadrata in input, restituisce la somma della diagonale da sinistra a destra.
 * Scrivete una seconda funzione che, presa una matrice quadrata e un booleano, a seconda del valore del booleano restituisce:
 * o la somma della diagonale da sinistra a destra;
 * o quella da destra a sinistra.
 */
package modulo2;

import metodi_utili.MetodiUtili;

import java.util.Random;
import java.util.Scanner;

public class SommaDiagonale {
    public static void main(String[] args) {

        int dimensione;
        int[][] matrice;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Inserisci la dimensione della matrice quadrata: ");
        dimensione = scanner.nextInt();
        matrice = new int[dimensione][dimensione];

        //Riempio la matrice di numeri casuali
        for (int i=0; i<dimensione; i++)
            for (int j=0; j<dimensione; j++)
                matrice[i][j] = random.nextInt(11);     //Passando 11, genera numeri tra 0 e 10

        MetodiUtili.stampaMatrice(matrice);
        System.out.println("\nLa somma della diagonale principale è: " +sommaDiagonaleMatrice(matrice, true));
        System.out.println("La somma della diagonale secondaria è: " +sommaDiagonaleMatrice(matrice, false));
    }

    private static int sommaDiagonaleMatrice(int[][] matrice) {
        int somma=0;

        for (int i=0; i<matrice.length; i++)
            somma += matrice[i][i];

        return somma;
    }

    private static int sommaDiagonaleMatrice(int[][] matrice, boolean diagonale_principale) {
        int somma=0;

        //Se check == true --> somma diagonale principale, altrimenti somma diagonale secondaria
        if (diagonale_principale)
            return sommaDiagonaleMatrice(matrice);
        else {
            for (int i=0; i<matrice.length; i++)
                somma += matrice[i][matrice.length-i-1];

            return somma;
        }
    }
}