package lpoo.control.state;

import lpoo.control.*;
import lpoo.control.command.Click;
import lpoo.control.command.Flag;
import lpoo.control.command.GameCommand;
import lpoo.control.command.GameUndo;
import lpoo.model.Configuration;
import lpoo.model.game.GameModel;
import lpoo.view.View;
import lpoo.view.game.GameView;

import java.io.IOException;

public class GameState extends ControllerState<GameModel> {
    GameModel gameModel;
    GameView gameView;

    public GameState(FactoryState factory, Configuration configuration, GameModel gameModel, GameView gameView) {
        super(factory, configuration);
        this.gameModel = gameModel;
        this.gameView = gameView;
        this.graphics = gameView.initGraphics();
    }

    @Override
    public View<GameModel> getView() {
        return gameView;
    }

    @Override
    public ControllerState<?> execute(Controller controller, CommandKey commandKey) throws IOException {
        GameCommand command = null;
        ControllerState<?> nextState = this;
        switch (commandKey.getCommandEnum()) {
            case UP:
                gameModel.getCursor().moveUp();
                break;
            case DOWN:
                gameModel.getCursor().moveDown();
                break;
            case RIGHT:
                gameModel.getCursor().moveRight();
                break;
            case LEFT:
                gameModel.getCursor().moveLeft();
                break;
            case FLAG:
                command = new Flag(gameModel);
                break;
            case CLICK:
                command = new Click(gameModel);
                break;
            case UNDO:
                command = new GameUndo(gameModel);
                break;
            case ESC:
                nextState = factory.genMenuState(configuration, true);
                break;
            case QUIT:
                nextState = null;
                break;
        }
        if (command != null)
            try {
                command.execute();
                gameModel.addCommand(command);
                if (gameModel.checkWin())
                    nextState = factory.genGameOverState(configuration, gameModel.getTable().getScore());
            } catch (GameOver g) {
                nextState = factory.genGameOverState(configuration, gameModel.getTable().getScore());
            }
        return goToState(nextState);
    }
}
