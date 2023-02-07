package modulo4.biblioteca;

public class Libro {
    private String titolo;
    private String autore;
    private String categoria;   //Scienza, fantasy, romanzi, gialli, ...
    private int indice;         //Indice all'interno della biblioteca


    public Libro(String titolo, String autore, String categoria, int indice) {
        this.titolo = titolo;
        this.autore = autore;
        this.categoria = categoria;
        this.indice = indice;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getIndice() {
        return indice;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }


    @Override
    public String toString() {
        return "Titolo: " +titolo+ "\nAutore: " +autore+ "\nCategoria: " +categoria+ "\nIndice all'interno della biblioteca: " +indice;
    }
}