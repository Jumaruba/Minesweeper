package lpoo.model.game;

import com.googlecode.lanterna.TerminalSize;
import lpoo.control.command.GameCommand;
import lpoo.model.Configuration;
import lpoo.model.Model;
import lpoo.model.Position;

import java.time.Clock;
import java.util.Stack;

public class GameModel implements Model {
    Stack<GameCommand> commands = new Stack<>();
    TableModel table;
    CursorModel cursor;
    ClockModel clockGame;
    Configuration configuration;

    public GameModel(Configuration configuration) {
        this.configuration = configuration;
        int freq;
        switch (configuration.getDifficulty()) {
            case EASY:
                freq = 10;
                break;
            case HARD:
                freq = 0;
                break;
            default:
                freq = 5;
                break;
        }
        this.table = new TableGenerator(configuration.getGameHeight(), configuration.getGameWidth()).generateTable(freq);
        this.clockGame = new ClockModel(Clock.systemUTC());
        this.cursor = new CursorModel(new TerminalSize(configuration.getGameWidth(), configuration.getGameHeight()), new Position(0, 0));
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public int getHeight() {
        return configuration.getGameHeight();
    }

    public int getWidth() {
        return configuration.getGameWidth();
    }

    public TableModel getTable() {
        return table;
    }

    public CursorModel getCursor() {
        return cursor;
    }

    public ClockModel getClock() {
        return clockGame;
    }

    public boolean checkWin() {
        return table.getWidth() * table.getHeight() == table.getRevealed() + table.getCorrectFlag();
    }

    private int getCursorRow() {
        return cursor.getPosition().getRow();
    }

    private int getCursorCol() {
        return cursor.getPosition().getCol();
    }

    public boolean click() {

        if (!table.markCell(getCursor().getPosition())) return false;
        return table.getCell(getCursor().getPosition()).getValue() == -1;
    }

    public void addCommand(GameCommand command) {
        commands.add(command);
    }

    public void undoLastCommand() {
        if (!commands.isEmpty())
            commands.pop().undo();
    }

    public void flag() {

        table.setFlag(getCursorRow(), getCursorCol());
    }

}
