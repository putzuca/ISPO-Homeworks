package formegeometriche;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RettangoloTest {
	private Rettangolo r1;
	private Punto vertice;
	private int l, a;
	private String colore;
	
	@Before
	public void setUp() {
		this.vertice=new Punto(1, 1);
		this.l=5;
		this.a=7;
		this.colore="rosso";
		this.r1=new Rettangolo(vertice, l, a, colore);
	}
	
	@Test
	public void testTrasla() {
		
		this.r1.trasla(3, 2);
		
		assertEquals(4, this.r1.getVertice().getX());
		assertEquals(3, this.r1.getVertice().getY());
		
	}
	

}
