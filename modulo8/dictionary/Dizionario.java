package modulo8.dictionary;

import modulo8.dictionary.eccezioni.LetteraNonPresenteException;
import modulo8.dictionary.eccezioni.ParolaNonPresenteException;
import java.util.HashSet;
import java.util.TreeMap;

public class Dizionario {
    /* Viene usata la TreeMap in quanto mantiene un ordine ascendente in base al valore della chiave. Questa struttura contiene,
     * partendo da quella più interna:
     * HashSet<String>                                      --> Definizione della parola all'interno del dizionario
     * TreeMap<String, HashSet<String>>                     --> Parola cercata insieme alla sua definizione
     * TreeMap<Character, TreeMap<String, HashSet<String>>> --> Carattere cercato insieme alla parola e alla sua definizione
     */
    private TreeMap<Character, TreeMap<String, HashSet<String>>> dizionario = new TreeMap<>();

    /**
     * Questo metodo permette di aggiungere una parola al dizionario, con relativa definizione. È possibile utilizzare questo metodo
     * anche per aggiungere ulteriori definizioni ad una parola già presente
     * @param parola parola da inserire
     * @param definizione definizione della parola (frase)
     */
    public void aggiungiParola(String parola, String definizione) {
        //Setto la parola in minuscolo
        parola = parola.toLowerCase();

        HashSet<String> hashset_definizione = new HashSet<>(1); //Inizializzo una strutture d'appoggio per memorizzare la definizione
        hashset_definizione.add(definizione);                               //Aggiungo la definizione alla struttura temporanea

        if (dizionario.containsKey(parola.charAt(0))) {                             //Controllo se il dizionario contiene già la prima lettera della parola
            if (dizionario.get(parola.charAt(0)).containsKey(parola))               //Controllo se la parola è già contenuta
                dizionario.get(parola.charAt(0)).get(parola).add(definizione);      //Se si, aggiungo un nuovo significato
            else
                dizionario.get(parola.charAt(0)).put(parola, hashset_definizione);  //Altrimenti aggiunge la nuova parola con la definizione
        }
        else {  //Caso in cui non è presente neanche la prima lettera
            TreeMap<String, HashSet<String>> parola_con_definizione = new TreeMap<>();  //Inizializzo una struttura per memorizzare la parola
            parola_con_definizione.put(parola, hashset_definizione);
            dizionario.put(parola.charAt(0), parola_con_definizione);
        }
    }

    /**
     * Questo metodo permette di aggiungere una definizione ad una parola già presente all'interno del dizionario. All'atto
     * pratico, questo metodo va a richiamare il metodo "aggiungiParola" con gli stessi parametri
     * @param parola parola di cui si vuole aggiungere un'ulteriore definizione
     * @param definizione definizione da aggiungere
     */
    public void aggiungiDefinizione(String parola, String definizione) {
        aggiungiParola(parola, definizione);
    }

    /**
     * Questo metodo stampa tutte le parole, con relative definizioni, a partire da una lettera fornita in input
     * @param lettera_iniziale lettera iniziale delle parole da stampare
     * @throws LetteraNonPresenteException lancia un'eccezione nel caso in cui la lettera inserita non sia presente all'interno del dizionario
     */
    public void cercaLetteraIniziale(char lettera_iniziale) throws LetteraNonPresenteException {
        lettera_iniziale = Character.toLowerCase(lettera_iniziale);

        //Controllo che la lettera sia presente all'interno del dizionario
        if (dizionario.containsKey(lettera_iniziale)) {
            System.out.println(lettera_iniziale);
            int i=1;

            for (String parola : dizionario.get(lettera_iniziale).keySet()) {
                System.out.println(parola);

                for (String definizione : dizionario.get(lettera_iniziale).get(parola))
                    System.out.println("[" +(i++)+ "] " +definizione);

                System.out.println();
            }
        }
        else
            throw new LetteraNonPresenteException(lettera_iniziale);
    }

    /**
     * Questo metodo si occupa di stampare la/e definizione/i della parola cercata
     * @param parola parola da cercare
     * @throws ParolaNonPresenteException lancia un'eccezione nel caso in cui la parola cercata non sia presente nel dizionario
     */
    public void cercaParola(String parola) throws ParolaNonPresenteException {
        parola = parola.toLowerCase();
        char lettera_iniziale = parola.charAt(0);

        //Controllo che sia presente il carattere iniziale e la parola da cercare
        if (dizionario.containsKey(lettera_iniziale) && dizionario.get(lettera_iniziale).containsKey(parola)) {
            System.out.println(parola.toLowerCase());
            int i=1;

            for (String definizione : dizionario.get(lettera_iniziale).get(parola))
                System.out.println("[" +(i++)+ "] " +definizione);
        }
        else
            throw new ParolaNonPresenteException(parola);
    }

    /**
     * Questo metodo si occupa di rimuovere una parola dal dizionario
     * @param parola parola da rimuovere
     * @throws ParolaNonPresenteException lancia un'eccezione nel caso in cui la parola da rimuovere non sia presente nel dizionario
     */
    public void rimuoviParola(String parola) throws ParolaNonPresenteException {
        parola = parola.toLowerCase();
        char lettera_iniziale = parola.charAt(0);

        //Controllo che sia presente il carattere iniziale e la parola da cercare
        if (dizionario.containsKey(lettera_iniziale) && dizionario.get(lettera_iniziale).containsKey(parola))
            dizionario.get(lettera_iniziale).remove(parola);
        else
            throw new ParolaNonPresenteException(parola);
    }


    @Override
    public String toString() {
        StringBuilder stringa = new StringBuilder();
        int i=1;

        for (Character character : dizionario.keySet()) {
            stringa.append(character);

            for (String parola : dizionario.get(character).keySet()) {
                stringa.append("\n" + parola);

                for (String definizione : dizionario.get(character).get(parola))
                    stringa.append("\n[" +(i++)+ "] " +definizione);

                stringa.append("\n");
                i=1;
            }
            stringa.append("\n");
        }

        return stringa.toString();
    }
}