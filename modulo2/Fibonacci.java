package modulo2;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {

        int n;
        long[] memo;                                     /* Vettore all'interno del quale si andranno a memorizzare i calcoli
                                                         * dell'n-esima posizione della sequenza. L'indice n corrisponde a fibonacci(n)
                                                         */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci numero: ");
        n = scanner.nextInt();
        memo = new long[n+1];        //n+1 poichè altrimenti memo[n] sforerebbe l'indice massimo ammissibile (che è n-1)

        System.out.println("La sequenza di Fibonacci al numero " +n+ " è: " +fibonacci(n, memo));
    }

    private static long fibonacci(int n, long[] memo) {
        if (n < 0)         //Numero non valido
            return -1;
        else if (n == 0)   //Passo base 1
            return 0;
        else if (n == 1)   //Passo base 2
            return 1;
        else if (memo[n] != 0)  //Se fibonacci(n) è stato già calcolato, non ripete i calcoli e restituisce memo[n]
            return memo[n];
        else                    //Passo ricorsivo, effettua un calcolo che non ha mai fatto prima e lo memorizza
            memo[n] = fibonacci(n-1, memo) + fibonacci(n-2, memo);

        return memo[n];
    }
}