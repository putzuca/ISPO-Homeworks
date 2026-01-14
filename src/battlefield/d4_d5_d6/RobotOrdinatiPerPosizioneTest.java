package battlefield.d4_d5_d6;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RobotOrdinatiPerPosizioneTest {
	private Battlefield field;

	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(5);

	}


    @Test
    public void testCampoVuoto() {
        List<Robot> l = this.field.getRobotOrdinatiPerPosizione();
        assertTrue(l.isEmpty());
    }

    @Test
    public void testUnRobot() {
        Walker w = new Walker(new Position(2, 3));
        this.field.addWalker(w);
        
        List<Robot> l = this.field.getRobotOrdinatiPerPosizione();

        assertEquals(1, l.size());
        assertSame(w, l.get(0));
    }

    @Test
    public void testDueRobotConXDiversa() {
        Walker w1 = new Walker(new Position(0, 4));
        Chaser c1 = new Chaser(new Position(3, 0));

        this.field.addWalker(w1);
        this.field.addChaser(c1);
        
        List<Robot> l = this.field.getRobotOrdinatiPerPosizione();

        assertEquals(2, l.size());
        // x crescente -> (0,4) prima di (3,0)
        assertSame(w1, l.get(0));
        assertSame(c1, l.get(1));
    }

    @Test
    public void testDueRobotConStessaX() {
        Walker w1 = new Walker(new Position(2, 1));
        Chaser c1 = new Chaser(new Position(2, 4));

        this.field.addWalker(w1);
        this.field.addChaser(c1);
        
        List<Robot> l = this.field.getRobotOrdinatiPerPosizione();

        assertEquals(2, l.size());
        // stessa x; y crescente -> (2,1) prima di (2,4)
        assertSame(w1, l.get(0));
        assertSame(c1, l.get(1));
    }

    @Test
    public void testQuattroRobot() {

        Robot r1 = new Walker(new Position(3, 2));
        Robot r2 = new Chaser(new Position(0, 1));
        Robot r3 = new Walker(new Position(3, 0));
        Robot r4 = new Chaser(new Position(2, 4));

        this.field.addRobot(r1);
        this.field.addRobot(r2);
        this.field.addRobot(r3);
        this.field.addRobot(r4);
        
        List<Robot> l = this.field.getRobotOrdinatiPerPosizione();

        assertEquals(4, l.size());

        // Ordine atteso per (x,y):
        // (0,1), (2,4), (3,0), (3,2)
        assertSame(r2, l.get(0));
        assertSame(r4, l.get(1));
        assertSame(r3, l.get(2));
        assertSame(r1, l.get(3));
    }
}
