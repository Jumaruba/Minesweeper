package lpoo.control.state;

import lpoo.control.CommandKey;
import lpoo.control.Controller;
import lpoo.control.command.Command;
import lpoo.model.Configuration;
import lpoo.model.menu.MenuModel;
import lpoo.view.View;
import lpoo.view.menu.MenuView;

import java.io.IOException;

public class MenuState extends ControllerState<MenuModel> {
    Boolean inGame;
    MenuModel model;
    MenuView view;

    public MenuState(FactoryState factory, Configuration configuration, Boolean inGame, MenuModel menuModel, MenuView menuView) {
        super(factory, configuration);
        this.model = menuModel;
        this.view = menuView;
        this.inGame = inGame;
        this.graphics = menuView.initGraphics();
    }

    @Override
    public View<MenuModel> getView() {
        return view;
    }

    @Override
    public ControllerState<?> execute(Controller controller, CommandKey readCommand) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        ControllerState<?> nextState = this;
        switch (readCommand.getCommandEnum()) {
            case UP:
                model.previousSelected();
                break;
            case DOWN:
                model.nextSelected();
                break;
            case CLICK:
                switch (model.getSelected()) {
                    case START:
                        if (!inGame)
                            nextState = factory.genGameState(configuration, controller);
                        else {
                            nextState = factory.genGameState(controller.getGame());
                        }
                        break;
                    case INST:
                        nextState = factory.genInstState(configuration, inGame);
                        break;
                    case RANKING:
                        nextState = factory.genRankingState(configuration, inGame);
                        break;
                    case PREF:
                        if (!inGame)
                            nextState = factory.genSettingsState(configuration);
                        break;
                    case EXIT:
                        nextState = null;
                }
                break;
            case QUIT:
                nextState = null;
        }
        return goToState(nextState);
    }
}
