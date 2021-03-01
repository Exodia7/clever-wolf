

import java.util.List;

public interface Wolf {
	public abstract int[] moveAll(List<int[]> wolvesSight, List<int[]> preysSight);
	// returns an array with 2 elements in {-1,0,1} where the 
	// first integer indicates the ROW movement, and the second the COL movement
	// Hence, diagonal movement is possible


	public abstract int moveLim(List<int[]> wolvesSight, List<int[]> preysSight);
	// returns 0 for No Movement, 1 for North, 2 for East, 3 for South, 4 for West
	// Hence, no diagonal movement is possible
}


/*
IDEAS:
VALENTIN:
- have the wolves move randomly until they see other wolves, in which case they move towards the other wolf
	when the distance between the wolves is smaller than some threshold, they start moving in a certain direction.
	when they see prey, they move towards it.
	 + change direction once you get too close to another wolf

NICK:
- move randomly until you see a prey. once you see a prey, go towards it and wait until either
		- another wolf reaches you and the prey is killed --> move in a certain direction with the other wolf
		- or you see another prey ? move to the other prey --> avoid being blocked with each wolf on different preys
*/