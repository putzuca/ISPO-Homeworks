package formegeometriche;

public class GruppoDiForme implements Forma {
	private static final int NUMERO_MAX = 10;
	private final Forma[] forme;
	private int contatoreForme = 0;
	public GruppoDiForme(int numeroForme) {
		if (numeroForme <= 0)
            throw new IllegalArgumentException("La capienza deve essere > 0");
		if (numeroForme > NUMERO_MAX)
			throw new IllegalArgumentException("Il raggruppamento non può avere più di 10 forme!");
		this.forme = new Forma[numeroForme];
			}
	
	public void aggiungiForma(Forma forma) {
		if (forma == null)
            throw new IllegalArgumentException("La forma non può essere null");
		if (this.contatoreForme >= forme.length)
			throw new IllegalStateException("Raggruppamento pieno: capienza massima raggiunta");
		this.forme[this.contatoreForme] = forma;
		this.contatoreForme++;
		}

	@Override
	public void trasla(int x, int y) {
		int i;
		for (i=0; i<contatoreForme; i++)
			forme[i].trasla(x, y);
		}
	@Override
	public String toString() {
		String s;
		int j;
		s="gruppo di forme: numero="+this.contatoreForme;
		for (j=0; j<contatoreForme; j++)
			s+="\n forma"+(j+1)+": "+forme[j].toString();
		return s;
	}
}
