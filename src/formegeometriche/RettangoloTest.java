package formegeometriche;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RettangoloTest {
	private Rettangolo r1;
	
	@Before
	public void setUp() {
		
		Punto vertice;
		int l, a;
		String colore;
		
		vertice=new Punto(1, 1);
		l=5;
		a=7;
		colore="rosso";
		this.r1=new Rettangolo(vertice, l, a, colore);
	}
	
	@Test
	public void testTrasla() {
		
		this.r1.trasla(3, 2);
		
		assertEquals(4, this.r1.getVertice().getX());
		assertEquals(3, this.r1.getVertice().getY());
		
	}
	

}
