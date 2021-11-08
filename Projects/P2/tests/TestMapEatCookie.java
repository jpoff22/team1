import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMapEatCookie {

    @Test
	public void testMapEatCookie() {
        NoFrame frame= null;
        try {
            frame= new NoFrame();
            frame.initPlayers();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        PacMan pacman= frame.addPacMan(new Location(1,1));
        Map map= frame.getMap();

        // add a cookie
        int row= 1;
        int col= 1;
        Location loc= new Location(row,col);
        CookieComponent tok = new CookieComponent(loc.x,loc.y,frame.scale);
        map.add("tok_x"+row+"_y"+col, loc, tok, Map.Type.COOKIE);
        tok.setLocation(row, col);

        assertEquals(tok, pacman.consume());
        // cookie should be gone now
        assertEquals(null, pacman.consume());
	}
}
