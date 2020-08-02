package lpoo.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.model.game.ClockModel;
import lpoo.model.game.CursorModel;
import lpoo.model.game.TableModel;
import lpoo.view.game.*;

import java.time.Clock;

import static lpoo.view.game.ClockView.CLOCK_HEIGHT;

public class FactoryView {
    public ClockView genClockView(ClockModel clockModel, int width, TextGraphics graphics) {
        BorderView borderView = new BorderView(width, CLOCK_HEIGHT, graphics);
        return new ClockView(clockModel, borderView, graphics);
    }

    public TableView genTableView(TableModel tableModel, TextGraphics graphics) {
        return new TableView(tableModel, graphics);
    }

    public CursorView genCursorView(CursorModel cursorModel, TextGraphics graphics) {
        return new CursorView(cursorModel, graphics);
    }
}





