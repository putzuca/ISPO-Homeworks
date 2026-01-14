package battlefield.d3;

public abstract class Robot {
	
    private final Position posizione;
    private int longevita;

    protected Robot(Position p) {
        this.posizione = p;
        this.longevita = 0;
    }
	
	public Position getPosizione() {
		return this.posizione;
	}
	
	public int incrementaLongevita() {
		return ++this.longevita;
	}
	
	public int getLongevita() {
		return this.longevita;
	}
	
	// Template method
	public final void passo(Battlefield field) {
		Position nuova = this.decidiMossa(field);				// Primitive operation 1
		if (nuova!=null) {
			Robot clone = creaClone(nuova);						// Primitive operation 2
			field.addRobot(clone);
		}
		this.incrementaLongevita();
	}
	
	protected abstract Position decidiMossa(Battlefield field); // Primitive operation 1
	protected abstract Robot creaClone(Position nuova);			// Primitive operation 2
	
}
