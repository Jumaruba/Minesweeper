package lpoo.view.menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import lpoo.model.settings.SettingsModel;
import lpoo.view.BorderView;
import lpoo.view.View;

import java.io.IOException;

import static com.googlecode.lanterna.SGR.BOLD;
import static lpoo.model.settings.SettingsModel.Option.*;

public class SettingsView extends View<SettingsModel> {
    BorderView borderView;

    public SettingsView(SettingsModel model) {
        super(model);
        initScreen();
        this.borderView = new BorderView(16, 3, graphics);
    }

    public void drawTitle() {

        String s1 = " _   _ ___ ___         _   _ ";
        String s2 = "|_  |_  |   |  | |\\ | |   |_ ";
        String s3 = " _| |_  |   |  | | \\| |_|  _|";

        graphics.setForegroundColor(TextColor.Factory.fromString("#b249d2"));   //violet
        graphics.putString(getCol(s1), 2, s1, BOLD);
        graphics.putString(getCol(s2), 3, s2, BOLD);
        graphics.putString(getCol(s3), 4, s3, BOLD);
    }

    private String normalize(String in, int n) {
        StringBuilder b = new StringBuilder(n);
        int toAdd = (n - in.length()) / 2;
        for (int i = 0; i < toAdd; i++) {
            b.append(" ");
        }
        b.append(in);
        if ((in.length() - n) % 2 == 1)
            toAdd++;
        for (int i = 0; i < toAdd; i++) {
            b.append(" ");
        }
        return b.toString();
    }

    public void drawOptions() {
        drawString("#f2e744", getStringLine(model.getPosElem(DIF)), normalize("" + model.enumToString(DIF), 12) + "      " + normalize("" + model.getConfiguration().getDifficulty(), 8)); //green
        drawString("#f2e744", getStringLine(model.getPosElem(HEIGHT)), normalize("" + model.enumToString(HEIGHT), 12) + "      " + normalize("" + model.getConfiguration().getGameHeight(), 8));   //yellow
        drawString("#f2e744", getStringLine(model.getPosElem(WIDTH)), normalize("" + model.enumToString(WIDTH), 12) + "       " + normalize("" + model.getConfiguration().getGameWidth(), 8));   //yellow
        drawString("#FF0000", getStringLine(model.getPosElem(BACK)), model.enumToString(BACK));   //red
    }

    public void drawSelectedBorder() {
        SettingsModel.Option selected = model.getSelected();

        if (selected == BACK) {
            int COL_BEGIN_SELECTED = COLS_MENU / 2 - 8;
            graphics.setForegroundColor(TextColor.Factory.fromString("#b249d2"));       //violet
            borderView.draw(COL_BEGIN_SELECTED, getStringLine(model.getPosElem(selected)) - 1);
        } else {
            graphics.setForegroundColor(TextColor.Factory.fromString("#f2e744"));       //violet
            graphics.putString(29, getStringLine(model.getPosElem(selected)), "<");
            graphics.putString(38, getStringLine(model.getPosElem(selected)), ">");
        }
    }

    @Override
    public void draw(int col, int row) throws IOException {
        clear(col, row);

        graphics.setBackgroundColor(TextColor.Factory.fromString("#010326"));       //dark blue
        graphics.fillRectangle(new TerminalPosition(col, row), getSize(), ' ');

        drawTitle();
        drawOptions();
        drawSelectedBorder();

        refresh();
    }
}
