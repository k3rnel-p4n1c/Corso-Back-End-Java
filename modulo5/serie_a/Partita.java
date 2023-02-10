package modulo5.serie_a;

import java.util.Random;

public class Partita {

    /**
     * Questo metodo si occupa di far giocare due quadre. I risultati della partita sono randomici
     * @param squadra1 prima squadra
     * @param squadra2 seconda squadra
     */
    public void giocaPartita(Squadra squadra1, Squadra squadra2) {
        Random random = new Random();
        int gol_fatti_squadra1 = random.nextInt(4) + 1;         //Da 0 ad un max di 4 gol fatti
        int gol_fatti_squadra2 = random.nextInt(4) + 1;

        //Imposto gol fatti e subiti alle rispettive squadre
        squadra1.setGolFatti(gol_fatti_squadra1);
        squadra1.setGolSubiti(gol_fatti_squadra2);
        squadra2.setGolFatti(gol_fatti_squadra2);
        squadra2.setGolSubiti(gol_fatti_squadra1);

        //In base ai risultati della partita, la squadra che vince guadagna +3, mentre se pareggiano entrambi +1
        if (gol_fatti_squadra1 > gol_fatti_squadra2)
            squadra1.setPunteggio(squadra1.getPunteggio() + 3);
        else if (gol_fatti_squadra2 > gol_fatti_squadra1)
            squadra2.setPunteggio(squadra2.getPunteggio() + 3);
        else {
            squadra1.setPunteggio(squadra1.getPunteggio() + 1);
            squadra2.setPunteggio(squadra2.getPunteggio() + 1);
        }
    }
}