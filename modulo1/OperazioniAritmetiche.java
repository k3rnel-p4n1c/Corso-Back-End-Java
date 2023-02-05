package modulo1;

import java.util.Scanner;

public class OperazioniAritmetiche {
    public static void main(String[] args) {

        int a, b;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a: ");
        a = scanner.nextInt();
        System.out.print("Enter b: ");
        b = scanner.nextInt();
        computeValues(a, b);

    }

    private static void computeValues(int a, int b) {
        System.out.println("\nSomma: " +(a+b));
        System.out.println("Differenza: " +(a-b));
        System.out.println("Moltiplicazione: " +(a*b));
        System.out.println("Divisione: " +((float)a/(float)b));
    }
}