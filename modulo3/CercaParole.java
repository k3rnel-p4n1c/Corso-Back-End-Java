package modulo3;

import java.util.Arrays;

public class CercaParole {
    public static void main(String[] args) {

        String parola_da_cercare = "cazzo";
        char[][] matrice = {{'c', 'd', 'g', 'u', 'p', 'y', 'e', 'n', 'a', 'c'},     //Matrice 10x10
                            {'t', 'a', 'a', 'k', 'o', 'y', 'o', 'l', 'p', 's'},
                            {'r', 'c', 'z', 'c', 'n', 'r', 'i', 'a', 'a', 'b'},
                            {'i', 'o', 'b', 'z', 'i', 's', 'c', 't', 'l', 'a'},
                            {'g', 'r', 'e', 'l', 'o', 'a', 'c', 'e', 'o', 'l'},
                            {'l', 'f', 'r', 'a', 'm', 'l', 'u', 's', 'i', 'e'},
                            {'i', 'a', 'e', 'm', 'l', 'm', 'l', 's', 'l', 'n'},
                            {'a', 'n', 't', 'a', 'e', 'o', 'c', 'a', 'g', 'a'},
                            {'j', 'o', 't', 'r', 'b', 'n', 'd', 'g', 'o', 'd'},
                            {'l', 'y', 'o', 'o', 'u', 'm', 'e', 'r', 'd', 'a'}};

        stampaMatrice(matrice);
        System.out.print("\nParola da cercare: " +parola_da_cercare+ "\nTrovata: " );
        System.out.println(trovaParola(parola_da_cercare, matrice));
    }

    private static void stampaMatrice(char[][] matrice) {
        for (char[] riga: matrice)
            System.out.println(Arrays.toString(riga));
    }

    private static boolean trovaParola(String parola, char[][] matrice) {

        if (parola.length() > 1) {
            int indice;                 //Indice che scorre i caratteri della parola da cercare
            int k, l;                   //Indici usati nei vari cicli for innestati

            //Scorro tutta la matrice fino a trovare il carattere con cui inizia la parola
            for (int i=0; i<matrice.length; i++) {
                for (int j=0; j<matrice[i].length; j++) {

                    if (matrice[i][j] == parola.toLowerCase().charAt(0)) {

                        /* Cerco la parola a dx del carattere trovato. Prima di procedere con la ricerca, controllo se ci sono abbastanza
                         * spazi (colonne) a dx per contenere la parola da cercare
                         */
                        if (matrice[i].length > j+parola.length()-1)
                            for (k=j+1, indice=1; indice<parola.length(); k++, indice++) {

                                if (matrice[i][k] != parola.toLowerCase().charAt(indice))
                                    break;
                                if (indice == parola.length()-1)
                                    return true;
                            }

                        //Controllo se la stringa si trova a sx del carattere trovato. Controllo se ci sono abbastanza spazi a sx
                        if (j-(parola.length()-1) >= 0)
                            for (k=j-1, indice=1; indice<parola.length(); k--, indice++) {

                                if (matrice[i][k] != parola.toLowerCase().charAt(indice))
                                    break;
                                if (indice == parola.length()-1)
                                    return true;
                            }

                        //Controllo se la stringa si trova sopra al carattere trovato. Controllo se ci sono abbastanza spazi
                        if (i-(parola.length()-1) >= 0)
                            for (k=i-1, indice=1; indice<parola.length(); k--, indice++) {

                                if (matrice[k][j] != parola.toLowerCase().charAt(indice))
                                    break;
                                if (indice == parola.length()-1)
                                    return true;
                            }

                        //Controllo se la stringa si trova sotto al carattere trovato. Controllo se ci sono abbastanza spazi
                        if (i+parola.length()-1 < matrice.length)
                            for (k=i+1, indice=1; indice<parola.length(); k++, indice++) {

                                if (matrice[k][j] != parola.toLowerCase().charAt(indice))
                                    break;
                                if (indice == parola.length()-1)
                                    return true;
                            }

                        //Controllo diagonale in alto a dx. Unisco le condizioni per trovare la stringa su e quelle per trovarla a dx
                        if (i-(parola.length()-1) >= 0 && matrice[i].length > j+parola.length()-1)
                            for (l=i-1, k=j+1, indice=1; indice<parola.length(); k++, l--, indice++) {

                                if (matrice[l][k] != parola.toLowerCase().charAt(indice))
                                    break;
                                if (indice == parola.length()-1)
                                    return true;
                            }

                        //Controllo diagonale in alto a sx. Unisco le condizioni per trovare la stringa su e quelle per trovarla a sx
                        if (i-(parola.length()-1) >= 0 && j-(parola.length()-1) >= 0)
                            for (l=i-1, k=j-1, indice=1; indice<parola.length(); k--, l--, indice++) {

                                if (matrice[l][k] != parola.toLowerCase().charAt(indice))
                                    break;
                                if (indice == parola.length()-1)
                                    return true;
                            }

                        //Controllo diagonale in basso a dx. Unisco le condizioni per trovare la stringa giù e quelle per trovarla a dx
                        if (i+parola.length()-1 < matrice.length && matrice[i].length > j+parola.length()-1)
                            for (l=i+1, k=j+1, indice=1; indice<parola.length(); k++, l++, indice++) {

                                if (matrice[l][k] != parola.toLowerCase().charAt(indice))
                                    break;
                                if (indice == parola.length()-1)
                                    return true;
                            }

                        //Controllo diagonale in basso a sx. Unisco le condizioni per trovare la stringa giù e quelle per trovarla a sx
                        if (i+parola.length()-1 < matrice.length && j-(parola.length()-1) >= 0)
                            for (l=i+1, k=j-1, indice=1; indice<parola.length(); k--, l++, indice++) {

                                if (matrice[l][k] != parola.toLowerCase().charAt(indice))
                                    break;
                                if (indice == parola.length()-1)
                                    return true;
                            }
                    }
                }
            }
            return false;
        }
        return false;
    }
}