package modulo5.gestore_veicoli.veicoli;

public class Automobile extends Veicolo {
    private int numero_porte;

    public Automobile(String targa, int numero_posti, int numero_porte) {
        super(targa, numero_posti);
        this.numero_porte = numero_porte;
    }

    @Override
    public String toString() {
        return super.toString()+ " : " +numero_porte;
    }
}