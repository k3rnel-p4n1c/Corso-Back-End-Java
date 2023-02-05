package modulo1;

import java.util.Scanner;

public class ContaOccorrenze {
    public static void main(String[] args) {

        String a, b;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter character a: ");
        a = scanner.nextLine();
        System.out.print("Enter string b: ");
        b = scanner.nextLine();
        countOccurrences(a.charAt(0), b);
    }

    static void countOccurrences(char a, String b) {
        int contatore=0;

        for (byte i=0; i<b.length(); i++)
            if (b.charAt(i) == a)
                contatore++;

        System.out.println("Il numero di occorrenze di \"a\" in \"b\" è: " +contatore);
    }
}