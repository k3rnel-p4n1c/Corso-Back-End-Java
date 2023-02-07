package modulo4.negozio;

import java.util.Arrays;

public class Negozio {
    Prodotto[] prodotti = new Prodotto[1];      //Massimo 100 prodotti



    /**
     * Questo metodo si occupa di stampare tutti i prodotti presenti in negozio
     */
    public void stampaListaProdotti() {

        //Controllo se esiste almeno il primo prodotto
        if (prodotti[0] != null)
            for (Prodotto prod : prodotti)
                System.out.println(prod.toString()+ "\n");
        else
            System.out.println("Lista vuota");
    }

    /**
     * Questo metodo si occupa di stampare la quantità di un prodotto, se presente, nella lista dei prodotti del negozio
     * @param tipo il tipo è il criterio attraverso il quale viene identificato il prodotto all'interno della lista del negozio
     */
    public void stampaQuantitaRimanenteProdotto(String tipo) {
        int indice = prodottoPresenteNelNegozio(tipo);      //Cerco il prodotto all'interno del vettore e ne ricavo l'indice

        //Se il prodotto esiste, restituisce la sua quantità, altrimenti -1
        if (indice != -1)
            System.out.println(prodotti[indice].getQuantita());
        else
            System.out.println("Il prodotto \"" +tipo+ "\" non è presente nel negozio");
    }

    /**
     * Questo metodo si occupa di rimuovere il prodotto dalla lista dei prodotti disponibili in negozio
     * @param tipo il tipo viene utilizzato come criterio di ricerca all'interno del vettore
     */
    public void rimuoviProdotto(String tipo) {
        int indice = prodottoPresenteNelNegozio(tipo);      //Cerco il prodotto all'interno del vettore e ne ricavo l'indice

        //Se questo prodotto esiste, procedo con l'eliminazione
        if (indice != -1) {
            Prodotto[] nuova_lista_prodotti = new Prodotto[prodotti.length-1];      //Il nuovo vettore avrà una cella in meno

            //Copio la prima parte del vettore in quello nuovo, fino al valore da eliminare
            for (int i=0; i<indice; i++)
                nuova_lista_prodotti[i] = prodotti[i];

            //Copio la seconda parte del vettore in quello nuovo, saltando l'elemento da eliminare
            for (int i=indice+1, k=indice; k<nuova_lista_prodotti.length; i++, k++)
                nuova_lista_prodotti[k] = prodotti[i];

            prodotti = nuova_lista_prodotti;
        }
        else
            System.err.println("Il prodotto \"" +tipo+ "\" non esiste");
    }

    /**
     * Questo metodo si occupa di aggiungere, al negozio, un prodotto alimentare
     * @param tipo tipo del prodotto (prosciutto, mele, pere, ...)
     * @param prezzo prezzo di vendita del SINGOLO prodotto
     * @param quantita quantità da aggiungere
     */
    public void aggiungiProdottoAlimentare(String tipo, float prezzo, int quantita) {
        addProduct(tipo.toLowerCase(), prezzo, true, quantita);
    }

    /**
     * Questo metodo si occupa di aggiungere, al negozio, un prodotto NON alimentare
     * @param tipo tipo del prodotto (aspirapolveri, asciugamani, ...)
     * @param prezzo prezzo di vendita del SINGOLO prodotto
     * @param quantita quantità da aggiungere
     */
    public void aggiungiProdotto(String tipo, float prezzo, int quantita) {
        addProduct(tipo.toLowerCase(), prezzo, false, quantita);
    }

