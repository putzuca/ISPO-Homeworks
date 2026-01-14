package battlefield.d4_d5_d6;

public class Chaser extends Robot {
	
	public Chaser(Position p) {
		super(p);
	}
	
	// Primitive operation 1
	@Override
	protected Position decidiMossa(Battlefield field) {
		Walker inseguito = cercaAvversario(field);
		if (inseguito==null) 
			return null; /* nessuno da inseguire: stai fermo */
		else return inseguito.getPosizione();
	}
	
	// Primitive operation 2
	@Override
	protected Robot creaClone(Position nuova) {
		return new Chaser(nuova);
	}

	private Walker cercaAvversario(Battlefield field) {
		for(Position p : field.adiacenti(this.getPosizione())) {
			Walker vicino = field.getWalker(p);
			if (isAvversario(vicino)) {
				return vicino;
			}
		}
		return null;
	}

	private boolean isAvversario(Object avvistato) {
		return true ; /* è sicuramente un Walker??? per ora SI! */
	}

}

