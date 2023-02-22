/* Leggere il file righe.txt usando le classi del package java.nio, ogni riga segue la formattazione k:v,v,v,v,v
 * Creare una Map<String, List> in cui, per ogni riga del file, aggiungiamo la chiave col valore della stringa "k" associata ai
 * valori "v,v,v,v,v" della riga
 * Es. ciao:come,va,come,stai -> map.put("ciao", ["come", "va", "come", "stai"])
 */
package modulo9.mappadirighe;

import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> righe = new HashMap<>(0);            //Tutte le righe del file
        ArrayList<String> valori = new ArrayList<>(0);                          //Parte del file dopo i :
        Path path = Paths.get("src", "modulo9", "mappadirighe", "file.txt");    //Percorso relativo del file
        String linea, linea_temp[];

        //try-with-resources -> chiude automaticamente lo stream alla fine di tutto (o nel caso di eccezioni)
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            while ((linea = reader.readLine()) != null) {                   //Controllo che linea != null (EOF)

                linea_temp = linea.split(":");                          //Separo in base ai :
                valori.addAll(Arrays.asList(linea_temp[1].split(","))); //Metto i valori nell'arraylist (già separati)
                righe.put(linea_temp[0], valori);                             //Mette nella mappa la coppia chiave-valore
                valori = new ArrayList<>(0);                     //Re-inizializzo l'arraylist
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        //finally non necessario poiché il try-with-resources chiude automaticamente le risorse

        //Stampo i risultati
        for (String chiave : righe.keySet()) {
            System.out.println("Chiave: " +chiave+ "\nValori: " + righe.get(chiave)+ "\n");
        }
    }
}