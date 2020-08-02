package lpoo.control.command;

import lpoo.model.game.GameModel;

public class GameUndo extends GameCommand {

    GameModel model;

    public GameUndo(GameModel model) {
        this.model = model;
    }

    @Override
    public void undo() {
        this.model.undoLastCommand();
    }

    @Override
    public void execute() {
        this.model.undoLastCommand();
    }
}
