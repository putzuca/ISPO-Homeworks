package esameCompleto.tre_c_d;

import static org . junit . Assert .*;
import java . util . HashSet ;
import java . util . Set ;
import org . junit . Before ;
import org . junit . Test ;

public class UnitTest1 {
	private Set < Forma > set ;
	
	@Before
	public void setUp () throws Exception {
		this.set = new HashSet < Forma >();
	}

	@Test
	public void test () {
		Forma r1 = new Equilatero ( 1 , " Rosso " ); // r1 ed ...
		Forma r2 = new Equilatero ( 1 , " Rosso " ); // .. r2 " contano " 1
		Forma r3 = new Quadrato ( 2 , " Nero " );
		Forma r4 = new Cerchio ( 2 , " Nero " );

		set.add ( r1 );
		set.add ( r2 );
		set.add ( r3 );
		set.add ( r4 );

		assertEquals (3 , set.size ()); /* N . B . 3 e NON 4 */ // <----------
	}
}