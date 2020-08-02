package lpoo.view.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.model.Position;
import lpoo.model.game.CursorModel;
import lpoo.view.ViewTest;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class CursorViewTest extends ViewTest<CursorModel> {
    public void initView() {
        graphics = mock(TextGraphics.class);
        model = mock(CursorModel.class);
        when(model.getPosition()).thenReturn(new Position(0, 0));
    }

    @Test
    public void testCursorView() throws IOException {
        initView();
        view = new CursorView(model, graphics);
        view.draw(0, 0);
        verify(graphics, times(2)).putString(anyInt(), anyInt(), anyString());
        verify(graphics, times(1)).setForegroundColor(any(TextColor.class));
    }
}
