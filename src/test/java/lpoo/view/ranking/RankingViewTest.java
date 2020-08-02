package lpoo.view.ranking;

import com.googlecode.lanterna.TerminalSize;
import lpoo.model.ranking.RankingModel;
import lpoo.view.ViewTest;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class RankingViewTest extends ViewTest<RankingModel> {
    RankingView view;

    public void initView() throws IOException {
        model = new RankingModel();
        view = mock(RankingView.class);

        doCallRealMethod().when(view).setModel(any(RankingModel.class));
        doCallRealMethod().when(view).initScreen();
        doCallRealMethod().when(view).draw(anyInt(), anyInt());
        doCallRealMethod().when(view).drawTitle();
        doCallRealMethod().when(view).drawRanking();
        when(view.getSize()).thenReturn(new TerminalSize(1, 1));

        view.setModel(model);
        view.initScreen();
        graphics = view.getGraphics();
    }

    @Test
    public void testInstView() throws IOException {
        initView();
        view.draw(0, 0);
        verify(view, times(1)).drawTitle();
        verify(view, times(1)).drawRanking();
    }
}
