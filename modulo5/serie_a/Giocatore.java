package modulo5.serie_a;

public class Giocatore {
    private int ID;             //Definito attraverso l'hashcode() calcolato dal nome e cognome
    private String nome;
    private String cognome;


    public Giocatore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        ID = nome.hashCode() + cognome.hashCode();

        //Mi assicuro che l'ID non sia negativo
        if (ID < 0)
            ID *= -1;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    @Override
    public String toString() {
        return "ID: " +ID+ "\nNome: " +nome+ "\nCognome: " +cognome;
    }
}