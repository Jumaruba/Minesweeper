package lpoo.view.menu;

import lpoo.model.instructions.InstModel;
import lpoo.view.ViewTest;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class InstViewTest extends ViewTest<InstModel> {
    InstView view;

    public void initView() throws IOException {
        model = mock(InstModel.class);
        view = mock(InstView.class);

        doCallRealMethod().when(view).initScreen();
        doCallRealMethod().when(view).draw(anyInt(), anyInt());
        doCallRealMethod().when(view).drawKeys();
        doCallRealMethod().when(view).drawTitle();

        view.initScreen();
        graphics = view.getGraphics();
    }

    @Test
    public void testInstView() throws IOException {
        initView();
        view.draw(0, 0);
        verify(view, times(1)).drawTitle();
        verify(view, times(1)).drawKeys();
    }
}
