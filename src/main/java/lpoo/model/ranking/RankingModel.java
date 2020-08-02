package lpoo.model.ranking;

import lpoo.model.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class RankingModel implements Serializable, Model {
    ArrayList<RankingItem> list;

    public RankingModel() {
        this.list = new ArrayList<>();
    }

    public void addPerson(RankingItem item) {
        if (list.size() == 10)
            list.remove(9);
        list.add(item);
        sort();
    }

    public void setList(ArrayList<RankingItem> list) {
        this.list = list;
    }

    public ArrayList<RankingItem> getPeople() {
        return list;
    }

    public void sort() {
        list.sort(new RankingItem("A", 0));
    }


}
