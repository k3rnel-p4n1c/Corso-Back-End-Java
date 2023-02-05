package modulo1;

import java.util.Scanner;

public class RimpiazzaIntrusi {
    public static void main(String[] args) {

        String a, b,c ;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string a: ");
        a = scanner.nextLine();
        System.out.print("Enter string b: ");
        b = scanner.nextLine();
        System.out.print("Enter string c: ");
        c = scanner.nextLine();

        replaceIntruder(a, b, c);

    }

    private static void replaceIntruder(String a, String b , String c) {
        String[] x = c.split(" ");
        x[1] = x[1].replace(a, b);

        System.out.println(x[1]);
    }
}