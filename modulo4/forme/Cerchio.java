package modulo4.forme;

public class Cerchio {

    private int raggio;
    private Colore colore;

    public Cerchio(int raggio) {
        this.raggio = raggio;
        colore = Colore.NERO;
    }

    public double calcolaCirconferenza() {
        return 2*Math.PI*raggio;
    }

    public double calcolaArea() {
        return 2*Math.PI*Math.pow(raggio, 2);
    }

    public void setColore(int r, int g, int b) {
        colore = new Colore(r, g, b);
    }

    public Colore getColore() {
        return colore;
    }
}