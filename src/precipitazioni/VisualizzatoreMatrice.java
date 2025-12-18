package precipitazioni;

/**
 * Implementazione concreta dell'interfaccia Visualizzatore che stampa su console
 * l'intera matrice delle intensità delle precipitazioni ad ogni passo.
 */
public class VisualizzatoreMatrice implements Visualizzatore {
	
	/**
     * Riferimento al modello. Serve per leggere la matrice aggiornata ad ogni passo.
     */
	private Precipitazioni precipitazioni;

	@Override
	public void setPrecipitazioni(Precipitazioni p) {
		
        // Memorizza il riferimento al modello per poter leggere la matrice
		precipitazioni = p;
		
	}

	@Override
	public void aggiornaSchermata(int passo) {
		
        // Stampa il numero del passo corrente
		System.out.println("Passo " + passo);
		
        // Scorre righe e colonne della matrice e stampa i valori separati da spazio
		for (int i = 0; i < precipitazioni.getCartaPrecipitazioni().length; i++) {
			
			for (int j = 0; j < precipitazioni.getCartaPrecipitazioni()[i].length; j++)
				System.out.print(precipitazioni.getCartaPrecipitazioni()[i][j] + " ");
			
			System.out.println();
			
		}
		
	}
	
}
