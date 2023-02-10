package modulo5.serie_a;

public class Squadra {
    private int ID;             //Inizializzato attraverso l'hashcode() del nome della squadra
    private String nome;
    private Giocatore[] giocatori;
    private int punteggio;
    private int gol_fatti;
    private int gol_subiti;


    public Squadra(String nome, Giocatore[] giocatori) {
        this.nome = nome;
        this.giocatori = giocatori;
        ID = nome.hashCode();

        //Mi assicuro che l'ID non sia negativo
        if (ID < 0)
            ID *= -1;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public void setGolFatti(int gol_fatti) {
        this.gol_fatti = gol_fatti;
    }

    public void setGolSubiti(int gol_subiti) {
        this.gol_subiti = gol_subiti;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public int getGolFatti() {
        return gol_fatti;
    }

    public int getGolSubiti() {
        return gol_subiti;
    }


    /**
     * Questo metodo si occupa di stampare tutti i giocatori di una squadra
     */
    public void stampaSquadra() {
        //Controllo che nel vettore "giocatori" non sia nullo (controllo il primo elemento)
        if (giocatori[0] != null)
            for (Giocatore giocatore : giocatori)
                System.out.println(giocatore.toString()+ "\n");
        else
            System.err.println("Non sono presenti giocatori!");
    }


    @Override
    public String toString() {
        return "ID: " +ID+ "\nNome: " +nome+ "\nPunteggio: " +punteggio+ "\nGol fatti: " +gol_fatti+ "\nGol subiti: " +gol_subiti;
    }
}