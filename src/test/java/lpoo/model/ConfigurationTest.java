package lpoo.model;

import lpoo.model.Configuration;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfigurationTest {
    Configuration configuration;

    @Before
    public void initConfiguration() {
        configuration = new Configuration(10, 11, Configuration.Difficulty.HARD);
    }

    @Test
    public void testConstructor() {
        assertEquals(10, configuration.getGameWidth());
        assertEquals(11, configuration.getGameHeight());
        assertEquals(Configuration.Difficulty.HARD, configuration.getDifficulty());
    }

    @Test
    public void testWidth() {
        configuration.setGameWidth(12);
        assertEquals(12, configuration.getGameWidth());
    }

    @Test
    public void testHeight() {
        configuration.setGameHeight(13);
        assertEquals(13, configuration.getGameHeight());
    }

    @Test
    public void testDif() {
        configuration.setDifficulty(Configuration.Difficulty.EASY);
        assertEquals(Configuration.Difficulty.EASY, configuration.getDifficulty());
    }
}
