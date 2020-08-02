package lpoo.control.command;

import lpoo.control.GameOver;
import lpoo.model.game.GameModel;

public abstract class Command {
    GameModel model;

    public abstract void execute() throws GameOver;
}
