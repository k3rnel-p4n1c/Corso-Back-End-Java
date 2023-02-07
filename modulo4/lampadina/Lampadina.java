package modulo4.lampadina;

/* Non ha senso dichiararlo all'interno della classe Lampadina. Ha senso andarla a dichiarare in una classe apposita, come segue:
 *  public enum Stato {
 *     ACCESA, SPENTA, ROTTA
 * }
 */
enum Stato {ACCESA, SPENTA, ROTTA, ERA_ACCESA}     //Definisce lo stato della lampadina

public class Lampadina {
    private Stato stato;               //"accesa", "spenta", "rotta"
    private static boolean corrente;   //Vale per tutte le lampadine, indica o meno la presenza di corrente - false di default
    private boolean riaccendere_lampadina;    //Nel caso in cui l'alimentazione va via, quando ritorna bisogna ripristinare lo stato
    private int numero_click;   //Dopo 5 click la lampadina si rompe

    public Lampadina(Stato stato) {
        this.stato = stato;
    }

    public Lampadina() {
        this(Stato.SPENTA);     //Richiama il costruttore ad un parametro
    }


    public String getStato() {
        return "Stato lampadina: " +stato+ "\nStato alimentazione: " +corrente;
    }

    public void click() {
        if (corrente) {
            numero_click++;

            if (numero_click == 5)
                stato = Stato.ROTTA;
            else {
                if (stato == Stato.SPENTA)
                    stato = Stato.ACCESA;
                else
                    stato = Stato.SPENTA;
            }
        }
    }

    public void interrompiAlimentazione() {
        corrente = false;

        if (stato == Stato.ACCESA)
            riaccendere_lampadina = true;

        stato = Stato.SPENTA;
    }

    public void ripristinaAlimentazione() {
        corrente = true;

        if (riaccendere_lampadina)
            stato = Stato.ACCESA;

        riaccendere_lampadina = false;
    }
}