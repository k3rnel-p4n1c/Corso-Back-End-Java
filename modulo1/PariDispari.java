package modulo1;

import java.util.Scanner;

public class PariDispari {
    public static void main(String[] args) {

        int number;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        number = scanner.nextInt();

        checkEvenOdd(number);
    }

    private static void checkEvenOdd(int number) {
        if (number%2 == 0)
            System.out.print("Il numero è pari");
        else
            System.out.print("Il numero è dispari");
    }
}