package esameCompleto.tre_b;

public class Quadrato extends AbstractForma {

	public Quadrato(int dimensione, String colore) {
		super(dimensione, colore);
	}

	@Override
	public int hashCode() {
		return this.getColore().hashCode() + this.getDimensione();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Quadrato)) return false;
		Quadrato q = (Quadrato) o;
		return (this.getColore().equals(q.getColore()) && this.getDimensione() == q.getDimensione());
	}
}
