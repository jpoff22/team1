import java.util.HashSet;
import java.util.ArrayList;

import javax.naming.event.NamingExceptionEvent;
import javax.swing.JComponent;
import java.util.Random;

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
		ArrayList<Location> moves = get_valid_moves();

		if (moves.size() == 0) {
			return false;
		}

		//randomly choose an available direction to move to
		Random rand = new Random();
		int i = rand.nextInt(moves.size());

		myLoc = new Location(moves.get(i).x, moves.get(i).y);
		
		return myMap.move("pacman", myLoc, Map.Type.PACMAN);

	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
