package modulo4.riparazioni;

import java.util.Arrays;

public class DittaRiparazioni {
    private Tecnico[] tecnici = new Tecnico[1];                 //Lista di tecnici che lavorano per la ditta
    private Riparazione[] riparazioni = new Riparazione[1];     //Lista di riparazioni da fare


    /**
     * Questo metodo si occupa di creare una nuova riparazione. Nel caso in cui il vettore che le contiene sia pieno, ne viene creato uno
     * nuovo di dimensione +1. Tutti gli oggetti al suo interno vengono copiati in quello nuovo.
     * @param indirizzo passato dall'utente, l'indirizzo della riparazione
     * @param priorita passata dall'utente, la priorità della riparazione
     */
    public void aggiungiRiparazione(String indirizzo, Priorita priorita) {
        Riparazione riparazione = new Riparazione(indirizzo, priorita);

        if (riparazioni[riparazioni.length-1] == null) {
            riparazione.setID(0);                               //Nel caso sia il primo elemento, avrà ID = 0
            riparazioni[riparazioni.length-1] = riparazione;
        }
        else {
            //Nel caso non sia il primo elemento, avrà ID = ID del valore precedente+1
            riparazione.setID(riparazioni[riparazioni.length-1].getID()+1);
            Riparazione[] nuova_lista_riparazioni = Arrays.copyOf(riparazioni, riparazioni.length+1);
            nuova_lista_riparazioni[nuova_lista_riparazioni.length-1] = riparazione;
            riparazioni = nuova_lista_riparazioni;
        }
    }

    /**
     * Questo metodo si occupa di aggiungere un nuovo tecnico alla lista dei dipendenti della ditta
     * @param tecnico questo è il parametro che verrà aggiunto alla lista
     */
    public void aggiungiTecnico(Tecnico tecnico) {

        //Controllo che il tecnico passato come parametro esista già nella lista di tecnici della ditta
        if (tecnicoEsistente(tecnico))
            System.err.println("Il tecnico che si sta tentando di aggiungere esiste già!");
        else {
            if (tecnici[tecnici.length-1] == null)
                tecnici[tecnici.length-1] = tecnico;
            else {
                Tecnico[] nuova_lista_tecnici = Arrays.copyOf(tecnici, tecnici.length+1);
                nuova_lista_tecnici[nuova_lista_tecnici.length-1] = tecnico;
                tecnici = nuova_lista_tecnici;
            }
        }
    }

    /**
     * Questo metodo si occupa di assegnare una riparazione al tecnico. Lo stato della riparazione passa a "IN_ATTESA". Per poter usare
     * questo metodo bisogna prima stampare una lista di tutte le riparazioni da fare, in modo che l'utente possa scegliere il numero cardinale
     * che identifica la riparazione. Tale numero verrà passato come parametro.
     * @param tecnico il tecnico (che deve far parte della dita) passato come parametro verrà assegnato alla riparazione
     * @param ID è il numero cardinale che, durante la stampa delle riparazioni, identifica la riparazione. Il valore utile di questo
     *               parametro è in realtà "indice-1", che corrisponde al valore della cella del vettore delle riparazioni
     */
    public void assegnaRiparazioneAlTecnico(Tecnico tecnico, int ID) {
        if (tecnicoEsistente(tecnico)) {

            if (tecnico.isImpegnato())
                System.err.println("Il tecnico è già impegnato in un altro lavoro!");
            else if (tecnico.isInFerie())
                System.err.println("Il tecnico è in ferie!");
            else {
                int indice = riparazioneEsistente(ID);

                if (indice != -1)                                                 //Controllo che il vettore delle riparazioni abbia la cella passata come parametro
                    if (riparazioni[indice].getTecnico() == null)                 //Controllo che la riparazione non sia già stata assegnata
                        if (riparazioni[indice].getStato() != Stato.CONCLUSO) {   //Controllo che la riparazione non sia già conclusa

                            //A questo punto posso assegnare la riparazione al tecnico passato come parametro
                            riparazioni[indice].setTecnico(tecnico);
                            riparazioni[indice].setStato(Stato.IN_ATTESA);    //Appena assegnato un tecnico, lo stato non può essere CONCLUSO
                            tecnico.setImpegnato(true);
                        }
            }
        }
        else
            System.err.println("Il tecnico non è un dipendente della ditta!");
    }

