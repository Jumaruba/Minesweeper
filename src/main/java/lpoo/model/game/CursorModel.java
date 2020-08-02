package lpoo.model.game;

import com.googlecode.lanterna.TerminalSize;
import lpoo.model.Model;
import lpoo.model.Position;

public class CursorModel implements Model {
    Position position;
    TerminalSize tableSize;

    public CursorModel(TerminalSize tableSize, Position position) {
        this.tableSize = tableSize;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public void moveDown() {
        int row = (position.getRow() + 1) % tableSize.getRows();
        position = new Position(row, position.getCol());
    }

    public void moveUp() {
        int row = ((position.getRow() - 1) + tableSize.getRows()) % tableSize.getRows();
        position = new Position(row, position.getCol());
    }


    public void moveRight() {
        int col = (position.getCol() + 1) % tableSize.getColumns();
        position = new Position(position.getRow(), col);
    }

    public void moveLeft() {
        int col = ((position.getCol() - 1) + tableSize.getColumns()) % tableSize.getColumns();
        position = new Position(position.getRow(), col);
    }
}
