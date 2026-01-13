package esamecompleto.tre_a;

public class Cerchio implements Forma {

	private int dimensione;
	private String colore;

	public Cerchio(int dimensione, String colore) {
		this.dimensione = dimensione;
		this.colore = colore;
	}

	public String getColore() {
		return this.colore;
	}

	public int getDimensione() {
		return this.dimensione;
	}

	public int hashCode() {
		return this.colore.hashCode() + this.dimensione;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Cerchio)) return false;
		Cerchio c = (Cerchio) o;
		return (this.colore.equals(c.getColore()) && this.dimensione == c.getDimensione());
	}
}
