import junit.framework.*;
import java.awt.Color;
import java.io.*;

//the imports Jayson used
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestPacManMove extends TestCase {
		@Test
		public void testPacManMove() throws FileNotFoundException{
			
        	NoFrame frame= null;
			try {
				frame= new NoFrame();
				
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}
			Map map= frame.getMap();

			//initialize a pacman at (1,1)
			PacMan mypacman = frame.addPacMan(new Location(1, 1));

			//first move should work since pacman can move to the right at least 3 times based off the map
			assertEquals(true, mypacman.move());
			assertEquals(true, mypacman.move());
			assertEquals(true, mypacman.move());

		}
}