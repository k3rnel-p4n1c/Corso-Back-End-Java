package modulo1;

public class SommaArmonica {
    public static void main(String[] args) {

        System.out.println(harmonicSum(0) == (0));
        System.out.println(harmonicSum(1) == (1));
        System.out.println(harmonicSum(2) == (3./2));
        System.out.println(harmonicSum(20) == (55835135./15519504));
    }

    private static double harmonicSum(int n) {
        double risultato = 0;

        if (n==0)
            return 0;
        else
            for (int i=1; i<=n; i++)
                risultato += 1/(double)i;

        return risultato;
    }
}