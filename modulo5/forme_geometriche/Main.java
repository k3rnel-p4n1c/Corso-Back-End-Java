/* Esercizio Forme Geometriche
 * Scrivere un programma in grado di modellare il concetto di forma geometrica associato a quadrati e rettangoli. In particolare,
 * create le classi Quadrato e Rettangolo entrambe con le seguenti caratteristiche: Ogni Quadrato deve esporre 3 metodi:
 * getArea: ritorna un intero
 * getPerimeter: ritorna il perimetro dell’oggetto
 * toString: ritorna «quadrato» o «rettangolo» a seconda del tipo di oggetto
 *
 * Il quadrato è un caso particolare di rettangolo
 */
package modulo5.forme_geometriche;

import modulo5.forme_geometriche.figure.Quadrato;
import modulo5.forme_geometriche.figure.Rettangolo;

public class Main {
    public static void main(String[] args) {

        Quadrato quadrato = new Quadrato(5);
        Rettangolo rettangolo = new Rettangolo(5, 6);

        System.out.println("Perimetro rettangolo: " +rettangolo.getPerimetro());
        System.out.println("Area rettangolo: " +rettangolo.getArea());
        System.out.println(rettangolo.toString());

        System.out.println("\nPerimetro quadrato: " +quadrato.getPerimetro());
        System.out.println("Area quadrato: " +quadrato.getArea());
        System.out.println(quadrato.toString());
    }
}