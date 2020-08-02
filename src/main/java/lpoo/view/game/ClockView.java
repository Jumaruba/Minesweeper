package lpoo.view.game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.model.game.ClockModel;
import lpoo.view.BorderView;
import lpoo.view.View;

public class ClockView extends View<ClockModel> {
    public final static int CLOCK_HEIGHT = 3;

    BorderView borderView;

    public ClockView(ClockModel model, BorderView borderView, TextGraphics graphics) {
        super(model);
        this.borderView = borderView;
        this.graphics = graphics;
    }

    @Override
    public TerminalSize getSize() {
        return new TerminalSize(borderView.getWidth(), CLOCK_HEIGHT);
    }

    private int calculatePosition(String seconds) {
        return borderView.getWidth() / 2 - seconds.length() / 2;
    }

    @Override
    public void draw(int col, int row) {
        borderView.draw(col, row);
        String seconds = model.getSeconds().toString();
        graphics.putString(calculatePosition(seconds) + col, row + CLOCK_HEIGHT / 2, seconds);
    }
}
