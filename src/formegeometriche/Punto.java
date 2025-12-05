package formegeometriche;

/* Rappresenta un punto nel piano cartesiano */
public class Punto {
	
	private int x, y;				// coordinate del punto
	
	/* Costruisce un punto a partire dalle sue coordinate */
	public Punto (int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	/* Imposta la coordinata x */
	public void setX(int x) {
		
		this.x = x;
	}
	
	/* Imposta la coordinata y */
	public void setY(int y) {
		
		this.y = y;
	}
	
	/* Restituisce la coordinata x */
	public int getX() {
		
		return this.x;
	}

	/* Restituisce la coordinata y */
	public int getY() {
		
		return this.y;
	}
}
