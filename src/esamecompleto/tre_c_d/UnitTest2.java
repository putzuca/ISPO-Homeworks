package esamecompleto.tre_c_d;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class UnitTest2 {
	private Set<Forma> forme;
	private RaggruppatoreDiForme raggruppatore;

	@Before
	public void setUp() throws Exception {
		this.forme = new HashSet<Forma>();
		this.raggruppatore = new RaggruppatoreDiForme();
	}

	@Test
	public void testRaggruppamento() {
		List<Equilatero> equilateri = Arrays.asList(new Equilatero[] {
				new Equilatero(3, "Rosso"),
				new Equilatero(2, "Rosso")
		});
		List<Cerchio> cerchi = Arrays.asList(new Cerchio[] {
				new Cerchio(1, "Blu")
		});
		List<Quadrato> quadrati = Arrays.asList(new Quadrato[] {
				new Quadrato(2, "Nero"),
				new Quadrato(4, "Marrone")
		});
		
		forme.addAll(equilateri);
		forme.addAll(cerchi);
		forme.addAll(quadrati);

		Raccoglitore raccoglitore = this.raggruppatore.raggruppa(forme);
		
		// verifica della cardinalità
		assertEquals(equilateri.size(), raccoglitore.getEquilateri().size());
		assertEquals(cerchi.size(), raccoglitore.getCerchi().size());
		assertEquals(quadrati.size(), raccoglitore.getQuadrati().size());

		// verifica del contenuto considerando che forme è un HashSet (altrimenti avrei usato un ArrayList)
		assertEquals(new HashSet<Equilatero>(equilateri),
			    new HashSet<Equilatero>(raccoglitore.getEquilateri()));
		assertEquals(new HashSet<Cerchio>(cerchi),
	            new HashSet<Cerchio>(raccoglitore.getCerchi()));
		assertEquals(new HashSet<Quadrato>(quadrati),
				new HashSet<Quadrato>(raccoglitore.getQuadrati()));
	}

}
