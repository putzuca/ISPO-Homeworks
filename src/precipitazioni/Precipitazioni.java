package precipitazioni;

public class Precipitazioni {

	private static final int MAX_VISUALIZZATORI = 10;
	private static final int DIM = 20;
	private static final int PASSI = 100;
	private static final int MS_SLEEP = 100;
	private static final int MAX_PIOGGIA = 10;
	
	private final int[][] cartaPrecipitazioni;
	private final Visualizzatore[] visualizzatori;
	private int numeroVisualizzatori = 0;

	public Precipitazioni () {
		this.cartaPrecipitazioni = new int[DIM][DIM];
		this.visualizzatori = new Visualizzatore[MAX_VISUALIZZATORI];
		this.numeroVisualizzatori = 0;
	}

	int[][] getCartaPrecipitazioni() {
		return this.cartaPrecipitazioni;
	}

	public void aggiungiVisualizzatore(Visualizzatore v) {
		
		if (v == null)
            throw new IllegalArgumentException("Il visualizzatore non può essere null");						// non si può aggiungere null
		
		if (this.numeroVisualizzatori >= visualizzatori.length)
			throw new IllegalStateException("Capienza massima raggiunta (" + visualizzatori.length + " visualizzatori)");	// gruppo già pieno
		
		this.visualizzatori[this.numeroVisualizzatori] = v;
		v.setPrecipitazioni(this);
		this.numeroVisualizzatori++;
	}

	public void notificaAggiornamento(int tempo) {
		for (int i = 0; i < this.numeroVisualizzatori; i++)
			this.visualizzatori[i].aggiornaSchermata(tempo);
	}

	private void calcolaPrecipitazioni(int istanteTemporale){
		for (int i = 0; i < this.cartaPrecipitazioni.length; i++)
			for (int j = 0; j < this.cartaPrecipitazioni[i].length; j++)
				this.cartaPrecipitazioni[i][j] = (int)(Math.random()*MAX_PIOGGIA);
		try { Thread.sleep(MS_SLEEP); }
		catch( InterruptedException e ) {
			e.printStackTrace();
		}
	}

	public void eseguiSimulazione() {
		for (int tempo=0; tempo<PASSI; tempo++) {
			this.calcolaPrecipitazioni(tempo);
			this.notificaAggiornamento(tempo);
		}
	}
}