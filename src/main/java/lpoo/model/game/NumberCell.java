package lpoo.model.game;

public class NumberCell extends Cell {

    private int value;

    public NumberCell(int value) {
        this.value = value;
    }

    @Override
    public void setRevealed(boolean revealed, TableModel table) {
        if (!revealed && this.revealed) table.setRevealed(table.getRevealed() - 1);
        if (revealed && !this.revealed) table.setRevealed(table.getRevealed() + 1);
        this.revealed = revealed;
    }

    @Override
    public void setFlag(TableModel table) {
        flag = !flag;

        if (flag) table.setWrongFlag(table.getWrongFlag() + 1);
        if (!flag) table.setWrongFlag(table.getWrongFlag() - 1);
    }

    //Used for creating table
    @Override
    public void increaseValue() {
        this.value++;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return " " + value + " ";
    }

}
