package formegeometriche;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/* Classe di test per la classe Cerchio */
public class CerchioTest {
	
	private Cerchio c1;			// cerchio da usare nei test
	
	/* ARRANGE: prima di ogni test inizializza il cerchio sul centro (-1, -3) */
	@Before
	public void setUp() {
		
		Punto centro;
		int r;
		String colore;
		
		centro = new Punto(-1, -3);
		r = 4;
		colore = "blu";
		c1 = new Cerchio(centro, r, colore);
		
	}
	
	/* Verifica che la traslazione del cerchio funzioni correttamente */
	@Test
	public void testTrasla() {

		this.c1.trasla(3, 2);						// ACT: trasla il cerchio di (3, 2)
		
		assertEquals(2, c1.getCentro().getX());		// ASSERT: verifica che adesso
		assertEquals(-1, c1.getCentro().getY());	//		   il centro sia (2, -1)
		
	}

}
