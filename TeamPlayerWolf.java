import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TeamPlayerWolf implements Wolf {
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

		boolean seeWolf = wolvesSight.length > 0
		boolean seePrey = preysSight.length > 0

		if (seeWolf) {	// if we see another wolf and it is further away than some min distance
			// Regroup with that other wolf
		}
		else if (seePrey) {
			// Follow the prey
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