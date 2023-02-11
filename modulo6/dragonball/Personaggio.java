package modulo6.dragonball;

public class Personaggio implements Comparable<Personaggio> {
    private String nome;
    private int hp;
    private int forza_fisica;       //Valore compreso tra 1 e 10
    private float schivata;         //Compreso tra 0.01 e 1, rappresenta la capacità di schivare attacchi
    private float resistenza;       //Compreso tra 0.01 e 1, rappresenta la sua resistenza fisica (più è basso il valore, più è alta)
    private Razza razza;
    private Attacco[] attacchi;     //Vettore di attacchi, di cui il primo (0) è l'attacco base e dipende dal personaggio


    public Personaggio(String nome, int hp, int forza_fisica, Razza razza, Attacco[] attacchi) {
        attacchi[0].setDanno(forza_fisica);     //L'attacco di base (da mischia) ha un danno pari alla forza fisica del personaggio

        this.nome = nome;
        this.hp = hp;
        this.forza_fisica = forza_fisica;
        this.razza = razza;
        this.attacchi = attacchi;
        schivata = (float)(Math.random() + 0.01);       //Valore compreso tra 0.01 e 1
        resistenza = (float)(Math.random() + 0.01);
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getNome() {
        return nome;
    }

    public Attacco getAttacco(int indice) {
        return attacchi[indice];
    }

    public float getResistenza() {
        return resistenza;
    }

    public float getSchivata() {
        return schivata;
    }


    /**
     * Questo metodo si occupa di stampare tutti gli attacchi del giocatore che lo invoca
     */
    public void mostraAttacchi() {
        for (Attacco attacco : attacchi)
            System.out.println(attacco+ "\n");
    }


    @Override
    public String toString() {
        return "Nome: " +nome+ "\nHP: " +hp+ "\nForza fisica: " +forza_fisica+ "\nCapacità di schivata: " +schivata+ "\n" +
                "Resistenza: " +resistenza+ "\nRazza: " +razza;
    }

    /**
     * Questo metodo stabilisce un criterio di ordinamento tra due oggetti di tipo Personaggio. Quando una classe implementa l'interfaccia
     * Comparable, gli oggetti di quella classe possono essere ordinati in base ad un criterio specifico. Le classi come Collections.sort e
     * Arrays.sort sono classi predefinite in Java che ti permettono di ordinare gli elementi di una raccolta o di un array.
     * Queste classi richiedono che gli elementi che devono essere ordinati implementino l'interfaccia Comparable.
     * @param personaggio l'oggetto che deve essere confrontato
     * @return restituisce 1 se l'oggetto che invoca il metodo ha più hp dell'oggetto confrontato, 0 se gli oggetti hanno gli stessi hp
     * e -1 nel caso in cui l'oggetto confrontato abbia più hp di quello che lo invoca. Nel caso in cui l'oggetto passato come parametro
     * sia nullo, restituisce -100
     */
    @Override
    public int compareTo(Personaggio personaggio) {
        //Controllo caso mai l'oggetto passato come parametro non sia nullo
        if (personaggio != null)
            /* L'espressione "return Integer.compare(this.hp, personaggio.hp)" restituisce un valore intero che indica se l'attributo
             * hp dell'oggetto corrente è minore, uguale o maggiore dell'attributo hp dell'oggetto passato come parametro. Il metodo
             * Integer.compare è un metodo statico della classe Integer che confronta due valori interi e restituisce un valore intero
             * seguendo questa convenzione:
             * Se il primo valore è minore del secondo, il metodo restituisce un valore negativo
             * Se i due valori sono uguali, il metodo restituisce zero.
             * Se il primo valore è maggiore del secondo, il metodo restituisce un valore positivo
             */
            return Integer.compare(this.hp, personaggio.hp);
        else
            return -100;    //Nel caso in cui l'oggetto sia nullo, restituisce -100
    }
}