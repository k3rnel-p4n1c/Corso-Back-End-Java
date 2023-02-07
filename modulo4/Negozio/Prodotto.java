package modulo4.negozio;

public class Prodotto {
    private String tipo;            //mele, pere, aspirapolveri, ...
    private float prezzo;
    private boolean alimentare;     //Se vero, vuol dire che il prodotto appartiene al genere alimentare
    private int quantita;


    public Prodotto(String tipo, float prezzo, boolean alimentare, int quantita) {
        this.tipo = tipo;
        this.prezzo = prezzo;
        this.alimentare = alimentare;
        this.quantita = quantita;
    }


    public String getTipo() {
        return tipo;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public boolean isAlimentare() {
        return alimentare;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }


    @Override
    public String toString() {
        return "Tipo: " +tipo+ "\nGenere alimentare: " +alimentare+ "\nPrezzo cadauno: " +prezzo+ "€\nQuantità: " +quantita;
    }
}