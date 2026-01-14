package battlefield.d3;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/* Modificare la classe Position affinche' 
 * il primo test abbia successo (vedi DOMANDA 1) 
 */
public class BattlefieldTest {
	
	private Battlefield field;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
	}

	@Test
	public void testAddWalker() {
		assertEquals(0, this.field.getAllWalkers().size());
		this.field.addWalker(new Walker(new Position(0,0)));
		assertEquals(1, this.field.getAllWalkers().size());
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testRaggruppaRobotDiDueTipiDiversi() {
		Walker w1, w2;
		Chaser c1, c2;

	    w1 = new Walker(new Position(0, 0));
	    w2 = new Walker(new Position(1, 1));

	    c1 = new Chaser(new Position(0, 1));
	    c2 = new Chaser(new Position(1, 0));


	    this.field.addWalker(w1);
	    this.field.addWalker(w2);

	    this.field.addChaser(c1);
	    this.field.addChaser(c2);

	    // Metodo sotto test: raggruppa i robot per tipo (Walker.class / Chaser.class)
	    Map<Class, Set<Robot>> mappa = this.field.raggruppaRobotPerTipo();

	    // Verifica che i gruppi siano due, uno per i Walker e uno per i Chaser
	    assertEquals(2, mappa.size());

	    // Verifica che le chiavi (le tipologie) siano presenti
	    assertTrue(mappa.containsKey(Walker.class));
	    assertTrue(mappa.containsKey(Chaser.class));

	    // Verifica che ogni gruppo contenga esattamente due elementi
	    assertEquals(2, mappa.get(Walker.class).size());
	    assertEquals(2, mappa.get(Chaser.class).size());

	    // Verifica che i set contengano proprio gli oggetti inseriti
	    assertTrue(mappa.get(Walker.class).contains(w1));
	    assertTrue(mappa.get(Walker.class).contains(w2));
	    assertTrue(mappa.get(Chaser.class).contains(c1));
	    assertTrue(mappa.get(Chaser.class).contains(c2));
	}

}
