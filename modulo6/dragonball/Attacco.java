package modulo6.dragonball;

public class Attacco {
    private String nome;
    private int danno;
    private int prob_colpire;     //Compreso tra 1 e 100, probabilità che l’attacco vada a segno


    public Attacco(String nome, int danno) {
        this.nome = nome;
        this.danno = danno;
        prob_colpire = (int)((Math.random() + 0.01)*100);   //Valore compreso tra 0.01 e 1, poi moltiplicato per 100
    }

    public Attacco(String nome) {
        this.nome = nome;
        prob_colpire = (int)((Math.random() + 0.01)*100);   //Valore compreso tra 0.01 e 1, poi moltiplicato per 100
    }


    public String getNome() {
        return nome;
    }

    public float getProbColpire() {
        return prob_colpire;
    }

    public int getDanno() {
        return danno;
    }

    protected void setDanno(int danno) {
        this.danno = danno;
    }


    @Override
    public String toString() {
        return "Nome: " +nome+ "\nDanno: " +danno+ "\nProbabilità che l'attacco vada a segno: " +prob_colpire;
    }
}