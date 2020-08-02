package lpoo.model.ranking;

import java.io.*;

public class WriteRanking {
    ObjectOutputStream o;
    FileOutputStream f;

    public WriteRanking() throws IOException {
        f = new FileOutputStream(new File("Score.txt"));
        o = new ObjectOutputStream(f);
    }

    public void writeInFile(RankingModel ranking) throws IOException {
        o.writeObject(ranking);
        o.close();
        f.close();
    }
}
