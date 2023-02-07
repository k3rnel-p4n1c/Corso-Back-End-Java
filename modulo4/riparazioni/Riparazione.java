package modulo4.riparazioni;

public class Riparazione {
    private String indirizzo;
    private Priorita priorita;
    private Stato stato;
    private Tecnico tecnico;
    private int ID;             //Identificativo univoco della riparazione


    public Riparazione(String indirizzo, Priorita priorita, Stato stato, Tecnico tecnico) {
        this.indirizzo = indirizzo;
        this.priorita = priorita;
        this.stato = stato;
        this.tecnico = tecnico;
    }

    public Riparazione(String indirizzo, Priorita priorita) {
        this(indirizzo, priorita, null, null);
    }


    public Priorita getPriorita() {
        return priorita;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        if (tecnico != null)
            return "Indirizzo: " +indirizzo+ "\nPriorità: " +priorita+ "\nID: " +ID+ "\nINFO TECNICO\n" +tecnico+ "\nStato: " +stato;
        else
            return "Indirizzo: " +indirizzo+ "\nPriorità: " +priorita+ "\nID: " +ID+ "\nTecnico da assegnare" +"\nStato: " +stato;
    }
}