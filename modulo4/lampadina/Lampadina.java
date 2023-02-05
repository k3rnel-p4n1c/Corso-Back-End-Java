package modulo4.lampadina;

public class Lampadina {
    private String stato;               //"accesa", "spenta", "rotta"
    private static boolean corrente;   //Vale per tutte le lampadine, indica o meno la presenza di corrente - false di default
    private boolean riaccendere_lampadina;    //Nel caso in cui l'alimentazione va via, quando ritorna bisogna ripristinare lo stato
    private int numero_click;   //Dopo 5 click la lampadina si rompe

    public Lampadina(String stato) {
        this.stato = stato;
    }

    public Lampadina() {
        this("spenta");     //Richiama il costruttore ad un parametro
    }


    public String getStato() {
        return "Stato lampadina: " +stato+ "\nStato alimentazione: " +corrente;
    }

    public void click() {
        if (corrente) {
            numero_click++;

            if (numero_click == 5)
                stato = "rotta";
            else {
                if (stato.equals("spenta"))
                    stato = "accesa";
                else
                    stato = "spenta";
            }
        }
    }

    public void interrompiAlimentazione() {
        corrente = false;

        if (stato.equals("accesa"))
            riaccendere_lampadina = true;

        stato = "spenta";
    }

    public void ripristinaAlimentazione() {
        corrente = true;

        if (riaccendere_lampadina)
            stato = "accesa";

        riaccendere_lampadina = false;
    }
}