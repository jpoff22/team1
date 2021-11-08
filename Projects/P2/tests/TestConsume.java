import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestConsume extends TestCase {
	public void testConsume() throws FileNotFoundException {

        	NoFrame frame= null;
			try {
				frame= new NoFrame();

			} catch (FileNotFoundException e) {
				System.out.println(e);
			}
			Map map= frame.getMap();

			//initialize a pacman at (9,12) like the README example
			PacMan mypacman = frame.addPacMan(new Location(9, 12));
			//should return null because there is no cooke at (9,12)
			assertNull(mypacman.consume());

			//test trying to consume at a spot with a cookie twice
			PacMan mypacman2 = frame.addPacMan(new Location(1, 2));
			//should not return null because there is a cookie
			assertNotNull(mypacman2.consume());
			//should be null because there is no longer a cookie
			assertNull(mypacman2.consume());

		}
}
