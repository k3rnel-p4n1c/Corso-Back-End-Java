/* Una ditta di riparazioni di caldaie vuole gestire gli interventi a domicilio. Progettare una classe Riparazione, che contiene
 * l'indirizzo a cui recarsi, la priorità dell'intervento (es. un intero). Progettare una classe Tecnico, che rappresenta il tecnico
 * che si occuperà della riparazione.
 *
 * Progettare quindi una classe DittaRiparazioni, che contiene un insieme di tecnici, che gestisce le seguenti funzioni:
 * aggiungere una nuova riparazione da fare
 * ottenere la lista delle riparazioni in attesa
 * ottenere la prossima riparazione con la maggior priorità
 * assegnare una riparazione ad un tecnico
 * marcare una riparazione come conclusa (può essere identificata dal nome del tecnico che la sta effettuando)
 * aggiungere un tecnico alla ditta
 * mandare in ferie un insieme di tecnici (identificati per nome)
 *
 * Note:
 * dato che i tecnici sono identificati per nome, non devono poter esistere due tecnici con lo stesso nome. Non bisogna assegnare
 * la stessa riparazione a due tecnici
 */
package modulo4.riparazioni;

public class Main {
    public static void main(String[] args) {
        DittaRiparazioni ditta = new DittaRiparazioni();

        Tecnico tecnico1 = new Tecnico("Mario");
        Tecnico tecnico2 = new Tecnico("Giovanni");
        Tecnico tecnico3 = new Tecnico("Paolo");
        Tecnico tecnico4 = new Tecnico("Lorenzo");

        ditta.aggiungiRiparazione("Viale 1", Priorita.BASSA);
        ditta.aggiungiRiparazione("Viale 2", Priorita.ALTA);
        ditta.aggiungiRiparazione("Viale 3", Priorita.NORMALE);

        ditta.aggiungiTecnico(tecnico1);
        ditta.aggiungiTecnico(tecnico2);
        ditta.aggiungiTecnico(tecnico3);
        ditta.aggiungiTecnico(tecnico4);

        ditta.stampaListaRiparazioni();
        System.out.println("\n----------------------");
        ditta.assegnaRiparazioneAlTecnico(tecnico1, 0);
        ditta.stampaListaRiparazioni();
        System.out.println("\n----------------------");
        ditta.marcaRiparazioneConclusa(tecnico1);
        ditta.stampaListaRiparazioni();
    }
}