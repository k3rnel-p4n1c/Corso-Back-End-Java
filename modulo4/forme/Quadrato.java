package modulo4.forme;

public class Quadrato {
    private int lato;
    private Colore colore;

    public Quadrato(int lato) {
        this.lato = lato;
        colore = Colore.NERO;
    }

    public int calcolaPerimetro() {
        return lato*4;
    }

    public void stampaQuadrato() {
        for (int i=0; i<lato; i++) {
            for (int j=0; j<lato; j++)
                System.out.print("*  ");
            System.out.println();
        }
    }

    public void setColore(int r, int g, int b) {
        colore = new Colore(r, g, b);
    }

    public Colore getColore() {
        return colore;
    }
}