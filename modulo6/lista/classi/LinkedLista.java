package modulo6.lista.classi;

//NOTA: TUTTI GLI OGGETTI PASSATI COME PARAMETRI, SONO PASSATI PER RIFERIMENTO. IL VALORE VIENE MODIFICATO OVUNQUE.
public class LinkedLista {

    //Dichiaro testa e coda per salvarmi inizio e fine della lista
    private Nodo head;
    private Nodo tail;

    public LinkedLista() {
        /* Creo i nodi testa e coda, con contenuto informativo sempre nullo, in maniera
         * tale da conoscere sempre il primo e l'ultimo elemento della lista e facilitare le operazioni
         * IMPORTANTE: NELLA NUMERAZIONE DEI NODI DELLA LISTA, HEAD E TAIL SONO ESCLUSI, quindi
         * il nodo corrispondente all'indice 0 sarà il successivo a head (questo perché questi 2
         * nodi sono utili solamente alla gestione del programma e non devono interferire con l'utente
         */
        tail = new Nodo("Tail");
        head = new Nodo("Head", tail);
    }

    //Metodi getter di head e tail NON REALI (ossia il primo e l'ultimo nodo utile della lista)
    public Nodo getHead() {
        return head.getNodoSuccessivo();
    }
    public Nodo getTail() {
        Nodo puntatore;

        //Scorro la lista fino ad arrivare al nodo PRECEDENTE alla coda REALE
        for (puntatore=head; puntatore!=tail; puntatore=puntatore.getNodoSuccessivo())
            //Quando il nodo successivo al puntatore è uguale alla coda REALE, allora sono arrivato a destinazione
            if (puntatore.getNodoSuccessivo().equals(tail))
                break;

        return puntatore;
    }


    /**
     * Aggiunge il nodo in testa
     * @param nodo nodo da aggiungere in testa
     */
    public void addHead(Nodo nodo) {

        //Controllo se il nodo non è in lista
        if (nodeAlreadyExists(nodo)<0) {
            nodo.setNodoSuccessivo(getHead());  //Imposto la testa NON REALE come successiva al nodo passato come parametro
            head.setNodoSuccessivo(nodo);       //Imposto il nodo come successivo della testa REALE
        }
        else {
            remove(nodeAlreadyExists(nodo));    //Lo tolgo dalla sua posizione e lo aggiungo in testa
            addHead(nodo);
        }
    }

    /**
     * Aggiunge il nodo in coda
     * @param nodo nodo da aggiungere in coda
     */
    public void addTail(Nodo nodo) {

        //Controllo se il nodo non è in lista
        if (nodeAlreadyExists(nodo)<0) {
            getTail().setNodoSuccessivo(nodo);      //Imposto A come nodo successivo alla coda NON reale
            nodo.setNodoSuccessivo(tail);           //Imposto la coda REALE come successiva al nodo A
        }
        else {
            remove(nodeAlreadyExists(nodo));        //Lo tolgo dalla sua posizione e lo aggiungo in coda
            addTail(nodo);
        }
    }

    /**
     * Aggiunge il nodo A prima del nodo B
     * @param a nodo da aggiungere prima di B
     * @param b nodo che si deve trovare dopo di A
     */
    public void addBefore(Nodo a, Nodo b) {

        //Controllo se il nodo non è in lista
        if (nodeAlreadyExists(a)<0) {

            /* Partendo dalla testa, scorro la lista finchè non trovo il nodo PRECEDENTE a B (così facendo
             * posso accedere ai vari campi del nodo precedente a B, che punteranno ad A, ed A a B)
             */
            for (Nodo puntatore=head; puntatore!=tail; puntatore=puntatore.getNodoSuccessivo()) {
                //La condizione è vera quando il Nodo puntatore ha raggiunto il nodo precedente a B
                if (puntatore.getNodoSuccessivo().equals(b)) {
                    a.setNodoSuccessivo(b);             //Imposto B come il successore di A
                    puntatore.setNodoSuccessivo(a);     //Imposto A come il successore del nodo precedente a B
                    break;
                }
            }
        }
        //Caso in cui il nodo A è già presente in lista
        else {
            remove(nodeAlreadyExists(a));   //Lo tolgo dalla sua posizione e lo aggiungo prima di B
            addBefore(a, b);
        }
    }

    /**
     * Aggiunge il nodo A dopo il nodo B
     * @param a nodo da aggiungere dopo B
     * @param b nodo che si deve trovare prima di A
     */
    public void addAfter(Nodo a, Nodo b) {

        //Controllo se il nodo non è in lista
        if (nodeAlreadyExists(a)<0) {
            a.setNodoSuccessivo(b.getNodoSuccessivo());     //Imposto il successivo a cui puntava B, come successivo di A
            b.setNodoSuccessivo(a);                         //Imposto A come successivo di B
        }
        else {
            remove(nodeAlreadyExists(a));   //Lo tolgo dalla sua posizione e lo aggiungo
            addAfter(a,b);
        }
    }

