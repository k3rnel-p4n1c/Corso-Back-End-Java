package modulo5.forme_geometriche.figure;

public class Rettangolo {

    protected int lato1;
    protected int lato2;

    public Rettangolo(int lato1, int lato2) {
        this.lato1 = lato1;
        this.lato2 = lato2;
    }

    public float getArea() {
        return lato1*lato2;
    }

    public int getPerimetro() {
        return lato1+lato2;
    }


    @Override
    public String toString() {
        return "Lato 1: " +lato1+ "\nLato 2: " +lato2;
    }
}