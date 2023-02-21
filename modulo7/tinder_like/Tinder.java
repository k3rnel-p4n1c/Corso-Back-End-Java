package modulo7.tinder_like;

import java.util.HashSet;

public class Tinder {
    private HashSet<Utente> utenti = new HashSet<>(0);


    /**
     * Registra l'utente su Tinder
     * @param utente utente da registrare al sito
     */
    public void inserisciUtente(Utente utente) {
        utenti.add(utente);
    }

    /**
     * Rimuove l'utente selezionato da Tinder
     * @param utente utente da rimuovere
     */
    public void rimuoviUtente(Utente utente) {
        if (utenti.isEmpty() || !utenti.contains(utente))
            System.out.println("L'utente selezionato non è presente su Tinder.");
        else {
            utenti.remove(utente);
            System.out.println("Utente rimosso con successo!");
        }
    }

    /**
     * Restituisce l'utente con più interessi in comune rispetto a quello passato come parametro
     * @param utente utente di partenza, ovvero quello utilizzato come criterio di ricerca per le cose in comune
     */
    public void utenteConPiuInteressiInComune(Utente utente) {
        //Contatori e variabili temporanee per il confronto
        int contatore1=0, contatore2=0;
        Utente utente_temp = null;

        for (Interesse interesse : utente.getInteressi()) {             //Scorro gli interessi dell'utente passato come parametro
            for (Utente utente1 : utenti) {                             //Scorro l'Hashset degli utenti, in modo da accedere agli interessi
                for (Interesse interesse1 : utente1.getInteressi()) {   //Scorro gli interessi di ciascun utente dell'Hashset
                    if (!utente.equals(utente1))                        //Non devo confrontare l'utente passato come parametro con sé stesso
                        if (interesse1 == interesse)                    //Controllo se gli interessi corrispondono
                            contatore1++;                               //Incremento il primo contatore
                }

                //Se il primo contatore è maggiore del secondo, allora memorizzo l'utente in questione
                if (contatore1 > contatore2)
                    utente_temp = utente1;

                //Imposto il contatore 2 al valore del primo, in modo che questo sia il nuovo valore da superare
                contatore2 = contatore1;
            }
        }

        if (utente_temp == null)
            System.out.println("Non sono presenti utenti con gli stessi interessi dell'utente selezionato.");
        else
            System.out.println(utente_temp);
    }

    /**
     * Stampa, se presenti, tutti gli utenti registrati a Tinder
     */
    public void mostraUtenti() {
        if (utenti.isEmpty())
            System.out.println("Non sono presenti utenti su Tinder.");
        else {
            for (Utente utente : utenti)
                System.out.println(utente+ "\n");
        }
    }
}