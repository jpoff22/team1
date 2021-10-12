import java.util.Random;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
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

		return myMap.move(myName, myLoc, Map.Type.GHOST);
	}

	public boolean is_pacman_in_range() { 
		//check above, to the right, below, and to the left of myLoc for a ghost
		if (myMap.getLoc(new Location(myLoc.x, myLoc.y + 1)).contains(Map.Type.PACMAN)
		|| myMap.getLoc(new Location(myLoc.x + 1, myLoc.y)).contains(Map.Type.PACMAN)
		|| myMap.getLoc(new Location(myLoc.x, myLoc.y - 1)).contains(Map.Type.PACMAN)
		|| myMap.getLoc(new Location(myLoc.x - 1, myLoc.y)).contains(Map.Type.PACMAN)) {
			return true;
		}

		return false;
	}

	public boolean attack() {
		if (is_pacman_in_range()) {
			myMap.attack(myName);
			return true;
		}
		return false;
	}
}
