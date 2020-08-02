package lpoo.view.ranking;

import com.googlecode.lanterna.TextColor;
import lpoo.model.ranking.RankingItem;
import lpoo.model.ranking.RankingModel;
import lpoo.view.BorderView;
import lpoo.view.View;

import java.io.IOException;

import static com.googlecode.lanterna.SGR.BOLD;
import static lpoo.model.ranking.RankingItem.RANKING_NAME_CHARS;

public class RankingView extends View<RankingModel> {

    BorderView borderView;

    public RankingView(RankingModel model) {
        super(model);
        this.borderView = new BorderView(16, 3, graphics);
        initScreen();
    }

    public void drawTitle() {
        String s1 = " _  _             _ ";
        String s2 = "|_||_||\\ ||/||\\ ||  ";
        String s3 = "|\\ | || \\||\\|| \\||_|";

        graphics.setForegroundColor(TextColor.Factory.fromString("#b249d2"));   //violet
        graphics.putString(getCol(s1), 2, s1, BOLD);
        graphics.putString(getCol(s2), 3, s2, BOLD);
        graphics.putString(getCol(s3), 4, s3, BOLD);
    }

    public void drawRanking() {
        graphics.putString(16, 6, "NAME         SCORE");
        graphics.setForegroundColor(TextColor.Factory.fromString("#f2e744"));

        int counter = 0;
        for (RankingItem p : model.getPeople()) {
            StringBuilder toPrint = new StringBuilder(p.getName());
            for (int i = Integer.toString(p.getScore()).length() + RANKING_NAME_CHARS; i < 18; i++)
                toPrint.append(" ");
            toPrint.append(p.getScore());
            graphics.putString(16, 8 + counter, toPrint.toString());
            counter++;
            if (counter == 10)
                break;
        }
    }

    @Override
    public void draw(int col, int row) throws IOException {
        clear(col, row);

        drawTitle();
        drawRanking();
        drawString("#FF0000", 20, "Press enter to continue...");

        refresh();
    }
}
