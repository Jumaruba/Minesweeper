package lpoo.model.game;

import org.junit.Test;

import java.time.Clock;

import static org.junit.Assert.assertEquals;

public class ClockModelTest {
    @Test
    public void testTime() {
        Clock c = Clock.systemUTC();
        ClockModel clock = new ClockModel(c);
        assertEquals(c.instant().getNano(), clock.getCurrent().getNano(), 1000000);
    }
}
