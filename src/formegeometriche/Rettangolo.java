package formegeometriche;

public class Rettangolo implements Forma {
	private Punto vertice;
	private int larghezza, altezza;
	private String colore;
	
	public Rettangolo(Punto vertice, int larghezza, int altezza, String colore) {
		this.vertice = new Punto(vertice.getX(), vertice.getY());
		this.larghezza = larghezza;
		this.altezza = altezza;
		this.colore = colore;
	}
	
	
	public Punto getVertice() {
		return this.vertice;
	}


	@Override
	public void trasla(int x, int y) {
		this.vertice.setX(this.vertice.getX()+x);
		this.vertice.setY(this.vertice.getY()+y);
	}
	
	@Override
	public String toString() {
		return "rettangolo: vertice=("+this.vertice.getX()+","+this.vertice.getY()
		+", larghezza="+this.larghezza
		+"), altezza="+this.altezza
		+", colore="+this.colore;
	}

}
