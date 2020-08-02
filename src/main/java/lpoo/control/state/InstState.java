package lpoo.control.state;

import lpoo.control.CommandKey;
import lpoo.control.Controller;
import lpoo.model.Configuration;
import lpoo.model.instructions.InstModel;
import lpoo.view.View;
import lpoo.view.menu.InstView;

import java.io.IOException;

public class InstState extends ControllerState<InstModel> {
    Boolean inGame;
    InstModel instModel;
    InstView instView;

    public InstState(FactoryState factory, Configuration configuration, Boolean inGame, InstModel instModel, InstView instView) {
        super(factory, configuration);
        this.inGame = inGame;
        this.instModel = instModel;
        this.instView = instView;
        this.graphics = instView.initGraphics();
    }

    @Override
    public View<InstModel> getView() {
        return instView;
    }

    @Override
    public ControllerState<?> execute(Controller controller, CommandKey readCommand) throws IOException {
        ControllerState<?> nextState = this;
        switch (readCommand.getCommandEnum()) {
            case CLICK:
                nextState = factory.genMenuState(configuration, inGame);
                break;
            case QUIT: {
                nextState = null;
                break;
            }
        }
        return goToState(nextState);
    }
}
