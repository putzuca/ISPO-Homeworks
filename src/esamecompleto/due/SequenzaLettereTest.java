package esamecompleto.due;

import static org.junit.Assert.*;
import org.junit.Test;

public class SequenzaLettereTest {

    @Test
    public void testSequenzaVirgole() {
        SequenzaLettere s = new SequenzaVirgole();
        assertEquals("k,A,m,c,F", s.genera());
    }

    @Test
    public void testSequenzaTrattini() {
        SequenzaLettere s = new SequenzaTrattini();
        assertEquals("q-B-z-D-h", s.genera());
    }
}
