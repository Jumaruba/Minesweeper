package lpoo.control;

import lpoo.control.state.ControllerState;
import lpoo.control.state.FactoryState;
import lpoo.control.state.MenuState;
import lpoo.control.state.RankingState;
import lpoo.model.Configuration;
import lpoo.model.ranking.RankingModel;
import lpoo.view.ranking.RankingView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;


public class RankingTest {
    Controller controller;
    FactoryState factoryState;
    Configuration configuration;
    RankingState rankingController;
    RankingModel model;
    RankingView rankingView;
    @Before
    public void before(){
        rankingView = Mockito.mock(RankingView.class);
        controller = Mockito.mock(Controller.class);
        factoryState = Mockito.mock(FactoryState.class);
        configuration = Mockito.mock(Configuration.class);
        rankingController = new RankingState(factoryState, configuration,true , model, rankingView);
    }

    @Test
    public void checkClick() throws IOException {
        CommandKey commandKey = Mockito.mock(CommandKey.class);
        when(commandKey.getCommandEnum()).thenReturn(CommandKey.COMMAND.CLICK);
        MenuState menuState = Mockito.mock(MenuState.class);
        when(factoryState.genMenuState(configuration, true)).thenReturn(menuState);
        ControllerState nextState = rankingController.execute(controller, commandKey);
        assertSame(nextState, menuState);
    }

    @Test
    public void checkQuit() throws IOException {
        CommandKey commandKey = Mockito.mock(CommandKey.class);
        when(commandKey.getCommandEnum()).thenReturn(CommandKey.COMMAND.QUIT);
        ControllerState nextState = rankingController.execute(controller,commandKey);
        assertSame(null, nextState);

    }
}
