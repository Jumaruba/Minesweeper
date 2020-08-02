package lpoo.model.game;

public class BombCell extends Cell {

    public BombCell() {
    }

    @Override
    public void setRevealed(boolean revealed, TableModel table) {
        this.revealed = revealed;
    }

    @Override
    public void setFlag(TableModel table) {
        flag = !flag;
        if (flag) table.setCorrectFlag(table.getCorrectFlag() + 1);
        else table.setCorrectFlag(table.getCorrectFlag() - 1);
    }

    @Override
    public int getValue() {
        return -1;
    }

    @Override
    public String toString() {
        return "-1 ";
    }

    @Override
    public void increaseValue() {
    }
}