    /**
     * Aggiunge il nodo all'i-esima posizione della lista
     * @param nodo nodo da aggiungere
     * @param position posizione alla quale si vuole aggiungere il nodo
     */
    public void add(Nodo nodo, int position) {

        //Controllo se il nodo non è in lista
        if (nodeAlreadyExists(nodo)<0) {

            //Effettuo un controllo nel caso in cui la posizione non sia valida
            if (position> lenght() || position<0)
                System.out.println("La posizione inserita non è valida!");
            else {
                int i=0;

                /* Scorro la lista partendo dalla testa REALE fino alla coda NON REALE. In questo modo quando i==position
                 * il puntatore si troverà in position-1, ossia il posto dove agganciare il nuovo nodo
                 */
                for (Nodo puntatore=head; puntatore!=tail; puntatore=puntatore.getNodoSuccessivo()) {
                    if (i==position) {
                        nodo.setNodoSuccessivo(puntatore.getNodoSuccessivo());  //Imposto il nodo successivo al puntatore come successivo
                        puntatore.setNodoSuccessivo(nodo);                      //Imposto A come nodo successivo al puntatore
                    }

                    i++;
                }
            }
        }
        //Caso in cui il nodo è già presente in lista
        else {
            remove(nodeAlreadyExists(nodo));    //Lo tolgo dalla sua posizione e lo aggiungo in testa
            add(nodo, position);
        }
    }

    /**
     * Questo metodo restituisce il nodo (senza rimuoverlo) alla posizione specificata
     * @param position posizione nella quale si vuole cercare il nodo
     * @return restituisce il nodo nella posizione specificata
     */
    public Nodo getNodo(int position) {
        //Effettuo un controllo sulla validità della posizione
        if (position<0 || position>= lenght())
            return null;
        else {
            int i=0;
            Nodo puntatore;

            /* Mi scorro tutta la lista in cerca del nodo i-esimo. Faccio iniziare il ciclo dalla testa NON REALE
             * in quanto per l'utente, la numerazione della lista esclude i nodi testa e coda creati da me
             */
            for (puntatore=getHead(); puntatore!=getTail(); puntatore=puntatore.getNodoSuccessivo()) {
                if (i==position)
                    break;
                i++;
            }

            return puntatore;
        }
    }

    /**
     * Rimuove il nodo i-esimo della lista
     * @param position posizione alla quale si vuole rimuovere il nodo
     */
    public void remove(int position) {
        //Effettuo un controllo sulla validità della posizione
        if (position<0 || position>=lenght())
            System.out.println("La posizione inserita non è valida!");
        else {
            int i=0;

            /* Scorro la lista partendo dalla testa REALE fino alla coda NON REALE. In questo modo quando i==position
             * il puntatore si trovera a position-1, ossia il posto dove agganciare il puntatore al nodo più avanti di 2
             */
            for (Nodo puntatore=head; puntatore!=tail; puntatore=puntatore.getNodoSuccessivo()) {
                if (i==position)
                    //Imposto come successivo al puntatore, il nodo che lo segue 2 posizioni in avanti (ne salto uno)
                    puntatore.setNodoSuccessivo(puntatore.getNodoSuccessivo().getNodoSuccessivo());

                i++;
            }
        }
    }

    /**
     * Pulisce ed elimina tutti i nodi della lista tranne testa e coda REALI, facendo puntare la testa alla coda
     */
    public void clear() {
        head.setNodoSuccessivo(tail);
    }

    /**
     * Calcola la lunghezza della lista
     * @return restituisce la lunghezza della lista
     */
    public int lenght() {
        int lenght=0;

        for (Nodo puntatore = getHead(); puntatore!=tail; puntatore=puntatore.getNodoSuccessivo())
            lenght++;

        return lenght;
    }

    /**
     * Stampa la lista dalla testa alla coda, altrimenti un messaggio che indica che la lista è vuota
     */
    public void stampaLista() {
        int i=0;

        //Effettuo un controllo nel caso in cui la lista sia vuota
        if (getHead() != tail)
            for (Nodo puntatore=getHead(); puntatore!=tail; puntatore=puntatore.getNodoSuccessivo()) {
                System.out.println("["+i+"] Elemento: "+puntatore.getElemento());

                /* Dato che l'utente non deve accorgersi di testa e coda REALI, quando viene stampata
                 * la coda NON REALE, bisogna stampare "null" come elemento successivo anzichè la coda REALE.
                 * Si potrebbe anche non stampare niente, è una scelta
                 */
                if (puntatore.getNodoSuccessivo()!=tail)
                    System.out.println("["+i+"] Successivo: "+puntatore.getNodoSuccessivo().getElemento());
                else
                    System.out.println("["+i+"] Successivo: null");

                i++;
            }
        else
            System.out.println("Lista vuota!");
    }

    /**
     * Controlla se un nodo è già presente all'interno della lista. Questo metodo serve anche per poter rimuovere
     * il nodo all'indice che viene restituito (la rimozione effettiva è svolta dal metodo apposito)
     * @param nodo nodo che si vuole cercare
     * @return restituisce -1 se non trova niente, altrimenti la posizione del nodo all'interno della lista
     */
    private int nodeAlreadyExists(Nodo nodo) {
        int position=0;

        //Scorro tutta la lista alla ricerca del nodo
        for (Nodo puntatore = getHead(); puntatore!=tail; puntatore=puntatore.getNodoSuccessivo()) {
            if (puntatore.equals(nodo))
                return position;
            position++;
        }

        return -1;
    }
}