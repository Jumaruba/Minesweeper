package lpoo.control;

import lpoo.control.state.ControllerState;
import lpoo.control.state.FactoryState;
import lpoo.model.Configuration;
import lpoo.model.game.GameModel;

import java.io.IOException;

import static lpoo.model.Configuration.Difficulty.MEDIUM;

public class Controller {
    ControllerState<?> state;
    GameModel game = null;

    public Controller(FactoryState factory) {
        Configuration configuration = new Configuration(15, 15, MEDIUM);
        this.state = factory.genMenuState(configuration, false);
    }

    public GameModel getGame() {
        return game;
    }

    public void setGame(GameModel game) {
        this.game = game;
    }

    public void start() throws InterruptedException, IOException, CloneNotSupportedException, ClassNotFoundException {
        while (this.state != null) {
            this.state = this.state.execute(this, this.state.getCommand());
            Thread.sleep(30);
        }
    }
}
