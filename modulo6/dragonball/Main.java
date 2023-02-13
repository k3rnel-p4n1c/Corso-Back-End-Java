/* Vogliamo creare un videogioco basato sul famosissimo manga di Akira Toriyama, nel quale i vari personaggi possono combattere tra di
 * loro in una sorta di Torneo Tenkaichi. Ogni personaggio ha un nome, dei punti vita, una lista di 4 possibili attacchi personalizzati e
 * una forza fisica. Inoltre ogni personaggio ha un valore compreso tra 0 ed 1 che rappresenta la sua capacità di schivare attacchi e un
 * valore compreso tra 0 ed 1 che rappresenta la sua resistenza fisica. Ogni attacco possibile ha un nome, un valore rappresentante la
 * quantità di danno, e un valore compreso tra 0 ed 1 che rappresenta la probabilità che l’attacco vada a segno. Notare che per calcolare
 * la probabilità che un attacco A vada a segno su un personaggio P sarà data dal prodotto della probabilità che l’attacco vada a segna con
 * la probabilità che l’attacco venga schivato. Quindi se per esempio il personaggio Goku utilizza il’attacco “Kaikoen” che ha probabilità
 * 0.9 di successo sul personaggio Freezer che ha probabilità 0.4 di schivare un attacco, la probabilità che l’attacco vada a segno è:
 * 0.90*0.40 = 0.36 (in pratica il 36% delle volte va a segno).
 *
 * Nota: un diverso attacco può essere nel kit di più personaggi. Per esempio l’attacco “Kamehameha” è un attacco sia di Goku che di
 * Gohan che del Maestro delle Tartarughe ecc.
 *
 * Torniamo ai personaggi. Essi possono essere di diverso tipo: Umano, Saiyan, Namecciano, Cyborg, Demone (per esempio Majin-bu) e Alieno
 * (per esempio Freezer). Tutti i personaggi, a parte i 4 attacchi personali, hanno un attacco fisico di base, e una probabilità che esso
 * vada a segno che cambia a seconda del personaggio. Questo attacco fisico di base è a tutti gli effetti un attacco, e il suo danno è uguale
 * alla forza fisica del personaggio. Vogliamo inoltre che i personaggi implementino l'interfaccia Comparable, facendo in modo che un
 * personaggio sia confrontato rispetto agli altri in base ai loro punti vita. Creare infine una classe Combattimento che rappresenta un
 * combattimento tra due personaggi. Questa classe avrà tra gli attributi i personaggi stessi e implementerà al proprio interno un metodo
 * combatti() che simulerà un combattimento. Il metodo eseguirà i seguenti passaggi:
 * 1) Sceglie a caso il combattente che inizierà per primo
 * 2) A turno, i combatteni scaglieranno un attacco preso random dalla lista dei suoi attacchi, calcolerà randomicamente se l’attacco andrà
 * a segno o meno, e se l’attacco va a segno infligge danno all’avversario pari al danno che l’attacco infligge moltiplicato per la resistenza
 * fisica dell’avversario (quindi più questo valore per un personaggio è vicino allo 0 più è resistente, più e vicino ad 1 meno è resistente).
 * Ad esempio, se Goku riesce ad infliggere un attacco “Kamehameha” a Majin-Bu che infligge 50 danni, se Majin-Bu ha una resistenza pari a 0.3
 * il danno inflitto sarà 50*0.3 = 15
 * 3) Il combattimento termina quando uno dei due personaggi raggiungerà un numero di punti vita <= 0. In tal caso il combattimento finisce e
 * i punti vita dei personaggi vengono ripristinati al massimo.
 *
 * Creare una classe Main dove vengano creati dei personaggi, degli attacchi, e vengano simulati dei combattimenti.
 * Nota: ovviamente se provate a fare più volte lo stesso combattimento potrete accorgervi di avere risultati diversi: è normale vista la
 * randomicità coinvolta!
 */
package modulo6.dragonball;

public class Main {
    public static void main(String[] args) {

        //Attacchi base (da mischia) - danno pari alla forza fisica del personaggio
        Attacco pugni_in_bocca = new Attacco("pugni in bocca");
        Attacco calci_in_faccia = new Attacco("calci in faccia");
        Attacco dita_negli_occhi = new Attacco("dita negli occhi");
        Attacco calcio_genitale = new Attacco("calcio genitale");
        Attacco morso_all_orecchio = new Attacco("morso all'orecchio");

        //Attacchi speciali
        Attacco kamehameha = new Attacco("kamehameha", 25);
        Attacco final_flash = new Attacco("final flash", 25);
        Attacco energia_sferica = new Attacco("energia sferica", 50);
        Attacco colpo_aura = new Attacco("colpo dell'aura", 5);
        Attacco cannone_speciale = new Attacco("cannone speciale", 30);
        Attacco raggio_oculare = new Attacco("raggio oculare", 10);
        Attacco cannone_garrik = new Attacco("cannone garrik", 20);
        Attacco masenko = new Attacco("masenko", 10);
        Attacco kienzan = new Attacco("kienzan", 20);
        Attacco pugno_del_drago = new Attacco("pugno del drago", 35);
        Attacco sfera_distruttiva = new Attacco("sfera distruttiva", 50);

        //Attacchi personalizzati
        Attacco[] combo_goku = {pugni_in_bocca, kamehameha, energia_sferica, colpo_aura, pugno_del_drago};
        Attacco[] combo_cell = {morso_all_orecchio, final_flash, kamehameha, cannone_speciale, cannone_garrik};
        Attacco[] combo_freezer = {dita_negli_occhi, raggio_oculare, colpo_aura, masenko, sfera_distruttiva};
        Attacco[] combo_crilin = {calcio_genitale, masenko, kienzan, colpo_aura, kamehameha};
        Attacco[] combo_vegeta = {calci_in_faccia, final_flash, cannone_speciale, cannone_garrik, colpo_aura};

        //Personaggi
        Personaggio goku = new Personaggio("Goku", 100, 10, Razza.SAIYAN, combo_goku);
        Personaggio cell = new Personaggio("Cell", 85, 8, Razza.ALIENO, combo_cell);
        Personaggio freezer = new Personaggio("Freezer", 90, 7, Razza.ALIENO, combo_freezer);
        Personaggio crilin = new Personaggio("Crilin", 50, 2, Razza.UMANO, combo_crilin);
        Personaggio vegeta = new Personaggio("Vegeta", 95, 9, Razza.SAIYAN, combo_vegeta);

        //Inizio il combattimento
        Combattimento.combatti(goku, vegeta);
    }
}