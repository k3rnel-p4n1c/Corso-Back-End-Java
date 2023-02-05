package modulo3;

public class StackOverflow {
    public static void main(String[] args) {

        System.out.println(factorial(10));
    }

    //Non essendoci il passo base, andrà in stack overflow
    private static long factorial(int n) {
        return n * factorial(n - 1);
    }
}