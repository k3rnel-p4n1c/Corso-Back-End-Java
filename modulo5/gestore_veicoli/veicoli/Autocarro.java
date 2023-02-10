package modulo5.gestore_veicoli.veicoli;

public class Autocarro extends Veicolo {
    private int max_quintali;


    public Autocarro(String targa, int numero_posti, int max_quintali) {
        super(targa, numero_posti);
        this.max_quintali = max_quintali;
    }

    @Override
    public String toString() {
        return super.toString()+ " : " +max_quintali;
    }
}