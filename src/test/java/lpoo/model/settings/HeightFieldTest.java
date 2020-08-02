package lpoo.model.settings;

import lpoo.model.Configuration;
import org.junit.Test;
import org.mockito.Mockito;

import static lpoo.model.Configuration.Difficulty.EASY;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class HeightFieldTest {
    @Test
    public void testIncrement() {
        Configuration conf = new Configuration(7, 7, EASY);
        HeightField field = new HeightField(conf);
        field.increment();
        assertEquals(8, conf.getGameHeight());
        field.increment();
        assertEquals(9, conf.getGameHeight());

        conf = new Configuration(7, 35, EASY);
        field = new HeightField(conf);
        field.increment();
        assertEquals(36, conf.getGameHeight());
        field.increment();
        assertEquals(36, conf.getGameHeight());
    }

    @Test
    public void testDecrement() {
        Configuration conf = new Configuration(7, 7, EASY);
        HeightField field = new HeightField(conf);
        field.decrement();
        assertEquals(6, conf.getGameHeight());
        field.decrement();
        assertEquals(6, conf.getGameHeight());

        conf = new Configuration(7, 35, EASY);
        field = new HeightField(conf);
        field.decrement();
        assertEquals(34, conf.getGameHeight());
        field.decrement();
        assertEquals(33, conf.getGameHeight());
    }

    @Test
    public void Increment() {
        Configuration configuration = Mockito.mock(Configuration.class);
        Configuration configuration2 = Mockito.mock(Configuration.class);
        int checkValue = 6;
        HeightField height = new HeightField(configuration);
        HeightField height2 = new HeightField(configuration2);

        when(configuration.getGameHeight()).thenReturn(36);
        when(configuration2.getGameHeight()).thenReturn(checkValue);

        height.increment();
        height2.increment();

        verify(configuration, times(0)).setGameHeight(anyInt());
        verify(configuration2, times(1)).setGameHeight(checkValue + 1);
        verify(configuration, times(1)).getGameHeight();
        verify(configuration2, times(1)).getGameHeight();

    }


    @Test
    public void Decrement() {

        Configuration configuration1 = Mockito.mock(Configuration.class);
        Configuration configuration3 = Mockito.mock(Configuration.class);
        int checkValue = 36;

        HeightField height1 = new HeightField(configuration1);
        HeightField height3 = new HeightField(configuration3);
        when(configuration1.getGameHeight()).thenReturn(6);
        when(configuration3.getGameHeight()).thenReturn(checkValue);

        height1.decrement();
        height3.decrement();

        verify(configuration1, times(0)).setGameHeight(anyInt());
        verify(configuration3, times(1)).setGameHeight(checkValue - 1);

        verify(configuration1, times(1)).getGameHeight();
        verify(configuration3, times(1)).getGameHeight();
    }
}
