package modulo9.righeinverse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> righe_inverse = new ArrayList<>(0);
        String linea;
        Path path_righe = Paths.get("src", "modulo9", "righeinverse", "righe.txt");
        Path path_righeinverse = Paths.get("src", "modulo9", "righeinverse", "righe_inverse.txt");

        //Apro il file per leggerlo e memorizzare il contenuto nell'arraylist
        try (BufferedReader reader = Files.newBufferedReader(path_righe)) {
            while ((linea = reader.readLine()) != null)
                righe_inverse.add(linea);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        //Ordino in ordine inverso le righe del file (la prima con l'ultima e viceversa)
        Collections.reverse(righe_inverse);

        //Apro (o creo) il file per scrivere il contenuto dell'arraylist in modo inverso
        try (BufferedWriter writer = Files.newBufferedWriter(path_righeinverse)) {
            for (String linea_da_scrivere : righe_inverse)
                writer.write(linea_da_scrivere+ "\n");      //Scrittura distruttiva

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}