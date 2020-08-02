package lpoo.control;

import lpoo.control.state.*;
import lpoo.model.Configuration;
import lpoo.model.instructions.InstModel;
import lpoo.view.menu.InstView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

public class InstructionTest {

    Controller controller;
    FactoryState factoryState;
    Configuration configuration;
    InstState instController;
    InstModel model;
    InstView instView;
    @Before
    public void before(){
        instView = Mockito.mock(InstView.class);
        controller = Mockito.mock(Controller.class);
        factoryState = Mockito.mock(FactoryState.class);
        configuration = Mockito.mock(Configuration.class);
        instController = new InstState(factoryState, configuration,true , model, instView);
    }

    @Test
    public void checkClick() throws IOException {
        CommandKey commandKey = Mockito.mock(CommandKey.class);
        when(commandKey.getCommandEnum()).thenReturn(CommandKey.COMMAND.CLICK);
        MenuState menuState = Mockito.mock(MenuState.class);
        when(factoryState.genMenuState(configuration, true)).thenReturn(menuState);
        ControllerState nextState = instController.execute(controller, commandKey);
        assertSame(nextState, menuState);
    }

    @Test
    public void checkQuit() throws IOException {
        CommandKey commandKey = Mockito.mock(CommandKey.class);
        when(commandKey.getCommandEnum()).thenReturn(CommandKey.COMMAND.QUIT);
        ControllerState nextState = instController.execute(controller,commandKey);
        assertSame(null, nextState);

    }

}
