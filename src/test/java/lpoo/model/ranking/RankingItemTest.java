package lpoo.model.ranking;

import lpoo.model.ranking.RankingItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RankingItemTest {
    RankingItem item;

    @Before
    public void initItem() {
        item = new RankingItem("AaA", 300);
    }

    @Test
    public void name() {
        assertEquals("AAA", item.getName());
    }

    @Test
    public void score() {
        assertEquals(300, item.getScore());
    }
}
