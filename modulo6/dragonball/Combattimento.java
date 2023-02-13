package modulo6.dragonball;

import java.util.Random;

public class Combattimento {

    /**
     * Questo metodo permette di far scontare due personaggi tra di loro, fornendo in stampa un log che riporta tutti gli avvenimenti.
     * Dato che certi attacchi potrebbero non andare a segno, per ragioni di pulizia dell'output ho deciso di non stampare quando ciò
     * accade ma di stampare solamente gli attacchi che vanno a segno. Questo metodo è statico, poiché non è necessario istanziare un
     * oggetto di tipo "Combattimento" (il combattimento è sempre uguale per tutti i personaggi)
     * @param personaggio1 personaggio da far combattere
     * @param personaggio2 personaggio da far combattere
     */
    public static void combatti(Personaggio personaggio1, Personaggio personaggio2) {
        Random random = new Random();

        //Uso queste due variabili per memorizzare gli hp, senza intaccare quelli del personaggio
        int hp1 = personaggio1.getHp();
        int hp2 = personaggio2.getHp();

        int inizio = random.nextInt(2)+1;   //Esce 1 o 2, in modo da scegliere chi inizia prima
        int indice;                                //Da 0 a 4, rappresenta l'indice casuale del vettore degli attacchi
        int probabilita_attacco;                   //Probabilità che l'attacco vada a segno
        int danno_inflitto;                        //Danno che un personaggio infligge (varia in base all'attacco)
        int attacchi1_a_segno=0;                   //Memorizza gli attacchi che il 1° personaggio manda a segno (il 2° li subisce)
        int attacchi2_a_segno=0;                   //Memorizza gli attacchi che il 2° personaggio manda a segno (il 1° li subisce)
        int attacchi1_mancati=0;                   //Memorizza gli attacchi che il 1° personaggio manca (il 2° li schiva)
        int attacchi2_mancati=0;                   //Memorizza gli attacchi che il 2° personaggio manca (il 1° li schiva)
        boolean flag;                              //Diventa vera quando avviene un attacco (mi serve per capire quando stampare dei messaggi)

        //Ciclo finché gli hp di uno dei 2 personaggi non arriva (o supera) lo 0
        while (hp1>0 && hp2>0) {
            indice = random.nextInt(5);    //Calcolo l'indice del vettore degli attacchi
            flag = false;                         //Ad ogni iterazione la imposto a false. Se avviene un attacco verrà cambiato in true

            //Caso in cui tocchi al primo personaggio
            if (inizio == 1) {

                //Probabilità che un attacco vada a segno: prob_colpire * schivata
                probabilita_attacco = (int)(personaggio1.getAttacco(indice).getProbColpire() * personaggio2.getSchivata());

                //Se esce un numero che va da 1 a "probabilita_attacco", allora l'attacco va a segno, altrimenti no
                if (random.nextInt(100)+1 <= probabilita_attacco) {

                    //Danno pari al danno che l’attacco infligge moltiplicato per la resistenza fisica dell’avversario
                    danno_inflitto = (int)(personaggio1.getAttacco(indice).getDanno() * personaggio2.getResistenza());
                    hp2 -= danno_inflitto;

                    //Stampo l'accaduto
                    System.out.println(personaggio1.getNome()+ " ha inflitto " +danno_inflitto+ " danni a " +personaggio2.getNome()+
                            " usando l'attacco \"" +personaggio1.getAttacco(indice).getNome()+ "\"");

                    //Se avviene un attacco, la flag diventa vera e il contatore degli attacchi andati a segno aumenta
                    flag = true;
                    attacchi1_a_segno++;
                }
                else
                    attacchi1_mancati++;    //Incremento il contatore degli attacchi che il 1° personaggio non ha mandato a segno

                //Cambio il valore del numero in modo che nel turno successivo sia l'altro personaggio a combattere
                inizio=2;
            }
            else {
                probabilita_attacco = (int)(personaggio2.getAttacco(indice).getProbColpire() * personaggio1.getSchivata());

                if (random.nextInt(100)+1 <= probabilita_attacco) {
                    danno_inflitto = (int)(personaggio2.getAttacco(indice).getDanno() * personaggio1.getResistenza());
                    hp1 -= danno_inflitto;

                    System.out.println(personaggio2.getNome()+ " ha inflitto " +danno_inflitto+ " danni a " +personaggio1.getNome()+
                            " usando l'attacco \"" +personaggio2.getAttacco(indice).getNome()+ "\"");

                    flag = true;
                    attacchi2_a_segno++;
                }
                else
                    attacchi2_mancati++;

                inizio=1;
            }

            //Stampo qualche info sulla vita se è avvenuto un attacco (flag==true), quindi se nessuno attacca, non stampo niente
            if (flag)
                System.out.println("HP " +personaggio1.getNome()+ ": " +hp1+
                        "\nHP " +personaggio2.getNome()+ ": " +hp2+ "\n");
        }

        if (hp1<=0)
            System.out.println("Il torneo è stato vinto da " +personaggio2.getNome()+ " con le seguenti statistiche:" +
                    "\nAttacchi andati a segno: " +attacchi2_a_segno+ "\nAttacchi non andati a segno: " +attacchi2_mancati+
                    "\nAttacchi subiti: " +attacchi1_a_segno+ "\nAttacchi schivati: " +attacchi1_mancati);
        else
            System.out.println("Il torneo è stato vinto da " +personaggio1.getNome()+ " con le seguenti statistiche:" +
                    "\nAttacchi andati a segno: " +attacchi1_a_segno+ "\nAttacchi non andati a segno: " +attacchi1_mancati+
                    "\nAttacchi subiti: " +attacchi2_a_segno+ "\nAttacchi schivati: " +attacchi2_mancati);
    }
}