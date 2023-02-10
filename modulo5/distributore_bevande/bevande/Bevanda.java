package modulo5.distributore_bevande.bevande;

public class Bevanda {
    protected String codice_univoco;
    protected float prezzo;
    protected int numero_prodotti;


    protected Bevanda(String codice_univoco, float prezzo) {
        this.codice_univoco = codice_univoco;
        this.prezzo = prezzo;
    }

    public String getCodiceUnivoco() {
        return codice_univoco;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public int getNumeroProdotti() {
        return numero_prodotti;
    }

    public void setNumeroProdotti(int numero_prodotti) {
        this.numero_prodotti = numero_prodotti;
    }

    @Override
    public String toString() {
        return "Codice: " +codice_univoco+ "\nPrezzo: " +prezzo+ "€\nNumero prodotti: " +numero_prodotti;
    }
}