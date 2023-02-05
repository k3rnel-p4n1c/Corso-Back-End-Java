package modulo2;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrammi {
    public static void main(String[] args) {

        String a, b;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string a: ");
        a = scanner.nextLine();
        System.out.print("Enter string b: ");
        b = scanner.nextLine();
        anagrams(a, b);
    }

    static void anagrams(String stringa1, String stringa2) {
        if (stringa1.length() != stringa2.length())
            System.out.println("Le stringhe non sono anagrammi");
        else {
            boolean flag = true;
            char[] charArray1 = stringa1.toLowerCase().toCharArray();
            char[] charArray2 = stringa2.toLowerCase().toCharArray();

            Arrays.sort(charArray1);
            Arrays.sort(charArray2);
            System.out.println("\n" +Arrays.toString(charArray1) +"\n"+ Arrays.toString(charArray2)+ "\n");

            for (int i=0; i<stringa1.length(); i++)
                if (charArray1[i] != charArray2[i])
                    flag = false;

            if (flag)
                System.out.println("Le stringhe sono anagrammi");
            else
                System.out.println("Le stringhe non sono anagrammi");
        }
    }
}