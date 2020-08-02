package lpoo.view.ranking;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import lpoo.model.ranking.GameOverModel;
import lpoo.view.View;

import java.io.IOException;

import static com.googlecode.lanterna.SGR.BOLD;
import static lpoo.model.ranking.RankingItem.RANKING_NAME_CHARS;

public class GameOverView extends View<GameOverModel> {
    public GameOverView(GameOverModel model) {
        super(model);
        initScreen();
    }

    @Override
    public void draw(int col, int row) throws IOException {
        clear(col, row);

        graphics.setBackgroundColor(TextColor.Factory.fromString("#010326"));       //dark blue
        graphics.fillRectangle(new TerminalPosition(0, 0), getSize(), ' ');

        String title = "GAME OVER";
        String score = "YOUR SCORE: " + model.getScore();
        String result = "YOU ";
        if (!model.getHighScore())
            result += "DID NOT ";
        result += "GET INTO THE RANKING";
        graphics.setForegroundColor(TextColor.Factory.fromString("#b249d2"));   //violet

        graphics.putString(getCol(title), 2, title, BOLD);
        graphics.putString(getCol(score), 6, score, BOLD);
        graphics.putString(getCol(result), 10, result, BOLD);
        if (model.getHighScore()) {
            String name = model.getName();
            StringBuilder toPrint = new StringBuilder(name);
            for (int i = name.length(); i < RANKING_NAME_CHARS; i++)
                toPrint.append("_");
            graphics.putString(getCol(toPrint.toString()), 16, toPrint.toString(), BOLD);
            drawString("#FF0000", 20, "Type your name to continue...");
        } else {
            drawString("#FF0000", 20, "Press enter to continue...");
        }

        refresh();
    }
}
