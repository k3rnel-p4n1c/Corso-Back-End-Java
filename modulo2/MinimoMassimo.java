package modulo2;

import java.util.Arrays;
import java.util.Scanner;

public class MinimoMassimo {
    public static void main(String[] args) {

        String a;
        int[] values;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers (comma-separated): ");
        a = scanner.nextLine();

        values = parseNumbers(a);
        computeMinAndMax(values);
    }

    private static int[] parseNumbers(String s) {
        String[] caratteri = s.split(",");
        int[] vettore = new int[caratteri.length];

        //Converte i caratteri in valori interi
        for (int i=0; i<caratteri.length; i++)
            vettore[i] = Integer.parseInt(caratteri[i]);

        return vettore;
    }

    private static void computeMinAndMax(int[] values) {
        //Ordina in modo crescente
        Arrays.sort(values);
        System.out.println(Arrays.toString(values));

        //Stampa in ordine decrescente
        System.out.print("[");
        for (int i=values.length-1; i>=0; i--) {
            System.out.print(values[i]);
            if (i != 0)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}