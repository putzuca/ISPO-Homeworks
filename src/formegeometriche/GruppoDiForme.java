package formegeometriche;

/* Rappresenta un gruppo di forme nel piano cartesiano ed è trattato anch'esso come una forma */
public class GruppoDiForme implements Forma {
	
	private static final int NUMERO_MAX = 10;		// numero massimo di forme consentito
	private final Forma[] forme;					// array di forme contenute nel gruppo
	private int contatoreForme = 0;					// numero di forme attualmente presenti
	
	/* Costruisce un gruppo di forme a partire dalla sua capienza (da 1 a NUMERO_MAX) */
	public GruppoDiForme(int numeroForme) {
		
		if (numeroForme <= 0)
            throw new IllegalArgumentException("La capienza deve essere > 0");						// capienza al di sotto di 1
		
		if (numeroForme > NUMERO_MAX)
			throw new IllegalArgumentException("Il raggruppamento non può avere più di 10 forme!");	// capienza oltre il numero massimo
		
		this.forme = new Forma[numeroForme];
		
	}
	
	/* Aggiunge una forma al gruppo */
	public void aggiungiForma(Forma forma) {
		
		if (forma == null)
            throw new IllegalArgumentException("La forma non può essere null");						// non si può aggiungere null
		
		if (this.contatoreForme >= forme.length)
			throw new IllegalStateException("Raggruppamento pieno: capienza massima raggiunta");	// gruppo già pieno
		
		this.forme[this.contatoreForme] = forma;
		this.contatoreForme++;
		
	}

	/* Trasla tutte le forme del gruppo di (x, y) */
	@Override
	public void trasla(int x, int y) {
		
		int i;
		
		for (i = 0; i < contatoreForme; i++)
			forme[i].trasla(x, y);
		
	}
	
	/* Restituisce una descrizione testuale del gruppo di forme */
	@Override
	public String toString() {
		
		String s;
		int j;
		
		s = "gruppo di forme: numero="+this.contatoreForme;
		for (j = 0; j < contatoreForme; j++)
			s += "\n forma" + (j + 1) + ": " + forme[j].toString();
		return s;
	
	}

}
