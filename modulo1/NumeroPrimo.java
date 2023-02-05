package modulo1;

public class NumeroPrimo {
    public static void main(String[] args) {

        int number = 0;
        System.out.println(number +": " +isPrime(number));

        number = 1;
        System.out.println(number +": " +isPrime(number));

        number = 2;
        System.out.println(number +": " +isPrime(number));

        number = 17;
        System.out.println(number +": " +isPrime(number));

        number = 631;
        System.out.println(number +": " +isPrime(number));

        number = 634;
        System.out.println("!" +number +": " +!isPrime(number));

        number = 999;
        System.out.println("!" +number +": " +!isPrime(number));

        number = 997;
        System.out.println(number +": " +isPrime(number));
    }

    private static boolean isPrime(int number) {

        if (number <= 1)
            return false;
        else if (number == 2)
            return true;
        else if (number%2 == 0)     //I numeri pari (escluso 2) non sono primi
            return false;
        else {
            for (int i=3; i<=(int)Math.sqrt(number); i+=2)    //Incremento di 2 per saltare i numeri pari
                if (number%i == 0)
                    return false;

            return true;
        }
    }
}