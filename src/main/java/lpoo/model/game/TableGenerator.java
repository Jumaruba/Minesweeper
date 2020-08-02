package lpoo.model.game;

import java.util.Random;

public class TableGenerator {
    private TableModel table;
    private int height, width;

    public TableGenerator(int height, int width) {
        this.height = height;
        this.width = width;
        this.table = new TableModel(height, width);
    }

    public boolean bombGenerate(Random r, int freq) {
        return r.nextGaussian() * 10 - freq > 5;
    }

    public TableModel generateTable(int freq) {
        Random r = new Random();
        for (int line = 0; line < height; line++) {
            for (int col = 0; col < width; col++) {
                if (bombGenerate(r, freq)) {
                    table.addCell(line, col, new BombCell());
                    updateAdjacent(line, col);
                }
            }
        }
        return this.table;
    }

    public void updateAdjacent(int line, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (table.validLine(line + i) && table.validCol(col + j))
                    table.increaseValue(line + i, col + j);
            }
        }
    }


}



