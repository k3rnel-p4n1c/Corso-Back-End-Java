package modulo3;

public class SommaRicorsivaArray {
    public static void main(String[] args) {

        int[] vettore = {1, 2, 3, 4, 5, 6, 7, 8, 9};    //La somma è 45
        System.out.println(sommaElementiArray(vettore));
    }

    private static int sommaElementiArray(int[] vettore, int indice) {
        if (indice-1 == 0)          //Passo base
            return vettore[0];
        else                        //Passo ricorsivo
            return vettore[indice-1] + sommaElementiArray(vettore, indice-1);
    }

    private static int sommaElementiArray(int[] vettore) {
        return sommaElementiArray(vettore, vettore.length);
    }
}