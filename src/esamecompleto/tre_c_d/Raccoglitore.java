package esamecompleto.tre_c_d;

import java.util.LinkedList ;
import java.util.List ;

public class Raccoglitore {
	private List <Cerchio> cerchi ;
	private List <Equilatero> equilateri ;
	private List <Quadrato> quadrati ;

	public Raccoglitore() {
		this.cerchi = new LinkedList <Cerchio>();
		this.equilateri = new LinkedList <Equilatero>();
		this.quadrati = new LinkedList <Quadrato>();
	}
	
	public List <Cerchio> getCerchi() { return this.cerchi ; }

	public List <Equilatero> getEquilateri() { return this.equilateri ; }

	public List <Quadrato> getQuadrati() { return this.quadrati ; }

	public void addCerchio (Cerchio c) { this.cerchi.add(c); }

	public void addEquilatero (Equilatero e) { this.equilateri.add(e); }

	public void addQuadrato (Quadrato q) { this.quadrati.add(q); }

}