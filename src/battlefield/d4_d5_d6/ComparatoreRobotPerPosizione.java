package battlefield.d4_d5_d6;

import java.util.Comparator;

public class ComparatoreRobotPerPosizione implements Comparator<Robot> {
	
	@Override
	public int compare(Robot r1, Robot r2) {
		
		int x_r1 = r1.getPosizione().getX();
		int y_r1 = r1.getPosizione().getY();
		int x_r2 = r2.getPosizione().getX();
		int y_r2 = r2.getPosizione().getY();
		
		if (x_r1 != x_r2)
			return x_r1-x_r2;
		else
			return y_r1-y_r2;
	}
}
