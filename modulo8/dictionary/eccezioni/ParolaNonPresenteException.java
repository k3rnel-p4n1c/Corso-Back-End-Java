package modulo8.dictionary.eccezioni;

public class ParolaNonPresenteException extends Exception {

    public ParolaNonPresenteException(String parola) {
        super("Parola \"" +parola+ "\" non presente nel dizionario");
    }
}