import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMapGetLoc {

    @Test
	public void testMapGetLoc() {
        NoFrame frame= null;
        try {
            frame = new NoFrame();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

		frame.addGhost(new Location(10, 2), "Blinky", Color.RED);
		frame.addPacMan(new Location(1, 2));
        Map map = frame.getMap();

		assertEquals(true, map.getLoc(new Location(10, 2)).contains(Map.Type.GHOST));
		assertEquals(true, map.getLoc(new Location(1, 2)).contains(Map.Type.PACMAN));
	}
}
