import java.util.HashSet;
import java.util.ArrayList;

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
		Location up = myLoc.shift(0, 1);
		Location down = myLoc.shift(0, -1);
		Location left = myLoc.shift(-1, 0);
		Location right = myLoc.shift(1, 0);

		ArrayList<Location> validMoves = new ArrayList<Location>();

		for (Location loc : new Location[]{up, down, left, right}) {
			if (myMap.getLoc(loc).contains(Map.Type.WALL)) {
				continue;
			}
			validMoves.add(loc);
		}

		return validMoves;
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

		if (myMap.getLoc(myLoc).contains(Map.Type.COOKIE)) {
			return myMap.eatCookie("pacman");
		}

 		return null;
	}
}
