package esamecompleto.tre_c_d;

public abstract class AbstractForma implements Forma {

    private int dimensione;
    private String colore;

    protected AbstractForma(int dimensione, String colore) {
        this.dimensione = dimensione;
        this.colore = colore;
    }

    public String getColore() {
        return this.colore;
    }

    public int getDimensione() {
        return this.dimensione;
    }
    
}
