package modulo6.lista;

import modulo6.lista.classi.Nodo;
import modulo6.lista.classi.LinkedLista;

public class Main {

    public static void main(String[] args) {

        //Questi sono dei nodi che verranno utilizzati per testare tutti i vari metodi (puntano tutti a null)
        Nodo A = new Nodo("A");
        Nodo B = new Nodo("B");
        Nodo C = new Nodo("C");
        Nodo D = new Nodo("D");
        Nodo E = new Nodo("E");

        /* Questo è l'oggetto con cui poter eseguire tutti i metodi che gestiscono la lista. Riceve come
         * parametri la testa e la coda qui sopra, in modo da tener traccia sempre di inizio e fine della lista
         */
        LinkedLista lista = new LinkedLista();

        System.out.println("Stampo la lista:");
        lista.stampaLista();

        System.out.println("\nAggiungo un nodo in testa e stampo la lista:");
        lista.addHead(A);
        lista.stampaLista();

        System.out.println("\nStampo la testa:\n" +lista.getHead());
        System.out.println("\nStampo la coda:\n" +lista.getTail());

        System.out.println("\nAggiungo un nodo in coda e stampo la lista:");
        lista.addTail(B);
        lista.stampaLista();

        System.out.println("\nAggiungo un nodo DOPO la testa e stampo la lista:");
        lista.addAfter(C,A);
        lista.stampaLista();

        System.out.println("\nAggiungo un nodo PRIMA della coda e stampo la lista:");
        lista.addBefore(D, lista.getTail());
        lista.stampaLista();

        System.out.println("\nAggiungo il nodo alla posizione 10 della lista:");
        lista.add(E, 10);

        System.out.println("\nAggiungo il nodo alla posizione 4 della lista e stampo la lista:");
        lista.add(E,4);
        lista.stampaLista();

        System.out.println("\nVisualizzo la lunghezza della lista: " +lista.lenght());

        System.out.println("\nVisualizzo il nodo alla posizione 5 della lista:");
        if (lista.getNodo(5) != null)
            System.out.println(lista.getNodo(5));
        else
            System.out.println("Il nodo non esiste!");

        System.out.println("\nRimuovo il nodo numero 3 della lista e stampo la lista:");
        lista.remove(3);
        lista.stampaLista();

        System.out.println("\nElimino tutti i nodi dalla lista e stampo la lista:");
        lista.clear();
        lista.stampaLista();

        System.out.println("\nAggiungo i nodi in ordine alfabetico e stampo la lista:");
        lista.addTail(A);
        lista.addTail(B);
        lista.addTail(C);
        lista.addTail(D);
        lista.addTail(E);
        lista.stampaLista();

        System.out.println("\nProvo ad aggiungere il nodo già esistente D in testa e stampo la lista:");
        lista.addHead(D);
        lista.stampaLista();

        System.out.println("\nRi-aggiungo il nodo A in testa e stampo la lista:");
        lista.addHead(A);
        lista.stampaLista();
    }
}