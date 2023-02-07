package modulo4.Negozio;

import java.util.Arrays;

public class Cliente {
    private String nome;
    private int eta;
    private Prodotto[] carrello = new Prodotto[1];      //Carrello di prodotti acquistati dall'utente


    public Cliente(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    /**
     * Questo metodo calcola il prezzo totale che il cliente dovrà pagare, moltiplicando il prezzo per prodotto con la quantità da acquistare.
     * In base al giorno della settimana (che viene calcolato random) e, se l'età del cliente è >=60, il prezzo sarà scontato del 20%.
     * I giorni della settimana in cui questo accade sono LUN e MER
     * @param giorno prende in input il giorno della settimana corrente, necessario a calcolare l'eventuale sconto
     * @return restituisce il prezzo (float) oppure -1 nel caso in cui il carrello sia vuoto
     */
    public float totaleDaPagare(Giorno giorno) {

        //Controllo che nel carrello ci sia almeno un elemento
        if (carrello[0] == null)
            return -1;
        else {
            float totale = 0;

            for (Prodotto prodotto : carrello)
                if (eta >= 60 && (giorno == Giorno.LUNEDI || giorno == Giorno.MERCOLEDI) && prodotto.isAlimentare())    //Verifico se è possibile applicare lo sconto del 20%
                    totale += (prodotto.getPrezzo() * prodotto.getQuantita()) - 0.2*(prodotto.getPrezzo() * prodotto.getQuantita());
                else
                    totale += prodotto.getPrezzo() * prodotto.getQuantita();

            return totale;
        }
    }

    /**
     * Metodo che aggiunge il prodotto al carrello. Questo metodo NON va richiamato nel main, ma è un metodo interno che va richiamato
     * nella classe Negozio. La sua visibilità è per forza pubblica in quanto altrimenti non posso usare questo metodo in altre classi
     * @param prodotto prende in input il parametro da aggiungere al carrello
     */
    public void aggiungiProdottoAlCarrello(Prodotto prodotto) {
        int indice = prodottoPresenteNelCarrello(prodotto.getTipo());

        //Nel caso in cui il prodotto sia già presente, devo aggiornare la quantità
        if (indice != -1)
            carrello[indice].setQuantita(carrello[indice].getQuantita() + prodotto.getQuantita());
        else {
            if (carrello[carrello.length-1] == null)        //Nel caso sia il primo elemento, lo inserisco
                carrello[carrello.length-1] = prodotto;
            else {
                //Nel caso non sia il primo elemento, espando di 1 il vettore e aggiungo il prodotto nell'ultima posizione
                Prodotto[] nuovo_carrello = Arrays.copyOf(carrello, carrello.length+1);
                nuovo_carrello[nuovo_carrello.length-1] = prodotto;
                carrello = nuovo_carrello;
            }
        }
    }

    /**
     * Questo metodo stampa la lista della spesa del cliente
     */
    public void stampaCarrello() {
        for (Prodotto prodotto : carrello)
            System.out.println(prodotto.toString()+ "\n");
    }

    /**
     * Questo metodo controlla se il prodotto è già presente nel carrello del negozio
     * @param tipo sarebbe il nome del prodotto, ovvero il criterio di ricerca
     * @return restttuisce l'indice del vettore se trova il prodotto, -1 altrimenti
     */
    private int prodottoPresenteNelCarrello(String tipo) {
        if (carrello[0] == null)    //Se non esiste neanche il primo elemento restituisce direttamente -1
            return -1;
        else
            for (int i=0; i<carrello.length; i++)
                if (carrello[i].getTipo().equals(tipo.toLowerCase()))
                    return i;

        return -1;
    }


    @Override
    public String toString() {
        return "Nome: " +nome+ "\nEtà: " +eta;
    }
}