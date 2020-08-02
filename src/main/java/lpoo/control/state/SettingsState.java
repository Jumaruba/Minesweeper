package lpoo.control.state;

import lpoo.control.CommandKey;
import lpoo.control.Controller;
import lpoo.model.Configuration;
import lpoo.model.settings.SettingsModel;
import lpoo.view.View;
import lpoo.view.menu.SettingsView;

import java.io.IOException;

public class SettingsState extends ControllerState<SettingsModel> {
    SettingsModel settingsModel;
    SettingsView settingsView;

    public SettingsState(FactoryState factory, Configuration configuration, SettingsModel settingsModel, SettingsView settingsView) {
        super(factory, configuration);
        this.settingsModel = settingsModel;
        this.settingsView = settingsView;
        this.graphics = settingsView.initGraphics();

    }

    @Override
    public View<SettingsModel> getView() {
        return settingsView;
    }

    public ControllerState<?> execute(Controller controller, CommandKey readCommand) throws IOException {
        ControllerState<?> nextState = this;
        switch (readCommand.getCommandEnum()) {
            case UP:
                this.settingsModel.previousSelected();
                break;
            case DOWN:
                this.settingsModel.nextSelected();
                break;
            case RIGHT:
                settingsModel.incrementField();
                break;
            case LEFT:
                settingsModel.decrementField();
                break;
            case CLICK:
                if (this.settingsModel.getSelected() == SettingsModel.Option.BACK)
                    nextState = factory.genMenuState(settingsModel.getConfiguration(), false);
                break;
            case QUIT:
                nextState = null;
        }
        return goToState(nextState);
    }
}
