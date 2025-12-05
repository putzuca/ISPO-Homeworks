package formegeometriche;

/* Rappresenta un cerchio nel piano cartesiano */
public class Cerchio implements Forma {
	
	private Punto centro;			// centro del cerchio
	private int raggio;				// raggio del cerchio
	private String colore;			// colore del cerchio
	
	/* Costruisce un cerchio a partire da centro, raggio e colore */
	public Cerchio(Punto centro, int raggio, String colore) {
		
		this.centro = new Punto(centro.getX(), centro.getY());
		this.raggio = raggio;
		this.colore = colore;
		
	}
	
	/* Restituisce il centro del cerchio */
	public Punto getCentro() {
		
		return this.centro;
		
	}

	/* Trasla il cerchio di (x, y) spostando il suo centro */
	@Override
	public void trasla(int x, int y) {
		
		this.centro.setX(this.centro.getX() + x);
		this.centro.setY(this.centro.getY() + y);
		
	}
	
	/* Restituisce una descrizione testuale del cerchio */
	@Override
	public String toString() {
		
		return "cerchio: centro=(" + this.centro.getX() + "," + this.centro.getY()
		+ "), raggio=" + this.raggio
		+ ", colore=" + this.colore;
		
	}
	
}
