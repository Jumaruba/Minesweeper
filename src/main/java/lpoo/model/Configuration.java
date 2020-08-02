package lpoo.model;

public class Configuration {
    public enum Difficulty {EASY, MEDIUM, HARD}

    int gameWidth, gameHeight;
    Difficulty difficulty;

    public Configuration(int gameWidth, int gameHeight, Difficulty difficulty) {
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        this.difficulty = difficulty;
    }


    public int getGameWidth() {
        return gameWidth;
    }

    public void setGameWidth(int gameWidth) {
        this.gameWidth = gameWidth;
    }

    public int getGameHeight() {
        return gameHeight;
    }

    public void setGameHeight(int gameHeight) {
        this.gameHeight = gameHeight;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Configuration getConfiguration() {
        return this;
    }
}
