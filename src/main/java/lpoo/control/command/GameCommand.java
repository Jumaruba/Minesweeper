package lpoo.control.command;

import lpoo.model.Position;

public abstract class GameCommand extends Command {
    Position position;

    protected void savePosition() {
        this.position = model.getCursor().getPosition();
    }

    public void undo() {
        model.getCursor().setPosition(position);
    }
}