    /**
     * Questo metodo si occupa di marcare una riparazione come conclusa, ovvero di togliere il tecnico assegnato e cambiarne lo stato
     * @param tecnico questo è il tecnico che verrà tolto dalla riparazione e verrà impostato come "disponibile" per lavorare
     */
    public void marcaRiparazioneConclusa(Tecnico tecnico) {
        if (tecnicoEsistente(tecnico)) {                            //Controllo che il tecnico appartenga alla ditta
            for (Riparazione rip : riparazioni)                     //Scorro il vettore delle riparazioni

                if (rip.getTecnico() != null)                                     //Controllo se c'è un tecnico nella riparazione i-esima
                    if (rip.getTecnico().getNome().equals(tecnico.getNome())) {   //Trovo la riparazione con il tecnico passato come parametro assegnato
                        rip.setStato(Stato.CONCLUSO);                             //Marco come "concluso" lo stato della riparazione
                        rip.setTecnico(null);                                     //Tolgo il tecnico passato come parametro dalla riparazione
                        tecnico.setImpegnato(false);                              //Il tecnico non è più impegnato
                    }
        }
        else
            System.err.println("Il tecnico non appartiene alla ditta!");
    }

    /**
     * Questo metodo manda in ferie il tecnico passato come parametro, ovvero lo rende indisponibile per poter essere assegnato ad
     * un'altra riparazione
     * @param tecnico tecnico da mandare in ferie
     */
    public void mandaInFerie(Tecnico tecnico) {
        if (tecnico.isImpegnato())
            System.err.println("Non è possibile mandare il tecnico in ferie in quanto è impegnato!\n");
        else if (tecnico.isInFerie())
            System.err.println("Il tecnico è già in ferie!\n");
        else {
            tecnico.setInFerie(true);
            System.out.println("Il seguente tecnico è stato mandato in ferie:\n" +tecnico.toString()+ "\n");
        }
    }

    /**
     * Stampa la lista di riparazioni nello stato "in attesa"
     */
    public void listaRiparazioniInAttesa() {
        for (Riparazione rip : riparazioni)
            if (rip.getStato() == Stato.IN_ATTESA)
                System.out.println(rip.toString());
    }

    /**
     * Questo metodo stampa l'intera rista di riparazioni da effettuare
     */
    public void stampaListaRiparazioni() {
        for (Riparazione rip : riparazioni)
            System.out.println(rip.toString()+ "\n");
    }

    /**
     * Questo metodo restituisce la prossima riparazione con maggior priorità
     */
    public String prossimaRiparazioneMaxPriorita() {
        int priorita = -1;
        int posizione = -1;

        for (int i=0; i<riparazioni.length; i++) {
            if (riparazioni[i].getPriorita().ordinal() > priorita) {    //Con il metodo ordinal() si ottiene il valore interno dell'enum
                posizione = i;
                priorita = riparazioni[i].getPriorita().ordinal();
            }
        }

        if (posizione != -1)
            return riparazioni[posizione].toString();
        else
            return "Non ci sono riparazioni da fare";
    }

    /**
     * Questo metodo controlla che non ci siano tecnici con lo stesso nome all'interno dei dipendenti della ditta
     * @param tecnico questo è il tecnico da controllare (se è già presente)
     * @return restituisce vero o falso, rispettivamente, se il tecnico esiste già o meno
     */
    private boolean tecnicoEsistente(Tecnico tecnico) {
        if (tecnici[0] == null)     //Controllo se il vettore è vuoto
            return false;
        else
            for (Tecnico tec : tecnici)
                if (tec.getNome().equals(tecnico.getNome()))
                    return true;

        return false;
    }

    /**
     * Questo metodo serve a controllare che una riparazione con l'ID passato come parametro esista
     * @param ID identificativo univoco da controllare
     * @return restituisce l'indice del vettore se lo trova, -1 altrimenti
     */
    private int riparazioneEsistente(int ID) {
        for (int i=0; i<riparazioni.length; i++)
            if (riparazioni[i].getID() == ID)
                return i;

        return -1;
    }
}