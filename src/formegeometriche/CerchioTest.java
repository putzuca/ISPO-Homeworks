package formegeometriche;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CerchioTest {
	
	private Cerchio c1;
	private Punto centro;
	private int r;
	private String colore;
	
	@Before
	public void setUp() {
		this.centro=new Punto(-1,-3);
		this.r=4;
		this.colore="blu";
		this.c1=new Cerchio(centro, r, colore);
	}
	
	@Test
	public void testTrasla() {

		this.c1.trasla(3, 2);
		
		assertEquals(2,c1.getCentro().getX());
		assertEquals(-1,c1.getCentro().getY());
	}

}
