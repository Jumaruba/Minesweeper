package lpoo.view.game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.model.Position;
import lpoo.model.game.TableModel;
import lpoo.view.View;

import java.io.IOException;

public class TableView extends View<TableModel> {
    public TableView(TableModel model, TextGraphics graphics) {
        super(model);
        this.graphics = graphics;
    }

    @Override
    public TerminalSize getSize() {
        return super.getSize();
    }

    @Override
    public void draw(int colBegin, int lineBegin) throws IOException {
        CellView cellView;
        for (int line = 0; line < model.getHeight(); line++) {
            for (int col = 0; col < model.getWidth(); col++) {
                Position position = new Position(line, col);
                cellView = new CellView(model.getCell(position), graphics);
                cellView.draw(col * CellView.CELL_SIZE + colBegin, line + lineBegin);
            }
        }
    }
}
