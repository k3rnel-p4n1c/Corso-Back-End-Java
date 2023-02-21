package modulo7.tinder_like;

public enum Interesse {
    PALESTRA("Palestra"),
    CALCIO("Calcio"),
    RUGBY("Rugby"),
    GIARDINAGGIO("Giardinaggio"),
    LETTURA("Lettura");

    private String descrizione;

    Interesse(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}