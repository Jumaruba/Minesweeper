package lpoo.view.game;

import com.googlecode.lanterna.TerminalSize;
import lpoo.model.game.GameModel;
import lpoo.view.FactoryView;
import lpoo.view.View;

import java.io.IOException;

import static lpoo.view.game.CellView.CELL_SIZE;
import static lpoo.view.game.ClockView.CLOCK_HEIGHT;


public class GameView extends View<GameModel> {
    public final static int HORIZONTAL_PADDING = 2;
    public final static int VERTICAL_PADDING = 1;

    FactoryView factory;

    public GameView(GameModel model, FactoryView factoryView) {
        super(model);
        this.factory = factoryView;
        initScreen();
    }

    @Override
    public TerminalSize getSize() {
        return new TerminalSize(model.getWidth() * CELL_SIZE + 2 * HORIZONTAL_PADDING, model.getHeight() + CLOCK_HEIGHT + 3 * VERTICAL_PADDING);
    }

    @Override
    public void draw(int col, int row) throws IOException {
        clear(col, row);

        int tableRow = row + CLOCK_HEIGHT + 2 * VERTICAL_PADDING;
        factory.genClockView(model.getClock(), model.getWidth() * CELL_SIZE, graphics).draw(col + HORIZONTAL_PADDING, row + VERTICAL_PADDING);
        factory.genTableView(model.getTable(), graphics).draw(col + HORIZONTAL_PADDING, tableRow);
        factory.genCursorView(model.getCursor(), graphics).draw(col + HORIZONTAL_PADDING, tableRow);

        refresh();

    }
}
