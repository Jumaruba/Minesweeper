package lpoo.model.game;

import lpoo.model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TableModelTest {
    TableModel beginsWithoutBomb;
    TableModel beginsWithBomb;

    @Before
    public void initTables() {
        do
            beginsWithoutBomb = new TableGenerator(10, 11).generateTable(10);
        while (beginsWithoutBomb.getCell(new Position(0, 0)).getValue() == -1);
        do
            beginsWithBomb = new TableGenerator(12, 13).generateTable(0);
        while (beginsWithBomb.getCell(new Position(0, 0)).getValue() != -1);
    }

    @Test
    public void testHeightWidth() {
        assertEquals(10, beginsWithoutBomb.getHeight());
        assertEquals(11, beginsWithoutBomb.getWidth());
        assertEquals(12, beginsWithBomb.getHeight());
        assertEquals(13, beginsWithBomb.getWidth());
    }
}
