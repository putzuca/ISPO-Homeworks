package precipitazioni;

/**
 * Classe di avvio della simulazione.
 * Crea il modello, crea più visualizzatori e li inserisce nel modello,
 * poi avvia la simulazione.
 */
public class SimulatorePrecipitazioni {

	public static void main(String[] args){
		Precipitazioni p = new Precipitazioni();
		Visualizzatore vm1 = new VisualizzatoreMatrice();
		Visualizzatore vm2 = new VisualizzatoreMatrice();
		Visualizzatore vm3 = new VisualizzatoreMatrice();

		p.aggiungiVisualizzatore(vm1);
		p.aggiungiVisualizzatore(vm2);
		p.aggiungiVisualizzatore(vm3);

		p.eseguiSimulazione();
	}
}