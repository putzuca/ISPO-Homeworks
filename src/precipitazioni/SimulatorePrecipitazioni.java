package precipitazioni;

public class SimulatorePrecipitazioni {

	public static void main (String[] args){
		Precipitazioni p = new Precipitazioni();
		VisualizzatoreMatrice vm1 = new VisualizzatoreMatrice();
		VisualizzatoreMatrice vm2 = new VisualizzatoreMatrice();
		VisualizzatoreMatrice vm3 = new VisualizzatoreMatrice();

		p.aggiungiVisualizzatore(vm1);
		p.aggiungiVisualizzatore(vm2);
		p.aggiungiVisualizzatore(vm3);

		p.eseguiSimulazione();
	}
}