package lpoo.model.ranking;

import java.io.*;

public class ReadRanking {
    FileInputStream fi;
    ObjectInputStream oi;

    public ReadRanking() throws IOException {
        File score = new File("Score.txt");

        if (score.createNewFile()) {
            FileOutputStream f = new FileOutputStream(score);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(new RankingModel());
        }
        fi = new FileInputStream(score);
        oi = new ObjectInputStream(fi);


    }

    public RankingModel read() throws IOException, ClassNotFoundException {
        //must make sure that initially there's 10 people in the Score (NONE 0)
        RankingModel ranking = (RankingModel) oi.readObject();
        oi.close();
        fi.close();
        return ranking;
    }
}
