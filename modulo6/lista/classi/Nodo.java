package modulo6.lista.classi;

/* Questa classe gestisce in maniera generale gli elementi di un nodo. È di tipo generics in quanto
 * ogni nodo potrebbe contenere elementi di tipo differente (lista con dei tipi di dati eterogenei)
 */
public class Nodo<T> {
    private T elemento;     //Elemento di tipo generico che sarà contenuto in un nodo della lista
    private Nodo successivo;    //Variabile che conterrà un oggetto di tipo Nodo, successivo al nodo in cui è contenuto "elemento"


    //Costruttore senza parametri della classe: crea un singolo nodo, vuoto, senza successivo
    public Nodo() {
        /* La key-word "this", in questo caso, invoca il costruttore
         * a due parametri passandogli come argomenti "null", "null"
         */
        this(null, null);
    }

    //Costruttore ad un parametro della classe: crea un singolo nodo, pieno, senza successivo
    public Nodo(T elemento) {
        this(elemento, null);
    }

    //Costruttore a due parametri della classe: crea un singolo nodo, pieno, con successivo
    public Nodo(T elemento, Nodo successivo) {
        this.elemento = elemento;
        this.successivo = successivo;
    }

    public T getElemento() {
        return elemento;
    }

    public Nodo getNodoSuccessivo() {
        return successivo;
    }

    /**
     * Imposta il contenuto informativo del nodo
     * @param elemento contenuto informativo che si vuole impostare
     */
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    /**
     * Imposta il nodo successivo (al quale questo nodo punta)
     * @param successivo nodo da aggiungere
     */
    public void setNodoSuccessivo (Nodo successivo) {
        this.successivo = successivo;
    }


    /* Non è possibile confrontare due oggetti con "==" poiché in questa maniera viene confrontato l'indirizzo di
     * memoria in cui risiedono gli oggetti. Per ovviare a ciò, è necessario ridefinire (Override) il metodo equals()
     * per implementarne uno adatto alla situazione
     */
    @Override
    public boolean equals(Object obj) {
        //Controllo se gli oggetti da confrontare appartengono alla stessa classe (getClass())
        if (getClass() != obj.getClass())
            return false;
        else {
            /* Effettuo un cast esplicito dell'oggetto obj nel tipo Nodo, per poter
             * confrontare oggetti dello stesso tipo, con stessi campi e stessi metodi
             */
            Nodo newNodo = (Nodo)obj;

            //A questo punto confronto i singoli campi dei due nodi
            return (elemento == newNodo.elemento && successivo == newNodo.successivo);
        }
    }

    //Effettuo anche una riscrittura del metodo toString per stampare un Nodo in maniera ottimale
    @Override
    public String toString() {
        String elemento = "Elemento: " +getElemento();
        String successivo = "Successivo: ";

        /* Effettuo un primo controllo nel caso in cui il nodo successivo non esista (oltre la coda REALE)
         * Successivamente controllo il caso in cui il nodo successivo sia la testa REALE (dovrà restituire null)
         */
        if (getNodoSuccessivo()!=null && getNodoSuccessivo().getNodoSuccessivo()!=null)
            successivo += getNodoSuccessivo().getElemento();
        else
            successivo += null;

        return elemento+ "\n" +successivo;
    }
}