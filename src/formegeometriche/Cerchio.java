package formegeometriche;

public class Cerchio implements Forma {
	private Punto centro;
	private int raggio;
	private String colore;
	
	public Cerchio(Punto centro, int raggio, String colore) {
		this.centro = new Punto(centro.getX(), centro.getY());
		this.raggio = raggio;
		this.colore = colore;
	}
	
	public Punto getCentro() {
		return this.centro;
	}

	@Override
	public void trasla(int x, int y) {
		this.centro.setX(this.centro.getX() + x);
		this.centro.setY(this.centro.getY() + y);
	}
	
	@Override
	public String toString() {
		return "cerchio: centro=("+this.centro.getX()+","+this.centro.getY()
		+"), raggio="+this.raggio
		+", colore="+this.colore;
	}
}
