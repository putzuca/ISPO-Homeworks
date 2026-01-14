package battlefield.d4_d5_d6;


public class Walker extends Robot {
	
	public Walker(Position p) {
		super(p);
	}
	
	// Primitive operation 1
	@Override
	protected Position decidiMossa(Battlefield field) {
		Position corrente = this.getPosizione();
		Position libera = field.posizioneLiberaVicino(corrente);
		return libera; // verso una posizione libera
					   // tutto occupato: fermo
	}
	
	// Primitive operation 2
	@Override
	protected Robot creaClone(Position nuova) {
		return new Walker(nuova);
	}
}

