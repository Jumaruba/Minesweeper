package lpoo.model.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {
    @Test
    public void testValue() {
        BombCell bomb = new BombCell();
        NumberCell number = new NumberCell(2);
        assertEquals(-1, bomb.getValue());
        assertEquals(2, number.getValue());
    }
}
