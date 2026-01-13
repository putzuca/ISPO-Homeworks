package esameCompleto.tre_a;

public class Equilatero implements Forma {

	private int dimensione;
	private String colore;

	public Equilatero(int dimensione, String colore) {
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
		if (!(o instanceof Equilatero)) return false;
		Equilatero e = (Equilatero) o;
		return (this.colore.equals(e.getColore()) && this.dimensione == e.getDimensione());
	}
}
