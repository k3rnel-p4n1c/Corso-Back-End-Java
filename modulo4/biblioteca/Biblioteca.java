package modulo4.biblioteca;

import java.util.Arrays;

public class Biblioteca {
    private static Libro[] libri = new Libro[1];    //Di default contiene una cella

    //Aggiunge un nuovo libro all'array di libri, ampliando di 1 l'array alla fine in modo da far rientrare il libro
    public void aggiungiLibro(Libro libro) {

        //Controllo se l'ultima cella del vettore è libera, altrimenti procedo con l'ampliamento del vettore (+1 cella)
        if (libri[libri.length-1] == null)
            libri[libri.length-1] = libro;
        else {
            Libro[] nuova_lista_libri = Arrays.copyOf(libri, libri.length+1);
            nuova_lista_libri[nuova_lista_libri.length-1] = libro;
            libri = nuova_lista_libri;
        }
    }

    //Prende un indice e restituisce true se esiste il libro con questo indice, false altrimenti
    public boolean esisteLibro(int indice) {
        for (Libro libro : libri)
            if (libro.getIndice() == indice)
                return true;

        return false;
    }

    //Ordina la lista degli indici di libri presenti nella biblioteca, in ordine ascendente (bubble sort)
    public void ordinaIndiciLibri() {
        Libro temp;

        for (int i=0; i<libri.length-1; i++) {
            for (int j=i+1; j<libri.length; j++) {
                if (libri[i].getIndice() > libri[j].getIndice()) {

                    temp = libri[i];
                    libri[i] = libri[j];
                    libri[j] = temp;
                }
            }
        }
    }

    public void stampaBiblioteca() {
        for (Libro libro : libri)
            System.out.println("\n" +libro.toString());
    }
}