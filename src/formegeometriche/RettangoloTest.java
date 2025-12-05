package formegeometriche;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/* Classe di test per la classe Rettangolo */
public class RettangoloTest {
	
	private Rettangolo r1;				// rettangolo da usare nei test
	
	/* ARRANGE: prima di ogni test inizializza il rettangolo col vertice (1, 1) */
	@Before
	public void setUp() {
		
		Punto vertice;
		int l, a;
		String colore;
		
		vertice = new Punto(1, 1);
		l = 5;
		a = 7;
		colore = "rosso";
		this.r1 = new Rettangolo(vertice, l, a, colore);
	}
	
	/* Verifica che la traslazione del rettangolo funzioni correttamente */
	@Test
	public void testTrasla() {
		
		this.r1.trasla(3, 2);							// ACT: trasla il rettangolo di (3, 2)
		
		assertEquals(4, this.r1.getVertice().getX());	// ASSERT: verifica che adesso
		assertEquals(3, this.r1.getVertice().getY());	//		   il vertice sia (4, 3)
		
	}
	
}
