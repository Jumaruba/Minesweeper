package lpoo.control;

import lpoo.control.state.*;
import lpoo.model.Configuration;
import lpoo.model.ranking.GameOverModel;
import lpoo.view.ranking.GameOverView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class GameOverTest extends ControlTest {

    FactoryState factoryState;
    Configuration configuration;
    GameOverModel model;
    GameOverView gameOverView;
    Controller controller;
    GameOverState state;

    @Before
    public void before() {

        model = Mockito.mock(GameOverModel.class);
        gameOverView = Mockito.mock(GameOverView.class);
        controller = Mockito.mock(Controller.class);
        factoryState = Mockito.mock(FactoryState.class);
        configuration = Mockito.mock(Configuration.class);
        state = new GameOverState(factoryState, configuration, model, gameOverView);
    }


    @Test
    public void checkClick_no_save() throws IOException, ClassNotFoundException, CloneNotSupportedException {

        when(model.getHighScore()).thenReturn(true);
        when(model.getName()).thenReturn("an");
        ControllerState nextState = Execute(CommandKey.COMMAND.CLICK, controller, state);

        verify(model, times(0)).saveScores();
        assertSame(state, nextState);


        when(model.getName()).thenReturn("anbn");
        nextState = Execute(CommandKey.COMMAND.CLICK, controller, state);

        verify(model, times(0)).saveScores();
        assertSame(state, nextState);
    }


    @Test
    public void checkClick_yes_save() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        MenuState menuState = Mockito.mock(MenuState.class);
        when(factoryState.genMenuState(configuration, false)).thenReturn(menuState);
        when(model.getHighScore()).thenReturn(true);
        when(model.getName()).thenReturn("anb");
        ControllerState nextState = Execute(CommandKey.COMMAND.CLICK, controller, state);

        verify(model, times(1)).saveScores();
        assertSame(menuState, nextState);
    }

    @Test
    public void checkQuit() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        ControllerState nextState = Execute(CommandKey.COMMAND.QUIT, controller, state);
        assertSame(null, nextState);
    }

    @Test
    public void checkBackspace_true_highScore() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        when(model.getHighScore()).thenReturn(true);
        ControllerState nextState = Execute(CommandKey.COMMAND.BACKSPACE, controller, state);

        verify(model, times(1)).deleteLastLetter();

        assertSame(state, nextState);
    }


    @Test
    public void checkBackspace_false_highScore() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        when(model.getHighScore()).thenReturn(false);

        ControllerState nextState = Execute(CommandKey.COMMAND.BACKSPACE, controller, state);

        verify(model, times(0)).deleteLastLetter();
        verify(model, times(0)).addChar('a');
        assertSame(state, nextState);
    }


}
