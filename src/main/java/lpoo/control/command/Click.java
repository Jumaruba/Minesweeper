package lpoo.control.command;

import lpoo.control.GameOver;
import lpoo.model.game.GameModel;

public class Click extends GameCommand {
    public Click(GameModel model) {
        this.model = model;
    }

    @Override
    public void undo() {
        super.undo();
        model.getTable().getCell(position).setRevealed(false, model.getTable());
    }

    @Override
    public void execute() throws GameOver {
        this.savePosition();
        if (model.click())
            throw new GameOver();
    }
}
