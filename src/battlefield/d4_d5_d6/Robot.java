package battlefield.d4_d5_d6;

public abstract class Robot implements Comparable<Robot> {
	
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
	
	public int hashCode() {
		return this.longevita + this.posizione.getX() + this.posizione.getY();
	}
	
	public boolean equals(Object o) {
		Robot r = (Robot) o;
		return (this.longevita == r.getLongevita())
				&& (this.posizione.equals(r.getPosizione()));
	}
	
	public int compareTo(Robot r) {
		if (this.longevita != r.getLongevita())
			return this.longevita - r.getLongevita();
		
		int x1 = this.posizione.getX();
        int y1 = this.posizione.getY();
        int x2 = r.getPosizione().getX();
        int y2 = r.getPosizione().getY();
        
        if (x1 != x2)
        	return x1 - x2;
        else
        	return y1 - y2;
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
