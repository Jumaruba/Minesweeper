package lpoo.view.menu;

import com.googlecode.lanterna.TerminalSize;
import lpoo.model.settings.SettingsModel;
import lpoo.view.ViewTest;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SettingsViewTest extends ViewTest<SettingsModel> {
    SettingsView view;

    public void initView() throws IOException {
        model = mock(SettingsModel.class);
        view = mock(SettingsView.class);

        doCallRealMethod().when(view).initScreen();
        doCallRealMethod().when(view).draw(anyInt(), anyInt());
        doCallRealMethod().when(view).drawTitle();
        when(view.getSize()).thenReturn(new TerminalSize(1, 1));

        view.initScreen();
        graphics = view.getGraphics();
    }

    @Test
    public void testInstView() throws IOException {
        initView();
        view.draw(0, 0);
        verify(view, times(1)).drawTitle();
        verify(view, times(1)).drawOptions();
        verify(view, times(1)).drawSelectedBorder();
    }
}
