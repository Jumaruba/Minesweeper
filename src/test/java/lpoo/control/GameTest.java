package lpoo.control;


import lpoo.control.state.*;
import lpoo.model.Configuration;
import lpoo.model.Position;
import lpoo.model.game.CursorModel;
import lpoo.model.game.GameModel;
import lpoo.model.game.TableModel;
import lpoo.view.game.GameView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class GameTest {
    FactoryState factoryState;
    Configuration configuration;
    GameModel gameModel;
    GameView gameView;
    GameState gameState;
    Controller controller;

    @Before
    public void before(){
        controller = Mockito.mock(Controller.class);
        factoryState = Mockito.mock(FactoryState.class);
        configuration = Mockito.mock(Configuration.class);
        gameModel = Mockito.mock(GameModel.class);
        gameView = Mockito.mock(GameView.class);
        gameState = new GameState(factoryState, configuration, gameModel, gameView);
    }

    @Test
    public void checkKeys() throws IOException {
        CursorModel cursorModel = Mockito.mock(CursorModel.class);
        CommandKey commandKey_UP = Mockito.mock(CommandKey.class);
        CommandKey commandKey_DOWN = Mockito.mock(CommandKey.class);
        CommandKey commandKey_LEFT = Mockito.mock(CommandKey.class);
        CommandKey commandKey_RIGHT = Mockito.mock(CommandKey.class);
        when(gameModel.getCursor()).thenReturn(cursorModel);
        when(commandKey_DOWN.getCommandEnum()).thenReturn(CommandKey.COMMAND.DOWN);
        when(commandKey_UP.getCommandEnum()).thenReturn(CommandKey.COMMAND.UP);
        when(commandKey_LEFT.getCommandEnum()).thenReturn(CommandKey.COMMAND.LEFT);
        when(commandKey_RIGHT.getCommandEnum()).thenReturn(CommandKey.COMMAND.RIGHT);

        gameState.execute(controller, commandKey_DOWN);
        gameState.execute(controller, commandKey_UP);
        gameState.execute(controller, commandKey_LEFT);
        gameState.execute(controller, commandKey_RIGHT);

        verify(cursorModel, times(1)).moveUp();

        verify(cursorModel, times(1)).moveDown();
        verify(cursorModel, times(1)).moveLeft();
        verify(cursorModel, times(1)).moveRight();


    }

    public ControllerState<?> BeforeCommandTest(CommandKey.COMMAND command) throws IOException {

        CommandKey commandKey = Mockito.mock(CommandKey.class);
        CursorModel cursorModel = Mockito.mock(CursorModel.class);
        when(gameModel.getCursor()).thenReturn(cursorModel);
        when(cursorModel.getPosition()).thenReturn(new Position(1,1));
        when(commandKey.getCommandEnum()).thenReturn(command);

        return gameState.execute(controller, commandKey);

    }
    @Test
    public void FlagCommand() throws IOException {
        ControllerState<?> nextState = BeforeCommandTest(CommandKey.COMMAND.FLAG);
        assertSame(nextState.getClass(), GameState.class);
        verify(gameModel, times(1)).flag();


    }

    @Test
    public void ClickCommand() throws IOException {
        ControllerState<?>  nextState = BeforeCommandTest(CommandKey.COMMAND.CLICK);

        assertSame(nextState.getClass(), GameState.class);
        verify(gameModel, times(1)).click();
    }

    @Test

    public void CheckEsc() throws IOException {

        MenuState menuState = Mockito.mock(MenuState.class);
        when(factoryState.genMenuState(configuration,true)).thenReturn(menuState);
        ControllerState<?> nextState = BeforeCommandTest(CommandKey.COMMAND.ESC);
        assertSame(nextState, menuState);
    }

    @Test
    public void CheckGameOver() throws IOException {
        ControllerState nextState = BeforeCommandTest(CommandKey.COMMAND.QUIT);
        assertSame(null, nextState);
    }

    @Test
    public void checkWinGame() throws IOException {
        GameOverState gameOverState = Mockito.mock(GameOverState.class);
        TableModel tableModel = Mockito.mock(TableModel.class);
        when(gameModel.getTable()).thenReturn(tableModel);
        when(tableModel.getScore()).thenReturn(10);
        when(factoryState.genGameOverState(configuration, 10)).thenReturn(gameOverState);
        when(gameModel.checkWin()).thenReturn(true);
        ControllerState<?> nextState = BeforeCommandTest(CommandKey.COMMAND.CLICK);
        assertSame(gameOverState, nextState);
    }

    @Test
    public void checkGameOver() throws IOException {
        when(gameModel.click()).thenReturn(true);
        GameOverState gameOverState = Mockito.mock(GameOverState.class);
        TableModel table = Mockito.mock(TableModel.class);
        when(gameModel.getTable()).thenReturn(table);
        when(table.getScore()).thenReturn(10);
        when(factoryState.genGameOverState(configuration, 10)).thenReturn(gameOverState);
        ControllerState<?> nextState = BeforeCommandTest(CommandKey.COMMAND.CLICK);
        assertSame(gameOverState, nextState);
    }

    @Test
    public void undoCommand() throws IOException {

        ControllerState<?> nextState = BeforeCommandTest(CommandKey.COMMAND.UNDO);
        verify(gameModel, times(1)).undoLastCommand();
        assertSame(GameState.class, nextState.getClass());

    }
}



