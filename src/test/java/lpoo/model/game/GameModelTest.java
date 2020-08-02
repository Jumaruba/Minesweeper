package lpoo.model.game;

import lpoo.model.Configuration;
import lpoo.model.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameModelTest {
    @Test
    public void testFlagWin() {
        GameModel model;
        do
            model = new GameModel(new Configuration(1, 1, Configuration.Difficulty.EASY));
        while (model.getTable().getCell(new Position(0, 0)).getValue() != -1);
        assertFalse(model.checkWin());
        model.flag();
        assertTrue(model.checkWin());
    }

    @Test
    public void testCellWin() {
        GameModel model;
        do
            model = new GameModel(new Configuration(1, 1, Configuration.Difficulty.EASY));
        while (model.getTable().getCell(new Position(0, 0)).getValue() == -1);
        assertFalse(model.checkWin());
        model.click();
        assertTrue(model.checkWin());
    }
}
