package lpoo.control.state;

import lpoo.control.Controller;
import lpoo.model.Configuration;
import lpoo.model.game.GameModel;
import lpoo.model.instructions.InstModel;
import lpoo.model.ranking.GameOverModel;
import lpoo.model.menu.MenuModel;
import lpoo.model.ranking.RankingModel;
import lpoo.model.ranking.ReadRanking;
import lpoo.model.settings.SettingsModel;
import lpoo.view.FactoryView;
import lpoo.view.ranking.GameOverView;
import lpoo.view.game.GameView;
import lpoo.view.menu.*;
import lpoo.view.ranking.RankingView;

import java.io.IOException;

public class FactoryState {
    public MenuState genMenuState(Configuration configuration, Boolean inGame) {
        MenuModel menuModel = new MenuModel(inGame);
        MenuView menuView = new MenuView(menuModel);
        return new MenuState(this, configuration, inGame, menuModel, menuView);
    }

    public RankingState genRankingState(Configuration configuration, Boolean inGame) throws IOException, CloneNotSupportedException, ClassNotFoundException {
        RankingModel rankingModel = new ReadRanking().read();
        RankingView rankingView = new RankingView(rankingModel);
        return new RankingState(this, configuration, inGame, rankingModel, rankingView);
    }

    public GameState genGameState(Configuration configuration, Controller controller) {
        GameModel gameModel = new GameModel(configuration);
        GameView gameView = new GameView(gameModel, new FactoryView());
        GameState gameState = new GameState(this, configuration, gameModel, gameView);
        controller.setGame(gameModel);
        return gameState;
    }

    public GameState genGameState(GameModel gameModel) {
        GameView gameView = new GameView(gameModel, new FactoryView());
        return new GameState(this, gameModel.getConfiguration(), gameModel, gameView);
    }

    public InstState genInstState(Configuration configuration, Boolean inGame) {
        InstModel instModel = new InstModel();
        InstView instView = new InstView(instModel);
        return new InstState(this, configuration, inGame, instModel, instView);
    }

    public GameOverState genGameOverState(Configuration configuration, int score) {
        boolean highScore = false;
        RankingModel rankingModel;
        try {
            rankingModel = new ReadRanking().read();
            if (rankingModel.getPeople().size() < 10 || rankingModel.getPeople().get(9).getScore() < score)
                highScore = true;
        } catch (Exception ignored) {
            rankingModel = new RankingModel();
            highScore = true;
        }
        GameOverModel gameOverModel = new GameOverModel(score, highScore, rankingModel);
        GameOverView gameOverView = new GameOverView(gameOverModel);
        return new GameOverState(this, configuration, gameOverModel, gameOverView);
    }

    public SettingsState genSettingsState(Configuration configuration) {
        SettingsModel settingsModel = new SettingsModel(configuration);
        SettingsView settingsView = new SettingsView(settingsModel);
        return new SettingsState(this, configuration, settingsModel, settingsView);
    }
}
