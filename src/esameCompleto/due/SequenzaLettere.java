package esameCompleto.due;

import java.util.List;

public abstract class SequenzaLettere {

    // Template Method: ordine fisso
    public final String genera() {
        List<String> lettere = creaLettere();  // primitive operation
        lettere = pulisci(lettere);            // hook (default)
        return formatta(lettere);              // primitive operation
    }

    // Primitive Operations
    protected abstract List<String> creaLettere();
    protected abstract String formatta(List<String> lettere);

    /* Hook (default): non modifica nulla.
       In future estensioni potrà, ad esempio:
       - ordinare le lettere in ordine alfabetico (ordine naturale)
       - rendere tutte le lettere maiuscole
       - rendere tutte le lettere minuscole */
    protected List<String> pulisci(List<String> lettere) {
        return lettere;
    }
}
