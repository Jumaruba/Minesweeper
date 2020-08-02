package lpoo.model.settings;

import lpoo.model.Configuration;
import lpoo.model.settings.BackField;
import org.junit.Test;

import static lpoo.model.Configuration.Difficulty.HARD;
import static org.junit.Assert.assertEquals;

public class BackFieldTest {
    @Test
    public void testIncrement() {
        Configuration conf = new Configuration(1, 1, HARD);
        Configuration oldConf = new Configuration(conf.getGameWidth(), conf.getGameWidth(), conf.getDifficulty());
        BackField backField = new BackField(conf);
        backField.increment();
        assertEquals(oldConf.getConfiguration().getDifficulty(), conf.getConfiguration().getDifficulty());
        assertEquals(oldConf.getConfiguration().getGameHeight(), conf.getConfiguration().getGameHeight());
        assertEquals(oldConf.getConfiguration().getGameWidth(), conf.getConfiguration().getGameWidth());
        backField.decrement();
        assertEquals(oldConf.getConfiguration().getDifficulty(), conf.getConfiguration().getDifficulty());
        assertEquals(oldConf.getConfiguration().getGameHeight(), conf.getConfiguration().getGameHeight());
        assertEquals(oldConf.getConfiguration().getGameWidth(), conf.getConfiguration().getGameWidth());
    }
}
