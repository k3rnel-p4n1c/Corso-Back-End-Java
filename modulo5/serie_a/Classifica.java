package modulo5.serie_a;

import java.util.Arrays;

public class Classifica {
    Squadra[] squadre = new Squadra[1];


    /**
     * Questo metodo aggiunge una squadra alla classifica
     * @param squadra quadra da aggiungere alla classifica
     */
    public void aggiungiSquadraAllaClassifica(Squadra squadra) {

        //Controllo se l'ultima cella del vettore è libera, altrimenti procedo con l'ampliamento del vettore (+1 cella)
        if (squadre[squadre.length-1] == null)
            squadre[squadre.length-1] = squadra;
        else {
            Squadra[] nuovo_array_squadre = Arrays.copyOf(squadre, squadre.length+1);
            nuovo_array_squadre[nuovo_array_squadre.length-1] = squadra;
            squadre = nuovo_array_squadre;
        }
    }

    /**
     * Questo metodo stampa la classifica ordinata per punteggio
     */
    public void stampaClassifica() {
        ordinaClassifica();

        //Controllo che ci sia almeno una squadra
        if (squadre[0] != null)
            for (Squadra squadra : squadre)
                System.out.println(squadra.toString()+ "\n");
    }

    /**
     * Stampa la squadra che ha segnato un maggior numero di reti
     */
    public void getMigliorAttacco() {

        //Controllo che ci sia almeno un elemento nel vettore delle squadre
        if (squadre[0] != null) {
            int indice=0, max_punteggio=0;

            for (int i=0; i<squadre.length; i++)
                if (squadre[i].getGolFatti() > max_punteggio) {     //Trovo l'indice nel vettore della squadra con più gol fatti
                    indice = i;
                    max_punteggio = squadre[i].getGolFatti();
                }

            //Stampo la squadra con i maggior gol fatti
            System.out.println(squadre[indice].toString());
        }
        else
            System.err.println("Non sono presenti squadre in classifica!");
    }

    /**
     * Stampa la squadra che ha subito il maggior numero di gol
     */
    public void getPeggiorDifesa() {

        //Controllo che ci sia almeno un elemento nel vettore delle squadre
        if (squadre[0] != null) {
            int indice=0, max_gol_subiti=0;

            for (int i=0; i<squadre.length; i++)
                if (squadre[i].getGolSubiti() > max_gol_subiti) {     //Trovo l'indice nel vettore della squadra con più gol subiti
                    indice = i;
                    max_gol_subiti = squadre[i].getGolSubiti();
                }

            //Stampo la squadra con i maggior gol subiti
            System.out.println(squadre[indice].toString());
        }
        else
            System.err.println("Non sono presenti squadre in classifica!");
    }

    /**
     * Questo metodo si occupa di ordinare (bubbleSort) la classifica in base al suo punteggio
     */
    private void ordinaClassifica() {
        //Controllo che ci siano almeno due elementi nel vettore delle squadre
        if (squadre.length >= 2) {
            Squadra squadra;

            for (int i=0; i<squadre.length-1; i++) {
                for (int j=i+1; j<squadre.length; j++) {
                    if (squadre[i].getPunteggio() < squadre[j].getPunteggio()) {    //Ordino dal più grande al più piccolo

                        squadra = squadre[i];
                        squadre[i] = squadre[j];
                        squadre[j] = squadra;
                    }
                }
            }
        }
    }
}