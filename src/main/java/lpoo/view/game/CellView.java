package lpoo.view.game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.model.game.Cell;
import lpoo.view.View;

import java.util.ArrayList;
import java.util.List;

public class CellView extends View<Cell> {
    public final static int CELL_SIZE = 3;

    public CellView(Cell model, TextGraphics graphics) {
        super(model);
        this.graphics = graphics;
    }

    static final List<String> colors = new ArrayList<String>() {{
        add("#010326"); // background colour
        add("#166eb7"); // blue
        add("#8dd45a"); // green
        add("#fde559"); // yellow
        add("#e7944b"); // orange
        add("#D95353"); // red
        add("#b249d2"); // violet
        add("#86541a"); // brown
        add("#180e01"); // black
    }};

    @Override
    public TerminalSize getSize() {
        return new TerminalSize(CELL_SIZE, 1);
    }

    @Override
    public void draw(int col, int row) {
        if (model.getRevealed()) {
            int value = model.getValue();
            if (value >= 0) {
                String color = colors.get(value);
                graphics.setForegroundColor(TextColor.Factory.fromString(color));
                graphics.putString(col, row, model.toString());
            }
        } else if (model.getFlag()) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#F000FF"));       // pink
            graphics.putString(col, row, " # ");
        } else {
            graphics.setForegroundColor(TextColor.Factory.fromString("#ede6dc"));       // white
            graphics.putString(col, row, " - ");
        }
    }

}
