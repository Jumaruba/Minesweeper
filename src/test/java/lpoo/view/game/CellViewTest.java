package lpoo.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.model.Position;
import lpoo.model.game.BombCell;
import lpoo.model.game.Cell;
import lpoo.model.game.NumberCell;
import lpoo.model.game.TableModel;
import lpoo.view.ViewTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CellViewTest extends ViewTest<Cell> {
    Position position = new Position(0, 0);
    TableModel tableModel;

    public void initView(Cell toTest) {
        graphics = mock(TextGraphics.class);
        tableModel = mock(TableModel.class);
        model = toTest;
        when(tableModel.getCell(position)).thenReturn(toTest);
    }

    @Test
    public void testNumberCell() throws IOException {
        // Testing all numbers
        for (int i = 0; i < 8; i++) {
            initView(new NumberCell(i));
            view = new CellView(model, graphics);
            view.draw(0, 0);
            verify(graphics, times(1)).putString(anyInt(), anyInt(), anyString());
            model.setFlag(tableModel);
            view.draw(0, 0);
            verify(graphics, times(2)).putString(anyInt(), anyInt(), anyString());
            model.setRevealed(true, tableModel);
            view.draw(0, 0);
            verify(graphics, times(3)).putString(anyInt(), anyInt(), anyString());
        }
    }

    @Test
    public void testBombCell() throws IOException {
        initView(new BombCell());
        view = new CellView(model, graphics);
        view.draw(0, 0);
        verify(graphics, times(1)).putString(anyInt(), anyInt(), anyString());
        model.setFlag(tableModel);
        view.draw(0, 0);
        verify(graphics, times(2)).putString(anyInt(), anyInt(), anyString());
        model.setRevealed(true, tableModel);
        view.draw(0, 0);
        verify(graphics, times(2)).putString(anyInt(), anyInt(), anyString());
    }
}
