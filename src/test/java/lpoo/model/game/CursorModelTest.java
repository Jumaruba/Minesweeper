package lpoo.model.game;

import com.googlecode.lanterna.TerminalSize;
import lpoo.model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CursorModelTest {
    CursorModel cursor;

    @Before
    public void initModel() {
        cursor = new CursorModel(new TerminalSize(4, 4), new Position(0, 0));
    }

    @Test
    public void testUp() {
        cursor.moveUp();
        assertEquals(3, cursor.getPosition().getRow());
    }

    @Test
    public void testDown() {
        for (int i = 0; i < 4; i++) {
            cursor.moveDown();
        }
        assertEquals(0, cursor.getPosition().getRow());
    }

    @Test
    public void testLeft() {
        cursor.moveLeft();
        assertEquals(3, cursor.getPosition().getCol());
    }

    @Test
    public void testRight() {
        for (int i = 0; i < 4; i++) {
            cursor.moveRight();
        }
        assertEquals(0, cursor.getPosition().getCol());
    }
}
