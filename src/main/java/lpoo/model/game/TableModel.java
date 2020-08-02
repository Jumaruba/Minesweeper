package lpoo.model.game;


import lpoo.model.Model;
import lpoo.model.Position;

public class TableModel implements Model {

    private Cell[][] table;
    private int height, width;

    //variables to calculate the score
    private int revealed;           /*Number of non-Revealed cells that are not bombs*/
    private int correctFlag = 0;    /*Flags in the correct place*/
    private int wrongFlag = 0;      /*Flags in the wrong place*/


    public TableModel(int height, int width) {
        this.table = new Cell[height][width];
        this.revealed = 0;
        this.width = width;
        this.height = height;

        initTable();
    }

    public void initTable() {
        for (int line = 0; line < height; line++) {
            for (int col = 0; col < width; col++) {
                table[line][col] = new NumberCell(0);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getRevealed() {
        return revealed;
    }

    public void setRevealed(int revealad) {
        this.revealed = revealad;
    }

    public void setCorrectFlag(int correctFlag) {
        this.correctFlag = correctFlag;
    }

    public int getCorrectFlag() {
        return correctFlag;
    }

    public void setWrongFlag(int wrongFlag) {
        this.wrongFlag = wrongFlag;
    }

    public int getWrongFlag() {
        return wrongFlag;
    }

    public boolean validCol(int pos) {
        return pos >= 0 && pos < width;
    }

    public boolean validLine(int pos) {
        return pos >= 0 && pos < height;
    }

    public boolean validPosition(Position pos) {
        return validCol(pos.getCol()) && validLine(pos.getRow());
    }

    public void setFlag(int line, int col) {
        table[line][col].setFlag(this);
    }

    public Cell getCell(Position position) {
        return table[position.getRow()][position.getCol()];
    }

    public void addCell(int line, int col, Cell cell) {
        table[line][col] = cell;
    }

    public void increaseValue(int line, int col) {
        table[line][col].increaseValue();

    }

    public int getScore() {
        return (300 * revealed) + correctFlag * 1000 - (wrongFlag * 600);
    }

    public boolean markCell(Position position) {
        if (!validPosition(position) || getCell(position).getFlag() || getCell(position).getRevealed())
            return false;
        if (table[position.getRow()][position.getCol()].markCell())
            revealed++;

        if (table[position.getRow()][position.getCol()].getValue() == 0)
            for (int i = -1; i <= 1; i++)
                for (int j = -1; j <= 1; j++) {
                    Position newPosition = new Position(position.getRow() + i, position.getCol() + j);
                    if (validPosition(newPosition)) {
                        markCell(newPosition);
                    }
                }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < height; i++) {
            s.append("\n");
            for (int j = 0; j < width; j++) {
                if (table[i][j].getRevealed()) s.append(table[i][j].toString());
                else s.append(" * ");
            }
        }
        return s.toString();
    }


}
