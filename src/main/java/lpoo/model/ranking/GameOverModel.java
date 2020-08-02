package lpoo.model.ranking;

import lpoo.model.Model;

import java.io.IOException;

import static lpoo.model.ranking.RankingItem.RANKING_NAME_CHARS;

public class GameOverModel implements Model {
    String name;
    int score;
    Boolean highScore;
    RankingModel rankingModel;

    public GameOverModel(int score, boolean highScore, RankingModel rankingModel) {
        this.score = score;
        this.name = "";
        this.highScore = highScore;
        this.rankingModel = rankingModel;
    }

    public void saveScores() throws IOException {
        if (highScore) {
            rankingModel.addPerson(new RankingItem(name, score));
            new WriteRanking().writeInFile(rankingModel);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setHighScore(Boolean highScore) {
        this.highScore = highScore;
    }

    public void setRankingModel(RankingModel rankingModel) {
        this.rankingModel = rankingModel;
    }

    public Boolean getHighScore() {
        return highScore;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void addChar(Character letter) {
        if (name.length() < RANKING_NAME_CHARS && Character.isAlphabetic(letter))
            name += Character.toUpperCase(letter);
    }

    public void deleteLastLetter() {
        if (name.length() > 0)
            name = name.substring(0, name.length() - 1);
    }
}
