package modulo8.dictionary.eccezioni;

public class LetteraNonPresenteException extends Exception{
    public LetteraNonPresenteException(char lettera_iniziale) {
        super("Lettera \"" +lettera_iniziale+ "\" non presente nel dizionario");
    }
}