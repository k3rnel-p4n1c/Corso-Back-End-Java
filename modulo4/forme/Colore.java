package modulo4.forme;

import java.util.Arrays;

public class Colore {
    private int r, g, b;
    public static final Colore BIANCO = new Colore(255, 255, 255);
    public static final Colore NERO = new Colore(0, 0, 0);


    public Colore(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
}