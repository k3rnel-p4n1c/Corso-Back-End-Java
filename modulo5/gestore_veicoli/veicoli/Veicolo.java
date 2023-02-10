package modulo5.gestore_veicoli.veicoli;

class Veicolo {
    protected String targa;
    protected int numero_posti;


    protected Veicolo(String targa, int numero_posti) {
        this.targa = targa;
        this.numero_posti = numero_posti;
    }

    @Override
    public String toString() {
        return targa;
    }
}