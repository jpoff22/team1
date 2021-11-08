import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException{
		NoFrame frame = new NoFrame();

		//Creating Players
		PacMan pacman = frame.addPacMan(new Location(2, 4)); //Creates PacMan at location x, y

		ArrayList<Location> moves = pacman.get_valid_moves();
		assertTrue(moves.contains(new Location(1, 4)));
		assertTrue(moves.contains(new Location(3, 4)));
		assertTrue(moves.contains(new Location(2, 3)));

		assertTrue(moves.contains(new Location(6, 8)));
	}
}
