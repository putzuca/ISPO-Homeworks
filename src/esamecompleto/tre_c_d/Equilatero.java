package esamecompleto.tre_c_d;

public class Equilatero extends AbstractForma {

	public Equilatero(int dimensione, String colore) {
		super(dimensione, colore);
	}

	@Override
	public int hashCode() {
		return this.getColore().hashCode() + this.getDimensione();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Equilatero)) return false;
		Equilatero e = (Equilatero) o;
		return (this.getColore().equals(e.getColore()) && this.getDimensione() == e.getDimensione());
	}
	
	@Override
	public void accetta(RaggruppatoreDiForme raggruppatore) {
    	raggruppatore.raggruppa(this);
    }

}
