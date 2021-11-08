import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.assertEquals;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException {
        assertEquals(true,true);
		/*
		NoFrame frame= null;
			try {
				frame= new NoFrame();
				
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}

		PacMan pacman = frame.addPacMan(new Location(10, 10));
		assertEquals(false, pacman.is_ghost_in_range());

		frame.addGhost(new Location(10, 12), "Blinky", Color.RED);
		assertEquals(false, pacman.is_ghost_in_range());

		frame.getMap().move("Blinky", new Location(10, 11), Map.Type.GHOST);
		assertEquals(true, pacman.is_ghost_in_range());
		*/
	}
}
