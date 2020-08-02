package lpoo.control.command;

import lpoo.model.game.GameModel;

public class Flag extends GameCommand {
    public Flag(GameModel model) {
        this.model = model;
    }

    @Override
    public void undo() {
        super.undo();
        model.flag();
    }

    @Override
    public void execute() {
        this.savePosition();
        model.flag();
    }
}
