package modulo3;

import java.util.Arrays;
import java.util.Scanner;

public class Labirinto {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input;                               //Memorizza l'input dell'utente
        char risposta;                              //Memorizza l'input convertito in un carattere minuscolo
        int[] posizione, arrivo;                    //Memorizza la posizione del giocatore e l'arrivo del labirinto
        boolean[][] matrice;                        //Matrice parallela al labirinto, marca le posizioni visitate come "true"
        char[][] labirinto = {{'-', '-', 'W', 'W', '-'},
                              {'-', 'W', '-', 'W', '-'},
                              {'P', 'W', '-', 'W', 'W'},
                              {'-', '-', 'W', '-', 'E'},
                              {'W', '-', '-', '-', 'W'}};

        matrice = new boolean[labirinto.length][labirinto[0].length];
        arrivo = trovaPosizione(labirinto, 'E');       //Coordinate dell'arrivo
        posizione = trovaPosizione(labirinto, 'P');    //Coordinate del giocatore
        stampaLabirinto(labirinto);

//        while (posizione[0] != arrivo[0] || posizione[1] != arrivo[1]) {
//
//            System.out.print("\nInserisci prossima mossa: ");
//            input = scanner.nextLine();
//            risposta = input.toLowerCase().charAt(0);
//
//            movimentoGiocatore(risposta, labirinto);
//            posizione = trovaPosizione(labirinto, 'P');
//        }

        System.out.println();
        risolviLabirinto(labirinto, matrice, posizione[0], posizione[1]);
    }

    private static void stampaLabirinto(char[][] labirinto) {
        //Stampa una riga per volta
        for (char[] chars : labirinto)
            System.out.println(Arrays.toString(chars));
    }

    //Scorro le righe della matrice fino a trovare il carattere cercato
    private static int[] trovaPosizione(char[][] labirinto, char carattere_da_trovare) {
        int[] posizione = new int[2];

        for (int i=0; i<labirinto.length; i++) {
            for (int j=0; j<labirinto[i].length; j++) {

                if (labirinto[i][j] == carattere_da_trovare) {      //Mi serve per trovare 'P' oppure 'E'
                    posizione[0] = i;
                    posizione[1] = j;

                    break;
                }
            }
        }
        return posizione;
    }

    private static void movimentoGiocatore(char risposta, char[][] labirinto) {

        int[] posizione_corrente = trovaPosizione(labirinto, 'P');
        int[] nuova_posizione = Arrays.copyOf(posizione_corrente, 2);           /* Non è possibile uguagliare i 2 vettori in
                                                                                            * in quanto il vettore "nuova_posizione"
                                                                                            * conterrebbe l'indirizzo di memoria dell'altro
                                                                                            * vettore
                                                                                            */

        switch (risposta) {
            case 'w':
                //Controllo se esiste una riga su || se non c'è un muro su
                if (posizione_corrente[0]-1 < 0 || labirinto[posizione_corrente[0]-1][posizione_corrente[1]] == 'W')
                    System.err.println("\nNon puoi andare più su!");
                else {
                    nuova_posizione[0]--;       //Decremento la riga poiché sto andando su
                    aggiornaLabirinto(posizione_corrente, nuova_posizione, labirinto);
                }
                break;

            case 'a':
                //Controllo se esiste una colonna a sx || se non c'è un muro a sx
                if (posizione_corrente[1]-1 < 0 || labirinto[posizione_corrente[0]][posizione_corrente[1]-1] == 'W')
                    System.err.println("\nNon puoi andare più a sx!");
                else {
                    nuova_posizione[1]--;       //Decremento la colonna poiché sto andando a sx
                    aggiornaLabirinto(posizione_corrente, nuova_posizione, labirinto);
                }
                break;

            case 's':
                //Controllo se esiste una colonna giù || se non c'è un muro giù
                if (posizione_corrente[0]+1 > labirinto.length-1 || labirinto[posizione_corrente[0]+1][posizione_corrente[1]] == 'W')
                    System.err.println("\nNon puoi andare più giù!");
                else {
                    nuova_posizione[0]++;       //Decremento la colonna poiché sto andando giù
                    aggiornaLabirinto(posizione_corrente, nuova_posizione, labirinto);
                }
                break;

            case 'd':
                //Controllo se esiste una colonna a dx || se non c'è un muro a dx
                if (posizione_corrente[1]+1 > labirinto[0].length-1 || labirinto[posizione_corrente[0]][posizione_corrente[1]+1] == 'W')
                    System.err.println("\nNon puoi andare più a destra!");
                else {
                    nuova_posizione[1]++;       //Decremento la colonna poiché sto andando a dx
                    aggiornaLabirinto(posizione_corrente, nuova_posizione, labirinto);
                }
                break;
        }
    }

    private static void aggiornaLabirinto(int[] posizione_corrente, int[] nuova_posizione, char[][] labirinto) {

        if (labirinto[nuova_posizione[0]][nuova_posizione[1]] == 'E') {
            System.out.println("Hai vinto!");

            /* Questo passaggio serve per poter aggiornare la P con la E, condizione necessaria per far terminare il programma.
             * Il programma termina solo quando la P raggiunge le stesse coordinate della E.
             */
            labirinto[nuova_posizione[0]][nuova_posizione[1]] = 'P';
            labirinto[posizione_corrente[0]][posizione_corrente[1]] = '-';
        }
        else {
            labirinto[nuova_posizione[0]][nuova_posizione[1]] = 'P';
            labirinto[posizione_corrente[0]][posizione_corrente[1]] = '-';

            stampaLabirinto(labirinto);
        }
    }

    //x ed y sono le coordinate della root del labirinto (https://it.wikipedia.org/wiki/Ricerca_in_profondit%C3%A0)
    private static void risolviLabirinto(char[][] labirinto, boolean[][] matrice, int x, int y) {

        //Passo base - controllo se sono arrivato all'uscita
        if (labirinto[x][y] == 'E') {
            System.out.println("L'uscita si trova alle coordinate (" +x+ ", " +y+ ")");
            return;         //Essendo un metodo void, non restituisce niente (se non il controllo al metodo chiamante)
        }

        /* Passi ricorsivi - se la posizione attuale del labirinto è una cella vuota, ri-eseguo questo stesso metodo ricorsivamente
         * in modo da poter esplorare tutte e 4 le direzioni attorno all P. Ovviamente, devo impostare la nuova posizione del giocatore
         * nella cella attuale
         */
        if (x-1 >= 0)                                               //Controllo se la cella in posizione x+1 (sopra) esiste
            if (labirinto[x-1][y] != 'W' && !matrice[x-1][y]) {     //Controllo se in quella cella c'è un muro ed è stata esplorata
                matrice[x][y] = true;                               //Contrassegno la cella attuale come "visitata" e passo a quella successiva
                risolviLabirinto(labirinto, matrice, x-1, y);    //Esploro sopra
            }

        if (y+1 < labirinto[0].length)
            if (labirinto[x][y+1] != 'W' && !matrice[x][y+1]) {
                matrice[x][y] = true;
                risolviLabirinto(labirinto, matrice, x, y+1);    //Esploro a dx
            }

        if (x+1 < labirinto.length)
            if (labirinto[x+1][y] != 'W' && !matrice[x+1][y]) {
                matrice[x][y] = true;
                risolviLabirinto(labirinto, matrice, x+1, y);    //Esploro sotto
            }

        if (y-1 >= 0)
            if (labirinto[x][y-1] != 'W' && !matrice[x][y-1]) {
                matrice[x][y] = true;
                risolviLabirinto(labirinto, matrice, x, y-1);    //Esploro a sx
            }
    }
}