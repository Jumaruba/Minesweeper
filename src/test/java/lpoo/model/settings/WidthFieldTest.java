package lpoo.model.settings;

import lpoo.model.Configuration;
import org.junit.Test;
import org.mockito.Mockito;

import static lpoo.model.Configuration.Difficulty.EASY;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WidthFieldTest {
    @Test
    public void Increment() {
        Configuration configuration = Mockito.mock(Configuration.class);
        Configuration configuration2 = Mockito.mock(Configuration.class);
        int checkValue = 6;
        WidthField width = new WidthField(configuration);
        WidthField width2 = new WidthField(configuration2);

        when(configuration.getGameWidth()).thenReturn(36);
        when(configuration2.getGameWidth()).thenReturn(checkValue);

        width.increment();
        width2.increment();

        verify(configuration, times(0)).setGameWidth(anyInt());
        verify(configuration2, times(1)).setGameWidth(checkValue + 1);
        verify(configuration, times(1)).getGameWidth();
        verify(configuration2, times(1)).getGameWidth();

    }


    @Test
    public void Decrement() {

        Configuration configuration1 = Mockito.mock(Configuration.class);
        Configuration configuration3 = Mockito.mock(Configuration.class);
        int checkValue = 36;

        WidthField width1 = new WidthField(configuration1);
        WidthField width3 = new WidthField(configuration3);
        when(configuration1.getGameWidth()).thenReturn(6);
        when(configuration3.getGameWidth()).thenReturn(checkValue);

        width1.decrement();
        width3.decrement();

        verify(configuration1, times(0)).setGameWidth(anyInt());
        verify(configuration3, times(1)).setGameWidth(checkValue - 1);

        verify(configuration1, times(1)).getGameWidth();
        verify(configuration3, times(1)).getGameWidth();
    }

    @Test
    public void testIncrement() {
        Configuration conf = new Configuration(7, 7, EASY);
        WidthField field = new WidthField(conf);
        field.increment();
        assertEquals(8, conf.getGameWidth());
        field.increment();
        assertEquals(9, conf.getGameWidth());

        conf = new Configuration(35, 7, EASY);
        field = new WidthField(conf);
        field.increment();
        assertEquals(36, conf.getGameWidth());
        field.increment();
        assertEquals(36, conf.getGameWidth());
    }

    @Test
    public void testDecrement() {
        Configuration conf = new Configuration(7, 7, EASY);
        WidthField field = new WidthField(conf);
        field.decrement();
        assertEquals(6, conf.getGameWidth());
        field.decrement();
        assertEquals(6, conf.getGameWidth());

        conf = new Configuration(35, 7, EASY);
        field = new WidthField(conf);
        field.decrement();
        assertEquals(34, conf.getGameWidth());
        field.decrement();
        assertEquals(33, conf.getGameWidth());
    }
}
