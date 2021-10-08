import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMapAttack {

    @Test
	public void testMapAttack() {
        NoFrame frame= null;
        try {
            frame= new NoFrame();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        PacMan pacman= frame.addPacMan(new Location(1,1));
        Map map= frame.getMap();

        Ghost ghost1= frame.addGhost(pacman.myLoc.shift(1,0), "Bob", Color.red);
        Ghost ghost2= frame.addGhost(pacman.myLoc.shift(4,4), "Fred", Color.blue);

        assertEquals(false, map.attack("Fred"));
        assertEquals(false, map.attack("John"));
        assertEquals(true, map.attack("Bob"));
        // any calls after to map.attack return true because game is now over
	}
}
