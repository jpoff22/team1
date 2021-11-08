import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	public void testPacManInRange() throws FileNotFoundException{
		Ghost ghost = frame.addGhost(new Location(3, 4), "name", Color.red); //Creates a red ghost named "name" at location x,y
	PacMan pacman = frame.addPacMan(new Location(1, 2)); //Creates PacMan at location x, y
	assertFalse(ghost.is_pacman_in_range());
	Ghost ghost2 = frame.addGhost(new Location(2, 2), "name2", Color.blue);
	assertTrue(ghost2.is_pacman_in_range());
	}
}
