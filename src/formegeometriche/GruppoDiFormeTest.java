package formegeometriche;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/* Classe di test per la classe GruppoDiForme */
public class GruppoDiFormeTest {
	
	private Rettangolo r1;			// rettangolo usato nei test
	
	private Cerchio c1, c2;			// cerchi usati nei test
	
	private GruppoDiForme g1, g2;	// gruppo semplice e gruppo di gruppi, usati nei test
	
	/* ARRANGE: prima di ogni test inizializza rettangolo, cerchi e gruppi */
	@Before
	public void setUp() {
		
		Punto vertice, centro1, centro2;
		int l, a, raggio1, raggio2;
		String colore, colore1, colore2;
		
		vertice = new Punto(1, 1);
		l = 5;
		a = 7;
		colore = "rosso";
		this.r1 = new Rettangolo(vertice, l, a, colore);
		
		centro1 = new Punto(-1, -3);
		raggio1 = 4;
		colore1 = "blu";
		this.c1 = new Cerchio(centro1, raggio1, colore1);
		
		this.g1 = new GruppoDiForme(2);
		this.g1.aggiungiForma(r1);			// g1 contiene
		this.g1.aggiungiForma(c1);			// r1 e c1
		
		centro2 = new Punto(-1, 2);
		raggio2 = 2;
		colore2 = "blu";
		this.c2 = new Cerchio(centro2, raggio2, colore2);
		
		this.g2 = new GruppoDiForme(2);
		this.g2.aggiungiForma(g1);			// g2 contiene
		this.g2.aggiungiForma(c2);			// g1 e c2
		
	}
	
	/* Verifica la traslazione di un gruppo semplice */
	@Test
	public void testTrasla_GruppoSemplice() {
		
		assertEquals(1, this.r1.getVertice().getX());	// ASSERT: verifica lo stato iniziale
		assertEquals(1, this.r1.getVertice().getY());	//		   del gruppo semplice
		assertEquals(-1, this.c1.getCentro().getX());			  
		assertEquals(-3, this.c1.getCentro().getY());	
		
		this.g1.trasla(3, 2);							// ACT: trasla il gruppo semplice di (3, 2)
		
		assertEquals(4, this.r1.getVertice().getX());	// ASSERT: verifica che il rettangolo e il cerchio
		assertEquals(3, this.r1.getVertice().getY());	//		   contenuti nel gruppo siano stati traslati
		assertEquals(2, this.c1.getCentro().getX());	
		assertEquals(-1, this.c1.getCentro().getY());	

	}
	
	/* Verifica la traslazione di un gruppo che contiene a sua volta un altro gruppo */
	@Test
	public void testTrasla_GruppoDiGruppi() {
		
		assertEquals(1, this.r1.getVertice().getX());	// ASSERT: verifica lo stato iniziale
		assertEquals(1, this.r1.getVertice().getY());	//		   del gruppo di gruppi	  
		assertEquals(-1, this.c1.getCentro().getX());	
		assertEquals(-3, this.c1.getCentro().getY());		
		assertEquals(-1, this.c2.getCentro().getX());	
		assertEquals(2, this.c2.getCentro().getY());	
		
		this.g2.trasla(3, 2);							// ACT: trasla il gruppo di gruppi di (3, 2)
		
		assertEquals(4, this.r1.getVertice().getX());	// ASSERT: verifica che il gruppo semplice e il cerchio
		assertEquals(3, this.r1.getVertice().getY());	//		   contenuti nel gruppo siano stati traslati
		assertEquals(2, this.c1.getCentro().getX());	
		assertEquals(-1, this.c1.getCentro().getY());	
		assertEquals(2, this.c2.getCentro().getX());	
		assertEquals(4, this.c2.getCentro().getY());	

	}
	
	/* Verifica che il costruttore lanci l'eccezione se il numero di forme è > 10 */
	@Test
	public void testCostruttorePiuDiDieciForme() {
		
		try {
			
			new GruppoDiForme(25);
			fail("Doveva essere lanciata IllegalArgumentException in quanto il numero di forme è superiore a 10");
			
		} catch (IllegalArgumentException e) {
			
			assertEquals("Il raggruppamento non può avere più di 10 forme!", e.getMessage());
			
		}
		
	}
	
	/* Verifica che il costruttore accetti un numero di forme <= 10 senza eccezioni */
	@Test
	public void testCostruttoreFinoADieciForme() {
		
		boolean eccezioneLanciata = false;
		
		try {
			
			new GruppoDiForme(5);
			
		} catch (IllegalArgumentException e) {
			
			eccezioneLanciata = true;
			
		}
		
		assertFalse("È stata lanciata IllegalArgumentException ma il numero di forme è inferiore o uguale a 10",
	               eccezioneLanciata);
		
	}
	
}
