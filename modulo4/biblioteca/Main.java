/* Scrivere un programma che permetta di gestire una Biblioteca semplificata, in grado di gestire un array di indici (interi) dei libri
 * che contiene. La Biblioteca viene costruita a partire da un array di indici di libri. In particolare, implementare i seguenti metodi:
 * esisteLibro: prende un indice e restituisce true se esiste il libro con questo indice, false altrimenti
 * getIndiciLibriOrdinati: ritorna la lista degli indici di libri presenti nella biblioteca, in ordine ascendente
 * Il codice del main() viene fornito dalla traccia
 *
 * Rendere la biblioteca funzionante con dei libri veri e propri invece che con solo i loro indici. Creare quindi una classe Libro con
 * delle proprie caratteristiche, tra cui l'indice che usavamo prima, nome, autore, categoria, ecc, e modificare di conseguenza la
 * classe Biblioteca ed il main di test.
 */
package modulo4.biblioteca;

public class Main {
    public static void main(String[] args) {

        Libro libro1 = new Libro("Titolo1", "Autore1", "Categoria1", 1);
        Libro libro2 = new Libro("Titolo2", "Autore2", "Categoria2", 2);
        Libro libro3 = new Libro("Titolo3", "Autore3", "Categoria3", 3);
        Libro libro4 = new Libro("Titolo4", "Autore4", "Categoria4", 4);
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.aggiungiLibro(libro4);
        biblioteca.aggiungiLibro(libro2);
        biblioteca.aggiungiLibro(libro3);
        biblioteca.aggiungiLibro(libro1);

        System.out.println("Biblioteca non ordinata:");
        biblioteca.stampaBiblioteca();

        System.out.println("\nBiblioteca ordinata:");
        biblioteca.ordinaIndiciLibri();
        biblioteca.stampaBiblioteca();

        System.out.println("\nEsiste il libro di indice 4? " +biblioteca.esisteLibro(4));
    }
}