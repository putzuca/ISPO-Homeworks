package esamecompleto.quattro_a_b;

import java.util.Set;

public class RaggruppatoreDiForme {
	private Raccoglitore raccoglitore ;

	public void raggruppa (Cerchio c) {

		this.raccoglitore.addCerchio(c);
	}

	public void raggruppa (Equilatero e) {
		this.raccoglitore.addEquilatero(e);
	}

	public void raggruppa (Quadrato q) {
		this.raccoglitore.addQuadrato(q);
	}

	public Raccoglitore raggruppa (Set<Forma> forme) {
		this.raccoglitore = new Raccoglitore();
		for (Forma r : forme) {
			r.accetta(this);
		}
		return this.raccoglitore;
	}
}