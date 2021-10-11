import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMapMove {

    @Test
	public void testMapMove() {
        NoFrame frame= null;
        try {
            frame= new NoFrame();
            frame.initPlayers();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        Map map= frame.getMap();

        // out of bounds
        assertEquals(false, map.move("pacman", new Location(100, 100), Map.Type.PACMAN));
        // wall
        assertEquals(false, map.move("pacman", new Location(0, 0), Map.Type.PACMAN));
        assertEquals(true, map.move("pacman", new Location(1, 2), Map.Type.PACMAN));
	}
}
