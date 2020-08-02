package lpoo.model.game;

import lpoo.model.Model;

public abstract class Cell implements Model {

    protected boolean flag;
    protected boolean revealed;

    public Cell() {
        this.revealed = false;
        this.flag = false;

    }

    abstract public void setRevealed(boolean revealed, TableModel table);

    public boolean markCell() {
        if (!this.flag) {
            this.revealed = true;
            return true;
        }
        return false;
    }

    abstract public void setFlag(TableModel table);

    public abstract void increaseValue();

    public abstract int getValue();


    public boolean getFlag() {
        return flag;
    }

    public boolean getRevealed() {
        return revealed;
    }
}
