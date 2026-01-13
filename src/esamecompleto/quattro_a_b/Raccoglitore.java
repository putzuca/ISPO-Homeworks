package esamecompleto.quattro_a_b;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Raccoglitore {
	private List <Cerchio> cerchi ;
	private List <Equilatero> equilateri ;
	private List <Quadrato> quadrati ;

	public Raccoglitore() {
		this.cerchi = new LinkedList <Cerchio>();
		this.equilateri = new LinkedList <Equilatero>();
		this.quadrati = new LinkedList <Quadrato>();
	}
	
	public List <Cerchio> getCerchi() { return this.cerchi; }

	public List <Equilatero> getEquilateri() { return this.equilateri; }

	public List <Quadrato> getQuadrati() { return this.quadrati; }

	public void addCerchio (Cerchio c) { this.cerchi.add(c); }

	public void addEquilatero (Equilatero e) { this.equilateri.add(e); }

	public void addQuadrato (Quadrato q) { this.quadrati.add(q); }
	
	public List<Forma> ordinaPerDimensione() {
		List<Forma> tutte = new LinkedList<Forma>();

	    tutte.addAll(this.cerchi);
	    tutte.addAll(this.equilateri);
	    tutte.addAll(this.quadrati);

	    Collections.sort(tutte, new Comparator<Forma>() {
	        @Override
	        public int compare(Forma f1, Forma f2) {
	            return f1.getDimensione() - f2.getDimensione(); // crescente
	        }
	    });
	    
	    return tutte;
	}
	
	public Map<String, Set<Forma>> raggruppaPerColore() {
	    Map<String, Set<Forma>> mappa = new HashMap<String, Set<Forma>>();

	    List<Forma> tutte = new LinkedList<Forma>();
	    tutte.addAll(this.cerchi);
	    tutte.addAll(this.equilateri);
	    tutte.addAll(this.quadrati);

	    for (Forma f : tutte) {
	        String colore = f.getColore();
	        Set<Forma> insieme = mappa.get(colore);

	        if (insieme == null) {
	            insieme = new HashSet<Forma>();
	            mappa.put(colore, insieme);
	        }

	        insieme.add(f);
	    }

	    return mappa;
	}


}