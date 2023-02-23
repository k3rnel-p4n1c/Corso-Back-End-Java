package modulo9.file_parole;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestoreParole {

    /**
     * Questo metodo stampa il contenuto di un file, ovvero il testo così com'è scritto sul file
     * @param path percorso relativo o assoluto del file
     */
    public static void stampaContenutoFile(Path path) {
        accediAlFileInLettura(path, false);
    }

    /**
     * Questo metodo stampa il contenuto di ogni riga in base ad una separazione delle parole mediante gli spazi
     * @param path percorso relativo o assoluto del file
     */
    public static void stampaParoleSeparateDaSpazi(Path path) {
        accediAlFileInLettura(path, true);
    }

    /**
     * Questo metodo si occupa di memorizzare in una HashMap tutte le parole presenti nel testo e di memorizzarle attraverso una
     * coppia chiave-valore, dove la chiave è la parola è il valore è il numero di volte che tale parola è stata scritta nel testo
     * @param path percorso relativo o assoluto del file
     * @return HashMap<String, Integer>
     */
    public static HashMap<String, Integer> contaOccorrenzeParole(Path path) {
        HashMap<String, Integer> occorrenze = new HashMap<>(0);
        String riga;    //Variabile per memorizzare il contenuto di una riga
        String[] temp;  //Variabile di appoggio per poter ripulire la riga da tutti i segni di punteggiatura

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            while((riga = reader.readLine()) != null) {
                temp = riga.split("\\W+");          //Pulisco la riga dalla punteggiatura attraverso la regex "\W+"

                //Per ogni parola presente nell'array di parole ripulite, la aggiunge nell'HashMap o aggiorna il contatore di occorrenze
                for (String parola : temp)
                    if (occorrenze.containsKey(parola))
                        occorrenze.put(parola, occorrenze.get(parola)+1);
                    else
                        occorrenze.put(parola, 1);      //Caso in cui trova la parola pr la prima volta
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }

        return occorrenze;
    }

    /**
     * Questo metodo si occupa di trovare le rime, in particolare cerca le parole che terminano con una delle seguenti configurazioni:
     * vocale - consonante - vocale
     * vocale - consonante - consonante - vocale
     * @param path percorso del file in cui ricercare le rime
     * @return HashMap<String, ArrayList<String>>, in cui la chiave è uno dei dittonghi sopra descritti, mentre l'arraylist
     * memorizza le parole che finiscono con il dittongo in questione
     */
    public static HashMap<String, ArrayList<String>> paroleInRima(Path path) {
        /* Le classi Pattern e Matcher sono utilizzate per la gestione delle espressioni regolari. La classe Pattern rappresenta
         * l'espressione regolare compilata e può essere utilizzata per creare oggetti Matcher, che a loro volta possono essere
         * utilizzati per cercare corrispondenze dell'espressione regolare in una stringa.
         *
         * La classe Pattern è utilizzata per compilare un'espressione regolare in un oggetto Pattern. La compilazione è un'operazione
         * costosa e, pertanto, è consigliabile eseguirla una sola volta per l'espressione regolare da utilizzare. Una volta che
         * l'espressione regolare è stata compilata, è possibile utilizzare l'oggetto Pattern per creare oggetti Matcher che possono
         * essere utilizzati per cercare corrispondenze dell'espressione regolare in una stringa. Per creare un oggetto Pattern,
         * è possibile utilizzare il metodo compile() della classe Pattern, passando l'espressione regolare come argomento.
         *
         * La classe Matcher è utilizzata per cercare corrispondenze dell'espressione regolare in una stringa. Dopo aver creato un
         * oggetto Pattern, è possibile utilizzarlo per creare un oggetto Matcher, che viene utilizzato per cercare corrispondenze
         * dell'espressione regolare in una stringa. Per creare un oggetto Matcher, è possibile utilizzare il metodo matcher()
         * dell'oggetto Pattern, passando la stringa in cui cercare le corrispondenze come argomento (pattern.matcher(stringa)).
         *
         * Dopo aver creato un oggetto Matcher, è possibile utilizzare il metodo find() per cercare la prima corrispondenza
         * dell'espressione regolare nella stringa. È anche possibile utilizzare il metodo group() per ottenere la sottostringa
         * corrispondente alla corrispondenza trovata.
         */
        HashMap<String, ArrayList<String>> rime = new HashMap<>(0);
        ArrayList<String> arraylist = new ArrayList<>(0);
        Pattern vo_con_vo = Pattern.compile("\\w*[aeiou][^aeiou\\W][aeiou]\\b");  /* Questa espressione regolare cerca qualsiasi
                                                                                        * carattere di parole \w* seguito da una vocale
                                                                                        * [aeiou], una consonante che non sia una vocale
                                                                                        * o un carattere non alfanumerico [^aeiou\W] e
                                                                                        * infine una vocale [aeiou]. Il carattere \b
                                                                                        * indica il limite di una parola.
                                                                                        */
        Pattern vo_con_con_vo = Pattern.compile("\\w*[aeiou][^aeiou\\W][^aeiou\\W][aeiou]\\b");
        Matcher matcher1, matcher2;
        String riga, temp, substring;

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            while((riga = reader.readLine()) != null) {
                matcher1 = vo_con_vo.matcher(riga);         //Cerco parole che soddisfano la prima regex
                matcher2 = vo_con_con_vo.matcher(riga);     //Cerco parole che soddisfano la seconda regex

                //In questo ciclo, matcher1 cercherà una corrispondenza in tutte le parole memorizzate in "riga"
                while (matcher1.find()) {
                    temp = matcher1.group();    //Assegno la corrispondenza (se esiste) alla variabile temp

                    //Controllo che la parola abbia una lunghezza superiore a 3 (perché il matcher1 controlla vo-con-vo)
                    if (temp.length() > 3) {
                        substring = temp.substring(temp.length()-3);    //Mi prendo il dittongo finale (chiave della HashMap)

                        //Se la chiave già esiste, accedo all'arraylist per aggiungere un nuovo valore (parole) che contiene il dittongo
                        if (rime.containsKey(substring))
                            rime.get(substring).add(temp);
                        else {                                               //Altrimenti aggiungo direttamente la coppia chiave-valore
                            arraylist.add(temp);
                            rime.put(substring, arraylist);
                            arraylist = new ArrayList<>(0);     //Pulisco l'arraylist
                        }
                    }
                }

                while (matcher2.find()) {
                    temp = matcher2.group();

                    if (temp.length() > 4) {
                        substring = temp.substring(temp.length()-4);

                        if (rime.containsKey(substring))
                            rime.get(substring).add(temp);
                        else {
                            arraylist.add(temp);
                            rime.put(substring, arraylist);
                            arraylist = new ArrayList<>(0);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return rime;
    }

    /**
     * Questo metodo permette di accedere al file in lettura e gestisce il caso in cui si voglia accedere per stampare il suo contenuto
     * così com'è oppure si vuole spezzettare ogni riga in base agli spazi tra le parole e stampare il file in questa maniera. Questo
     * metodo è richiamato dai metodi publici "stampaContenutoFile" e "stampaParoleSeparateDaSpazi", che fungono da interfaccia
     * all'utente per poter accedere a questo, privato, che farà una o l'altra cosa in base al parametro booleano
     * @param path percorso relativo o assoluto del file
     * @param stampa_parole parametro booleano che sta ad indicare se si vuole effettuare uno split (true) in base agli spazi oppure
     *                      stampare il contenuto del file così com'è (false)
     */
    private static void accediAlFileInLettura(Path path, boolean stampa_parole) {
        String riga;

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            while((riga = reader.readLine()) != null)
                if (stampa_parole)
                    System.out.println(Arrays.toString(riga.split(" ")));   //Divide e stampa la riga in funzione degli spazi
                else
                    System.out.println(riga);                                      //Stampa la riga così com'è

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}