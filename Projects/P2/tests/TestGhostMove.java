import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.assertEquals;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException {
        NoFrame frame = new NoFrame();

		Ghost ghost = frame.addGhost(new Location(1, 1), "Blinky", Color.RED);
        Map map = frame.getMap();
		ghost.move();

		// ghost only has two places to move, make sure it moved to one of them
		assertEquals(true, map.getLoc(new Location(1, 2)).contains(Map.Type.GHOST) || map.getLoc(new Location(2, 1)).contains(Map.Type.GHOST));
	}
}
