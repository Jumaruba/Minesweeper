package lpoo.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.model.game.ClockModel;
import lpoo.view.BorderView;
import lpoo.view.ViewTest;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ClockViewTest extends ViewTest<ClockModel> {
    BorderView border;

    public void initView() {
        graphics = mock(TextGraphics.class);
        model = mock(ClockModel.class);
        border = mock(BorderView.class);
        view = new ClockView(model, border, graphics);
    }

    @Test
    public void testClockView() throws IOException {
        initView();
        view.draw(0, 0);
        verify(graphics, times(1)).putString(anyInt(), anyInt(), anyString());
        verify(border, times(1)).draw(anyInt(), anyInt());
    }
}
