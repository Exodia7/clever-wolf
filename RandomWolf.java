

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomWolf implements Wolf {

	/** Returns a 2D move to apply.
	  *
	  * @params wolvesSight: positions of the wolves in its sight (can not distinguish the wolves though)
	  * @params preysSight: positions of the preys in its sight
	  *
	  * See getWolfViewW and getWolfViewP for what these parameters will be like
	*/
	@Override
	public int[] moveAll(List<int[]> wolvesSight, List<int[]> preysSight) {
		Random r = new Random();
		int[] mymove = new int[2];
		mymove[0] = r.nextInt(3)-1;		// move on vertical axis (-1, 0, +1)
		mymove[1] = r.nextInt(3)-1;		// move on horizontal axis (-1, 0, +1)
		return mymove;
	}
	
	public int moveLim(List<int[]> wolvesSight, List<int[]> preysSight) {
		Random r = new Random();
		return r.nextInt(4) + 1;		// moveLim can only move in one direction
	}


}
