package lpoo.control;

import lpoo.control.state.*;
import lpoo.model.Configuration;
import lpoo.model.game.GameModel;
import lpoo.model.menu.MenuModel;
import lpoo.view.menu.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static lpoo.model.menu.MenuModel.Option.*;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class MenuControllerTest extends ControlTest{

    FactoryState factoryState;
    Configuration configuration;
    MenuModel model;
    MenuView view;
    Controller controller;
    MenuState state;
    MenuState state1;
    @Before
    public void before() {

        model = Mockito.mock(MenuModel.class);
        view = Mockito.mock(MenuView.class);
        controller = Mockito.mock(Controller.class);
        factoryState = Mockito.mock(FactoryState.class);
        configuration = Mockito.mock(Configuration.class);
        state = new MenuState(factoryState, configuration, true, model, view);
        state1 = new MenuState(factoryState, configuration, false, model, view);
    }

    @Test
    public void upDown() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        ControllerState nextState_1 = Execute(CommandKey.COMMAND.UP, controller, state);
        ControllerState nextState_2 = Execute(CommandKey.COMMAND.DOWN, controller, state);

        verify(model, times(1)).previousSelected();
        verify(model, times(1)).nextSelected();
        assertSame(nextState_1, state);
        assertSame(nextState_2, state);

    }

    @Test
    public void Click() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        //start
        when(model.getSelected()).thenReturn(MenuModel.Option.START);
        GameModel gameModel = Mockito.mock(GameModel.class);
        GameState gameState = Mockito.mock(GameState.class);

        GameState gameState_1 = Mockito.mock(GameState.class);

        when(controller.getGame()).thenReturn(gameModel);

        when(factoryState.genGameState(gameModel)).thenReturn(gameState);
        when(factoryState.genGameState(configuration,controller)).thenReturn(gameState_1);

        ControllerState nextState = Execute(CommandKey.COMMAND.CLICK, controller, state);

        state = state1;

        ControllerState nextState_1 = Execute(CommandKey.COMMAND.CLICK, controller, state);

        assertSame(nextState, gameState);
        assertSame(nextState_1, gameState_1);

        //inst
        when(model.getSelected()).thenReturn(INST);
        InstState instState = Mockito.mock(InstState.class);
        when(factoryState.genInstState(configuration, false)).thenReturn(instState);
        nextState = Execute(CommandKey.COMMAND.CLICK, controller,state);
        assertSame(nextState, instState);

        //ranking

        when(model.getSelected()).thenReturn(RANKING);
        RankingState rankingState = Mockito.mock(RankingState.class);
        when(factoryState.genRankingState(configuration, false)).thenReturn(rankingState);
        nextState = Execute(CommandKey.COMMAND.CLICK, controller,state);
        assertSame(nextState, rankingState);

        //pref true

        when(model.getSelected()).thenReturn(PREF);
        SettingsState settingsState = Mockito.mock(SettingsState.class);
        when(factoryState.genSettingsState(configuration)).thenReturn(settingsState);
        nextState = Execute(CommandKey.COMMAND.CLICK, controller,state);
        assertSame(nextState, settingsState);

        //pref false
        state =  new MenuState(factoryState, configuration, true, model, view);
        when(model.getSelected()).thenReturn(PREF);
        settingsState = Mockito.mock(SettingsState.class);
        when(factoryState.genSettingsState(configuration)).thenReturn(settingsState);
        nextState = Execute(CommandKey.COMMAND.CLICK, controller,state);
        assertSame(nextState, state);


    }
    @Test
    public void checkQuit() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        ControllerState nextState = Execute(CommandKey.COMMAND.QUIT, controller, state);
        assertSame(null, nextState);
    }
}
