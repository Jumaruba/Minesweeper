package lpoo.model.ranking;

import java.io.Serializable;
import java.util.Comparator;

public class RankingItem implements Serializable, Comparator<RankingItem> {
    public final static int RANKING_NAME_CHARS = 3;

    String name;
    int score;

    public RankingItem(String name, int score) {
        this.name = name.toUpperCase();
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return this.name + "\t\t\t" + this.score;
    }

    @Override
    public int compare(RankingItem p, RankingItem p1) {
        return Integer.compare(p1.score, p.score);
    }
}
