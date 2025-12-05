package formegeometriche;

/* Interfaccia che rappresenta una generica forma geometrica nel piano cartesiano.
 * Le classi Cerchio, Rettangolo e GruppoDiForme la implementano */
public interface Forma {

	/* Trasla la forma di (x, y) */
	public void trasla(int x, int y);
	
}