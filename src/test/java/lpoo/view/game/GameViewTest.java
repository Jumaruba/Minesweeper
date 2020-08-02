package lpoo.view.game;

import lpoo.model.game.ClockModel;
import lpoo.model.game.CursorModel;
import lpoo.model.game.GameModel;
import lpoo.model.game.TableModel;
import lpoo.view.FactoryView;
import lpoo.view.ViewTest;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class GameViewTest extends ViewTest<GameModel> {
    FactoryView factory;
    ClockView clockView = mock(ClockView.class);
    CursorView cursorView = mock(CursorView.class);
    TableView tableView = mock(TableView.class);

    public void initView() {
        model = mock(GameModel.class);
        factory = mock(FactoryView.class);
        view = new GameView(model, factory);
        graphics = view.getGraphics();

        // Model
        when(model.getClock()).thenReturn(mock(ClockModel.class));
        when(model.getCursor()).thenReturn(mock(CursorModel.class));
        when(model.getTable()).thenReturn(mock(TableModel.class));

        // Factory
        when(factory.genClockView(any(ClockModel.class), anyInt(), eq(graphics))).thenReturn(clockView);
        when(factory.genCursorView(any(CursorModel.class), eq(graphics))).thenReturn(cursorView);
        when(factory.genTableView(any(TableModel.class), eq(graphics))).thenReturn(tableView);
    }

    @Test
    public void testGameView() throws IOException {
        initView();
        view.draw(0, 0);
        verify(clockView, times(1)).draw(anyInt(), anyInt());
        verify(cursorView, times(1)).draw(anyInt(), anyInt());
        verify(tableView, times(1)).draw(anyInt(), anyInt());
    }

}
