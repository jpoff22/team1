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
        ArrayList<Location> validMoves= new ArrayList<Location>();

        for (int[] pos : new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}}) {
            Location loc= myLoc.shift(pos[0], pos[1]);
            if (myMap.getLoc(loc).contains(Map.Type.WALL))
                continue;

            validMoves.add(loc);
        }

        return validMoves;
	}

	public boolean move() {
		ArrayList<Location> moves = get_valid_moves();
		if (moves.isEmpty()) {
			return false;
		}

		Location move = moves.get(0);
		myMap.move(myName, move, Map.Type.GHOST);
		myLoc = move;
		return true;
	}

	public boolean is_pacman_in_range() { 
        for (int[] pos : new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}}) {
            Location check= myLoc.shift(pos[0], pos[1]);
            if (myMap.getLoc(check).contains(Map.Type.PACMAN))
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
