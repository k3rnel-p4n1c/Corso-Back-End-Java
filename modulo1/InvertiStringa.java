package modulo1;

import java.util.Scanner;

public class InvertiStringa {
    public static void main(String[] args) {

        String a;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        a = scanner.nextLine();
        reverseString(a);
    }

    private static void reverseString(String s) {
        String[] split = s.split(" ");
        System.out.println(split[1]+ " " +split[0]);
    }
}