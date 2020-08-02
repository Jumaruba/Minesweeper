package lpoo.control.state;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.control.CommandKey;
import lpoo.control.Controller;
import lpoo.model.Configuration;
import lpoo.model.Model;
import lpoo.view.View;

import java.io.IOException;


public abstract class ControllerState<T extends Model> {
    FactoryState factory;
    Configuration configuration;
    TextGraphics graphics;

    public ControllerState(FactoryState factory, Configuration configuration) {
        this.factory = factory;
        this.configuration = configuration;
    }

    public abstract View<T> getView();

    protected void draw(TextGraphics graphics) throws IOException {
        this.getView().draw(0, 0);
    }

    protected ControllerState<?> goToState(ControllerState<?> nextState) throws IOException {
        if (nextState != this)
            this.getView().close();
        return nextState;
    }

    public CommandKey getCommand() throws IOException {
        draw(graphics);
        CommandKey commandKey = this.getView().getCommand();
        if (commandKey == null)
            return this.getView().getCommand();
        return commandKey;
    }

    public abstract ControllerState<?> execute(Controller controller, CommandKey commandKey) throws IOException, ClassNotFoundException, CloneNotSupportedException;
}
