package lpoo.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class BorderViewTest {
    protected TextGraphics graphics;
    protected BorderView view;

    public void initView() throws IOException {
        graphics = mock(TextGraphics.class);
        view = new BorderView(10, 10, graphics);
    }

    @Test
    public void testInstView() throws IOException {
        initView();
        view.draw(0, 0);
        // Draw sides
        verify(graphics, times(4)).drawLine(any(TerminalPosition.class), any(TerminalPosition.class), anyChar());
        // Draw corners
        verify(graphics, times(4)).putString(anyInt(), anyInt(), anyString());
    }
}
