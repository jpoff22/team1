import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map{

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE		
	}
	
	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components; 
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet; 

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
		
	public boolean move(String name, Location loc, Type type) {
        if (type != Map.Type.PACMAN && type != Map.Type.GHOST)
            return false;
        
        if (field.get(loc) != null && field.get(loc).contains(Map.Type.WALL))
            return false;

        // bounds check
        if (loc.x > dim/2 || loc.x < 0 || loc.y > dim/2 || loc.y < 0)
            return false;
		
		
		// update field at current location
		Location prevLoc= locations.get(name);	
		if (prevLoc != null) {
			HashSet<Type> typesAtPrev= field.get(prevLoc);
			if (typesAtPrev != null)
				typesAtPrev.remove(type);
		}

        // update component, field, and locations using the new location
		components.get(name).setLocation(loc.x, loc.y);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
		locations.put(name, loc);

        return true;
	}
	
	public HashSet<Type> getLoc(Location loc) {
		return field.get(loc);
	}

	public boolean attack(String Name) {
		//update gameOver
		return false;
	}
	
	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1
		return null;
	}
}
