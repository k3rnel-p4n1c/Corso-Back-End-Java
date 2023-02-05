package modulo1;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {

        String a;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        a = scanner.nextLine();
        stringReverse(a);
    }

    static void stringReverse(String s) {

        for (int i=s.length()-1; i>=0; i--)
            System.out.print(s.charAt(i));
    }
}