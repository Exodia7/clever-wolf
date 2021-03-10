import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TeamPlayerWolf implements Wolf {
	private double MIN_GROUP_DISTANCE = 5;		// This sets the distance at which the wolves regroup 
	
	/**
	 * This wolf has the following pattern:
	 *      1. First, it moves around at random.
	 *      2. Until it sees another wolf, then it will aim to group up with that wolf.
	 *      3. Finally, once they see a prey, they will move towards the prey.
	 *
	 * @param wolvesSight
	 * @param preysSight
	 * @return
	 */
	@Override
	public int[] moveAll(List<int[]> wolvesSight, List<int[]> preysSight) {
		int[] mymove = new int[2];
		
		boolean seeWolf = wolvesSight.size() > 1;		// set to 1, as the wolf always sees itself
		boolean seePrey = preysSight.size() > 0;
		
		// Compute the minimum distance to a wolf that is further away than the MIN_GROUP_DISTANCE
		// 	 --> idea is to find the closest wolf that is not already in the "group"
		double minWolfDistance = Double.MAX_VALUE;
		int[] minWolfPos = new int[2];
		boolean foundWolf = false;
		for (int i=0; i < wolvesSight.size(); i ++) {
			// For all wolves, check their positions and distances
			int[] wolfPos = wolvesSight.get(i);
			double currentDist = Math.sqrt(Math.pow(wolfPos[0], 2) + Math.pow(wolfPos[1], 2));
			
			// If they match the conditions and are closer than the current closest
			if ((currentDist > this.MIN_GROUP_DISTANCE) && (currentDist < minWolfDistance)) {
				// Save their position and distance
				minWolfDistance = currentDist;
				for (int j=0; j < wolfPos.length; j++) {
					minWolfPos[j] = wolfPos[j];
				}
				
				// Save the fact that we found a wolf matching the criteria
				foundWolf = true;
			}
		}
		
		if (seeWolf && foundWolf) {	// if we see another wolf that is not already in the group
			// Regroup with that other wolf
			mymove = findDirection(minWolfPos);
		}
		else if (seePrey) {
			// Follow the prey
			mymove = findDirection(preysSight.get(0));
		}
		else {
			// Move at random
			Random r = new Random();
			mymove[0] = r.nextInt(3)-1;		// move on vertical axis (-1, 0, +1)
			mymove[1] = r.nextInt(3)-1;		// move on horizontal axis (-1, 0, +1)
		}
		
		// Return the result
		return mymove;
	}
	
	/** Given the relative cell position "position", 
	 * compute the direction to move in as [moveOnX, moveOnY]
	 */
	public static int[] findDirection(int[] position) {
		int[] recommendedMove = {0, 0};
		
		// Compute the recommended move on each dimension
		for (int dim=0; dim < position.length; dim ++) {
			if (position[dim] > 0)
				recommendedMove[dim] = -1;
			else if (position[dim] < 0)
				recommendedMove[dim] = 1;
		}
		
		return recommendedMove;
	}

	/**
	 * Default: move randomly for moveLim (which is not going to be used)
	 *
	 * @param wolvesSight list with the positions of all wolves in its sight (can not distinguish the wolves though)
	 * @param preysSight positions of the preys in its sight
	 *
	 * @return a single integer corresponding to the move to perform (up, down, left, right, stay)
	 */
	public int moveLim(List<int[]> wolvesSight, List<int[]> preysSight) {
		Random r = new Random();
		return r.nextInt(4) + 1;
	}
}