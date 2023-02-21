package modulo7.tinder_like;

import java.util.HashSet;

public class Utente {
    private static int contatore_ID=0;  //Per ogni nuovo utente viene incrementato, in modo che abbiano tutti un ID diverso
    private int ID;
    private String username;
    private HashSet<Interesse> interessi = new HashSet<>(0);


    public Utente(String username, Interesse interesse) {
        this.username = username;
        interessi.add(interesse);
        ID = contatore_ID++;
    }

    public Utente(String username) {
        this.username = username;
        ID = contatore_ID++;
    }

    public HashSet<Interesse> getInteressi() {
        return interessi;
    }

    public void aggiungiInteresse(Interesse interesse) {
        interessi.add(interesse);
    }

    @Override
    public String toString() {
        return "ID: " +ID+ "\nUsername: " +username+ "\nInteressi:\n" +interessi;
    }
}