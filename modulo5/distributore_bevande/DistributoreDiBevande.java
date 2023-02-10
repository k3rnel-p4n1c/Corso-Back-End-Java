package modulo5.distributore_bevande;

import modulo5.distributore_bevande.bevande.Bevanda;
import modulo5.distributore_bevande.bevande.Caffe;
import modulo5.distributore_bevande.bevande.Cappuccino;

public class DistributoreDiBevande {
    private Caffe caffe;
    private Cappuccino cappuccino;
    private float saldo;


    /**
     * Questo metodo si occupa di caricare il prodotto nel distributore, ovvero di aggiornare la quantità di caffè o cappuccini presenti
     * @param bevanda la bevanda (caffe o cappuccino) che si vuole aggiungere
     * @param numero_prodotti numero di bevande da aggiungere
     */
    public void caricaProdotto(Bevanda bevanda, int numero_prodotti) {
        //Calcolo il numero totale di bevande presenti nel distributore. Mi serve poiché il numero max di bevande è 50
        int totale = getNumeroBevande();

        if (totale + numero_prodotti <= 50)             //Controllo se l'aggiunta non sfori le 50 unità
            if (bevanda.getClass() == Caffe.class) {    //Controllo se la bevanda è un caffè
                caffe = (Caffe) bevanda;                //Downcast - il caffe di questa classe lo referenzio al caffè istanziato nel main
                caffe.setNumeroProdotti(caffe.getNumeroProdotti() + numero_prodotti);   //Aggiorno il numero di caffe
            }
            else {
                cappuccino = (Cappuccino) bevanda;
                cappuccino.setNumeroProdotti(cappuccino.getNumeroProdotti() + numero_prodotti);
            }
        else
            System.err.println("Puoi caricare al massimo 50 bevande, quindi altre " +(50-totale)+ " (tu ne volevi caricare " +numero_prodotti+ ")");
    }

    /**
     * Questo metodo serve per ottenere il numero totale di bevande presenti nel distributore
     * @return restituisce un valore intero
     */
    public int getNumeroBevande() {
        int totale = 0;

        if (caffe != null)                              //Controllo che l'oggetto sia stato referenziato
            if (caffe.getNumeroProdotti() != 0)         //Controllo che ci sia almeno un prodotto
                totale += caffe.getNumeroProdotti();    //Aggiorno il totale

        if (cappuccino != null)
            if (cappuccino.getNumeroProdotti() != 0)
                totale += cappuccino.getNumeroProdotti();

        return totale;
    }

    /**
     * Questo metodo permette all'utente di scegliere (e comprare) una bevanda inserendo il rispettivo codice. Prima è necessario aver
     * inserito un importo all'interno del distributore
     * @param codice_prodotto codice del prodotto che si vuole acquistare
     */
    public void scegliProdotto(String codice_prodotto) {
        if (codice_prodotto.equals(caffe.getCodiceUnivoco())) {                 //Controllo se è stato inserito un caffè
            if (caffe.getNumeroProdotti() > 0)                                  //Controllo se ci sono abbastanza caffè
                if (saldo >= caffe.getPrezzo()) {                               //Controllo se il saldo è sufficiente
                    System.out.println("Il distributore eroga un caffe");
                    saldo -= caffe.getPrezzo();                                 //Decremento il saldo
                }
                else
                    System.err.println("Saldo insufficiente");
            else
                System.err.println("Non ci sono caffe!");
        }
        else if (codice_prodotto.equals(cappuccino.getCodiceUnivoco())) {
            if (cappuccino.getNumeroProdotti() > 0)
                if (saldo >= cappuccino.getPrezzo()) {
                    System.out.println("Il distributore eroga un cappuccino");
                    saldo -= cappuccino.getPrezzo();
                }
                else
                    System.err.println("Saldo insufficiente");
            else
                System.err.println("Non ci sono cappuccini!");
        }
    }

    /**
     * Questo metodo si occupa di restituire il resto del distributore e azzerare il saldo disponibile
     */
    public void getResto() {
        System.out.format("Resto dal distributore: %.2f€\n", saldo);
        saldo=0;
    }

    /**
     * Questo metodo si occupa di inserire denaro per poter acquistare una o più bevande
     * @param importo importo da aggiungere nella macchinetta
     */
    public void inserisciImporto(int importo) {
        saldo = importo;
    }
}