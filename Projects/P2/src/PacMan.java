import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

import Map.Type;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;	
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() { 
		//ArrayList <Ghost> myGhosts = MainFrame.ghosts;
		Map.Type mynum = Map.Type.EMPTY;

		//check above, to the right, below, and to the left of myLoc for a ghost
		if (myMap.getLoc(new Location(myLoc.x, myLoc.y + 1)).contains(Map.Type.GHOST)
		|| myMap.getLoc(new Location(myLoc.x + 1, myLoc.y)).contains(Map.Type.GHOST)
		|| myMap.getLoc(new Location(myLoc.x, myLoc.y - 1)).contains(Map.Type.GHOST)
		|| myMap.getLoc(new Location(myLoc.x - 1, myLoc.y)).contains(Map.Type.GHOST)) {
			return true;
		}

		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
