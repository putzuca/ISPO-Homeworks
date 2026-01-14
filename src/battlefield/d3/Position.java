package battlefield.d3;


/*
 * Da sistemare. Vedi PositionTest.
 * (vedi DOMANDA 1)
 */
public class Position {
	
	private final int x, y;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
		
	public String toString() {
		return this.x+"-"+this.y;
	}
	
	/* I metodi hashCode() e equals sono necessari affinché due posizioni
	 * con coordinate uguali siano considerate lo stesso elemento.
	 */
	public int hashCode() {
		return this.x + this.y;
	}
	
	public boolean equals(Object o) {
		Position p = (Position) o;
		return this.x == p.getX() && this.y == p.getY();
	}

}