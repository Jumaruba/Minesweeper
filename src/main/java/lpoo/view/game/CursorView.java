package lpoo.view.game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.model.game.CursorModel;
import lpoo.view.View;

import static lpoo.view.game.CellView.CELL_SIZE;


public class CursorView extends View<CursorModel> {
    public CursorView(CursorModel model, TextGraphics graphics) {
        super(model);
        this.graphics = graphics;
    }

    @Override
    public TerminalSize getSize() {
        return new TerminalSize(CELL_SIZE, 1);
    }

    @Override
    public void draw(int col, int row) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#F000FF"));       //pink

        int realCol = col + model.getPosition().getCol() * CELL_SIZE;
        int realLine = row + model.getPosition().getRow();

        graphics.putString(realCol, realLine, "<");
        graphics.putString(realCol + 2, realLine, ">");
    }
}
