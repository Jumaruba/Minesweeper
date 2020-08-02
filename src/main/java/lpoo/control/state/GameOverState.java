package lpoo.control.state;

import lpoo.control.CommandKey;
import lpoo.control.Controller;
import lpoo.model.Configuration;
import lpoo.model.ranking.*;
import lpoo.view.View;
import lpoo.view.ranking.GameOverView;

import java.io.IOException;

public class GameOverState extends ControllerState<GameOverModel> {
    GameOverModel gameOverModel;
    GameOverView gameOverView;

    public GameOverState(FactoryState factory, Configuration configuration, GameOverModel gameOverModel, GameOverView gameOverView) {
        super(factory, configuration);
        this.gameOverModel = gameOverModel;
        this.gameOverView = gameOverView;
        this.graphics = gameOverView.initGraphics();
    }

    @Override
    public View<GameOverModel> getView() {
        return gameOverView;
    }

    @Override
    public ControllerState<?> execute(Controller controller, CommandKey readCommand) throws IOException {
        ControllerState<?> nextState = this;
        switch (readCommand.getCommandEnum()) {
            case BACKSPACE:
                if (gameOverModel.getHighScore())
                    gameOverModel.deleteLastLetter();
                break;
            case CLICK:
                if (gameOverModel.getHighScore() && gameOverModel.getName().length() != 3)
                    break;
                if (gameOverModel.getHighScore() && gameOverModel.getName().length() == 3)
                    gameOverModel.saveScores();
                nextState = factory.genMenuState(configuration, false);
                break;
            case QUIT:
                nextState = null;
                break;
        }
        if (gameOverModel.getHighScore())
            gameOverModel.addChar(readCommand.getKey());
        return goToState(nextState);
    }
}
