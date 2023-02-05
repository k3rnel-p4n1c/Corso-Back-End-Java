package modulo4.contatore;

public class Contatore {
    private int valore;

    public Contatore(int valore) {
        this.valore = valore;
    }

    public Contatore() {}

    public void incrementaConteggio() {
        valore++;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }
}