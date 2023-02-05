package modulo1;

public class Factorial {
    public static void main(String[] args) {

        System.out.println(factorial(1) == (0));        //false, perché 1! = 1
        System.out.println(factorial(2) == (2));
        System.out.println(factorial(5) == (120));
        System.out.println(factorial(10) == (3628800));
        System.out.println(factorial(20) == 2432902008176640000L);
    }

    private static long factorial(int n) {
        if (n<0)
            return -1;          //Il fattoriale di un numero negativo non esiste
        else if (n==0)
            return 1;           //Passo base. Per definizione, 0! = 1
        else
            return n * factorial(n-1);    //Passo ricorsivo: n(n-1)!

            //Senza ricorsione
            /*long risultato = 1;
            for (int i = n; i > 0; i--)
                risultato *= i;
            return risultato;*/
    }
}