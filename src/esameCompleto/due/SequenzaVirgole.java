package esameCompleto.due;

import java.util.Arrays;
import java.util.List;

/* ConcreteClass:
 * implementa le primitive operations
 * per una sequenza separata da virgole */
public class SequenzaVirgole extends SequenzaLettere {

    /* Primitive Operation:
     * definisce i dati di partenza
     * (5 lettere in ordine sparso) */
    @Override
    protected List<String> creaLettere() {
        return Arrays.asList("k", "A", "m", "c", "F");
    }

    /* Primitive Operation:
     * definisce il formato di output
     * (separatore: virgola) */
    @Override
    protected String formatta(List<String> lettere) {
        return String.join(",", lettere);
    }
}
