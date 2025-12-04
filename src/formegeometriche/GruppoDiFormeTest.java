package formegeometriche;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GruppoDiFormeTest {
	
	private Rettangolo r1;
	
	private Cerchio c1, c2;
	
	private GruppoDiForme g1, g2;
	
	@Before
	public void setUp() {
		
		Punto vertice, centro1, centro2;
		int l, a, raggio1, raggio2;
		String colore, colore1, colore2;
		
		vertice=new Punto(1, 1);
		l=5;
		a=7;
		colore="rosso";
		this.r1=new Rettangolo(vertice, l, a, colore);
		
		centro1=new Punto(-1, -3);
		raggio1=4;
		colore1="blu";
		this.c1=new Cerchio(centro1, raggio1, colore1);
		
		this.g1=new GruppoDiForme(2);
		this.g1.aggiungiForma(r1);
		this.g1.aggiungiForma(c1);
		
		centro2=new Punto(-1, 2);
		raggio2=2;
		colore2="blu";
		this.c2=new Cerchio(centro2, raggio2, colore2);
		
		this.g2=new GruppoDiForme(2);
		this.g2.aggiungiForma(g1);
		this.g2.aggiungiForma(c2);
		
	}
	
	@Test
	public void testTrasla_GruppoSemplice() {
		
		assertEquals(1, this.r1.getVertice().getX());
		assertEquals(1, this.r1.getVertice().getY());
		assertEquals(-1, this.c1.getCentro().getX());
		assertEquals(-3, this.c1.getCentro().getY());
		
		this.g1.trasla(3, 2);
		
		assertEquals(4, this.r1.getVertice().getX());
		assertEquals(3, this.r1.getVertice().getY());
		assertEquals(2, this.c1.getCentro().getX());
		assertEquals(-1, this.c1.getCentro().getY());

	}
	
	@Test
	public void testTrasla_GruppoDiGruppi() {
		
		assertEquals(1, this.r1.getVertice().getX());
		assertEquals(1, this.r1.getVertice().getY());
		assertEquals(-1, this.c1.getCentro().getX());
		assertEquals(-3, this.c1.getCentro().getY());
		assertEquals(-1, this.c2.getCentro().getX());
		assertEquals(2, this.c2.getCentro().getY());
		
		this.g2.trasla(3, 2);
		
		assertEquals(4, this.r1.getVertice().getX());
		assertEquals(3, this.r1.getVertice().getY());
		assertEquals(2, this.c1.getCentro().getX());
		assertEquals(-1, this.c1.getCentro().getY());
		assertEquals(2, this.c2.getCentro().getX());
		assertEquals(4, this.c2.getCentro().getY());

	}
	
	@Test
	public void testCostruttorePiuDiDieciForme() {
		try {
			new GruppoDiForme(25);
			fail("Doveva essere lanciata IllegalArgumentException perché il numero di forme è superiore a 10");
		} catch(IllegalArgumentException e) {
			assertEquals("Il raggruppamento non può avere più di 10 forme!", e.getMessage());
		}
	}
	
	@Test
	public void testCostruttoreFinoADieciForme() {
		boolean eccezioneLanciata = false;
		try {
			new GruppoDiForme(5);
		} catch(IllegalArgumentException e) {
			eccezioneLanciata = true;
		}
		assertFalse("È stata lanciata IllegalArgumentException ma il numero di forme è inferiore o uguale a 10",
	               eccezioneLanciata);
	}
	
}
