package lpoo.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.model.game.TableModel;
import lpoo.view.ViewTest;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TableViewTest extends ViewTest<TableModel> {
    public void initView(int height, int width) {
        graphics = mock(TextGraphics.class);
        model = new TableModel(height, width);
        view = new lpoo.view.game.TableView(model, graphics);
    }

    public void testTableView(int height, int width) throws IOException {
        initView(height, width);
        view.draw(0, 0);
        verify(graphics, times(height * width)).putString(anyInt(), anyInt(), anyString());
    }

    @Test
    public void testSmallTableView() throws IOException {
        testTableView(6, 6);
    }

    @Test
    public void testBigTableView() throws IOException {
        testTableView(36, 36);
    }

    @Test
    public void testTallTableView() throws IOException {
        testTableView(36, 6);
    }

    @Test
    public void testLongTableView() throws IOException {
        testTableView(6, 36);
    }
}
