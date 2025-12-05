package formegeometriche;

/* Rappresenta un rettangolo nel piano cartesiano */
public class Rettangolo implements Forma {
	
	private Punto vertice;					// vertice del rettangolo
	private int larghezza;					// larghezza del rettangolo
	private int altezza;					// altezza del rettangolo
	private String colore;					// colore del rettangolo
	
	/* Costruisce un rettangolo a partire da vertice, larghezza, altezza e colore */
	public Rettangolo(Punto vertice, int larghezza, int altezza, String colore) {
		
		this.vertice = new Punto(vertice.getX(), vertice.getY());
		this.larghezza = larghezza;
		this.altezza = altezza;
		this.colore = colore;
		
	}
	
	/* Restituisce il vertice del rettangolo */
	public Punto getVertice() {
		
		return this.vertice;
		
	}

	/* Trasla il rettangolo di (x, y) spostando il suo vertice */
	@Override
	public void trasla(int x, int y) {
		
		this.vertice.setX(this.vertice.getX() + x);
		this.vertice.setY(this.vertice.getY() + y);
		
	}
	
	/* Restituisce una descrizione testuale del rettangolo */
	@Override
	public String toString() {
		
		return "rettangolo: vertice=(" + this.vertice.getX() + "," + this.vertice.getY()
		+ "), larghezza=" + this.larghezza
		+ ", altezza=" + this.altezza
		+ ", colore=" + this.colore;
		
	}

}
