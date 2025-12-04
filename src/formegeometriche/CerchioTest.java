package formegeometriche;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CerchioTest {
	
	private Cerchio c1;
	
	@Before
	public void setUp() {
		
		Punto centro;
		int r;
		String colore;
		
		centro=new Punto(-1, -3);
		r=4;
		colore="blu";
		c1=new Cerchio(centro, r, colore);
	}
	
	@Test
	public void testTrasla() {

		this.c1.trasla(3, 2);
		
		assertEquals(2, c1.getCentro().getX());
		assertEquals(-1, c1.getCentro().getY());
	}

}
