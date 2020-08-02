package lpoo.model.settings;

import lpoo.model.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static lpoo.model.Configuration.Difficulty.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DifficultyFieldTest {
    Configuration conf = new Configuration(1, 1, EASY);
    DifficultyField field;

    @Before
    public void initField() {
        field = new DifficultyField(conf);
    }

    @Test
    public void testIncrement() {
        field.increment();
        assertEquals(MEDIUM, conf.getDifficulty());
        field.increment();
        assertEquals(HARD, conf.getDifficulty());
        field.increment();
        assertEquals(EASY, conf.getDifficulty());
    }

    @Test
    public void testDecrement() {
        field.decrement();
        assertEquals(HARD, conf.getDifficulty());
        field.decrement();
        assertEquals(MEDIUM, conf.getDifficulty());
        field.decrement();
        assertEquals(EASY, conf.getDifficulty());
    }


    @Test
    public void Increment(){
        //difficulty to easy
        Configuration conf1 = Mockito.mock(Configuration.class);
        Configuration conf2 = Mockito.mock(Configuration.class);
        Configuration conf3 = Mockito.mock(Configuration.class);
        DifficultyField field1= new DifficultyField(conf1);
        DifficultyField field2 = new DifficultyField(conf2);
        DifficultyField field3 = new DifficultyField(conf3);
        when(conf1.getDifficulty()).thenReturn(Configuration.Difficulty.HARD);
        when(conf2.getDifficulty()).thenReturn(Configuration.Difficulty.EASY);
        when(conf3.getDifficulty()).thenReturn(Configuration.Difficulty.MEDIUM);

        field1.increment();
        field2.increment();
        field3.increment();
        verify(conf1, times(1)).setDifficulty(Configuration.Difficulty.EASY);
        verify(conf2, times(1)).setDifficulty(Configuration.Difficulty.MEDIUM);
        verify(conf3, times(1)).setDifficulty(Configuration.Difficulty.HARD);
    }


    @Test
    public void Decrement(){
        //difficulty to easy
        Configuration conf1 = Mockito.mock(Configuration.class);
        Configuration conf2 = Mockito.mock(Configuration.class);
        Configuration conf3 = Mockito.mock(Configuration.class);
        DifficultyField field1= new DifficultyField(conf1);
        DifficultyField field2 = new DifficultyField(conf2);
        DifficultyField field3 = new DifficultyField(conf3);
        when(conf1.getDifficulty()).thenReturn(Configuration.Difficulty.HARD);
        when(conf2.getDifficulty()).thenReturn(Configuration.Difficulty.EASY);
        when(conf3.getDifficulty()).thenReturn(Configuration.Difficulty.MEDIUM);

        field1.decrement();
        field2.decrement();
        field3.decrement();
        verify(conf1, times(1)).setDifficulty(Configuration.Difficulty.MEDIUM);
        verify(conf2, times(1)).setDifficulty(Configuration.Difficulty.HARD);
        verify(conf3, times(1)).setDifficulty(Configuration.Difficulty.EASY);
    }
}
