package esameCompleto.tre_a;

public class Quadrato implements Forma {

	private int dimensione;
	private String colore;

	public Quadrato(int dimensione, String colore) {
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
		if (!(o instanceof Quadrato)) return false;
		Quadrato q = (Quadrato) o;
		return (this.colore.equals(q.getColore()) && this.dimensione == q.getDimensione());
	}
}
