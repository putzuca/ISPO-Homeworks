package esameCompleto.tre_c_d;

public class Cerchio extends AbstractForma {

	public Cerchio(int dimensione, String colore) {
		super(dimensione, colore);
	}

	@Override
	public int hashCode() {
		return this.getColore().hashCode() + this.getDimensione();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Cerchio)) return false;
		Cerchio c = (Cerchio) o;
		return (this.getColore().equals(c.getColore()) && this.getDimensione() == c.getDimensione());
	}
	
	@Override
	public void accetta(RaggruppatoreDiForme raggruppatore) {
    	raggruppatore.raggruppa(this);
    }

}
