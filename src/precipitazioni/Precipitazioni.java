package precipitazioni;

/**
 * Rappresenta il modello della simulazione:
 * mantiene la matrice delle precipitazioni e
 * gestisce un insieme di visualizzatori registrati (max 10).
 */
public class Precipitazioni {

	private static final int MAX_VISUALIZZATORI = 10;	// numero massimo di visualizzatori registrabili
	private static final int DIM = 20;					// dimensione della griglia (DIM x DIM)
	private static final int PASSI = 100;				// numero di passi della simulazione
	private static final int MS_SLEEP = 100;			// pausa tra un passo e l'altro
	private static final int MAX_PIOGGIA = 10;			// numero massimo dei valori di intensità della pioggia
	
	/**
     * Matrice delle precipitazioni.
     */
	private final int[][] cartaPrecipitazioni;
	
	/**
	 * Array dei visualizzatori.
	 */
	private final Visualizzatore[] visualizzatori;
	
	/**
     * Contatore dei visualizzatori effettivamente registrati nell'array.
     */
	private int numeroVisualizzatori;

	/**
     * Costruttore: inizializza la matrice delle precipitazioni e l'array dei visualizzatori.
     */
	public Precipitazioni() {
		
		this.cartaPrecipitazioni = new int[DIM][DIM];
		this.visualizzatori = new Visualizzatore[MAX_VISUALIZZATORI];
		this.numeroVisualizzatori = 0;
		
	}
	
	/**
     * Restituisce il riferimento alla matrice delle precipitazioni.
     */
	int[][] getCartaPrecipitazioni() {
		
		return this.cartaPrecipitazioni;
		
	}

	/**
     * Aggiunge un nuovo visualizzatore al modello inserendolo nell'array dei visualizzatori.
     *
     * @param v visualizzatore da aggiungere
     * @throws IllegalArgumentException se v è null
     * @throws IllegalStateException se la capienza massima è già stata raggiunta
     */
	public void aggiungiVisualizzatore(Visualizzatore v) {
		
		if (v == null)
			throw new IllegalArgumentException("Il visualizzatore non può essere null");
		
		if (this.numeroVisualizzatori >= visualizzatori.length)
			throw new IllegalStateException("Capienza massima raggiunta (" + visualizzatori.length + " visualizzatori)");							
		
		this.visualizzatori[this.numeroVisualizzatori] = v;
		v.setPrecipitazioni(this);
		this.numeroVisualizzatori++;
		
	}

	/**
     * Notifica a tutti i visualizzatori inseriti che la schermata va aggiornata.
     *
     * @param tempo passo della simulazione da visualizzare
     */
	public void notificaAggiornamento(int tempo) {
		
		for (int i = 0; i < this.numeroVisualizzatori; i++) {
			this.visualizzatori[i].aggiornaSchermata(tempo);
		}
	}

	
	/**
     * Aggiorna i valori delle precipitazioni nella matrice.
     *
     * @param istanteTemporale parametro attualmente non usato: potrebbe servire
     *                         in estensioni future (es. formule dipendenti dal tempo).
     */
	private void calcolaPrecipitazioni(int istanteTemporale) {
		
		for (int i = 0; i < this.cartaPrecipitazioni.length; i++) {
			for (int j = 0; j < this.cartaPrecipitazioni[i].length; j++) {
				this.cartaPrecipitazioni[i][j] = (int)(Math.random() * MAX_PIOGGIA);
			}
		}
		
		try {
			Thread.sleep(MS_SLEEP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	 /**
     * Avvia la simulazione per un numero prestabilito di passi, ad ognuno dei quali
     * la matrice viene aggiornata e i visualizzatori vengono notificati.
     */
	public void eseguiSimulazione() {
		
		for (int tempo = 0; tempo < PASSI; tempo++) {
			this.calcolaPrecipitazioni(tempo);
			this.notificaAggiornamento(tempo);
		}
	
	}
	
}