package precipitazioni;

/**
 * Interfaccia che rappresenta un generico visualizzatore
 * di simulazione dell'intensità delle precipitazioni su un territorio.
 */
public interface Visualizzatore {
	
    /**
     * Collega questo visualizzatore al modello della simulazione.
     * @param p il modello Precipitazioni da cui leggere la matrice delle intensità.
     */
	public void setPrecipitazioni(Precipitazioni p);
	
	/**
     * Visualizza lo stato del modello in corrispondenza di un certo passo temporale.
     * @param passo indice del passo temporale della simulazione (0, 1, 2, ...)
     */
	public void aggiornaSchermata(int passo);

}