    /**
     * Questo metodo si occupa di riempire il carrello del cliente. Vengono fatti dei controlli sui dati
     * @param cliente il cliente di cui si vuole riempire il carrello
     * @param tipo il tipo di prodotto da aggiungere alla lista della spesa del cliente
     * @param quantita_da_acquistare quantità del prodotto da acquistare
     */
    public void riempiCarrello(Cliente cliente, String tipo, int quantita_da_acquistare) {
        int indice = prodottoPresenteNelNegozio(tipo);

        //Nel caso in cui l'elemento sia presente nel negozio, procedo con l'inserimento nel carrello. La quantità non deve essere negativa
        if (indice != -1 && quantita_da_acquistare>0) {
            if (quantita_da_acquistare <= prodotti[indice].getQuantita()) {     //Verifico che ci sia abbastanza quantità di roba

                //Tolgo la roba acquistata dal totale disponibile del negozio
                prodotti[indice].setQuantita(prodotti[indice].getQuantita() - quantita_da_acquistare);
                Prodotto prodotto = new Prodotto(tipo.toLowerCase(), prodotti[indice].getPrezzo(), prodotti[indice].isAlimentare(), quantita_da_acquistare);
                cliente.aggiungiProdottoAlCarrello(prodotto);
            }
            else
                System.err.println("Non è possibile aggiungere " +quantita_da_acquistare+ " \"" +tipo.toLowerCase()+ "\". Quantità non disponibile.");
        }
        else
            System.err.println("Non è possibile aggiungere il prodotto \"" +tipo.toLowerCase()+ "\" in quanto non è presente in negozio");
    }

    /**
     * Questo metodo si occupa di aggiungere effettivamente il prodotto al vettore di prodotti. Nel caso in cui il prodotto sia già presente
     * nel vettore, aggiorna la quantita. Questo metodo è privato in quanto verrà chiamato da altri 2 metodi pubblici che si occuperanno di
     * fare distinzione tra l'aggiunta di un prodotto alimentare o meno, in modo da non far inserire all'utente questo dato
     * @param tipo questo parametro identifica il tipo del prodotto (mele, pere, pentole, ...)
     * @param prezzo prezzo del SINGOLO prodotto
     * @param alimentare variabile booleana che identifica se il prodotto è di tipo alimentare o meno
     * @param quantita quantità di prodotti da aggiungere
     */
    private void addProduct(String tipo, float prezzo, boolean alimentare, int quantita) {

        //Controllo che ci siano al massimo 100 prodotti
        if (prodotti.length <= 100) {
            int indice = prodottoPresenteNelNegozio(tipo);

            //Nel caso in cui il prodotto sia già presente, devo aggiornare la quantità
            if (indice != -1)
                prodotti[indice].setQuantita(prodotti[indice].getQuantita() + quantita);
            else {
                Prodotto prodotto = new Prodotto(tipo, prezzo, alimentare, quantita);

                if (prodotti[prodotti.length-1] == null)        //Nel caso sia il primo elemento, lo inserisco
                    prodotti[prodotti.length-1] = prodotto;
                else {
                    //Nel caso non sia il primo elemento, espando di 1 il vettore e aggiungo il prodotto nell'ultima posizione
                    Prodotto[] nuova_lista_prodotti = Arrays.copyOf(prodotti, prodotti.length+1);
                    nuova_lista_prodotti[nuova_lista_prodotti.length-1] = prodotto;
                    prodotti = nuova_lista_prodotti;
                }
            }
        }
        else
            System.err.println("Non è possibile aggiungere ulteriori prodotti!");
    }

    /**
     * Questo metodo controlla se il prodotto esiste già nel negozio
     * @param tipo questo parametro rappresenta il tipo del prodotto da ricercare all'interno del negozio (mele, pere, PC, ...)
     * @return restituisce l'indice del vettore se il prodotto è presente, -1 altrimenti
     */
    private int prodottoPresenteNelNegozio(String tipo) {
        if (prodotti[0] == null)    //Se non esiste neanche il primo elemento restituisce direttamente -1
            return -1;
        else
            for (int i=0; i<prodotti.length; i++)
                if (prodotti[i].getTipo().equals(tipo.toLowerCase()))
                    return i;

        return -1;
    }
}