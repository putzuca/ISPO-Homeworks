package formegeometriche;

public class Rettangolo implements Forma {
	private int altezza, larghezza;
	private Punto vertice;
	private String colore;
	
	public Rettangolo(Punto vertice, int altezza, int larghezza, String colore) {
		this.altezza = altezza;
		this.larghezza = larghezza;
		this.colore = colore;
		this.vertice = new Punto(vertice.getX(), vertice.getY());
	}
	
	@Override
	public void trasla(int x, int y) {
		this.vertice.setX(this.vertice.getX()+x);
		this.vertice.setY(this.vertice.getY()+y);
	}
	
	@Override
	public String toString() {
		return "rettangolo: vertice=("+this.vertice.getX()+","+this.vertice.getY()
		+"), altezza="+this.altezza
		+", larghezza="+this.larghezza
		+", colore="+this.colore;
	}

}
