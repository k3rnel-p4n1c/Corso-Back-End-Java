package modulo4.riparazioni;

public class Tecnico {
    private String nome;            //Nome del tecnico
    private boolean impegnato;      //Nel caso in cui il tecnico sia già impegnato in una riparazione -> true
    private boolean in_ferie;       //Nel caso in cui il tecnico sia in ferie -> true

    public Tecnico(String nome) {
        this.nome = nome;
        impegnato = false;      //Valore di default
        in_ferie = false;      //Valore di default
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setImpegnato(boolean impegnato) {
        this.impegnato = impegnato;
    }

    public void setInFerie(boolean in_ferie) {
        this.in_ferie = in_ferie;
    }

    public boolean isImpegnato() {
        return impegnato;
    }

    public boolean isInFerie() {
        return in_ferie;
    }


    @Override
    public String toString() {
        return "Nome: " +nome+ "\nImpegnato: " +impegnato+ "\nIn ferie: " +in_ferie;
    }
}