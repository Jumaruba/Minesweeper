package lpoo.model.ranking;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


import static org.junit.Assert.*;


public class RankingModelTest {
    RankingModel model ;
    RankingItem i1 = new RankingItem("FILHINHO", 1);
    RankingItem i2 = new RankingItem("FILHINHO", 2);
    RankingItem i3 = new RankingItem("FILHINHO", 3);
    RankingItem i4 = new RankingItem("FILHINHO", 4);
    RankingItem i5 = new RankingItem("FILHINHO", 5);
    RankingItem i6 = new RankingItem("FILHINHO", 6);
    RankingItem i7 = new RankingItem("FILHINHO", 7);
    RankingItem i8 = new RankingItem("FILHINHO", 8);
    RankingItem i9 = new RankingItem("FILHINHO", 9);
    RankingItem i10 = new RankingItem("FILHINHO", 10);
    RankingItem i11 = new RankingItem("CARA", 100);
    @Before
    public void setRankingModel(){
        model = new RankingModel();
       ArrayList<RankingItem> lista= new ArrayList<>();


        lista.add(i1);
        lista.add(i2);
        lista.add(i3);
        lista.add(i6);
        lista.add(i7);
        lista.add(i4);
        lista.add(i5);
        lista.add(i8);
        lista.add(i9);

        model.setList(lista);

    }
    @Test
    public void addPersonTest2(){
        model.addPerson(i10);

        ArrayList<RankingItem> lista= new ArrayList<>();
        lista.add(i10);
        lista.add(i9);
        lista.add(i8);
        lista.add(i7);
        lista.add(i6);
        lista.add(i5);
        lista.add(i4);
        lista.add(i3);
        lista.add(i2);
        lista.add(i1);

        assertEquals(lista, model.getPeople());

        lista= new ArrayList<>();
        lista.add(i11);
        lista.add(i10);
        lista.add(i9);
        lista.add(i8);
        lista.add(i7);
        lista.add(i6);
        lista.add(i5);
        lista.add(i4);
        lista.add(i3);
        lista.add(i2);

        model.addPerson(i11);
        assertArrayEquals(lista.toArray(), model.getPeople().toArray());

    }

    @Test
    public void testAdd() {
        model = new RankingModel();;
        model.addPerson(new RankingItem("a", 1));
        model.addPerson(new RankingItem("b", 2));
        model.addPerson(new RankingItem("a", 3));
        assertEquals(3, model.getPeople().size());
        model.addPerson(new RankingItem("a", 1));
        model.addPerson(new RankingItem("b", 2));
        model.addPerson(new RankingItem("a", 3));
        model.addPerson(new RankingItem("a", 1));
        model.addPerson(new RankingItem("b", 2));
        model.addPerson(new RankingItem("a", 3));
        model.addPerson(new RankingItem("a", 3));
        assertEquals(10, model.getPeople().size());
        model.addPerson(new RankingItem("a", 5));
        assertEquals(10, model.getPeople().size());
        assertEquals(1, model.getPeople().get(9).getScore());
    }
}
