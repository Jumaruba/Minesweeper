package lpoo.control;

import lpoo.control.state.*;
import lpoo.model.Configuration;
import lpoo.model.settings.SettingsModel;
import lpoo.view.menu.SettingsView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static junit.framework.TestCase.assertSame;
import static org.mockito.Mockito.*;

public class SettingsTest extends ControlTest{
    Controller controller;
    FactoryState factoryState;
    Configuration configuration;
    SettingsState state;
    SettingsModel model;
    SettingsView view;
    @Before
    public void before(){
        model = Mockito.mock(SettingsModel.class);
        view = Mockito.mock(SettingsView.class);
        controller = Mockito.mock(Controller.class);
        factoryState = Mockito.mock(FactoryState.class);
        configuration = Mockito.mock(Configuration.class);
        state = new SettingsState(factoryState, configuration, model, view);
    }

    @Test
    public void keys() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        ControllerState nextState_1 = Execute(CommandKey.COMMAND.UP, controller, state) ;
        ControllerState nextState_2 = Execute(CommandKey.COMMAND.DOWN, controller, state);
        ControllerState nextState_3 = Execute(CommandKey.COMMAND.LEFT, controller, state);
        ControllerState nextState_4 = Execute(CommandKey.COMMAND.RIGHT, controller, state);

        assertSame(state, nextState_1);
        assertSame(state, nextState_2);
        assertSame(state, nextState_3);
        assertSame(state, nextState_4);

        verify(model, times(1)).previousSelected();
        verify(model, times(1)).nextSelected();
        verify(model, times(1)).incrementField();
        verify(model, times(1)).decrementField();
    }

    @Test
    public void checkClick_no_back() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        when(model.getSelected()).thenReturn(SettingsModel.Option.HEIGHT);
        ControllerState nextState = Execute(CommandKey.COMMAND.CLICK, controller, state);
        assertSame(state, nextState);

    }

    @Test
    public void checkClick_yes_back() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        when(model.getSelected()).thenReturn(SettingsModel.Option.BACK);
        MenuState menuState = Mockito.mock(MenuState.class);
        when(model.getConfiguration()).thenReturn(configuration);
        when(factoryState.genMenuState(configuration,false)).thenReturn(menuState);
        ControllerState nextState = Execute(CommandKey.COMMAND.CLICK, controller, state);
        assertSame(menuState, nextState);

    }
    @Test
    public void checkQuit() throws IOException {
        CommandKey commandKey = Mockito.mock(CommandKey.class);
        when(commandKey.getCommandEnum()).thenReturn(CommandKey.COMMAND.QUIT);
        ControllerState nextState = state.execute(controller,commandKey);
        Assert.assertSame(null, nextState);

    }

}
