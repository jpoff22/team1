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
            frame.initPlayers();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        PacMan pacman= frame.addPacMan(new Location(1,1));
        Map map= frame.getMap();

        Ghost ghost1= frame.addGhost(pacman.myLoc.shift(1,0), "Bob", Color.red);
        Ghost ghost2= frame.addGhost(pacman.myLoc.shift(4,4), "John", Color.red);

        // not in range
        assertEquals(false, ghost2.attack());
        // in range
        assertEquals(true, ghost1.attack());
        // game now over - any attack will return true (game loop over so this doesn't matter)
        assertEquals(true, ghost2.attack());
	}
}
